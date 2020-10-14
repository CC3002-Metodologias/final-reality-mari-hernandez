package com.github.cc3002.finalreality.model.weapon;

/**
 * A class that holds all the information of a Bow.
 * @author María Antonia Hernández
 */

public class Bow extends Weapon {

    /**
     * Creates a Bow with a name, a base damage and weight.
     *
     * @param name
     *      Bow´s name
     * @param damage
     *      Bow´s damage
     * @param weight
     *      Bow´s weight
     */

    public Bow(String name, int damage, int weight) {
        super(name, damage, weight);
    }
}
