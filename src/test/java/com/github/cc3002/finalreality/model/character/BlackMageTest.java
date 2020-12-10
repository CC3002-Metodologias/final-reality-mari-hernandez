package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.weapon.Staff;
import com.github.cc3002.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class BlackMageTest {

    protected LinkedBlockingQueue turns = new LinkedBlockingQueue<>();
    private static final String BLACKMAGE_NAME = "Test Black Mage";
    private static final String BLACKMAGE_NAME2 = "Test Black Mage 2";
    protected IWeapon testWeappon;
    private BlackMage testBlackMage;

    @BeforeEach
    void basicSetUpsetUp() {
        testWeappon = new Staff("Test Staff", 10, 10);
        testBlackMage = new BlackMage(turns, BLACKMAGE_NAME, 50, 5);
    }

    @Test
    void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        testBlackMage.equip(testWeappon);
        testBlackMage.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testBlackMage, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void constructorTest() {
        var expectedBlackMage = new BlackMage(turns, BLACKMAGE_NAME, 1, 3);
        var expectedBlackMage2 = new BlackMage(turns, BLACKMAGE_NAME2, 1, 3);
        var expectedBlackMage3 = new BlackMage(turns, BLACKMAGE_NAME, 2, 3);
        var expectedBlackMage4 = new BlackMage(turns, BLACKMAGE_NAME, 1, 4);
        var expectedWhiteMage = new WhiteMage(turns, BLACKMAGE_NAME, 1, 3);

        assertEquals(expectedBlackMage, expectedBlackMage);
        assertEquals(expectedBlackMage.hashCode(), expectedBlackMage.hashCode());

        assertEquals(expectedWhiteMage, expectedWhiteMage);
        assertEquals(expectedWhiteMage.hashCode(), expectedWhiteMage.hashCode());

        assertFalse(expectedBlackMage.equals(expectedBlackMage2));
        assertFalse(expectedBlackMage.equals(expectedBlackMage3));
        assertFalse(expectedBlackMage.equals(expectedBlackMage4));
        assertFalse(expectedBlackMage.equals(expectedWhiteMage));
    }

    @Test
    void equipWeaponTest() {
        testWeappon = new Knife("Test Knife", 10, 10);
        Sword testWeappon2 = new Sword("Test Sword", 10, 10);
        BlackMage blackMage1 = new BlackMage(turns, BLACKMAGE_NAME, 10, 15);
        assertNull(blackMage1.getEquippedWeapon());
        blackMage1.equip(testWeappon);
        assertEquals(testWeappon, blackMage1.getEquippedWeapon());
        blackMage1.equip(testWeappon2);
        assertEquals(testWeappon, blackMage1.getEquippedWeapon());
    }

    @Test
    void attackTest() {
        testBlackMage= new BlackMage(turns, BLACKMAGE_NAME, 10, 5);
        Knife testKnife= new Knife("Cuchillito", 12, 10);
        testBlackMage.equip(testKnife);
        Knight testKnight = new Knight(turns, "Knight test", 10, 5);
        testBlackMage.attack(testKnight);
        assertTrue(testKnight.getPuntosDeVida() == 3);
        testBlackMage.attack(testKnight);
        assertTrue(testKnight.getPuntosDeVida() == 0);

        Knight testKnight2 = new Knight(turns, "Knight test", 10, 5);
        BlackMage testBlackMage2 = new BlackMage(turns, "malo", 0, 5);
        testBlackMage2.attack(testKnight);
        assertTrue(testKnight2.getPuntosDeVida() == 10);



    }
}

