package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class BlackMage extends PlayerCharacter{


    private int mana;

    /**
     * Creates a new BlackMage.
     *
     * @param name
     *     the Black Mage´s name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     * @param puntosDeVida
     *     Black Mage´s health points
     * @param defense
     *     Black Mage´s defense points
     * @param mana
     *     Black Mage´s mana points
     */

    public BlackMage(@NotNull BlockingQueue<ICharacter> turnsQueue,
                     @NotNull String name, int puntosDeVida, int defense,int mana) {
        super(turnsQueue, name, puntosDeVida, defense);
        this.mana = mana;
    }


    /**
     * gets the character´s HP
     */
    public int getMana() {
        return mana;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BlackMage)) {
            return false;
        }
        final BlackMage that = (BlackMage) o;
        return getName().equals( that.getName())
                && getPuntosDeVida() == that.getPuntosDeVida()
                && getDefense() == that.getDefense()
                &&  getMana() == that.getMana();


    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

}
