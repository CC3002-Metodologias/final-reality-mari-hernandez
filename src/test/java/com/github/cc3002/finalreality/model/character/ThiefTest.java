package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class ThiefTest{

    protected BlockingQueue<ICharacter> turns =new LinkedBlockingQueue<>();
    private static final String THIEF_NAME = "Test Thief";
    private static final String THIEF_NAME2 = "Test Thief 2";
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
        var expectedThief = new Thief(turns, THIEF_NAME, 1, 3);
        var expectedThief2 = new Thief(turns, THIEF_NAME2, 1, 3);
        var expectedThief3 = new Thief(turns, THIEF_NAME, 2, 3);
        var expectedThief4 = new Thief(turns, THIEF_NAME, 1, 4);
        var expectedThief5 = new Thief(turns, THIEF_NAME, 1, 3);
        var expectedBlackMage = new BlackMage(turns, THIEF_NAME, 1, 3);

        assertEquals(expectedBlackMage, expectedBlackMage);
        assertEquals(expectedBlackMage.hashCode(), expectedBlackMage.hashCode());

        assertEquals(expectedThief, expectedThief);
        assertEquals(expectedThief.hashCode(), expectedThief.hashCode());

        assertFalse(expectedThief.equals(expectedThief2));
        assertFalse(expectedThief.equals(expectedThief3));
        assertFalse(expectedThief.equals(expectedThief4));
        assertTrue(expectedThief.equals(expectedThief5));
        assertFalse(expectedThief.equals(expectedBlackMage));
    }
    @Test
    void equipWeaponTest() {
        testThief= new Thief(turns, THIEF_NAME, 50, 5);
        Engineer testEngineer = new Engineer(turns, "Engineer test", 50, 5);
        Thief testThief2 = new Thief(turns, "Thief", 0, 5);
        Bow testBow= new Bow("Bow", 10, 10);
        Sword testSword= new Sword("Sword", 10, 10);
        Staff testStaff= new Staff("Staff", 10, 10);

        testThief.equip(testBow);
        testThief.attack(testEngineer);
        assertEquals(testEngineer.getPuntosDeVida(), 45);

        testThief.equip(testSword);
        testThief.attack(testEngineer);
        assertEquals(testEngineer.getPuntosDeVida(), 40);

        testThief.equip(testStaff);
        testThief.attack(testEngineer);
        assertEquals(testEngineer.getPuntosDeVida(), 35);

        testThief2.attack(testEngineer);
        assertEquals(testEngineer.getPuntosDeVida(), 35);
    }


}
