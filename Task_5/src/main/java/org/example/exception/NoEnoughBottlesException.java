package org.example.exception;

import org.example.bottle.Bottle;

public class NoEnoughBottlesException extends Exception {
    private int amountMore;
    private Bottle bottle;

    public NoEnoughBottlesException(int amountMore, Bottle bottle) {
        this.amountMore = amountMore;
        this.bottle = bottle;
    }

    @Override
    public String toString() {
        return "NoEnoughBottlesException{" +
                "amountMore=" + amountMore +
                ", bottle=" + bottle +
                "} " + super.toString();
    }
}
