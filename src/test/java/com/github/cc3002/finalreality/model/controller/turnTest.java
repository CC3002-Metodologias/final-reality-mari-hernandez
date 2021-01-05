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
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class turnTest {
    private  Random random = new Random();

    @Test
    void controllerTest() throws InterruptedException {
        GameController testController = new GameController();
        testController.createBlackMage("BLACK MAGE TEST",80, 30);
        testController.createKnife("KNIFE TEST",60,25);
        assertEquals(testController.lookForWeaponName(0), "KNIFE TEST");
        assertTrue(testController.lookForWeaponDamage(0)==(60));
        assertTrue(testController.lookForWeaponWeight(0)==(25));
        testController.equip(testController.lookForCharacterByName("BLACK MAGE TEST"), testController.lookForWeaponInInventoryByName("KNIFE TEST") );
        assertEquals(testController.lookForPlayerCharacterWeapon(0).getName(),"KNIFE TEST" );

        testController.createEngineer("ENGINEER TEST", 80, 30);
        testController.createAxe("AXE TEST", 60,60);
        testController.equip(testController.lookForCharacterByName("ENGINEER TEST"), testController.lookForWeaponInInventoryByName("AXE TEST") );

        testController.createKnight("KNIGHT TEST", 80, 30);
        testController.createSword("SWORD TEST", 60, 50);
        testController.equip(testController.lookForCharacterByName("KNIGHT TEST"), testController.lookForWeaponInInventoryByName("SWORD TEST") );

        testController.createBow("BOW TEST", 60, 70);
        testController.createStaff("STAFF TEST", 60,70);
        testController.equip(testController.lookForCharacterByName("BLACK MAGE TEST"), testController.lookForWeaponInInventoryByName("STAFF TEST") );

        testController.createEnemy("ENEMY 1", 10, 100, 10, 10000000);
        testController.createEnemy("ENEMY 2", 10, 100, 25, 10000000);
        testController.createEnemy("ENEMY 3", 10, 100, 35, 10000000);

        testController.createWhiteMage("WHITE MAGE TEST",10,10);
        testController.createThief("THIEF TEST",10,10);

        assertTrue(testController.lookForCharacterByName("NO EXISTO")==(null));
        assertTrue(testController.lookForWeaponInInventoryByName("NO EXISTO")==(null));


        assertEquals(testController.getInventory().size(),2 );
        assertEquals(testController.getPartyEnemies().size(),3 );
        assertEquals(testController.getParty().size(),3 );

        testController.tryToGameStarter();

        assertEquals(testController.getParty().size(),3 );
        assertEquals(testController.lookForEnemyDamage(0),10000000 );
        assertEquals(testController.lookForEnemyWeight(0),10 );
        assertEquals(testController.lookForEnemiesDefense(0),100 );
        assertEquals(testController.lookForEnemiesName(0),"ENEMY 1" );
        assertTrue(testController.getWinner()==(null));
        assertEquals(testController.lookForCharacterName(0),"BLACK MAGE TEST" );
        assertEquals(testController.lookForCharacterDefense(0),30 );

        assertEquals(testController.getAlivePlayerCharacter(),3 );
        assertEquals(testController.getTotalPlayerCharacter(),3 );

        Thread.sleep(7000);

    }




}

