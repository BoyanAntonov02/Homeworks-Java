package org.example;

import org.example.bottle.Bottle;
import org.example.bottle.BottleType;
import org.example.exception.NoEnoughBottlesException;
import org.example.exception.NoSuchBottleException;
import org.example.factory.Client;
import org.example.factory.Factory;
import org.example.factory.FactoryService;
import org.example.utils.BottleSerializer;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Factory factory1 = new Factory("Econt");
        Factory factory2 = new Factory("Speedy");
        Factory factory3 = new Factory("Oracle");

        Bottle bottle1 = new Bottle(BottleType.GLASS, 0.5);
        Bottle bottle2 = new Bottle(BottleType.PLASTIC, 1.5);
        Bottle bottle3 = new Bottle(BottleType.GLASS, 1);
        Bottle bottle4 = new Bottle(BottleType.PLASTIC, 1.5);
        Bottle bottle5 = new Bottle(BottleType.GLASS, 1);

        Client client1 = new Client("Pesho");
        Client client2 = new Client("Gosho");
        Client client3 = new Client("Ivan");

        FactoryService factoryService1 = new FactoryService(factory1);
        FactoryService factoryService2 = new FactoryService(factory2);
        FactoryService factoryService3 = new FactoryService(factory3);

        factoryService1.deliveryEmptyBottles(bottle1, 6);
        try {
            factoryService1.fillEmptyBottle(bottle1, 6);
        } catch (NoEnoughBottlesException e) {
            throw new RuntimeException(e);
        } catch (NoSuchBottleException e) {
            throw new RuntimeException(e);
        }



        try(FileWriter fileWriter=new FileWriter("Invoice1.txt", true)){
            fileWriter.write(factoryService1.sellBottle(bottle1, 6, client1, 0.8));
        } catch (NoEnoughBottlesException e) {
            throw new RuntimeException(e);
        } catch (NoSuchBottleException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(bottle1);
        bottle1.setLiters(1);

        String filePath = "bottle.ser";
        BottleSerializer.serialzeBottle(filePath, bottle1);
        System.out.println("Deserialize");
        System.out.println(BottleSerializer.deserializeBottle(filePath));
        System.out.println(bottle1);

    }
}