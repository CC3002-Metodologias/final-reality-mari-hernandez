package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AxeTest  {
    private static final String AXE_NAME = "Test Axe";
    private static final String AXE_NAME2 = "Test Axe 2";
    protected LinkedBlockingQueue turns=new LinkedBlockingQueue<>();
    private IWeapon testAxe;

    @BeforeEach
    void setUp() {
        testAxe = new Axe(AXE_NAME, 15, 10);
    }

    @Test
    void constructorTest() {
        var expectedAxe = new Axe(AXE_NAME, 1,2);
        var expectedAxe2 = new Axe(AXE_NAME2, 1,2);
        var expectedAxe3 = new Axe(AXE_NAME, 2,2);
        var expectedAxe4 = new Axe(AXE_NAME, 1,3);
        var expectedBow = new Bow(AXE_NAME, 1,2);

        assertEquals(expectedAxe, expectedAxe);
        assertEquals(expectedAxe.hashCode(), expectedAxe.hashCode());

        assertEquals(expectedBow, expectedBow);
        assertEquals(expectedBow.hashCode(), expectedBow.hashCode());

        assertFalse(expectedAxe.equals(expectedAxe2));
        assertFalse(expectedAxe.equals(expectedAxe3));
        assertFalse(expectedAxe.equals(expectedAxe4));
        /**assertFalse(expectedAxe.equals(expectedBow));*/
    }
}
