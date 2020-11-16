package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest{

    protected BlockingQueue<ICharacter> turns=new LinkedBlockingQueue<>();
    private static final String KNIGHT_NAME = "Test Knight";
    private static final String KNIGHT_NAME2 = "Test Knight 2";
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
        var expectedKnight = new Knight(turns, KNIGHT_NAME, 1, 3);
        var expectedKnight2 = new Knight(turns, KNIGHT_NAME2, 1, 3);
        var expectedKnight3 = new Knight(turns, KNIGHT_NAME, 2, 3);
        var expectedKnight4 = new Knight(turns, KNIGHT_NAME, 1, 4);
        var expectedKnight5 = new Knight(turns, KNIGHT_NAME, 1, 3);
        var expectedBlackMage = new BlackMage(turns, KNIGHT_NAME, 1, 3, 10);

        assertEquals(expectedBlackMage, expectedBlackMage);
        assertEquals(expectedBlackMage.hashCode(), expectedBlackMage.hashCode());

        assertEquals(expectedKnight, expectedKnight);
        assertEquals(expectedKnight.hashCode(), expectedKnight.hashCode());

        assertFalse(expectedKnight.equals(expectedKnight2));
        assertFalse(expectedKnight.equals(expectedKnight3));
        assertFalse(expectedKnight.equals(expectedKnight4));
        assertTrue(expectedKnight.equals(expectedKnight5));
        assertFalse(expectedKnight.equals(expectedBlackMage));
    }

   @Test
    void equipWeaponTest() {
       testKnight= new Knight(turns, KNIGHT_NAME, 50, 5);
       Engineer testEngineer = new Engineer(turns, "Engineer test", 50, 5);
       Knight testKnight2 = new Knight(turns, "Knight", 0, 5);
       Axe testAxe= new Axe("Axe", 10, 10);
       Knife testKnife= new Knife("Knife", 10, 10);
       Sword testSword= new Sword("Sword", 10, 10);

       testKnight.equip(testAxe);
       testKnight.attack(testEngineer);
       assertEquals(testEngineer.getPuntosDeVida(), 45);

       testKnight.equip(testKnife);
       testKnight.attack(testEngineer);
       assertEquals(testEngineer.getPuntosDeVida(), 40);

       testKnight.equip(testSword);
       testKnight.attack(testEngineer);
       assertEquals(testEngineer.getPuntosDeVida(), 35);

       testKnight2.attack(testEngineer);
       assertEquals(testEngineer.getPuntosDeVida(), 35);
    }


}
