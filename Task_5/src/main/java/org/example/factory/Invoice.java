package org.example.factory;

import java.math.RoundingMode;
import java.time.LocalDate;

public class Invoice {
    private final int id;
    private Factory factory;
    private Client client;
    private  int sellBottles;

    private double price;

    private double sum;

    public Invoice(int id, Factory factory, Client client, int sellBottles, double price) {
        this.id = id;
        this.factory = factory;
        this.client = client;
        this.sellBottles = sellBottles;
        this.price = price;
        sum = price*sellBottles;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id= " + id + '\n'+
                ", factory= " + factory.getName() + '\n'+
                ", client= " + client.getName() +'\n'+
                ", date= " + LocalDate.now() +'\n'+
                ", sellBottles= " + sellBottles +'\n'+
                ", price for one bottle= " + price +'\n'+
                ", sum price=  " + Math.round(sum* 100.0)/100.0 +'\n'+
                '}' ;
    }
}
