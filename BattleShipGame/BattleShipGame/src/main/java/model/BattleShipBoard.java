package model;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.management.BadAttributeValueExpException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class BattleShipBoard 
{
    public static final int BOARDSIZE = 20; //row and column
    public static final int PREPAREPHASE = 1;
    public static final int GAMEPHASE = 2;

    public boolean isHost;
    private Player self;
    public LinkedList<Player> playerList;
    private int turn;
    private int phase;
    
    public int lastestCommandCode;
    
    public BattleShipBoard(String ipv4, int port, boolean isHost, String name)
    {
        phase = 1;
        turn = 1;
        this.isHost = isHost;
        playerList = new LinkedList<>();
        addSelf(ipv4, port, name);
    }

    //----------------------------------------player---------------------------------------------

    private void addSelf(String ipv4, int port, String name)
    {
        this.self = new Player(ipv4, port, name);
        playerList.add(self);
    }

    /**
     * add player to the current host board
     * @param json json packet recieve from client
     */
    public void addPlayer(String json)
    {
        Type listOfMyClassObject = new TypeToken<BattleShipBoard>() {}.getType();
        BattleShipBoard newBoard = new Gson().fromJson(json, listOfMyClassObject);
        playerList.add(newBoard.self);
    }

    /**
     * manually add a player
     * @param player player object
     */
    public void addPlayer(Player player)
    {
        playerList.add(player);
    }

    public Player getSelfFromPlayerList()
    {
        for(Player player : playerList)
        {
            if(player.ipv4.compareTo(self.ipv4) == 0 && player.port == self.port && player.name.compareTo(self.name) == 0)
            {
                this.self = player;
                return player;
            }
        }

        return null;
    }
    
    public void resetSelfBoard()
    {
        this.getSelfFromPlayerList().boardMatrix = new BoardMatrix();
    }

    //----------------------------------------Board setup---------------------------------------------

    /**
     * print self board
     * @return self board is one big String
     */
    public String printSelfBoard()
    {
        return this.self.boardMatrix.printSelfBoard();
    }

    /**
     * print shoot board
     * @return shoot board in one big String
     */
    public String printShootBoard()
    {
        return this.self.boardMatrix.printShootBoard();
    }

    /**
     * get current game phase as String
     * @return game phase as String
     */
    public String getGamePhase()
    {
        switch(phase)
        {
            case PREPAREPHASE:
                return "Prepare Phase";
            case GAMEPHASE:
                return "Game Phase";
            default:
                return null;
        }
    }

    private boolean isValidPlaceShip(String[] square)
    {
        boolean horizontal = Integer.parseInt(square[0].charAt(1) + "") == Integer.parseInt(square[1].charAt(1) + "");
        List<Integer> rowIDs = new ArrayList<>();
        List<Integer> columnIDs = new ArrayList<>();

        for(String str : square)
        {
            rowIDs.add(Integer.parseInt(str.charAt(1) + ""));
            columnIDs.add((int)str.charAt(0));
        }

        Collections.sort(rowIDs);
        Collections.sort(columnIDs);

        if(horizontal)
        {
            int rowID = rowIDs.get(0);
            int columnID = columnIDs.get(0);

            for(int count = 0; count < rowIDs.size(); count++)
            {
                if(rowIDs.get(count) != rowID)
                    return false;

                if(Math.abs(columnIDs.get(count) - columnID) > 1)
                    return false;

                rowID = rowIDs.get(count);
                columnID = columnIDs.get(count);
            }
        }
        else //if it not horizontal place
        {
            int rowID = rowIDs.get(0);
            int columnID = columnIDs.get(0);

            for(int count = 0; count < rowIDs.size(); count++)
            {
                if(Math.abs(rowIDs.get(count) - rowID) > 1)
                    return false;

                if(columnIDs.get(count) != columnID)
                    return false;

                rowID = rowIDs.get(count);
                columnID = columnIDs.get(count);
            }
        }

        return true;
    }

    /**
     * place/set a Carrier ship with length of 5 square on the self board (only valid for case: vertical or horizontal)
     * @param square list of 5 square code name
     * @return true if it a valid placement else false
     */
    public boolean placeCarrier(String[] square)
    {
        //check take 5 square
        if(square.length != 5)
            return false;

        if(!self.boardMatrix.placeShip(square, "Carrier"))
            return false;
        
        return true;
    }

    /**
     * place/set a battle ship with length of 4 square on the self board (only valid for case: vertical or horizontal)
     * @param square list of 4 square code name
     * @return true if it a valid placement else false
     */
    public boolean placeBattleShip(String[] square)
    {
        //check take 4 square
        if(square.length != 4)
            return false;

        if(!self.boardMatrix.placeShip(square, "BattleShip"))
            return false;

        return true;
    }

    /**
     * place/set a crusier ship with length of 3 square on the self board (only valid for case: vertical or horizontal)
     * @param square list of 3 square code name
     * @return true if it a valid placement else false
     */
    public boolean placeCrusier(String[] square)
    {
        //check take 3 square
        if(square.length != 3)
            return false;

        if(!self.boardMatrix.placeShip(square, "Crusier"))
            return false;
        
        return true;
    }

    /**
     * place/set a submarine ship with length of 3 square on the self board (only valid for case: vertical or horizontal)
     * @param square list of 3 square code name
     * @return true if it a valid placement else false
     */
    public boolean placeSubmarine(String[] square)
    {
        //check take 3 square
        if(square.length != 3)
            return false;

        if(!self.boardMatrix.placeShip(square, "Submarine"))
            return false;

        return true;
    }

    /**
     * place/set a destroyer ship with length of 2 square on the self board (only valid for case: vertical or horizontal)
     * @param square list of 2 square code name
     * @return true if it a valid placement else false
     */
    public boolean placeDestroyer(String[] square)
    {
        //check take 2 square
        if(square.length != 2)
            return false;

        if(!self.boardMatrix.placeShip(square, "Destroyer"))
            return false;

        return true;
    }

    //----------------------------------------Game Phrase---------------------------------------------

    /**
     * is it self turn on the board?
     * @return true if it self turn on the board
     */
    public boolean isSelfTurn()
    {
        return self.selfTurn;
    }

    /**
     * is it game over for my self on the board (check if all ship is shinked)
     * @return true if it game over for self
     */
    public boolean isGameOverForSelf()
    {
        return self.boardMatrix.isAllShipShink();
    }

    /**
     * is it game over (all player ship shink except one player)
     * @return true if all player ship shink except one player
     */
    public boolean isGameOver()
    {
        int numberOfDeadPlayer = 0;
        for(Player player : playerList)
        {
            if(player.boardMatrix.isAllShipShink())
                numberOfDeadPlayer++;
        }

        return numberOfDeadPlayer >= (playerList.size() - 1);
    }

    /**
     * start the game function should be call after host add all player
     * @return update board command for all other client
     */
    public String startTheGame()
    {
        Random random = new Random();
        int num = random.nextInt(playerList.size());
        playerList.get(num).selfTurn = true;
        phase = GAMEPHASE;

        return createUpdateBoardCommand();
    }

    //----------------------------------------json command---------------------------------------------

    /**
     * handle all incomming command from jsonPacket
     * @param jsonPacket json String comming from either host or client
     * @return the current board if host need to update board for all client or null if nothing is needed
     * @throws NullPointerException if jsonPacket String is either have data lost, invalid or wrong
     */
    public String handleCommand(String jsonPacket) throws NullPointerException
    {
        Command command = Command.fromJson(jsonPacket);
        this.lastestCommandCode = command.commandCode;
        
        if(command.commandCode <= 0)
            throw new NullPointerException("can't handle command because invalid json packet");

        if(command.commandCode == Command.UPDATEBOARD)
        {
            
            this.playerList.clear();
            this.playerList = command.battleShipBoard.playerList;
            getSelfFromPlayerList();
            
        }

        if(command.commandCode == Command.SHOOT)
        {
            Player sender = getPlayer(command.senderIvp4, command.senderPort, command.senderName);
            String hitCodeName = command.hitAtCodeName;
            boolean hitSomething = false;

            for(Player player : playerList)
            {
                if(player != sender)
                {
                    boolean hit = player.boardMatrix.takeHit(hitCodeName);
                    if(hitSomething == false)
                        hitSomething = hit;
                }
            }

            if(hitSomething)
                sender.boardMatrix.registerHit(hitCodeName);
            else 
                sender.boardMatrix.registerMissHit(hitCodeName);

            //next player turn
            for(Player player : playerList)
                player.selfTurn = false;
            int playerIndex = playerList.indexOf(sender);

            do
            {
                playerIndex = (playerIndex + 1) % playerList.size();
            }
            while(playerList.get(playerIndex).boardMatrix.isAllShipShink());
            
            playerList.get(playerIndex).selfTurn = true;
            
            return createUpdateBoardCommand();
        }

        if(command.commandCode == Command.ADDPLAYER)
        {
            addPlayer(command.battleShipBoard.self);
        }
        
        if(command.commandCode == Command.KEEPALIVE)
        {
            this.addPlayer(command.player);
            
            return createUpdateBoardCommand();
        }
        
        if(command.commandCode == Command.REQUESTKEEPALIVE)
        {
            return createKeepAlive();
        }

        return null;
    }
    
    public String createKeepAlive()
    {
        Command command = new Command(Command.KEEPALIVE);
        
        command.player = this.getSelfFromPlayerList();
        
        return command.toJson();
    }
    
    public String createRequestKeepAlive()
    {
        Command command = new Command(Command.REQUESTKEEPALIVE);
        
        return command.toJson();
    }

    /**
     * create add player json String packet for host
     * @return jsonPacket ready to send
     */
    public String createAddPlayerCommand()
    {
        Command command = new Command(Command.ADDPLAYER);

        command.battleShipBoard = this;

        return command.toJson();
    }

    /**
     * create update board command for all client
     * @return jsonPacket ready to send
     */
    public String createUpdateBoardCommand()
    {
        Command command = new Command(Command.UPDATEBOARD);

        command.battleShipBoard = this;

        return command.toJson();
    }

    /**
     * create shoot command for host
     * @param squareCodeName what is the square code name
     * @return json packet ready to send
     * @throws BadAttributeValueExpException if square code name is invalid
     */
    public String createShootCommand(String squareCodeName) throws BadAttributeValueExpException
    {
        if(!self.boardMatrix.shootBoardMap.containsKey(squareCodeName))
            throw new BadAttributeValueExpException("invalid square code name");

        Command command = new Command(Command.SHOOT);

        command.senderIvp4 = self.ipv4;
        command.senderPort = self.port;
        command.senderName = self.name;
        command.hitAtCodeName = squareCodeName;

        return command.toJson();
    }
    
    public String createWinnerCommand()
    {
        Command command = new Command(Command.WINNER);
        
        return command.toJson();
    }

    private String toJson()
    {
        return new Gson().toJson(this);
    }

    private void updateBoard(String json)
    {
        Type listOfMyClassObject = new TypeToken<BattleShipBoard>() {}.getType();
        BattleShipBoard newBoard = new Gson().fromJson(json, listOfMyClassObject);
        this.playerList.clear();
        this.playerList = newBoard.playerList;
        getSelfFromPlayerList();
        
        // Type listOfMyClassObject = new TypeToken<LinkedList<Player>>() {}.getType();
        // LinkedList<Player> newPlayerList = gson.fromJson(json, listOfMyClassObject);
        // this.playerList = newPlayerList;
    }

    public Player getPlayer(String ipv4, int port, String name)
    {
        for(Player player : playerList)
        {
            if(player.ipv4.compareTo(ipv4) == 0 && player.port == port && player.name.compareTo(name) == 0)
                return player;
        }

        return null;
    }
    
    public void shufflePlayerTurn()
    {
        for(Player player : playerList)
            player.selfTurn = false;
        Random random = new Random();
        int num = random.nextInt(playerList.size());
        playerList.get(num).selfTurn = true;
    }
    
    public void removeAllButSelf()
    {
        Player self = this.getSelfFromPlayerList();
        
        playerList.clear();
        
        playerList.add(self);
    }
}
