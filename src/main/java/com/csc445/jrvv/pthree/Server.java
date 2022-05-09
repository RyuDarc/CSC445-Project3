package com.csc445.jrvv.pthree;

import java.util.List;

public interface Server {
    /**
     * unblock udp or ask tcp server to accept
     */
    public void StartConnection();
    /**
     * Send the data to all available client
     * @param data json->string
     */
    public void SendingData(String data);
    
    /**
     * Fetch data from tcp/udp buffer
     * @return packet data in string(json string)
     */
    public List<String> ReceiveData();

    /**
     * Send message to server
     * @return bool successful (http status 200)
     * @throws illegalstate no server registered
     */
    public boolean toServer(Object message) throws java.lang.IllegalStateException;

    /**
     * Send message to client by asking server
     */
}
