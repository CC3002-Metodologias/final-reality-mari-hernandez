package com.github.cc3002.finalreality.model.character;

import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author María Antonia Hernández
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  protected ScheduledExecutorService scheduledExecutor;
  protected int puntosDeVida;
  protected int defense;

  /**
   * Creates a Character with a turn, name, HP and defense points
   *
   * @param turnsQueue
   *      Character´s turn in the queue
   * @param name
   *      Characters´s name
   * @param puntosDeVida
   *      Character´s health points
   * @param defense
   *      Character´s defense points
   */

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                              @NotNull String name, int puntosDeVida, int defense) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.puntosDeVida = puntosDeVida;
    this.defense = defense;
  }


  @Override
  public void waitTurn() { }


  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  /**
   * gets the name of the character
   */
  public String getName() {
    return name;
  }

  /**
   * gets the character´s HP
   */
  public int getPuntosDeVida() {
    return puntosDeVida;
  }

  /**
   * gets the character´s defense points
   */
  public int getDefense() {
    return defense;
  }
}
