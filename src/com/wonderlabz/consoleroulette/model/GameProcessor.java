/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.consoleroulette.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
public class GameProcessor {

    public GameProcessor() {
    }
     public static void processGameResultsTotals(List<Player> playerList,String previousresultsfile) throws FileNotFoundException{
           Map<String,PlayerResult> resultMap=new HashMap<>();  
         //Read all Players and create a map entry
           for(Player player:playerList) {
         
         
             PlayerResult  playerResult=resultMap.get( player.getName());
             if(playerResult==null){
                 playerResult=new PlayerResult(player.getName(),0.0,0.0);
                 resultMap.put(player.getName(), playerResult);
                 
             }
         
                      
         
            }
        
       //end read all players
       //now processing results
         for(Player player2:playerList) {
              
                  PlayerResult  playerResult=resultMap.get( player2.getName());
                  if( playerResult!=null){
                       playerResult.calculateTotalWin(player2.getTotawin());
                       playerResult.calculateTotalBet(player2.getTotalbet());
                  }
         } 

          System.out.println();
          System.out.println();
          System.out.println("##################################################################");
          System.out.format("%15s %15s %15s", "Player", "Total Win", "Total bet\n");
          System.out.println("##################################################################");
           
           List<PlayerResult> playersTotalBetsAndWinList = getPlayersTotalBetsAndWinFromFile(previousresultsfile);
          //now processing  pass results
         for(PlayerResult playerresult:playersTotalBetsAndWinList) {
                //System.out.println(playerresult.getName()+" "+playerresult.getTotalwin()+" "+playerresult.getTotalbet()); 
             PlayerResult  playerResult=resultMap.get( playerresult.getName());
             if(playerResult!=null){
                 double totalwin=playerResult.getTotalwin()+playerresult.getTotalwin();
                 double totalbet=playerResult.getTotalbet()+playerresult.getTotalbet();
                System.out.format("%15s %15.2f %15.2f", playerresult.getName(),totalwin, totalbet);
                System.out.println();
                 
             }
         
         }
        
      }
    
   public static void processGameResults(String playerslist,String previousresultsplaylist) throws FileNotFoundException{
            int  winner = WinningBall.getWinningNumber();
            System.out.println();
            System.out.println("Number :" + winner);
            System.out.println();
            System.out.println("###############################################################################");
            System.out.format("%15s %15s %15s %15s  %15s", "Player", "Bet", "Outcome","Bet Amount", "Winnings\n");
            System.out.println("##############################################################################");
            List<Player> playerlist = getPlayersBetsFromFile(playerslist);
          
            List<Player> playerlistresults=new ArrayList<>();
                 playerlist.forEach(player -> {
            
                double  playerRewards = 0.0;
                boolean isint=isInteger( player.getBet());
            
                 if( isint){
                      int playerBet = Integer.valueOf(player.getBet());
                  
                     
                      if (playerBet == winner) {
                            playerRewards = player.getBetamount() * 36;
                            System.out.format("%15s %15s %15s %15.2f %15.2f", player.getName(), player.getBet(), Level.WON,player.getBetamount(), playerRewards);
                            System.out.println();
                            player.setTotalbet(player.getBetamount());
                            player.setTotawin(playerRewards);
                                      
                        }  else{
                            playerRewards = 0.0;
                            System.out.format("%15s %15s %15s %15.2f %15.2f", player.getName(), player.getBet(), Level.LOSE,player.getBetamount(), playerRewards);
                            System.out.println();
                            player.setTotalbet(player.getBetamount());
                            player.setTotawin(playerRewards);
                          
                        }
                      
                      
                       }else{
                           String evenodd=evenOrOdd(player.getBet());
                     
                           String winningball=checkWinningNumber(winner);
                   
                  
                     if(evenodd.equalsIgnoreCase(winningball)){
                            playerRewards =player.getBetamount() * 2;
                            System.out.format("%15s %15s %15s  %15.2f %15.2f", player.getName(),player.getBet(), Level.WON,player.getBetamount(), playerRewards);
                            System.out.println();
                            player.setTotalbet(player.getBetamount());
                            player.setTotawin(playerRewards);
                     }else{
                           playerRewards = 0.0;
                            System.out.format("%15s %15s %15s  %15.2f %15.2f", player.getName(), player.getBet(), Level.LOSE,player.getBetamount(), playerRewards);
                            System.out.println();
                            player.setTotalbet(player.getBetamount());
                            player.setTotawin(playerRewards);
                     }
                       
                     
                 }
                
                playerlistresults.add(player);
        }); 
       
        processGameResultsTotals(playerlist,previousresultsplaylist);
    }
    
   
     public   static  List<Player> getPlayersBetsFromFile(String filename) throws FileNotFoundException{
           
                File fr = new File(filename);
                Scanner fileReader = new Scanner(fr);
                List<Player> players = new ArrayList<Player>();
                Player player=null;
                while (fileReader.hasNextLine()) {
                    player=new Player();
                    String data = fileReader.nextLine();
                               
                     String[] bet = data.split("\\s+"); 
                    player.setName(bet[0]);
                    player.setBet(bet[1]);
                    player.setBetamount(Double.valueOf(bet[2]));
                  
                    
                    players.add(player);
                }
                fileReader.close();
                      
                return  players;
            
        }  
    
    
    
    public  static  List<PlayerResult> getPlayersTotalBetsAndWinFromFile(String filename) throws FileNotFoundException{
          File fr = new File(filename);
                Scanner fileReader = new Scanner(fr);
                List<PlayerResult> playerResultList = new ArrayList<>();
              
                while (fileReader.hasNextLine()) {
                  
                    String data = fileReader.nextLine();
                   // System.out.println(" sss "+ data);
                  
                     String[] bet = data.split(","); 
                   PlayerResult playerResult=new PlayerResult(bet[0],Double.valueOf(bet[1]),Double.valueOf(bet[2]));
                    
                   playerResultList.add( playerResult);
                }
                fileReader.close();
          
        return playerResultList;
          
      }
    
    public static boolean isInteger(String s) {
           boolean isValidInteger = false;
           try {
               Integer.parseInt(s);
               isValidInteger = true;
           }catch (NumberFormatException ex) {
               //System.out.println("Validate Integer fail:" + ex);
           }
            return isValidInteger;
        }
       
     public  static int getWinnerBall(){        
            Random rand = new Random();
            return rand.nextInt(36);
      }
    public static String checkWinningNumber(int i){
         String evenodd="ODD";
         if(i % 2 == 0){
             evenodd="EVEN";
         }
            return evenodd; 
    }    
     public static String evenOrOdd( String bet){
            return ( bet.equals("EVEN")) ? "EVEN" : "ODD"; 
       }
           
}
