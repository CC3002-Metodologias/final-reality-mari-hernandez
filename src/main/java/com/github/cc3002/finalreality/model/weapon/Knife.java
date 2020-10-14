package com.github.cc3002.finalreality.model.weapon;

/**
 * A class that holds all the information of a Knife.
 * @author María Antonia Hernández
 */

public class Knife extends Weapon{

    /**
     * Creates a Knife with a name, a base damage and weight.
     *
     * @param name
     *      Knife´s name
     * @param damage
     *      Knife´s damage
     * @param weight
     *      Knife´s weight
     */

    public Knife(String name, int damage, int weight) {
        super(name, damage, weight);
    }
}
