package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class KnifeTest {

    private static final String KNIFE_NAME = "Test Knife";
    private static final String KNIFE_NAME2 = "Test Knife 2";
    protected LinkedBlockingQueue turns=new LinkedBlockingQueue<>();
    private IWeapon testKnife;

    @BeforeEach
    void setUp() {
        testKnife = new Knife(KNIFE_NAME, 15, 10);
    }

    @Test
    void constructorTest() {
        var expectedKnife= new Knife(KNIFE_NAME ,1,2);
        var expectedKnife2 = new Knife(KNIFE_NAME2, 1,2);
        var expectedKnife3 = new Knife(KNIFE_NAME, 2,2);
        var expectedKnife4 = new Knife(KNIFE_NAME, 1,3);
        var expectedAxe = new Axe(KNIFE_NAME, 1,2);

        assertEquals(expectedAxe, expectedAxe);
        assertEquals(expectedAxe.hashCode(), expectedAxe.hashCode());

        assertEquals(expectedKnife, expectedKnife);
        assertEquals(expectedKnife.hashCode(), expectedKnife.hashCode());

        assertFalse(expectedKnife.equals(expectedKnife2));
        assertFalse(expectedKnife.equals(expectedKnife3));
        assertFalse(expectedKnife.equals(expectedKnife4));

    }
}
