package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class WhiteMage extends AbstractPlayerCharacter {

    /**
     * Creates a new WhiteMage.
     * @param name
     *     the White Mage´s name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     * @param puntosDeVida
     *     White Mage´s health points
     * @param defense
     *     White Mage´s defense points
     */

    public WhiteMage(@NotNull BlockingQueue<ICharacter> turnsQueue,
                    @NotNull String name, int puntosDeVida, int defense) {
        super(turnsQueue, name, puntosDeVida, defense);
    }

    @Override
    public void equip(IWeapon weapon){
        weapon.equipByWhiteMage(this);
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
                && getDefense() == that.getDefense();

    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
