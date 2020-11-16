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
    protected LinkedBlockingQueue turns=new LinkedBlockingQueue<>();
    private IWeapon testBow;

    @BeforeEach
    void setUp() {
        testBow = new Bow(BOW_NAME, 15, 10);
    }

    @Test
    void constructorTest() {
        var expectedBow= new Bow(BOW_NAME ,1,2);
        var expectedBow2 = new Bow(BOW_NAME2, 1,2);
        var expectedBow3 = new Bow(BOW_NAME, 2,2);
        var expectedBow4 = new Bow(BOW_NAME, 1,3);
        var expectedAxe = new Axe(BOW_NAME, 1,2);

        assertEquals(expectedAxe, expectedAxe);
        assertEquals(expectedAxe.hashCode(), expectedAxe.hashCode());

        assertEquals(expectedBow, expectedBow);
        assertEquals(expectedBow.hashCode(), expectedBow.hashCode());

        assertFalse(expectedBow.equals(expectedBow2));
        assertFalse(expectedBow.equals(expectedBow3));
        assertFalse(expectedBow.equals(expectedBow4));
    }


}
