package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;

/**
 * A class that holds all the information of a Sword.
 * @author María Antonia Hernández
 */

public class Sword extends Weapon {

    /**
     * Creates a Sword with a name, a base damage and weight.
     *
     * @param name
     *      Sword´s name
     * @param damage
     *      Sword´s damage
     * @param weight
     *      Sword´s weight
     */

    public Sword(String name, int damage, int weight) { super(name, damage, weight); }

    @Override
    public void equipByKnight(Knight knight){
        knight.setEquippedWeapon(this);
    }

    @Override
    public void equipByThief(Thief thief){
        thief.setEquippedWeapon(this);
    }
}
