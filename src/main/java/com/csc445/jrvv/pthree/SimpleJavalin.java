package com.csc445.jrvv.pthree;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import io.javalin.Javalin;
import io.javalin.websocket.WsContext;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

//import com.google.gson.*;
import org.json.*;
import java.io.*;
import java.net.*;
import java.nio.*;
import java.util.*;
import java.util.concurrent.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.status.StatusData;

public class SimpleJavalin implements Server {
    // private static Map<WsContext, String> userUsernameMap = new ConcurrentHashMap<>();
    // private static int nextUserNumber = 1; // Assign to username for next connecting user
    Javalin app;
    private int port;
    public static List<String> ActiveHost = new ArrayList<String>();
    ObjectMapper mapper = new ObjectMapper();
    OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    BattleShipGame bs = null;
    Algorithm algorithm = Algorithm.HMAC256("battleship");
    JWTVerifier verifier = JWT.require(algorithm).withIssuer("auth0").build();
    
    

    public String createToken(String payload){
        String token = JWT.create()
                .withIssuer("auth0")
                .withClaim("payload",payload)
                .sign(algorithm);
    }

    public String decodeToken(String token) throws JWTVerificationException{
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getPayload();
    }

    public SimpleJavalin(BattleShipGame bs) {
        // Javalin app = Javalin.create(config -> {
        // config.addStaticFiles("/public", Location.CLASSPATH);
        // }).start(port);
        this.bs = bs;
        this.port = bs.getPort();
        app = Javalin.create(config -> {
            config.defaultContentType = "application/json";
        });
        // app.ws("/chat", ws -> {
        // ws.onConnect(ctx -> {
        // String username = "User" + nextUserNumber++;
        // userUsernameMap.put(ctx, username);
        // broadcastMessage("Server", (username + " joined the chat"));
        // });
        // ws.onClose(ctx -> {
        // String username = userUsernameMap.get(ctx);
        // userUsernameMap.remove(ctx);
        // broadcastMessage("Server", (username + " left the chat"));
        // });
        // ws.onMessage(ctx -> {
        // broadcastMessage(userUsernameMap.get(ctx), ctx.message());
        // });
        // });

        // register
        app.get("/register", ctx -> {
            bs.addClient(ctx.body());
            this.ActiveHost.add(ctx.body());
        });

        //generate JTW token test
        app.get("/generate", ctx -> {
            JSONObject json = new JSONObject();
            json.put("test","True");
            String token = createToken(json.toString());
            ctx.json(token);
        });

        app.post("/verify",ctx->{
            try{
                String payload = decodeToken(ctx.body());
                JSONObject json = new JSONObject();
                json.put("status",200);
                ctx.json(json.toString());
                ctx.status(200);
            }catch(Exception e){
                ctx.status(401);
            }
        });

        // heartbeat
        app.get("/heartbeat", ctx -> ctx.html("Alive"));

        // boardstatus
        // app.get("/boardstatus", ctx -> new
        // JSONObject().put(bs.getBoardStatus()).toString());
        app.get("/boardstatus", ctx -> {
            ctx.json(bs.getBoardStatus());
        });

        // command
        app.post("/command", ctx -> {
            ctx.status(200);
            bs.processCommand(ctx.body());
        });

        /**
         * Gets fired
         * 
         * @POST
         */
        app.post("fire", ctx -> {
            String js = ctx.body();
            bs.getFired(js);
        });

        /**
         * @POST
         * receive any command in post payload and call controller to process
         */
        app.post("receiveCommand",ctx-> {
            String command = ctx.body();
            bs.receiveCommand(command);
        });

        

    }


    /**
     * 
     * @param payload Object Any object with toString() complaint
     * @param host the host to communicate with
     * @param endpoint the url to post
     * @return String result
     */
    public String SendAnything(Object payload, String host, String endpoint){
        HttpUrl url = new HttpUrl.Builder().scheme("http").host(host).addPathSegment(endpoint).build();
        RequestBody body = RequestBody.create(payload.toString(), JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if (response.code() == 200) {
            return response.body().string();
        } else {
            throw new RuntimeException("Request Failed");
        }
    }

    public void SendSomething(JSONObject js, String host) throws IOException {
        
        RequestBody body = RequestBody.create(js.toString(), JSON);
        Request request = new Request.Builder()
                .url(host)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if (response.code() == 200) {
            return;
        } else {
            throw new RuntimeException("Request Failed");
        }
        // return response.body().string();
    }

    // Sends a message from one user to all users, along with a list of current
    // usernames
    private static void broadcastMessage(String sender, String message) {
        userUsernameMap.keySet().stream().filter(ctx -> ctx.session.isOpen()).forEach(session -> {
            session.send(
                    new JSONObject()
                            // .put("userMessage", createHtmlMessageFromSender(sender, message))
                            .put("userlist", userUsernameMap.values())
                            .toString());
        });
    }


    @Override
    public void StartConnection() {
        app.start(this.port);
    }

    @Override
    public void SendingData(String data) {
        for (String host : ActiveHost) {
            RequestBody body = RequestBody.create(data, JSON);
            Request request = new Request.Builder()
                    .url(host)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            if (response.code() == 200) {
                return;
            } else {
                throw new RuntimeException("Request Failed");
            }
        }
    }

    /**
     * Check if all host is alive
     */
    public void AreYouAlive() {
        for (String host : ActiveHost) {
            String data = "";
            RequestBody body = RequestBody.create(data, JSON);
            Request request = new Request.Builder()
                    .url(host)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            if (response.code() == 200) {
            } else {
                // delete dead client from list
                ActiveHost.remove(host);
                // throw new RuntimeException("Request Failed");
            }
        }
    }

    /**
     * Check if host is alive
     * 
     * @param host the host ip address to check
     * @return true if the host answered heartbeat,false if the host timeout
     */
    public boolean AreYouAlive(String host) {

        String data = "";
        RequestBody body = RequestBody.create(data, JSON);
        Request request = new Request.Builder()
                .url(host)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if (response.code() == 200) {
            return true;
        } else {
            // delete dead client from list
            ActiveHost.remove(host);
            return false;
            // throw new RuntimeException("Request Failed");
        }

    }

    public void SendingData(String data, String host) {
        RequestBody body = RequestBody.create(data, JSON);
        Request request = new Request.Builder()
                .url(host)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if (response.code() == 200) {
            return;
        } else {
            throw new RuntimeException("Request Failed");
        }
    }

    @Override
    public List<String> ReceiveData() {
        return null;
    }

    public static void main(String[] args) {
        // SimpleJavalin sj = new SimpleJavalin(7000);
    }

    @Override
    public boolean toServer(Object message) throws IllegalStateException {
        // TODO Auto-generated method stub
        RequestBody body = RequestBody.create(message.toString(), JSON);
        try{
            Request request = new Request.Builder()
                .url(this.server)
                .post(body)
                .build();
            Response response = client.newCall(request).execute();
            if (response.code() == 200) {
                return true;
            } 
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
