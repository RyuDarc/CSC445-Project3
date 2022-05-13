package RAFT_Battleship.server;

public class LogEntry {
    public int term;
    Gamestate gamestate;
    public LogEntry(int term, Gamestate gamestate) {
        this.term = term; this.gamestate = gamestate;
    }
}
