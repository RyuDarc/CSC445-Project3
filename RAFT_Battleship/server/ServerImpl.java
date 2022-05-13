/*
package RAFT_Battleship.server;

import RAFT_Battleship.shared.RAFT_RMI_Client;
import RAFT_Battleship.shared.RAFT_RMI_Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements RAFT_RMI_Server {

    public ServerImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void RequestVote(int cTerm, String cID, int cLogLength, int cLogTerm, RAFT_RMI_Client client) {
        String result = str.toUpperCase();
        // heavy calculation here

        */
/*try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}*//*


        try {
            client.VoteResponse(result);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void LogRequest(String follower, int term, int ack, boolean success, RAFT_RMI_Client client) throws RemoteException {

    }
}
*/
