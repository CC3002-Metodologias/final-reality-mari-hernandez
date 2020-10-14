package com.github.cc3002.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author María Antonia Hernández
 */
public class Enemy extends AbstractCharacter {

  private final int weight;
  private final int damage;

  /**
   * Creates a new enemy with the characters ready to play.
   * @param turnsQueue
   *      Enemy´s turn in the queue
   * @param name
   *      Enemy´s name
   * @param puntosDeVida
   *      Enemy´s health points
   * @param defense
   *      Enemy´s defense points
   * @param weight
   *      Enemy´s weight
   * @param damage
   *      Enemy´s damage points
   */
  public Enemy(@NotNull BlockingQueue<ICharacter> turnsQueue,
                                @NotNull String name, int puntosDeVida, int defense,int weight,int damage) {
    super(turnsQueue, name, puntosDeVida, defense);
    this.weight = weight;
    this.damage = damage;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Returns the damage of this enemy.
   */
  public int getDamage() {
    return damage;
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    var enemy = (Enemy) this;
    scheduledExecutor
            .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return getName().equals( enemy.getName())
            && getPuntosDeVida() == enemy.getPuntosDeVida()
            && getDefense() == enemy.getDefense()
            &&  getWeight() == enemy.getWeight()
            &&  getDamage() == enemy.getDamage();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }
}
