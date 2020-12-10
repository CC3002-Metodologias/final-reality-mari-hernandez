package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SwordTest{

    private static final String SWORD_NAME = "Test Sword";
    private static final String SWORD_NAME2 = "Test Sword 2";
    private static final String SWORD_NAME3 = "Test Sword 3";
    private static final String SWORD_NAME4 = "Test Sword 4";
    private static final String SWORD_NAME5 = "Test Sword 5";
    private static final int DAMAGE = 15;
    private static final int SPEED = 10;
    protected LinkedBlockingQueue turns=new LinkedBlockingQueue<>();
    private IWeapon testSword;

    @BeforeEach
    void setUp() {
        testSword = new Sword(SWORD_NAME, DAMAGE, SPEED);

    }

    @Test
    void constructorTest() {
        var expectedSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
        var expectedSword2 = new Sword(SWORD_NAME2, 10, SPEED);
        var expectedSword3 = new Sword(SWORD_NAME3, DAMAGE, 14);
        var expectedSword4 = new Sword(SWORD_NAME4, DAMAGE, SPEED);
        var expectedSword5 = new Sword(SWORD_NAME5, DAMAGE, SPEED);
        var expectedBlackMage = new BlackMage(turns,"Mago Negro",1,3);

        assertEquals(expectedSword, testSword);
        assertEquals(expectedSword.hashCode(), testSword.hashCode());

        assertEquals(expectedSword, expectedSword);
        assertEquals(expectedSword.hashCode(), expectedSword.hashCode());

        assertFalse(testSword.equals(expectedBlackMage));
        assertFalse(expectedBlackMage.hashCode() == testSword.hashCode());

        assertFalse(testSword.equals(expectedSword2));
        assertFalse(expectedSword2.hashCode() == testSword.hashCode());

        assertFalse(testSword.equals(expectedSword3));
        assertFalse(expectedSword3.hashCode() == testSword.hashCode());

        assertFalse(testSword.equals(expectedSword4));
        assertFalse(expectedSword4.hashCode() == testSword.hashCode());

        assertTrue(testSword.equals(testSword));
        assertTrue(testSword.hashCode() == testSword.hashCode());

        assertFalse(testSword.equals(expectedSword5));
        assertFalse(expectedSword5.hashCode() == testSword.hashCode());
    }

}
