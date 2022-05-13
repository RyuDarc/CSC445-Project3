package RAFT_Battleship.shared;

import RAFT_Battleship.server.Ballot;
import RAFT_Battleship.server.LogEntry;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;

public interface RAFT_RMI_Client extends Remote {
    void VoteResponse(Ballot ballot) throws RemoteException;
    void LogResponse(String follower, int term, int ack, boolean success) throws RemoteException;
}
