package RAFT_Battleship.server;

public class Ballot {
    String nodeID;
    int term;
    boolean voteGranted;
    public Ballot(String nodeID, int term, boolean voteGranted) {
        this.nodeID = nodeID; this.term = term; this.voteGranted = voteGranted;
    }
}
