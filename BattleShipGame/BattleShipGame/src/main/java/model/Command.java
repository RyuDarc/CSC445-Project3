package model;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Command 
{
    public static int SHOOT = 1;
    public static int UPDATEBOARD = 2;
    public static int ADDPLAYER = 3;
    public static int KEEPALIVE = 4;
    public static int REQUESTKEEPALIVE = 5;
    public static int WINNER = 6;

    public int commandCode;
    public String hitAtCodeName;
    public String senderIvp4;
    public int senderPort;
    public String senderName;
    public BattleShipBoard battleShipBoard;
    public Player player;

    public Command(int commandCode)
    {
        this.commandCode = commandCode;
    }

    public String toJson()
    {
        return new Gson().toJson(this);
    }

    public static Command fromJson(String json)
    {
        Type listOfMyClassObject = new TypeToken<Command>() {}.getType();
        Command newCommand = new Gson().fromJson(json, listOfMyClassObject);
        return newCommand;
    }
}
