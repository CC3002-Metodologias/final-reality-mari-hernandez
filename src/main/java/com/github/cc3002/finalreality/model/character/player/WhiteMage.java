package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class WhiteMage extends PlayerCharacter{

    private int mana;

    /**
     * Creates a new WhiteMage.
     *
     * @param name
     *     the White Mage´s name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     * @param puntosDeVida
     *     White Mage´s health points
     * @param defense
     *     White Mage´s defense points
     * @param mana
     *     White Mage´s mana points
     */

    public WhiteMage(@NotNull BlockingQueue<ICharacter> turnsQueue,
                    @NotNull String name, int puntosDeVida, int defense, int mana) {
        super(turnsQueue, name, puntosDeVida, defense);
        this.mana=mana;
    }


    /**
     * gets the character´s Mana
     */
    public int getMana() {
        return mana;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WhiteMage)) {
            return false;
        }
        final WhiteMage that = (WhiteMage) o;
        return getName().equals(that.getName())
                && getPuntosDeVida() == that.getPuntosDeVida()
                && getDefense() == that.getDefense()
                && getMana() == that.getMana();

    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
