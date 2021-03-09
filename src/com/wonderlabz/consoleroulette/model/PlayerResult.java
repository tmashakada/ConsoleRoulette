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
public class PlayerResult {
    private String name;
    private Double totalwin;
    private double totalbet;

    public PlayerResult(String name, Double totalwin, double totalbet) {
        this.name = name;
        this.totalwin = totalwin;
        this.totalbet = totalbet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalwin() {
        return totalwin;
    }

    public void setTotalwin(Double totalwin) {
        this.totalwin = totalwin;
    }

    public double getTotalbet() {
        return totalbet;
    }

    public void setTotalbet(double totalbet) {
        this.totalbet = totalbet;
    }
    
}
