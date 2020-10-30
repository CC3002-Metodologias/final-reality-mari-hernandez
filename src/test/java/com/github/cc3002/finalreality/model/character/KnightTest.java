package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Staff;
import com.github.cc3002.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class KnightTest{


    protected BlockingQueue<ICharacter> turns=new LinkedBlockingQueue<>();
    protected List<ICharacter> testCharacters;

    private static final String KNIGHT_NAME = "Test Knight";
    private static final String KNIGHT_NAME2 = "Test Knight 2";
    private static final String KNIGHT_NAME3 = "Test Knight 3";
    private static final String KNIGHT_NAME4 = "Test Knight 4";
    private static final String KNIGHT_NAME5 = "Test Knight 5";
    protected IWeapon testWeappon;
    private Knight testKnight;

    @BeforeEach
    void basicSetUpsetUp() {
        testWeappon = new Sword("Test Sword", 10, 10);
        testKnight = new Knight(turns, KNIGHT_NAME, 50, 5);
    }

    @Test
    void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        testKnight.equip(testWeappon);
        testKnight.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testKnight, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void constructorTest() {
        var expectedKnight = new Knight(turns, KNIGHT_NAME, 1, 5);
        var expectedKnight2 = new Knight(turns, KNIGHT_NAME2, 1, 5);
        var expectedKnight3 = new Knight(turns, KNIGHT_NAME3, 1, 10);
        var expectedKnight4 = new Knight(turns, KNIGHT_NAME4, 1, 5);
        var expectedKnight5 = new Knight(turns, KNIGHT_NAME5, 1, 5);
        var expectedWhiteMage = new WhiteMage(turns, "White Mage", 1, 5,5);
        var expectedKnight6 = new Knight(turns, KNIGHT_NAME, 2, 5);
        var expectedKnight7 = new Knight(turns, KNIGHT_NAME, 1, 2);
        assertEquals(expectedWhiteMage, expectedWhiteMage);
        assertEquals(expectedWhiteMage.hashCode(), expectedWhiteMage.hashCode());

        assertEquals(expectedKnight, expectedKnight);
        assertEquals(expectedKnight.hashCode(), expectedKnight.hashCode());

        assertFalse(expectedKnight.equals(expectedKnight2));
        assertFalse(expectedKnight.equals(expectedKnight6));
        assertFalse(expectedKnight.equals(expectedKnight6));

        assertFalse(testKnight.equals(expectedWhiteMage));
        assertFalse(expectedKnight.hashCode() == expectedWhiteMage.hashCode());


        assertFalse(testKnight.equals(expectedKnight2));
        assertFalse(expectedKnight2.hashCode() == testKnight.hashCode());

        assertFalse(testKnight.equals(expectedKnight3));
        assertFalse(expectedKnight3.hashCode() == testKnight.hashCode());

        assertFalse(testKnight.equals(expectedKnight4));
        assertFalse(expectedKnight4.hashCode() == testKnight.hashCode());

        assertTrue(testKnight.equals(testKnight));
        assertTrue(testKnight.hashCode() == testKnight.hashCode());

        assertFalse(testKnight.equals(expectedKnight5));
        assertFalse(expectedKnight5.hashCode() == testKnight.hashCode());

    }

   @Test
    void equipWeaponTest() {
        testWeappon = new Sword("Test Sword",10,10);
        Knight knight = new Knight(turns, KNIGHT_NAME, 10, 15);
        assertNull(knight.getEquippedWeapon());
        knight.equip(testWeappon);
        assertEquals(testWeappon, knight.getEquippedWeapon());
    }


}
