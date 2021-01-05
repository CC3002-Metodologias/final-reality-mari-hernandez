package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.Controller.GameController;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerTest {
    private GameController testController;
    private LinkedBlockingQueue turns = new LinkedBlockingQueue<>();
    private ArrayList<IPlayerCharacter> partyTest;
    private ArrayList<Enemy> enemyPartyTest;
    private HashMap<String, IWeapon> inventoryTest;


    @BeforeEach
    void setUp() {
        testController = new GameController();
        testController.createBlackMage( "Black Mage Test", 50, 3);
        testController.createEngineer( "Engineer Test", 51, 3);
        testController.createKnight( "Knight Test", 52, 3);
        testController.createThief( "Thief Test", 53, 3);
        testController.createWhiteMage( "White Mage Test", 54, 3);
        testController.createEnemy( "Enemy Test", 10, 3, 18, 4);
        testController.createEnemy( "Enemy Test 2", 11, 4, 20, 5);
        testController.createEnemy( "Enemy Test 3", 12, 5, 21, 6);
        testController.createEnemy( "Enemy Test 4", 13, 6, 22, 7);
        testController.createEnemy( "Enemy Test 5", 14, 7, 23, 70);
        testController.createEnemy( "Enemy Test 6", 15, 8, 24, 9);
        testController.createAxe("Axe", 25, 10);
        testController.createKnife("Knife", 25, 12);
        testController.createStaff("Staff", 25, 14);
        testController.createSword("Sword", 25, 16);
        testController.createBow("Bow", 25, 10);
    }

/**
    @Test
    void controllerTest() {

        assertFalse(testController.getParty().equals(partyTest));
        assertFalse(testController.getPartyEnemies().equals(enemyPartyTest));
        assertFalse(testController.getInventory().equals(inventoryTest));

        assertTrue(testController.lookForCharacterName(0).equals("Black Mage Test"));
        assertTrue(testController.lookForCharacterName(1).equals("Engineer Test"));
        assertTrue(testController.lookForCharacterName(2).equals("Knight Test"));

        assertTrue(testController.lookForEnemiesName(0).equals("Enemy Test"));
        assertTrue(testController.lookForEnemiesName(1).equals("Enemy Test 2"));
        assertTrue(testController.lookForEnemiesName(2).equals("Enemy Test 3"));
        assertTrue(testController.lookForEnemiesName(3).equals("Enemy Test 4"));
        assertTrue(testController.lookForEnemiesName(4).equals("Enemy Test 5"));

        assertTrue(testController.lookForCharacterDefense(0) == 3);
        assertTrue(testController.lookForCharacterPuntosDeVida(0) == 50);

        assertTrue(testController.lookForEnemiesDefense(0) == 3);
        assertTrue(testController.lookForEnemiesPuntosDeVida(0) == 10);
        assertTrue(testController.lookForEnemyDamage(0) == 4);
        assertTrue(testController.lookForEnemyWeight(0) == 18);

        testController.equip(testController.lookForPlayerCharacter(0), testController.lookForWeaponInInventoryByName("Sword"));
        testController.equip(testController.lookForPlayerCharacter(0), testController.lookForWeaponInInventoryByName("Staff"));
        //assertTrue(testController.lookForPlayerCharacterWeapon(0).getName().equals(testController.lookForWeaponInInventoryByName("Staff")));
        testController.equip(testController.lookForPlayerCharacter(0), testController.lookForWeaponInInventoryByName("Bow"));
        //assertTrue(testController.lookForPlayerCharacterWeapon(0).getName().equals(testController.lookForWeaponInInventoryByName("Staff")));
        testController.equip(testController.lookForPlayerCharacter(0), testController.lookForWeaponInInventoryByName("Knife"));
        //assertTrue(testController.lookForPlayerCharacterWeapon(0).getName().equals(testController.lookForWeaponInInventoryByName("Knife")));
        testController.equip(testController.lookForPlayerCharacter(1), testController.lookForWeaponInInventoryByName("Axe"));
        testController.equip(testController.lookForPlayerCharacter(2), testController.lookForWeaponInInventoryByName("Sword"));

        testController.attack(testController.lookForPlayerCharacter(0),testController.lookForEnemy(0));
        testController.attack(testController.lookForEnemy(4),testController.lookForPlayerCharacter(0));
        //assertTrue(testController.lookForCharacterPuntosDeVida(0)==0);
        testController.attack(testController.lookForPlayerCharacter(1),testController.lookForEnemy(1));
        //assertTrue(testController.lookForEnemiesPuntosDeVida(1)==0);
        testController.attack(testController.lookForPlayerCharacter(1),testController.lookForEnemy(2));
        //assertTrue(testController.lookForEnemiesPuntosDeVida(2)==0);
        testController.attack(testController.lookForPlayerCharacter(1),testController.lookForEnemy(3));
        //assertTrue(testController.lookForEnemiesPuntosDeVida(3)==0);
        testController.attack(testController.lookForPlayerCharacter(1),testController.lookForEnemy(4));
        //assertTrue(testController.lookForEnemiesPuntosDeVida(4)==0);

        //assertTrue(testController.getWinner().equals("Player"));
    }
*/

}

