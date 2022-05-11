
package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class SimpleTCPClient extends TCPClient implements Runnable
{
    public static void main(String[] args) 
    {
        SimpleTCPClient simpleTCPClient = new SimpleTCPClient("localhost", 1111);
        Scanner scan = new Scanner(System.in);
        String input = "";
        try
        {
            simpleTCPClient.connect();
            while(input.compareTo("EXIT") != 0)
            {
                System.out.print("send data: ");
                input = scan.nextLine();
                if(input.compareTo("EXIT") == 0 || input == null)
                {
                    simpleTCPClient.close();
                    break;
                }
                simpleTCPClient.SendToServer(input);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private Thread mainThread;
    public boolean startThreadOnConnect = true;
    public boolean running;
    @Override
    public void run() 
    {
        this.running = true;
        
        while(!mainThread.isInterrupted() && running)
        {
            try
            {
                handleReceiveFromServer(RecieveFromServer());
            }
            catch(SocketException ex)
            {
                ex.printStackTrace();
                close();
                break;
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
                close();
                break;
            }
        }
    }

    public void handleReceiveFromServer(String receiveString)
    {
//        System.out.println(String.format("Receive from server: \n(raw):%s", receiveString));
    }

    public SimpleTCPClient()
    {
        super();
    }

    public SimpleTCPClient(String ip, int port)
    {
        super(ip, port);
    }

    @Override
    void connect() throws Exception 
    {
        // TODO Auto-generated method stub
        super.connect();

        mainThread = new Thread(this, "TCP client");

        if(startThreadOnConnect)
            mainThread.start();

        System.out.println(String.format("Connected to: ip:%s, port:%s", super.ip, super.port));
    }

    @Override
    public void close() 
    {
        // TODO Auto-generated method stub
        super.close();
        mainThread.interrupt();
        this.running = false;
        handleDisconnectToServer(this.ip, this.port);
    }

    public void killThread()
    {
        try
        {
            mainThread.interrupt();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void handleDisconnectToServer(String ip, int port)
    {
        System.out.println(String.format("Disconnect to: %s, %s", this.ip, this.port));
    }
}

class TCPClient
{
    //String name="";
    String ip = "localhost";
    int port = 1111;
    private Socket socket = null;

    private PrintWriter outToServer;
    private BufferedReader inFromServer;

    TCPClient()
    {
        
    }

    TCPClient(String ip, int port)
    {
        this.ip = ip;
        this.port = port;
    }

    /**
     * this function will send data to server
     * @param data data to be send
     */
    public void SendToServer(String data)
    {
        // System.out.println("send data: " + data);
        //send msg to server
        outToServer.println(data);
        outToServer.flush();
        // outToServer.println(data);
        // outToServer.flush();
    }
    
    /**
     * this function will return data recive from server
     * @return data recive from server
     * @throws Exception throw exception when unable to recive data
     */
    public String RecieveFromServer() throws Exception
    {
        return inFromServer.readLine();
    }

    public String SendAndWaitForServer(String data) throws IOException
    {
        outToServer.println(data);
        outToServer.flush();
        return inFromServer.readLine();
    }

    /**
     * this function will connect socket to server
     * @throws Exception throw exception when unable to connect to server
     */
    void connect() throws Exception
    {
        if(socket == null || !socket.isConnected() || socket.isClosed())
        {
            socket = new Socket(ip, port);
            outToServer = new PrintWriter(socket.getOutputStream(), true);
            inFromServer = new BufferedReader(new InputStreamReader (socket.getInputStream()));
        }
        else
            throw new Exception("Server is already connected");
    }
    
    /**
     * this function will close all connection from current server
     * @throws Exception exception throw when server is not connected or there something wrong with establising read data from server
     */
    void close()
    {
        try
        {
            outToServer.close();
            inFromServer.close();
            socket.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
