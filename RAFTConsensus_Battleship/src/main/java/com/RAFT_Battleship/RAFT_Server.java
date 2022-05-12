package com.RAFT_Battleship;
/*
    Zach Freeman

    RAFT protocol implementation customized for a Battleship game application,
    made with much help from https://www.youtube.com/watch?v=uXEYuDwm7e4

    -- tried implementing using gRPC, but was not feasible due to the gameboard
        being a 2D array, which gRPC has no good support for communicating. So,
        default Java RMI was used instead.
 */

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class RAFT_Server {
    protected static final int PORT = 27081;

    // store these 4 variables in stable storage (on disk) to recover from a crash
    private static int currentTerm = 0;
    private static final LinkedList<LogEntry> log = new LinkedList<>();
    private static String currentRole, votedFor = null;

    private static int commitLength = 0;
    private static String currentLeader;
    private static final String selfID = getLocalAddress().getHostAddress();
    private static final String[] nodes= new String[]{"cs.oswego.edu", "rho.cs.oswego.edu", "pi.cs.oswego.edu", "moxie.cs.oswego.edu"};
    private static final LinkedList<String> votesReceived = new LinkedList<>();   // counts self in total vote count;
    private static HashTable sentLength, ackedLength;
    private static final Timer heartbeatTimer = new Timer();
    private static Timer electionTimer = new Timer();

    private static String[][] gameboard;
    private static String playerID;

    static class LogEntry {
        int term;
        Gamestate gamestate;
        public LogEntry(int term, Gamestate gamestate) {
            this.term = term; this.gamestate = gamestate;
        }
    }

    static class Gamestate {
        String[][] board;
        String pid; // playerID (randomly generated per client)
        public Gamestate (String[][] board, String pid) {
            this.board = board;
            this.pid = pid;
        }
    }

    static class Ballot {
        String nodeID;
        int term;
        boolean voteGranted;
        public Ballot(String nodeID, int term, boolean voteGranted) {
            this.nodeID = nodeID; this.term = term; this.voteGranted = voteGranted;
        }
    }

    public static void main(String[] args) {
        initialize();
        restartElectionTimer();
        // every node will attempt to heartbeat, but only the leader will be able to successfully create a pulse
        heartbeatTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                tryHeartbeat();
            }
        }, 0, 50);
        while(true) {
            // UDP/TCP receive message (packets? json?) containing gameboard and player's ID
            // gameboard = received gameboard
            // playerID = received playerID
            //broadcast(); // adds to log and sends to followers (if leader) when message fully received, using globally set gameboard & playerID, so needs no parameters
        }
    }

    private static void initialize() {
        // these variables would need to be reinitialized when recovering from a crash,
        // so they are here for that reinitialization capability
        currentRole = "follower";
        currentLeader = null;
        sentLength = new HashTable();
        ackedLength = new HashTable();
    }

    // MAKE RPC (connected with voteResponse(...))
    // voteRequest is invoked (via RMI) on a node when a candidate (cID) wants a vote from this node
    public static void voteRequest(int cTerm, String cID, int cLogLength, int cLogTerm) {
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

        // vote for this candidate if it's term is at least as up to date as ours, its log is ok, and if we haven't already voted for another node
        if(cTerm >= currentTerm && logOk && (votedFor == null || votedFor.equalsIgnoreCase(cID))) {
            votedFor = cID;
            // voteResponse RMI invocation here, to the effect of rhoClient.voteResponse(new Ballot(selfID, currentTerm, true), cID) (send to cID, e.g. rho)
        } else {
            // voteResponse RMI invocation here, to the effect of rhoClient.voteResponse(new Ballot(selfID, currentTerm, false), cID) (send to cID, e.g. rho)
        }
    }

    // MAKE RPC (connected with voteRequest(...))
    // voteResponse is invoked (via RPC) by the node who was asked for a vote
    public static void voteResponse(Ballot ballot) {
        // if we're the candidate and were granted a valid vote,
        if(currentRole.equals("candidate") && ballot.term == currentTerm && ballot.voteGranted) {
            //  add it to our votesReceived list,
            votesReceived.add(ballot.nodeID);
            // then if we have votes from the majority, become leader and let the other nodes know.
            if(votesReceived.size() >= ((nodes.length+1)/2)) {
                currentRole = "leader";
                currentLeader = selfID;
                restartElectionTimer();
                for(String follower : nodes) {  // replicate our log to all other nodes
                    try {
                        if(!InetAddress.getByName(follower).getHostAddress().equals(selfID)) {
                            sentLength.put(follower, log.size());
                            ackedLength.put(follower, 0);
                            ReplicateLog(selfID, follower);
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

    // handles when a message has been received from player
    private static void broadcast() {
        if(currentRole.equals("leader")) {
            log.add(new LogEntry(currentTerm, new Gamestate(gameboard, playerID)));
            ackedLength.put(selfID, log.size());
            for(String follower : nodes)
                ReplicateLog(selfID, follower);
        } else {
            // send to currentLeader in same manner than client sent the message (UDP/TCP)
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
    private static void ReplicateLog(String leaderID, String followerID) {
        int prefixLen = sentLength.get(followerID);
        LinkedList<LogEntry> suffix = new LinkedList<>();   // suffix contains all the entries that we think haven't yet been sent to this follower
        for(int i = prefixLen; i < log.size()-1; i++)
            suffix.add(log.get(i));
        int prefixTerm = 0;
        if(prefixLen > 0)
            prefixTerm = log.get(prefixLen-1).term;
        // logRequest RMI invocation goes here, something like rhoClient.logRequest(leaderID, currentTerm, prefixLen, prefixTerm, commitLength, suffix) (send to followerID, e.g. rho)
    }

    // MAKE RPC (connected with logResponse(...))
    // invoked by leader onto a follower node to update this follower's log
    private static void logRequest(String leaderID, int term, int prefixLen, int prefixTerm, int leaderCommit, LinkedList<LogEntry> suffix) {
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
            // logResponse RMI invocation here, something like rhoClient.logResponse(selfID, currentTerm, ack, true) (send to leaderID, e.g. rho)
        } else {
            // logResponse RMI invocation here, something like rhoClient.logResponse(selfID, currentTerm, 0, false) (send to leaderID, e.g. rho)
        }
    }

    // only followers invoke this, where they append uncommitted entries received from the leader to their own log
    private static void AppendEntries(int prefixLen, int leaderCommit, LinkedList<LogEntry> suffix) {
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
                // deliver log.get(i).gamestate to the application? according to video.
                // (seems wrong to have every follower send an update to the application though..)
            }
            commitLength = leaderCommit;
        }
    }

    // MAKE RPC (connected with logRequest(...))
    // invoked by non-leader node onto leader to acknowledge whether it appended what was sent to it or not
    private static void logResponse(String follower, int term, int ack, boolean success) {
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
                ReplicateLog(selfID, follower);
            }
        } else if(term > currentTerm) {
            currentTerm = term;
            currentRole = "follower";
            votedFor = null;
            restartElectionTimer();
        }
    }

    // invoked only by leader, commits log entries which have been acknowledged by majority of followers,
    // and then send to the application.
    private static void CommitLogEntries() {
        while(commitLength < log.size()) {
            int acks = 0;
            // check every node for if they have uncommitted log entries
            for(String node : nodes) {
                if(ackedLength.get(node) > commitLength)
                    acks++;
            }
            // if a majority of nodes have uncommitted log entries, commit them (send to application and increment commitLength)
            if(acks >= (nodes.length+1)/2) {
                // deliver log.get(commitLength).gamestate to the application
                commitLength++;
            } else
                break;
        }
    }

    // invoked by every node, but only if leader, send an update to all followers.
    // (nothing was added to the leader though, so this won't change anything on the followers, but will keep them
    // from triggering an election)
    private static void tryHeartbeat() {
        if(currentRole.equals("leader")) {
            for(String follower : nodes) {
                ReplicateLog(selfID, follower);
            }
        }
    }

    // passive timer thread to trigger an election if it times out
    private static void restartElectionTimer() {
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
    private static void electionTimedOut() {
        currentTerm += 1;
        currentRole = "candidate";
        votedFor = selfID;
        votesReceived.clear();
        votesReceived.add(selfID);
        int lastTerm = 0;
        if(log.size() > 0) {
            LogEntry state = log.get(log.size()-1);
            lastTerm = state.term;
        }
        for(String node : nodes) {
            if(!node.equals(selfID)) {
                InetAddress destination;
                try {
                    destination = InetAddress.getByName(node);
                } catch (UnknownHostException e) {
                    System.out.println("ERROR GETTING ADDRESS FOR: " + node);
                }
                // [RequestVote RPC with args (currentTerm, selfID, log.size(), lastTerm)]
                // voteRequest RMI invocation goes here, to the effect of rhoClient.voteRequest(currentTerm, selfID, log.size(), lastTerm), sending to destination (e.g. rho)
            }
        }
        restartElectionTimer();
    }

    private static InetAddress getLocalAddress() {
        try(final DatagramSocket socket = new DatagramSocket()){
            socket.connect(InetAddress.getByName("8.8.8.8"), PORT);
            return socket.getLocalAddress();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
