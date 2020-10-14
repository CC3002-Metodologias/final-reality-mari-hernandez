package com.github.cc3002.finalreality.model.weapon;

/**
 * A class that holds all the information of a Staff.
 * @author María Antonia Hernández
 */

public class Staff extends Weapon{

    /**
     * Creates a Staff with a name, a base damage and weight.
     *
     * @param name
     *      Staff´s name
     * @param damage
     *      Staff´s damage
     * @param weight
     *      Staff´s weight
     */

    public Staff(String name, int damage, int weight) {
        super(name, damage, weight);
    }
}
