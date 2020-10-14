package com.github.cc3002.finalreality.model.weapon;

/**
 * A class that holds all the information of a Axe.
 * @author María Antonia Hernández
 */

public class Axe extends Weapon {

    /**
     * Creates a Axe with a name, a base damage and weight.
     *
     * @param name
     *      Axe´s name
     * @param damage
     *      Axe´s damage
     * @param weight
     *      Axe´s weight
     */

    public Axe(String name, int damage, int weight) {
        super(name, damage, weight);
    }

}
