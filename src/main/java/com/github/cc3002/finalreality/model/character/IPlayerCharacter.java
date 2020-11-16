package com.github.cc3002.finalreality.model.character;
/**
 * This represents a player character from the game.
 * A player can be controlled by the player .
 *
 * @author María Antonia Hernández
 */
import com.github.cc3002.finalreality.model.weapon.IWeapon;

public interface IPlayerCharacter extends ICharacter{

    /**
     * equips a weapon for a player
     */
    void equip(IWeapon weapon);


}
