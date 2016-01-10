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
@Food(price = 30.0)
public class Sushi {

    @Time(takes = 30)
    public void prepare() {

    }
    @Time(takes = 0)
    public void cook() {
        //none
    }

    @Time(takes = 20)
    public void send() {

    }
    
}
