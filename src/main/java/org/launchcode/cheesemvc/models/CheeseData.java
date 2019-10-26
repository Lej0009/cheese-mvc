package org.launchcode.models;

import java.util.ArrayList;

public class CheeseData {

    static ArrayList<org.launchcode.models.Cheese> cheeses = new ArrayList<>();

    // getAll
    public static ArrayList<org.launchcode.models.Cheese> getAll() {
        return cheeses;
    }

    // add
    public static void add(org.launchcode.models.Cheese newCheese) {
        cheeses.add(newCheese);
    }

    // remove
    public static void remove(int id) {
        org.launchcode.models.Cheese cheeseToRemove = getById(id);
        cheeses.remove(cheeseToRemove);
    }

    // getById
    public static org.launchcode.models.Cheese getById(int id) {

        org.launchcode.models.Cheese theCheese = null;

        for (org.launchcode.models.Cheese candidateCheese : cheeses) {
            if (candidateCheese.getCheeseId() == id) {
                theCheese = candidateCheese;
            }
        }

        return theCheese;
    }

}
