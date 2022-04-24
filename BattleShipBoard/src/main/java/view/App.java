package view;

import javax.management.BadAttributeValueExpException;

import model.BattleShipBoard;
import model.BoardMatrix;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NullPointerException, BadAttributeValueExpException
    {
        String updateBoard;

        BattleShipBoard host = new BattleShipBoard("localhost", 1111, true, "HOST");
        host.placeCarrier(new String[] {"A1", "B1", "C1", "D1", "E1"});
        host.placeBattleShip(new String[] {"A4", "B4", "C4", "D4"});

        BattleShipBoard player1 = new BattleShipBoard("localhost", 1111, false, "player1");
        player1.placeBattleShip(new String[] {"A6", "B6", "C6", "D6"});

        BattleShipBoard player2 = new BattleShipBoard("localhost", 1111, false, "player2");
        player2.placeBattleShip(new String[] {"A8", "B8", "C8", "D8"});

        host.handleCommand(player1.createAddPlayerCommand());
        host.handleCommand(player2.createAddPlayerCommand());

        updateBoard = host.startTheGame();

        player1.handleCommand(updateBoard);
        player2.handleCommand(updateBoard);

        host.printSelfBoard();
        player1.printSelfBoard();
        player2.printSelfBoard();

        System.out.println("Host turn: " + host.isSelfTurn());
        System.out.println("player1 turn: " + player1.isSelfTurn());
        System.out.println("player2 turn: " + player2.isSelfTurn());

        if(host.isSelfTurn())
        {
            updateBoard = host.createShootCommand("A6");
            updateBoard = host.handleCommand(updateBoard);
            player1.handleCommand(updateBoard);
            player2.handleCommand(updateBoard);
        }
        else if(player1.isSelfTurn())
        {   
            updateBoard = player1.createShootCommand("A1");
            updateBoard = host.handleCommand(updateBoard);
            player1.handleCommand(updateBoard);
            player2.handleCommand(updateBoard);
        }
        else if(player2.isSelfTurn())
        {
            updateBoard = player1.createShootCommand("A2");
            updateBoard = host.handleCommand(updateBoard);
            player1.handleCommand(updateBoard);
            player2.handleCommand(updateBoard);
        }

        host.printSelfBoard();
        host.printShootBoard();

        player1.printSelfBoard();
        player1.printShootBoard();

        player2.printSelfBoard();
        player2.printShootBoard();
        
        System.out.println(host.isGameOverForSelf());
        System.out.println(player1.isGameOverForSelf());
        System.out.println(host.isGameOver());
    }
}
