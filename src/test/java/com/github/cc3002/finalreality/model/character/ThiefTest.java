package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.character.player.WhiteMage;
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

public class ThiefTest {

    protected BlockingQueue<ICharacter> turns =new LinkedBlockingQueue<>();
    protected List<ICharacter> testCharacters;

    private static final String THIEF_NAME = "Test Thief";
    private static final String THIEF_NAME2 = "Test Thief 2";
    private static final String THIEF_NAME3 = "Test Thief 3";
    private static final String THIEF_NAME4 = "Test Thief 4";
    private static final String THIEF_NAME5 = "Test Thief 5";

    private Thief testThief;
    protected IWeapon testWeappon;

    @BeforeEach
    void basicSetUpsetUp() {
        testWeappon = new Sword("Test Sword",10,10);
        testThief = new Thief(turns,THIEF_NAME,50,5);
    }

    @Test
    void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        testThief.equip(testWeappon);
        testThief.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testThief, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void constructorTest() {
        var expectedThief = new Thief(turns, THIEF_NAME, 1, 5);
        var expectedThief2 = new Thief(turns, THIEF_NAME2, 1, 5);
        var expectedThief3 = new Thief(turns, THIEF_NAME3, 1, 10);
        var expectedThief4 = new Thief(turns, THIEF_NAME4, 1, 5);
        var expectedThief5 = new Thief(turns, THIEF_NAME5, 1, 5);
        var expectedWhiteMage = new WhiteMage(turns, "White Mage", 1, 5,5);
        var expectedThief6 = new Thief(turns, THIEF_NAME, 2, 5);
        var expectedThief7 = new Thief(turns, THIEF_NAME, 1, 2);

        assertEquals(expectedWhiteMage, expectedWhiteMage);
        assertEquals(expectedWhiteMage.hashCode(), expectedWhiteMage.hashCode());

        assertEquals(expectedThief, expectedThief);
        assertEquals(expectedThief.hashCode(), expectedThief.hashCode());

        assertFalse(expectedThief.equals(expectedThief2));
        assertFalse(expectedThief.equals(expectedThief6));
        assertFalse(expectedThief.equals(expectedThief7));



        assertFalse(testThief.equals(expectedThief2));
        assertFalse(expectedThief2.hashCode() == testThief.hashCode());

        assertFalse(testThief.equals(expectedWhiteMage));
        assertFalse(expectedThief.hashCode() == expectedWhiteMage.hashCode());

        assertFalse(testThief.equals(expectedThief3));
        assertFalse(expectedThief3.hashCode() == testThief.hashCode());

        assertFalse(testThief.equals(expectedThief4));
        assertFalse(expectedThief4.hashCode() == testThief.hashCode());

        assertTrue(testThief.equals(testThief));
        assertTrue(testThief.hashCode() == testThief.hashCode());

        assertFalse(testThief.equals(expectedThief5));
        assertFalse(expectedThief5.hashCode() == testThief.hashCode());



    }
    @Test
    void equipWeaponTest() {
        Thief thief= new Thief(turns,THIEF_NAME,10,15);
        assertNull(thief.getEquippedWeapon());
        thief.equip(testWeappon);
        assertEquals(testWeappon,thief.getEquippedWeapon());
    }


}
