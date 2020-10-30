package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Knight extends AbstractPlayerCharacter {

    /**
     * Creates a new Knight.
     *
     * @param name
     *     the Knight´s name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     * @param puntosDeVida
     *     Knight´s health points
     * @param defense
     *     Knight´s defense points
     */

    public Knight(@NotNull BlockingQueue<ICharacter> turnsQueue,
                    @NotNull String name, int puntosDeVida, int defense) {
        super(turnsQueue, name, puntosDeVida, defense);
    }

    @Override
    public void equip(IWeapon weapon){
        weapon.equipByKnight(this);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Knight)) {
            return false;
        }
        final Knight that = (Knight) o;
        return  getName().equals(that.getName())
                && getPuntosDeVida() == that.getPuntosDeVida()
                && getDefense() == that.getDefense();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

