package com.csc445.jrvv.pthree;

public interface UDPInterface {
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
    public String ReceiveData();
}
