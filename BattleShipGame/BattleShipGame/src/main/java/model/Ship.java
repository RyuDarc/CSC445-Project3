package model;

public class Ship 
{
    String name;
    int length;
    String[] squareCodeNames;
    boolean shinkedShip;

    public Ship(String name, int length, String[] squareCodeName)
    {
        shinkedShip = false;
        this.name = name;
        this.length = length;
        this.squareCodeNames = squareCodeName;
    }
}
