package RAFT_Battleship.server;

public class Gamestate {
    String[][] board;
    String pid; // playerID (randomly generated per client)
    public Gamestate (String[][] board, String pid) {
        this.board = board;
        this.pid = pid;
    }
}