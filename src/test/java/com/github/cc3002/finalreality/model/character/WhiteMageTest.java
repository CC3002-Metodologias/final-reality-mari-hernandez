package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class WhiteMageTest {

    protected BlockingQueue<ICharacter> turns=new LinkedBlockingQueue<>();
    private static final String WHITEMAGE_NAME = "Test White Mage";
    private static final String WHITEMAGE_NAME2 = "Test White Mage 2";
    private WhiteMage testWhiteMage;
    protected IWeapon testWeappon;

    @BeforeEach
    void basicSetUpsetUp() {
        testWeappon = new Staff("Test Staff",10,10);
        testWhiteMage = new WhiteMage(turns,WHITEMAGE_NAME,50,5,20);
    }

    @Test
    void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        testWhiteMage.equip(testWeappon);
        testWhiteMage.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testWhiteMage, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }


    @Test
    void constructorTest() {
        var expectedWhiteMage = new WhiteMage(turns, WHITEMAGE_NAME, 1, 3, 10);
        var expectedWhiteMage2 = new WhiteMage(turns, WHITEMAGE_NAME2, 1, 3, 10);
        var expectedWhiteMage3 = new WhiteMage(turns, WHITEMAGE_NAME, 2, 3, 10);
        var expectedWhiteMage4 = new WhiteMage(turns, WHITEMAGE_NAME, 1, 4, 10);
        var expectedWhiteMage5 = new WhiteMage(turns, WHITEMAGE_NAME, 1, 3, 12);
        var expectedWhiteMage6 = new WhiteMage(turns, WHITEMAGE_NAME, 1, 3, 10);
        var expectedBlackMage = new BlackMage(turns, WHITEMAGE_NAME, 1, 3, 10);

        assertEquals(expectedBlackMage, expectedBlackMage);
        assertEquals(expectedBlackMage.hashCode(), expectedBlackMage.hashCode());

        assertEquals(expectedWhiteMage, expectedWhiteMage);
        assertEquals(expectedWhiteMage.hashCode(), expectedWhiteMage.hashCode());

        assertFalse(expectedWhiteMage.equals(expectedWhiteMage2));
        assertFalse(expectedWhiteMage.equals(expectedWhiteMage3));
        assertFalse(expectedWhiteMage.equals(expectedWhiteMage4));
        assertFalse(expectedWhiteMage.equals(expectedWhiteMage5));
        assertTrue(expectedWhiteMage.equals(expectedWhiteMage6));
        assertFalse(expectedWhiteMage.equals(expectedBlackMage));
    }

    @Test
    void equipWeaponTest() {
        testWeappon = new Staff("Test Staff",10,10);
        WhiteMage whiteMage= new WhiteMage(turns,WHITEMAGE_NAME,10,15,10);
        assertNull(whiteMage.getEquippedWeapon());
        whiteMage.equip(testWeappon);
        assertEquals(testWeappon,whiteMage.getEquippedWeapon());
    }



}
