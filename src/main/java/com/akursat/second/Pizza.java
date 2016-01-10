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
@Food(price = 22.5)
public class Pizza {

    @Time(takes = 10)
    public void prepare() {

    }

    @Time(takes = 20)
    public void cook() {

    }

    @Time(takes = 15)
    public void send() {

    }
}
