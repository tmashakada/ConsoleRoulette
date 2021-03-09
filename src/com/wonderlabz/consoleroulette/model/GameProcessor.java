/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.consoleroulette.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
public class GameProcessor {

    public GameProcessor() {
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
       
}
