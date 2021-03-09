/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.consoleroulette;

import com.wonderlabz.consoleroulette.model.GameProcessor;
import java.io.FileNotFoundException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
public class ConsoleRoulette {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(ConsoleRoulette::run, 0, 30, TimeUnit.SECONDS);
        
    }
    
     private static void run() {
          try {
            // TODO code application logic here
            String playerlist="playerlist.txt";
            String previousresults="previousresults.txt";
            System.out.println("Running: " + new java.util.Date());
            GameProcessor.processGameResults(playerlist, previousresults);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConsoleRoulette.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
}
