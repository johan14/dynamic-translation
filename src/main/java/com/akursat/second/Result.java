/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akursat.second;

/**
 *
 * @author akursat
 */
public class Result {

    private String name;
    private double price;
    private int time;

    public Result(String name, double price) {
        this.name = name;
        this.price = price;
    }

    
    
    public Result(String name, double price, int takes) {
        this.name = name;
        this.price = price;
        this.time = takes;
    }

    Result() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
