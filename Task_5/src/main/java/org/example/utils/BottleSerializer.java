package org.example.utils;

import org.example.bottle.Bottle;

import java.io.*;

public class BottleSerializer {
    public static void serialzeBottle(String filePath, Bottle bottle) {
        try(FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream outputStream = new ObjectOutputStream(fos);) {
                outputStream.writeObject(bottle);

        } catch(IOException ex){
    throw new RuntimeException(ex);
        }
    }

    public static Bottle deserializeBottle(String filePath){
        try(FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream inputStream = new ObjectInputStream(fis);) {
            Bottle bottle = (Bottle) inputStream.readObject();
            return bottle;
        }catch(ClassNotFoundException ex){
            throw new RuntimeException(ex);
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }

        }

}
