/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.consoleroulette.model;

import java.util.Random;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
public class WinningBall {
      public static int getWinningNumber(){
       Random random = new Random();
       int rand = 0;
      while (true){
          rand = random.nextInt(37);
          if(rand !=0) break;
      }
       return  rand;
   }
}
