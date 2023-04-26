package org.example.factory;

import org.example.exception.NoEnoughBottlesException;
import org.example.exception.NoSuchBottleException;
import org.example.bottle.Bottle;

import java.util.HashMap;
import java.util.Map;

public class FactoryService {
    private Factory factory;
    private static int invoiceNum = 0;

    public FactoryService(Factory factory) {
        this.factory = factory;
    }

    public void deliveryEmptyBottles(Bottle bottle, int amount){
        Map<Bottle, Integer> emptyBottle = new HashMap<>();
        emptyBottle = factory.getEmptyBottle();
        if(emptyBottle.containsKey(bottle)){
            int amountIn=emptyBottle.get(bottle);
            emptyBottle.put(bottle, amountIn + amount);
        }
        else{
            emptyBottle.put(bottle, amount);
            factory.setEmptyBottle(emptyBottle);
        }
    }

    public void fillEmptyBottle(Bottle bottle, int remove) throws NoEnoughBottlesException, NoSuchBottleException {
        Map<Bottle, Integer> emptyBottle = new HashMap<>();
        emptyBottle = factory.getEmptyBottle();
        if(emptyBottle.containsKey(bottle)){
            if(emptyBottle.get(bottle) - remove >= 0){
                emptyBottle.put(bottle, emptyBottle.get(bottle) - remove);
                factory.setEmptyBottle(emptyBottle);
                Map<Bottle, Integer> fullBottle = new HashMap<>();
                fullBottle = factory.getFullBottle();
                if(fullBottle.containsKey(bottle)){
                    fullBottle.put(bottle, fullBottle.get(bottle) + remove);
                }
                else fullBottle.put(bottle, remove);
                factory.setFullBottle(fullBottle);
            }
            else {
                throw new NoEnoughBottlesException(remove - emptyBottle.get(bottle), bottle);
            }
        }
        else throw new NoSuchBottleException();

    }

    public String sellBottle(Bottle bottle, int sell, Client client, double price) throws NoEnoughBottlesException, NoSuchBottleException{
        Map<Bottle, Integer> fullBottle = new HashMap<>();
        fullBottle = factory.getFullBottle();
        if(fullBottle.containsKey(bottle)) {
            if (fullBottle.get(bottle) - sell >= 0) {
                    fullBottle.put(bottle, fullBottle.get(bottle) - sell);
                    factory.setFullBottle(fullBottle);
                    invoiceNum++;
                    Invoice invoice = new Invoice(invoiceNum, factory, client, sell, price);
                    return invoice.toString();

            }
            else throw new NoEnoughBottlesException(fullBottle.get(bottle) - sell, bottle);

        }
        else throw new NoSuchBottleException();
    }
}
