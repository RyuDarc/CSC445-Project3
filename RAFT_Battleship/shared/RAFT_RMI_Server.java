package RAFT_Battleship.shared;

import RAFT_Battleship.server.LogEntry;
import RAFT_Battleship.server.RunServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;

public interface RAFT_RMI_Server extends Remote {
    void RequestVote(int cTerm, String cID, int cLogLength, int cLogTerm, RunServer client) throws RemoteException;
    void LogRequest(String leaderID, int term, int prefixLen, int prefixTerm, int leaderCommit, LinkedList<LogEntry> suffix, RunServer client) throws RemoteException;
}
