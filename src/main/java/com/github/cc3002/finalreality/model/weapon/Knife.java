package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Knight;

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
    @Override
    public void equipByKnight(Knight knight){
        knight.setEquippedWeapon(this);
    }
    @Override
    public void equipByBlackMage(BlackMage blackMage){
        blackMage.setEquippedWeapon(this);
    }
}
