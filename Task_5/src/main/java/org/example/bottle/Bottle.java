package org.example.bottle;
import java.io.Serializable;
public class Bottle implements Serializable{
    private BottleType bottleType;
    private double liters;

    public Bottle(BottleType bottleType, double liters) {
        this.bottleType = bottleType;
        this.liters = liters;
    }

    public void setBottleType(BottleType bottleType) {
        this.bottleType = bottleType;
    }

    public void setLiters(double liters) {
        this.liters = liters;
    }

    @Override
    public String toString() {
        return "Bottle{" +
                "bottleType=" + bottleType +
                ", liters=" + liters +
                '}';
    }
}
