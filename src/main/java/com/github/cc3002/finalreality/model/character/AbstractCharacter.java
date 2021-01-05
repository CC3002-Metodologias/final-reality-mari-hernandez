package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.Controller.IDeadHandler;
import org.jetbrains.annotations.NotNull;
import java.beans.PropertyChangeSupport;
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
  private final PropertyChangeSupport deadPlayerEvent = new PropertyChangeSupport(this);
  private final PropertyChangeSupport enterToQueueEvent = new PropertyChangeSupport(this);

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

  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
      if(getPuntosDeVida()>0){
      turnsQueue.add(this);
      scheduledExecutor.shutdown();
      enterToQueueEvent.firePropertyChange( name + "enter to queue " , null, this);
    }
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
   * modify the character´s HP
   */
  public void setPuntosDeVida(int puntosDeVida){
    this.puntosDeVida= puntosDeVida;
  }

  /**
   * gets the character´s defense points
   */
  public int getDefense() {
    return defense;
  }

  /**
   * gets attacks by another character
   */
  public void attackedBy(int damage){
    if(this.getPuntosDeVida()>0 && damage>this.getDefense()){
      this.setPuntosDeVida(this.getPuntosDeVida() - damage + this.getDefense());
      if(this.getPuntosDeVida()<0){
        this.setPuntosDeVida(0);
        deadPlayerEvent.firePropertyChange( name + "Died " , null, this);
      }
    }
  }

  /**
   * Observer Pattern
   */
  public void addListenerDead(IDeadHandler handler) {
    deadPlayerEvent.addPropertyChangeListener(handler);
  }

  /**
   * Observer Pattern
   */
  public void addListenerQueue(IDeadHandler handler) {
    enterToQueueEvent.addPropertyChangeListener(handler);
  }

}
