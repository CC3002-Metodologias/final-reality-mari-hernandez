package com.github.cc3002.finalreality.model.character;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author María Antonia Hernández
 */
public interface ICharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's HP.
   */
  int getPuntosDeVida() ;

  /**
   * Returns this character's defense points.
   */
  int getDefense();

  /**
   * gets attacks by another character
   */
  void attackedBy(int damage);
}
