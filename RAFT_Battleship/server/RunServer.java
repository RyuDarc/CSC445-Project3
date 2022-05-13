package RAFT_Battleship.server;

import RAFT_Battleship.shared.RAFT_RMI_Client;
import RAFT_Battleship.shared.RAFT_RMI_Server;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class RunServer implements RAFT_RMI_Server, RAFT_RMI_Client {
    // store these 4 variables in stable storage (on disk) to recover from a crash
    private int currentTerm = 0;
    private final LinkedList<LogEntry> log = new LinkedList<>();
    private String currentRole, votedFor = null;

    private int commitLength = 0;
    private String currentLeader;
    private final String SELF_ID = getLocalAddress().getHostAddress();
    private final String[] NODES = new String[]{"altair", "rho", "pi", "moxie"};
    private final HashMap<String, String> serversAddresses = new HashMap<>();
    private final LinkedList<String> votesReceived = new LinkedList<>();   // counts self in total vote count;
    private HashTable sentLength, ackedLength;

    private static final Timer heartbeatTimer = new Timer();
    private Timer electionTimer = new Timer();

    private static RAFT_RMI_Server remoteServer;
    private static RunServer client;

    private String[][] gameboard;
    private String playerID;

    public RunServer() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    public static void main(String[] args) throws RemoteException {
        RAFT_RMI_Server server = new RunServer();
        LocateRegistry.createRegistry(1099);
        client = new RunServer();
        try {
            Naming.rebind("Server", server);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Server started");

        client.initialize();
        client.restartElectionTimer();
        // every node will attempt to heartbeat, but only the leader will be able to successfully create a pulse
        heartbeatTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                client.tryHeartbeat();
            }
        }, 0, 50);
        while(true) {
            // UDP/TCP receive message (packets? json?) containing gameboard and player's ID
            // gameboard = received gameboard
            // playerID = received playerID
            client.broadcast(); // adds to log and sends to followers (if leader) when message fully received, using globally set gameboard & playerID, so needs no parameters
        }
    }

    private void initialize() {
        // these variables would need to be reinitialized when recovering from a crash,
        // so they are here for that reinitialization capability
        currentRole = "follower";
        currentLeader = null;
        sentLength = new HashTable();
        ackedLength = new HashTable();
        serversAddresses.put("altair", "129.3.20.2");
        serversAddresses.put("pi", "129.3.20.26");
        serversAddresses.put("rho", "127.0.1.1");   //address = "129.3.20.24"; <-- this is external address of rho, but it doesn't work with RMI??
        serversAddresses.put("moxie", "129.3.20.3");
    }

    /********************************* RMI Methods *********************************/

    @Override
    public void RequestVote(int cTerm, String cID, int cLogLength, int cLogTerm, RunServer sender) {
        if(cTerm > currentTerm) {
            currentTerm = cTerm;
            currentRole = "follower";
            votedFor = null;
        }
        int lastTerm = 0;
        if(log.size() > 0)
            lastTerm = log.get(log.size()-1).term;

        // log is ok if the candidate's last log term is more up to date than ours, or if the candidate's last log is the same term and size as ours
        boolean logOk = (cLogTerm > lastTerm) || (cLogTerm == lastTerm && cLogLength >= log.size());

        startClient(cID);   // connect to candidate node (cID)
        // vote for this candidate if it's term is at least as up to date as ours, its log is ok, and if we haven't already voted for another node
        if(cTerm >= currentTerm && logOk && (votedFor == null || votedFor.equalsIgnoreCase(cID))) {
            votedFor = cID;
            sender.VoteResponse(new Ballot(SELF_ID, currentTerm, true)); // RMI response to the server who sent this request
        } else {
            sender.VoteResponse(new Ballot(SELF_ID, currentTerm, false)); // RMI response to the server who sent this request
        }
    }

    // invoked by leader onto a follower node to update this follower's log
    @Override
    public void LogRequest(String leaderID, int term, int prefixLen, int prefixTerm, int leaderCommit, LinkedList<LogEntry> suffix, RunServer sender) {
        if(term > currentTerm) {
            currentTerm = term;
            votedFor = null;
            restartElectionTimer();
        }
        // This 'if' covers the case of the previous 'if' being skipped because of this node already being in the same
        // term as the leader. This could mean we're currently in the candidate state, and so we must revert to follower
        // (since we now know there's already a leader).
        if(term == currentTerm) {
            currentRole = "follower";
            currentLeader = leaderID;
            restartElectionTimer(); // video didn't include this but pretty sure this needs to be since we're a
        }                           // candidate in this situation, meaning electionTimer has been started?

        // logOk guarantees the prefix of the leader is equal to the prefix of this node by checking:
        // prefixLen is equal or shorter than this log's length, since prefixLen = how many log entries the leader thinks
        // this node already received, (otherwise means the leader needs to include more in suffix)
        // AND either if the length of prefix is 0 OR if the term numbers match at the end-1 of the prefix of this node's
        // log and the leader's log. By checking the end-1 entry, it effectively guarantees the logs match up to the
        // prefix length index (according to RAFT).
        boolean logOk = (log.size() >= prefixLen) &&
                (prefixLen == 0 || log.get(prefixLen-1).term == prefixTerm);

        if(term == currentTerm && logOk) {
            AppendEntries(prefixLen, leaderCommit, suffix);
            int ack = prefixLen + suffix.size();    // total number of entries received
            sender.LogResponse(SELF_ID, currentTerm, ack, true); // RMI response to the server who sent this request
        } else {
            sender.LogResponse(SELF_ID, currentTerm, 0, false);  // RMI response to the server who sent this request
        }
    }

    // followers invoke this on the candidate node who sent a VoteRequest to them
    @Override
    public void VoteResponse(Ballot ballot) {
        // if we're the candidate and were granted a valid vote,
        if(currentRole.equals("candidate") && ballot.term == currentTerm && ballot.voteGranted) {
            //  add it to our votesReceived list,
            votesReceived.add(ballot.nodeID);
            // then if we have votes from the majority, become leader and let the other nodes know.
            if(votesReceived.size() >= ((NODES.length+1)/2)) {
                currentRole = "leader";
                currentLeader = SELF_ID;
                restartElectionTimer();
                for(String follower : NODES) {  // replicate our log to all other nodes
                    try {
                        if(!InetAddress.getByName(follower).getHostAddress().equals(SELF_ID)) {
                            sentLength.put(follower, log.size());
                            ackedLength.put(follower, 0);
                            ReplicateLog(SELF_ID, follower);
                        }
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                        System.out.println("ERROR GETTING ADDRESS FOR: " + follower);
                    }
                }
            }
        }
        // else if someone else is already the leader though or lagging behind for some reason, revert to follower state
        else if(ballot.term > currentTerm) {
            currentTerm = ballot.term;
            currentRole = "follower";
            votedFor = null;
            restartElectionTimer();
        }
    }

    // non-leaders invoke this on leader to acknowledge whether it appended what was sent to it or not
    @Override
    public void LogResponse(String follower, int term, int ack, boolean success) {
        if(term == currentTerm && currentRole.equals("leader")) {
            // ack = the total entries appended to the follower, so the new amount must be greater than the old amount
            if(success && ack >= ackedLength.get(follower)) {
                sentLength.put(follower, ack);
                ackedLength.put(follower, ack);
                CommitLogEntries();
            }
            // or if logRequest didn't succeed, and a non-empty logRequest was made,
            // decrease the number tracking how many entries we "know" the follower has already received, which
            // increases the number of entries (by 1) that will be sent on the next ReplicateLog(...) call.
            // There are ways of doing this faster than one at a time, but they're not simple changes.
            else if(sentLength.get(follower) > 0) {
                sentLength.put(follower, sentLength.get(follower)-1);
                ReplicateLog(SELF_ID, follower);
            }
        } else if(term > currentTerm) {
            currentTerm = term;
            currentRole = "follower";
            votedFor = null;
            restartElectionTimer();
        }
    }

    public void startClient(String targetHost) {
        try {
            remoteServer = (RAFT_RMI_Server)Naming.lookup("//" + targetHost + ":1099/Server");
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void requestVote(int cTerm, String cID, int cLogLength, int cLogTerm) {
        try {
            remoteServer.RequestVote(cTerm, cID, cLogLength, cLogTerm, this);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not contact server");
        }
    }

    public void logRequest(String leaderID, int term, int prefixLen, int prefixTerm, int leaderCommit, LinkedList<LogEntry> suffix) {
        try {
            remoteServer.LogRequest(leaderID, term, prefixLen, prefixTerm, leaderCommit, suffix,this);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not contact server");
        }
    }

    /****************************** RMI Methods end ****************************/

    // handles when a message has been received from player
    private void broadcast() {
        if(currentRole.equals("leader")) {
            log.add(new LogEntry(currentTerm, new Gamestate(gameboard, playerID)));
            ackedLength.put(SELF_ID, log.size());
            for(String follower : NODES)
                ReplicateLog(SELF_ID, follower);
        } else {
            // send to currentLeader in same manner as how the application sent the update to us (UDP/TCP)
        }
    }

    /*
     *  ReplicateLog is invoked only by leader to send update to followerID.
     *  Updates can contain new log entries if there've been messages received and not already sent, or just be an empty
     *  message serving as a heartbeat.
     *
     *  The node will know to send log entries or not based on the map sentLength tracking how many entries have been
     *  sent to that node already, and using that length against the length of the log to control how many to send (can
     *  be 0, which serves as a heartbeat).
     */
    private void ReplicateLog(String leaderID, String followerID) {
        int prefixLen = sentLength.get(followerID);
        LinkedList<LogEntry> suffix = new LinkedList<>();   // suffix contains all the entries that we think haven't yet been sent to this follower
        for(int i = prefixLen; i < log.size()-1; i++)
            suffix.add(log.get(i));
        int prefixTerm = 0;
        if(prefixLen > 0)
            prefixTerm = log.get(prefixLen-1).term;
        logRequest(leaderID, currentTerm, prefixLen, prefixTerm, commitLength, suffix);
    }

    // only followers invoke this, where they append uncommitted entries received from the leader to their own log
    private void AppendEntries(int prefixLen, int leaderCommit, LinkedList<LogEntry> suffix) {
        // if this node has log entries that go beyond the length of the prefix, and the suffix is non-zero
        if(suffix.size() > 0 && log.size() > prefixLen) {
            int index = Math.min(log.size(), prefixLen + suffix.size()) - 1;    // index = whichever log length is shorter (this log or the leader's)
            // if the logs term numbers at their ends don't match up,
            if(log.get(index).term != suffix.get(index - prefixLen).term) {
                // truncate this node's log. (remove all entries that go beyond the length of the leader's log)
                for(int i = log.size()-1; i > prefixLen-1; i--)
                    log.remove(i);
            }
        }
        // if this node's log doesn't have all of the entries that the leader has,
        if(prefixLen + suffix.size() > log.size()) {
            // append all of the suffix entries from the leader to this node's log.
            for(int i = log.size() - prefixLen; i < suffix.size()-1; i++)
                log.add(suffix.get(i));
        }
        if(leaderCommit > commitLength) {
            for(int i = commitLength; i < leaderCommit; i++) {
                // deliver log.get(i).gamestate to the application(UDP/TCP)? according to video...
                // (seems wrong to have every follower send an update to the application though..)
            }
            commitLength = leaderCommit;
        }
    }

    // invoked only by leader, commits log entries which have been acknowledged by majority of followers,
    // and then send to the application.
    private void CommitLogEntries() {
        while(commitLength < log.size()) {
            int acks = 0;
            // check every node for if they have uncommitted log entries
            for(String node : NODES) {
                if(ackedLength.get(node) > commitLength)
                    acks++;
            }
            // if a majority of nodes have uncommitted log entries, commit them (send to application and increment commitLength)
            if(acks >= (NODES.length+1)/2) {
                // deliver log.get(commitLength).gamestate to the application
                commitLength++;
            } else
                break;
        }
    }

    // invoked by every node, but only if leader, send an update to all followers.
    // (nothing was added to the leader though, so this won't change anything on the followers, but will keep them
    // from triggering an election)
    private void tryHeartbeat() {
        if(currentRole.equals("leader")) {
            for(String follower : NODES) {
                ReplicateLog(SELF_ID, follower);
            }
        }
    }

    // passive timer thread to trigger an election if it times out
    private void restartElectionTimer() {
        electionTimer.cancel();
        electionTimer = new Timer();
        double randomElectionDelay = Math.random()*(300-150+1)+150; // election delay can be anywhere from 150-300 ms (must be random for event of simultaneous elections)
        electionTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                electionTimedOut();
            }
        }, (long)randomElectionDelay);
    }

    // turn this node into a candidate and begin an election
    private void electionTimedOut() {
        currentTerm += 1;
        currentRole = "candidate";
        votedFor = SELF_ID;
        votesReceived.clear();
        votesReceived.add(SELF_ID);
        int lastTerm = 0;
        if(log.size() > 0) {
            LogEntry state = log.get(log.size()-1);
            lastTerm = state.term;
        }
        for(String node : NODES) {
            if(!serversAddresses.get(node).equals(SELF_ID)) {
                startClient(serversAddresses.get(node));
                requestVote(currentTerm, SELF_ID, log.size(), lastTerm);
            }
        }
        restartElectionTimer();
    }

    private static InetAddress getLocalAddress() {
        try(final DatagramSocket socket = new DatagramSocket()){
            socket.connect(InetAddress.getByName("8.8.8.8"), 27082);
            return socket.getLocalAddress();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
