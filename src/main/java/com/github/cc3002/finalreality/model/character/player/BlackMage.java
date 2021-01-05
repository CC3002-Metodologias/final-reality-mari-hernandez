package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class BlackMage extends AbstractPlayerCharacter {

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

     */

    public BlackMage(@NotNull BlockingQueue<ICharacter> turnsQueue,
                     @NotNull String name, int puntosDeVida, int defense) {
        super(turnsQueue, name, puntosDeVida, defense);
    }

    @Override
    public void equip(IWeapon weapon){
        weapon.equipByBlackMage(this);
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
                && getDefense() == that.getDefense();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

}
