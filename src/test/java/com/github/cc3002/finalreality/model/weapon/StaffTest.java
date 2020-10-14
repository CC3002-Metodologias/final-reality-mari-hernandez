package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class StaffTest {

    private static final String STAFF_NAME = "Test Staff";
    private static final String STAFF_NAME2 = "Test Staff 2";
    private static final String STAFF_NAME3 = "Test Staff 3";
    private static final String STAFF_NAME4 = "Test Staff 4";
    private static final String STAFF_NAME5 = "Test Staff 5";

    private static final int DAMAGE = 15;
    private static final int SPEED = 10;

    protected LinkedBlockingQueue turns=new LinkedBlockingQueue<>();
    private BlackMage testBlackMage;

    private IWeapon testStaff;

    @BeforeEach
    void setUp() {
        testStaff = new Staff(STAFF_NAME, DAMAGE, SPEED);
    }

    @Test
    void constructorTest() {
        var expectedStaff = new Staff(STAFF_NAME, DAMAGE, SPEED);
        var expectedStaff2 = new Staff(STAFF_NAME2, 10, SPEED);
        var expectedStaff3= new Staff(STAFF_NAME3, DAMAGE, 14);
        var expectedStaff4 = new Staff(STAFF_NAME4, DAMAGE, SPEED);
        var expectedStaff5 = new Staff(STAFF_NAME5, DAMAGE, SPEED);
        var expectedBlackMage = new BlackMage(turns,"Mago Negro",1,3,10);

        assertEquals(expectedStaff, testStaff);
        assertEquals(expectedStaff.hashCode(), testStaff.hashCode());

        assertEquals(expectedStaff, expectedStaff);
        assertEquals(expectedStaff.hashCode(), expectedStaff.hashCode());

        assertFalse(testStaff.equals(expectedBlackMage));
        assertFalse(expectedBlackMage.hashCode() == testStaff.hashCode());

        assertFalse(testStaff.equals(expectedStaff2));
        assertFalse(expectedStaff2.hashCode()== testStaff.hashCode());

        assertFalse(testStaff.equals(expectedStaff3));
        assertFalse(expectedStaff3.hashCode()== testStaff.hashCode());

        assertFalse(testStaff.equals(expectedStaff4));
        assertFalse(expectedStaff4.hashCode()== testStaff.hashCode());

        assertTrue(testStaff.equals(testStaff));
        assertTrue(testStaff.hashCode()==testStaff.hashCode());

        assertFalse(testStaff.equals(expectedStaff5));
        assertFalse(expectedStaff5.hashCode()== testStaff.hashCode());

    }
}


