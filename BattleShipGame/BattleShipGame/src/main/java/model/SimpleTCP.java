
package model;

import java.net.InetAddress;

import okhttp3.*;
public class SimpleTCP 
{
    public SimpleTCPClient client;
    public SimpleTCPServer server;
    public String ip;
    public int port;


    public SimpleTCP(String ip, int port)
    {
        this.ip = ip;
        this.port = port;

        server = new SimpleTCPServer(port)
        {
            @Override
            public void handleRecieveFromClient(String data) 
            {
                super.handleRecieveFromClient(data);
                handleRecieveData(data);
            }
            
            @Override
            public void handleDisconnectToClient(String ip, int port) {
                handleDisconnect(ip, port);
            }
            
        };
    }

    public static String getExternalIP() {
        OkHttpClient client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder().scheme("http").host("ifconfig.io").addPathSegment("ip").build();
        // RequestBody body = RequestBody.create(payload.toString(), JSON);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.code() == 200) {
                return response.body().string();
            } else {
                try {
                    return InetAddress.getLocalHost().getHostAddress();
                } catch (Exception ex) {

                }

            }
        } catch (Exception e) {

        }
        return null;
    }

    public void startServer()
    {
        if(!server.running)
            server.startServer();
        else
        {
            server.shutdownServer();
            server.startServer();
        }
    }

    public boolean connect()
    {
        if(client != null)
            client.close();

        client = new SimpleTCPClient(ip, port)
        {
            @Override
            public void handleReceiveFromServer(String receiveString) 
            {
                handleRecieveData(receiveString);
            }
            
            @Override
            public void handleDisconnectToServer(String ip, int port) {
                handleDisconnect(ip, port);
            }
            
        };
        
        try
        {
            client.connect();
        }
        catch(Exception ex)
        {
            return false;
        }
        
        return true;
    }

    public void connect(String ip, int port)
    {
        if(client != null)
            client.close();

        client = new SimpleTCPClient(ip, port);
    }
    
    public void handleRecieveData(String data)
    {
        
    }
    
    public void handleDisconnect(String ip, int port)
    {
        System.out.println(String.format("Disconnect (ip:%s, port:%s)", ip, port));
    }
}
