package model;

public class Player
{
    public String name;
    public String ipv4;
    public int port;
    public BoardMatrix boardMatrix;
    public boolean selfTurn;
    
    public Player(String ipv4, int port)
    {
        this.ipv4 = ipv4;
        this.port = port;
        this.name = "Player";
        boardMatrix = new BoardMatrix();
        selfTurn = false;
    }

    public Player(String ipv4, int port, String name)
    {
        this.ipv4 = ipv4;
        this.port = port;
        this.name = name;
        boardMatrix = new BoardMatrix();
        selfTurn = false;
    }

    
}
