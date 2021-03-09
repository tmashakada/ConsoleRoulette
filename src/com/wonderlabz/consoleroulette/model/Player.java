/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.consoleroulette.model;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
public class Player {
    private String name;
    private String bet;
    private  double betamount ;
    private double totawin;
    private double totalbet;

    public double getTotawin() {
        return totawin;
    }

    public void setTotawin(double totawin) {
        this.totawin = totawin;
    }

    public double getTotalbet() {
        return totalbet;
    }

    public void setTotalbet(double totalbet) {
        this.totalbet = totalbet;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBet() {
        return bet;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    public double getBetamount() {
        return betamount;
    }

    public void setBetamount(double betamount) {
        this.betamount = betamount;
    }
    
}
