package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class KnifeTest {

    private static final String KNIFE_NAME = "Test Knife";
    private static final String KNIFE_NAME2 = "Test Knife 2";
    private static final String KNIFE_NAME3 = "Test Knife 3";
    private static final String KNIFE_NAME4 = "Test Knife 4";
    private static final String KNIFE_NAME5 = "Test Knife 5";
    private static final int DAMAGE = 15;
    private static final int SPEED = 10;
    protected LinkedBlockingQueue turns=new LinkedBlockingQueue<>();
    private BlackMage testBlackMage;

    private IWeapon testKnife;

    @BeforeEach
    void setUp() {
        testKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
    }


    @Test
    void constructorTest() {
        var expectedKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
        var expectedKnife2 = new Knife(KNIFE_NAME2,10, SPEED);
        var expectedKnife3 = new Knife(KNIFE_NAME3, DAMAGE, 14);
        var expectedKnife4 = new Knife(KNIFE_NAME4, DAMAGE, SPEED);
        var expectedKnife5 = new Knife(KNIFE_NAME5, DAMAGE, SPEED);
        var expectedBlackMage = new BlackMage(turns,"Mago Negro",1,3,10);

        assertEquals(expectedKnife, testKnife);
        assertEquals(expectedKnife.hashCode(), testKnife.hashCode());

        assertEquals(expectedKnife, expectedKnife);
        assertEquals(expectedKnife.hashCode(), expectedKnife.hashCode());

        assertFalse(testKnife.equals(expectedBlackMage));
        assertFalse(expectedBlackMage.hashCode() == testKnife.hashCode());

        assertFalse(testKnife.equals(expectedKnife2));
        assertFalse(expectedKnife2.hashCode() == testKnife.hashCode());

        assertFalse(testKnife.equals(expectedKnife3));
        assertFalse(expectedKnife3.hashCode() == testKnife.hashCode());

        assertFalse(testKnife.equals(expectedKnife4));
        assertFalse(expectedKnife4.hashCode() == testKnife.hashCode());

        assertTrue(testKnife.equals(testKnife));
        assertTrue(testKnife.hashCode() == testKnife.hashCode());

        assertFalse(testKnife.equals(expectedKnife5));
        assertFalse(expectedKnife5.hashCode() == testKnife.hashCode());


    }
}
