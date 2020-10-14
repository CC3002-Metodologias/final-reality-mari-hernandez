package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

/**
 *  An abstract class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author María Antonia Hernández
 */
public abstract class Weapon implements IWeapon{

  private final String name;
  private final int damage;
  private final int weight;

  /**
   * Creates a weapon with a name, a base damage and wight.
   * @param name
   *      weapon´s name
   * @param damage
   *      weapon´s damage
   * @param weight
   *      weapon´s weight
   */

  public Weapon(final String name, final int damage, final int weight) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
  }

  /**
   * gets the name of the weapon
   */
  public String getName() {
    return name;
  }

  /**
   * gets the damage of the weapon
   */
  public int getDamage() {
    return damage;
  }

  /**
   * gets the weight of the character
   */
  public int getWeight() {
    return weight;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Weapon)) {
      return false;
    }
    final Weapon that = (Weapon) o;
    return getName().equals(that.getName())
            && getDamage() == that.getDamage()
            && getWeight() == that.getWeight();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight());
  }



}


