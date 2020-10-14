package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BowTest {

    private static final String BOW_NAME = "Test Bow";
    private static final String BOW_NAME2 = "Test Bow 2";
    private static final String BOW_NAME3 = "Test Bow 3";
    private static final String BOW_NAME4 = "Test Bow 4";
    private static final String BOW_NAME5 = "Test Bow 5";
    private static final int DAMAGE = 15;
    private static final int SPEED = 10;
    protected LinkedBlockingQueue turns=new LinkedBlockingQueue<>();
    private BlackMage testBlackMage;


    private IWeapon testBow;

    @BeforeEach
    void setUp() {
        testBow = new Bow(BOW_NAME, DAMAGE, SPEED);
    }

    @Test
    void constructorTest() {
        var expectedBow = new Bow(BOW_NAME, DAMAGE, SPEED);
        var expectedBow2 = new Bow(BOW_NAME2, 10, SPEED);
        var expectedBow3 = new Bow(BOW_NAME3, DAMAGE, 14);
        var expectedBow4 = new Bow(BOW_NAME4, DAMAGE, SPEED);
        var expectedBow5 = new Bow(BOW_NAME5, DAMAGE, SPEED);
        var expectedBlackMage = new BlackMage(turns,"Mago Negro",1,3,10);

        assertEquals(expectedBow, testBow);
        assertEquals(expectedBow.hashCode(), testBow.hashCode());

        assertEquals(expectedBow, expectedBow);
        assertEquals(expectedBow.hashCode(), expectedBow.hashCode());

        assertFalse(testBow.equals(expectedBlackMage));
        assertFalse(expectedBlackMage.hashCode() == testBow.hashCode());

        assertFalse(testBow.equals(expectedBow2));
        assertFalse(expectedBow2.hashCode() == testBow.hashCode());

        assertFalse(testBow.equals(expectedBow3));
        assertFalse(expectedBow3.hashCode() == testBow.hashCode());

        assertFalse(testBow.equals(expectedBow4));
        assertFalse(expectedBow4.hashCode() == testBow.hashCode());

        assertTrue(testBow.equals(testBow));
        assertTrue(testBow.hashCode() == testBow.hashCode());

        assertFalse(testBow.equals(expectedBow5));
        assertFalse(expectedBow5.hashCode() == testBow.hashCode());
    }


}
