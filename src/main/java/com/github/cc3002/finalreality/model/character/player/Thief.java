package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Thief extends PlayerCharacter{

    /**
     * Creates a new Knight.
     *
     * @param name
     *     the Thief´s name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     * @param puntosDeVida
     *     Thief´s health points
     * @param defense
     *     Thief´s defense points
     */

    public Thief(@NotNull BlockingQueue<ICharacter> turnsQueue,
                 @NotNull String name, int puntosDeVida, int defense) {
        super(turnsQueue, name, puntosDeVida, defense);
    }
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Thief)) {
            return false;
        }
        final Thief that = (Thief) o;
        return getName().equals(that.getName())
                && getPuntosDeVida() == that.getPuntosDeVida()
                && getDefense() == that.getDefense();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
