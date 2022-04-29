package com.csc445.jrvv.pthree;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import io.javalin.Javalin;
import io.javalin.websocket.WsContext;
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

    // Builds a HTML element with a sender-name, a message, and a timestamp
    // private static String createHtmlMessageFromSender(String sender, String
    // message) {
    // return article(
    // b(sender + " says:"),
    // span(attrs(".timestamp"), new SimpleDateFormat("HH:mm:ss").format(new
    // Date())),
    // p(message)).render();
    // }

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
}
