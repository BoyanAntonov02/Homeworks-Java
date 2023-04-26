package org.example.factory;

import org.example.bottle.Bottle;

import java.util.HashMap;
import java.util.Map;

public class Factory {

    private String name;
    private Map<Bottle, Integer> emptyBottle;
    private Map<Bottle, Integer> fullBottle;

    public Factory(String name) {
        this.name = name;
        emptyBottle = new HashMap<>();
        fullBottle = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Bottle, Integer> getEmptyBottle() {
        return emptyBottle;
    }

    public void setEmptyBottle(Map<Bottle, Integer> emptyBottle) {
        this.emptyBottle = emptyBottle;
    }

    public Map<Bottle, Integer> getFullBottle() {
        return fullBottle;
    }

    public void setFullBottle(Map<Bottle, Integer> fullBottle) {
        this.fullBottle = fullBottle;
    }
}
