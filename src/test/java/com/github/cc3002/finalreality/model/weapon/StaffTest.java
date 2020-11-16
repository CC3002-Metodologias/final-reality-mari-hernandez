package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class StaffTest {

    private static final String STAFF_NAME = "Test Staff";
    private static final String STAFF_NAME2 = "Test Staff 2";
    protected LinkedBlockingQueue turns=new LinkedBlockingQueue<>();
    private IWeapon testStaff;

    @BeforeEach
    void setUp() {
        testStaff = new Staff(STAFF_NAME, 15, 10);
    }

    @Test
    void constructorTest() {
        var expectedStaff= new Staff(STAFF_NAME ,1,2);
        var expectedStaff2 = new Staff(STAFF_NAME2, 1,2);
        var expectedStaff3 = new Staff(STAFF_NAME, 2,2);
        var expectedStaff4 = new Staff(STAFF_NAME, 1,3);
        var expectedAxe = new Axe(STAFF_NAME, 1,2);

        assertEquals(expectedAxe, expectedAxe);
        assertEquals(expectedAxe.hashCode(), expectedAxe.hashCode());

        assertEquals(expectedStaff, expectedStaff);
        assertEquals(expectedStaff.hashCode(), expectedStaff.hashCode());

        assertFalse(expectedStaff.equals(expectedStaff2));
        assertFalse(expectedStaff.equals(expectedStaff3));
        assertFalse(expectedStaff.equals(expectedStaff4));

    }
}


