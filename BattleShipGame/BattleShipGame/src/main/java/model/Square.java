package model;

public class Square 
{
    public String codeName;
    public boolean missHit;
    public boolean hit;
    public boolean isShipPart;
    public Ship ship;

    public Square(String codeName)
    {
        hit = false;
        isShipPart = false;
        this.codeName = codeName;
    }

    public void placeShipPart(Ship ship)
    {
        this.isShipPart = true;
        this.ship = ship;
    }

    @Override
    public String toString()
    {
        if(missHit)
            return "[O]";

        if(hit)
            return "[X]";

        if(isShipPart)
            return String.format("[%s]", (ship.name.charAt(0) + "").toUpperCase());

        return codeName;
    }
}
