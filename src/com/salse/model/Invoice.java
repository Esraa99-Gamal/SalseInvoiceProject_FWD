/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salse.model;

import java.util.ArrayList;

/**
 *
 * @author esraa
 */
public class Invoice {
    
   
    private int num;
    private String date;
    private String customer;
    private ArrayList<Line> lines;

    public Invoice() {
    }

    public Invoice(int num, String date, String customer) {
        this.num = num;
        this.date = date;
        this.customer = customer;
    }
    public double getTotal_invo(){
        double total =0.0;
        for(Line L : getLines() ){
            total += L.getTotal_line();
        }
        return total;
                }
    public ArrayList<Line> getLines() {
        if(lines == null)
        lines= new ArrayList<>();
        return lines;
    }

    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Invoice{" + "num=" + num + ", date=" + date + ", customer=" + customer + '}';
    }

   
   
}
