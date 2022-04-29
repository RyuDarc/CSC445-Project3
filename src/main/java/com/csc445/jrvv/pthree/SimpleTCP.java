package com.csc445.jrvv.pthree;

import java.io.*;
import java.net.*;
import java.nio.*;
import java.util.*;
import java.util.concurrent.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.status.StatusData;
import com.google.common.base.Preconditions;



public class SimpleTCP implements Server {
    private static Logger logger = LogManager.getLogger(SimpleTCP.class);
    
    /**
     * Ten Threads(Clients) for max incoming connections
     */
    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newScheduledThreadPool(10);
    Thread ServerThread = null;
    ServerSocket ss;
    SimpleTCPFactory tcpfactory = new SimpleTCPFactory();
    List<Thread> threads = new ArrayList<>();
    List<Thread> ActiveThreads = Collections.synchronizedList(threads);
    List<SimpleTCPHandler> ActiveHandlers = new ArrayList<SimpleTCPHandler>();
    List<SimpleTCPHandler> SyncActiveHandlers = Collections.synchronizedList(ActiveHandlers);
    Map<Socket,BufferedReader> rmap = new HashMap<>();
    Map<Socket,BufferedWriter> wmap = new HashMap<>();
    Map<Socket,BufferedReader> srmap = Collections.synchronizedMap(rmap);
    Map<Socket, BufferedWriter> swmap = Collections.synchronizedMap(wmap);
    List<BufferedReader> br = new ArrayList<BufferedReader>();
    List<BufferedWriter> bw = new ArrayList<BufferedWriter>();
    public SimpleTCP() throws IOException{
        this(56789);
    }

    public SimpleTCP(int tcpport) throws IOException{
        ss = new ServerSocket(tcpport);
        logger.info("Server Created : {}",ss);
    }   
    

    @Override
    public void StartConnection() {
        ServerThread = new Thread(()->{
            try(Socket client = ss.accept()){
                logger.info("New Client : {}", client);
                client.setSoTimeout(1000);
                //then we store two streams
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                // br.add(in);
                // bw.add(out);
                swmap.put(client,out);
                srmap.put(client,in);
                // SimpleTCPHandler handler = new SimpleTCPHandler(client);
                // //SyncActiveHandlers.add(handler);
                // Thread t = tcpfactory.newThread(handler);
                // ActiveThreads.add(t);
                // executor.execute(t);
                // //executor.execute(handler);
            }catch(Exception e){
                e.printStackTrace();
            }
        });
        ServerThread.start();
    }

    @Override
    public void SendingData(String data) {
        for(Map.Entry<Socket, BufferedWriter>entry:swmap.entrySet()){
            try{
                entry.getValue().write(data);
            } catch (SocketTimeoutException ex) {
                logger.warn("Write failed to : {}", entry.getKey());
            }
            catch(SocketException ex){
                logger.error("The socket is dead : {}", entry.getKey());
                swmap.remove(entry.getKey());
                srmap.remove(entry.getKey());
            }
            catch(Exception e){ 
                e.printStackTrace();
                //the writer(client is dead)
                swmap.remove(entry.getKey());
                srmap.remove(entry.getKey());
            }
        }
    }

    @Override
    public List<String> ReceiveData() {
        List<String>rBuffer = new ArrayList<String>();
        for (Map.Entry<Socket, BufferedReader> entry : srmap.entrySet()) {
            try {
                rBuffer.add(entry.getValue().readLine());
            }
            catch(SocketTimeoutException ex){
                logger.warn("No data yet for : {}",entry.getKey());
            }
            catch (SocketException e) {
                // the writer(client is dead)
                logger.error("The socket is dead : {}",entry.getKey());
                swmap.remove(entry.getKey());
                srmap.remove(entry.getKey());
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return rBuffer;
    }

}


