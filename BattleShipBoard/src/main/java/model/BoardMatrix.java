package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BoardMatrix 
{
    public HashMap<String, Square> selfBoardMap;
    public HashMap<String, Square> shootBoardMap;
    public LinkedList<Ship> shipList;
    public static final int maxShip = 5;
    public int currentAviableShip;
    public int shinkedShip;

    public BoardMatrix()
    {
        selfBoardMap = new HashMap<>();
        shootBoardMap = new HashMap<>();
        shipList = new LinkedList<>();
        currentAviableShip = maxShip;
        shinkedShip = 0;

        for(int count = 1; count <= BattleShipBoard.BOARDSIZE; count++)
        {
            for(int character = 65; character < (65 + BattleShipBoard.BOARDSIZE); character++)
            {
                char characterT = (char)(character);
                String codeName = characterT + "" + count;
                selfBoardMap.put(codeName, new Square(codeName));
                shootBoardMap.put(codeName, new Square(codeName));
            }
        }
    }

    public boolean isAllShipShink()
    {
        // for(Ship ship : shipList)
        //     if(!ship.shinkedShip)
        //         return false;

        // return true;

        return shinkedShip == (maxShip - currentAviableShip);
    }

    public boolean takeHit(String squareCodeName)
    {
        Square square = selfBoardMap.get(squareCodeName);

        if(!square.isShipPart)
        {
            square.missHit = true;
            return false;
        }

        square.hit = true;

        //check if that make it ship shink
        for(String scn : square.ship.squareCodeNames)
        {
            Square s = selfBoardMap.get(scn);
            if(s.hit == false)
                return true;
        }
        shinkedShip++;
        square.ship.shinkedShip = true;
        return true;
    }

    public void registerHit(String squareCodeName)
    {
        Square square = shootBoardMap.get(squareCodeName);
        square.hit = true;
    }

    public void registerMissHit(String squareCodeName)
    {
        Square square = shootBoardMap.get(squareCodeName);
        square.missHit = true;
    }

    public boolean placeShip(String[] squareCodeNames, String shipName)
    {
        if(currentAviableShip == 0)
            return false;

        for(String codeName : squareCodeNames)
        {
            if(selfBoardMap.get(codeName.toUpperCase()).isShipPart)
                return false;
        }

        for(String codeName : squareCodeNames)
        {
            Ship newShip = new Ship(shipName, squareCodeNames.length, squareCodeNames);
            shipList.add(newShip);
            selfBoardMap.get(codeName.toUpperCase()).placeShipPart(newShip);
        }

        currentAviableShip--;

        return true;
    }

    public String printSelfBoard()
    {
        String board = "";
        for(int count = 1; count <= BattleShipBoard.BOARDSIZE; count++)
        {
            for(int character = 65; character < (65 + BattleShipBoard.BOARDSIZE); character++)
            {
                char characterT = (char)(character);
                String codeName = characterT + "" + count;
                Square square = selfBoardMap.get(codeName);

                board += square.toString() + "\t";
            }
            board += "\n";
        }

        System.out.println(board);
        
        return board;
    }

    public String printShootBoard()
    {
        String board = "";
        for(int count = 1; count <= BattleShipBoard.BOARDSIZE; count++)
        {
            for(int character = 65; character < (65 + BattleShipBoard.BOARDSIZE); character++)
            {
                char characterT = (char)(character);
                String codeName = characterT + "" + count;
                Square square = shootBoardMap.get(codeName);

                board += square.toString() + "\t";
            }
            board += "\n";
        }

        System.out.println(board);
        
        return board;
    }
}
