package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BlackMageTest {

    protected LinkedBlockingQueue turns=new LinkedBlockingQueue<>();

    private static final String BLACKMAGE_NAME = "Test Black Mage";
    private static final String BLACKMAGE_NAME2 = "Test Black Mage 2";
    private static final String BLACKMAGE_NAME3 = "Test Black Mage 3";
    private static final String BLACKMAGE_NAME4 = "Test Black Mage 4";
    private static final String BLACKMAGE_NAME5 = "Test Black Mage 5";
    protected IWeapon testWeappon;

    private BlackMage testBlackMage;

    @BeforeEach
    void basicSetUpsetUp() {
        testWeappon = new Staff("Test Staff",10,10);
        testBlackMage = new BlackMage(turns,BLACKMAGE_NAME,50,5,20);
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
        var expectedBlackMage = new BlackMage(turns,BLACKMAGE_NAME,1,3,10);
        var expectedBlackMage2 = new BlackMage(turns,BLACKMAGE_NAME2,1,3,10);
        var expectedBlackMage3 = new BlackMage(turns,BLACKMAGE_NAME3,3,3,10);
        var expectedBlackMage4 = new BlackMage(turns,BLACKMAGE_NAME4,1,5,10);
        var expectedBlackMage5 = new BlackMage(turns,BLACKMAGE_NAME5,1,3,11);
        var expectedBlackMage6 = new BlackMage(turns,BLACKMAGE_NAME,1,3,11);
        var expectedBlackMage7 = new BlackMage(turns,BLACKMAGE_NAME,2,3,10);
        var expectedBlackMage8 = new BlackMage(turns,BLACKMAGE_NAME,1,4,10);
        var expectedWhiteMage= new WhiteMage(turns,"White Mage",1,3,10);

        assertEquals(expectedWhiteMage, expectedWhiteMage);
        assertEquals(expectedWhiteMage.hashCode(), expectedWhiteMage.hashCode());

        assertFalse(expectedBlackMage.equals(expectedBlackMage2));
        assertFalse(expectedBlackMage.equals(expectedBlackMage6));
        assertFalse(expectedBlackMage.equals(expectedBlackMage7));
        assertFalse(expectedBlackMage.equals(expectedBlackMage7));


        assertEquals(testBlackMage, testBlackMage);
        assertEquals(testBlackMage.hashCode(), testBlackMage.hashCode());


        assertFalse(testBlackMage.equals(expectedWhiteMage));
        assertFalse(expectedBlackMage.hashCode() == expectedWhiteMage.hashCode());

        assertTrue(expectedBlackMage.getMana()==expectedBlackMage2.getMana());

        assertFalse(testBlackMage.equals(expectedBlackMage2));
        assertFalse(expectedBlackMage2.hashCode() == testBlackMage.hashCode());

        assertFalse(testBlackMage.equals(expectedBlackMage3));
        assertFalse(expectedBlackMage3.hashCode() == testBlackMage.hashCode());

        assertFalse(testBlackMage.equals(expectedBlackMage4));
        assertFalse(expectedBlackMage4.hashCode() == testBlackMage.hashCode());

        assertTrue(testBlackMage.equals(testBlackMage));
        assertTrue(testBlackMage.hashCode() == testBlackMage.hashCode());

        assertFalse(testBlackMage.equals(expectedBlackMage5));
        assertFalse(expectedBlackMage5.hashCode() == testBlackMage.hashCode());

    }

    @Test
    void equipWeaponTest() {
        testWeappon = new Staff("Test Staff",10,10);
        BlackMage blackMage1= new BlackMage(turns,BLACKMAGE_NAME,10,15,10);
        assertNull(blackMage1.getEquippedWeapon());
        blackMage1.equip(testWeappon);
        assertEquals(testWeappon,blackMage1.getEquippedWeapon());
    }

}
