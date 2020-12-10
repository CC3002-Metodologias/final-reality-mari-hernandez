package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.weapon.IWeapon;

import java.util.HashMap;

public class Inventory {
    private HashMap<String, IWeapon> inventory;

    /**
     * Creates a new Inventory
     */
    public Inventory() {
        inventory = new HashMap<>();
    }


    /**
     *look for a weapon in the inventory
     */
    public IWeapon lookForWeaponInInventory(String weapon){
        IWeapon theWeapon = inventory.get(weapon);
        return theWeapon;
    }

    /**
     *Inserts a weapon in the inventory
     */
    public void getInInventory(IWeapon weapon){
        inventory.put(weapon.getName(),weapon);
    }

    /**
     *gets a weapon out of the inventory
     */
    public void getOutOfInventory(IWeapon weapon){
        inventory.remove(weapon.getName(),weapon);
    }

}
