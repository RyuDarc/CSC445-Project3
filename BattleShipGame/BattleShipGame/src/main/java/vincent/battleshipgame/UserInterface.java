package com.csc445.jrvv.pthree;

import java.awt.Color;
import java.util.ArrayList;
import javax.management.BadAttributeValueExpException;
import javax.swing.JOptionPane;

import model.BattleShipBoard;

public class UserInterface {

    static ArrayList<String> LocationGreen = new ArrayList<>(); //location of green ship

    static ArrayList<String> LocationBlue = new ArrayList<>(); //location of blue ship

    static ArrayList<String> LocationYellow = new ArrayList<>(); //etc.

    static ArrayList<String> LocationPink = new ArrayList<>();

    static ArrayList<String> LocationOrange = new ArrayList<>();

    String myIPV4string = "";
    String myPort = "";

    static int counter = 0;   //How to increment if working on different server?
    static String updateBoard = "";

    static BattleShipBoard host = new BattleShipBoard("localhost", 1111, true, "HOST");
    static BattleShipBoard player1 = new BattleShipBoard("localhost", 1111, false, "player1");
    static BattleShipBoard player2 = new BattleShipBoard("localhost", 1111, false, "player2");

    UserInterface(String IPV4string, String port) {
        myIPV4string = IPV4string;
        myPort = port;
    }

    
    
    
    public static void setupPlayers() {

        switch (counter) {  
            case 0:
                host.placeCarrier(new String[]{LocationGreen.get(0), LocationGreen.get(1), LocationGreen.get(2), LocationGreen.get(3), LocationGreen.get(4)});
                host.placeBattleShip(new String[]{LocationBlue.get(0), LocationBlue.get(1), LocationBlue.get(2), LocationBlue.get(3)});
                host.placeCrusier(new String[]{LocationYellow.get(0), LocationYellow.get(1), LocationYellow.get(2)});
                host.placeSubmarine(new String[]{LocationPink.get(0), LocationPink.get(1), LocationPink.get(2)});
                host.placeDestroyer(new String[]{LocationOrange.get(0), LocationOrange.get(1)});
                counter++;
                break;
            case 1:

                player1.placeCarrier(new String[]{LocationGreen.get(0), LocationGreen.get(1), LocationGreen.get(2), LocationGreen.get(3), LocationGreen.get(4)});
                player1.placeBattleShip(new String[]{LocationBlue.get(0), LocationBlue.get(1), LocationBlue.get(2), LocationBlue.get(3)});
                player1.placeCrusier(new String[]{LocationYellow.get(0), LocationYellow.get(1), LocationYellow.get(2)});
                player1.placeSubmarine(new String[]{LocationPink.get(0), LocationPink.get(1), LocationPink.get(2)});
                player1.placeDestroyer(new String[]{LocationOrange.get(0), LocationOrange.get(1)});
                counter++;
                break;
            case 2:

                player2.placeCarrier(new String[]{LocationGreen.get(0), LocationGreen.get(1), LocationGreen.get(2), LocationGreen.get(3), LocationGreen.get(4)});
                player2.placeBattleShip(new String[]{LocationBlue.get(0), LocationBlue.get(1), LocationBlue.get(2), LocationBlue.get(3)});
                player2.placeCrusier(new String[]{LocationYellow.get(0), LocationYellow.get(1), LocationYellow.get(2)});
                player2.placeSubmarine(new String[]{LocationPink.get(0), LocationPink.get(1), LocationPink.get(2)});
                player2.placeDestroyer(new String[]{LocationOrange.get(0), LocationOrange.get(1)});
                counter++;
                break;

            case 3:
                JOptionPane.showMessageDialog(null,
                        "You can only have 3 players!",
                        "TITLE",
                        JOptionPane.WARNING_MESSAGE);
            default:
                break;
        }
    }
    
    
    
    
    
    
    
    

    public static void startGame() {

        host.handleCommand(player1.createAddPlayerCommand());
        host.handleCommand(player2.createAddPlayerCommand());
        updateBoard = host.startTheGame();
        player1.handleCommand(updateBoard);
        player2.handleCommand(updateBoard);
     
        
    }

    
    
    
    
    
    
    
    public static void shootTorpedo(String actionCommand) throws BadAttributeValueExpException {

        
        
        if (host.isSelfTurn()) {
            
            updateBoard = host.createShootCommand(actionCommand);
            updateBoard = host.handleCommand(updateBoard);
            player1.handleCommand(updateBoard);
            player2.handleCommand(updateBoard);
            
        System.out.println("\nHost:");
        host.printSelfBoard();
        host.printShootBoard();

        } else if (player1.isSelfTurn()) {
            updateBoard = player1.createShootCommand(actionCommand);
            updateBoard = host.handleCommand(updateBoard);
            player1.handleCommand(updateBoard);
            player2.handleCommand(updateBoard);
            
            
            System.out.println("\nPlayer 1:");
        player1.printSelfBoard();
        player1.printShootBoard();

        } else if (player2.isSelfTurn()) {
            updateBoard = player1.createShootCommand(actionCommand);
            updateBoard = host.handleCommand(updateBoard);
            player1.handleCommand(updateBoard);
            player2.handleCommand(updateBoard);
            
        System.out.println("\nPlayer 2:");
        player2.printSelfBoard();
        player2.printShootBoard();
        }
        
        


        
//      System.out.println(host.isGameOverForSelf());
//      System.out.println(player1.isGameOverForSelf());
//      System.out.println(host.isGameOver());




    }
    
    
    

}

