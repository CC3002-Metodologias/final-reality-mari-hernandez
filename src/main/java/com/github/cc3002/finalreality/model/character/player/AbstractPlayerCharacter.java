package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * A class that holds all the information of a single player character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author María Antonia Hernández.
 */
public abstract  class AbstractPlayerCharacter extends AbstractCharacter implements IPlayerCharacter {
  protected IWeapon equippedWeapon;

  /**
   * Creates a new Player Character.
   *
   * @param name
   *     the Player´s name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param puntosDeVida
   *     Player´s health points
   * @param defense
   *     Player´s defense points
   */
  public AbstractPlayerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                                 @NotNull String name, int puntosDeVida, int defense) {
    super(turnsQueue, name, puntosDeVida, defense);
    this.equippedWeapon= null ;
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }

  /**
   * gets the weapon equipped by this player
   */
  public IWeapon getEquippedWeapon() {
    return equippedWeapon;
  }

  /**
   * equips a weapon for this player
   */
  public void setEquippedWeapon(IWeapon weapon) {
      this.equippedWeapon = weapon;
  }

  /**
   * equips a weapon for a player
   */
  public void equip(IWeapon weapon){}

  /**
   * attacks other character
   */
  public void attack(ICharacter character){
    if(this.getPuntosDeVida()>0 && equippedWeapon!=null){
      character.attackedBy(equippedWeapon.getDamage());
      }
  }

}
