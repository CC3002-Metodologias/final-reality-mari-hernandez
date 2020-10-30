package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.*;

/**
 * This represents a Weapon from the game.
 * A weapon can be equip by a player .
 *
 * @author María Antonia Hernández
 */

public interface IWeapon {

    /**
     * Returns this weapon's name.
     */
    String getName();

    /**
     * Returns this weapon's damage.
     */
    int getDamage();

    /**
     * Returns this weapon's weight.
     */
    int getWeight();

    public void equipByThief(Thief thief);
    public void equipByBlackMage(BlackMage blackMage);
    public void equipByEngineer(Engineer engineer);
    public void equipByKnight(Knight knight);
    public void equipByWhiteMage(WhiteMage whiteMage);
}
