package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AxeTest  {
    private static final String AXE_NAME = "Test Axe";
    private static final String AXE_NAME2 = "Test Axe 2";
    private static final String AXE_NAME3 = "Test Axe 3";
    private static final String AXE_NAME4 = "Test Axe 4";
    private static final String AXE_NAME5 = "Test Axe 5";
    private static final int DAMAGE = 15;
    private static final int SPEED = 10;
    protected LinkedBlockingQueue turns=new LinkedBlockingQueue<>();
    private BlackMage testBlackMage;


    private IWeapon testAxe;

    @BeforeEach
    void setUp() {
        testAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
    }

    @Test
    void constructorTest() {
        var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
        var expectedAxe2 = new Axe(AXE_NAME2, 10, SPEED);
        var expectedAxe3 = new Axe(AXE_NAME3, DAMAGE, 14);
        var expectedAxe4 = new Axe(AXE_NAME4, DAMAGE, SPEED);
        var expectedAxe5 = new Axe(AXE_NAME5, DAMAGE, SPEED);
        var expectedAxe6 = new Axe(AXE_NAME, 20, SPEED);
        var expectedAxe7 = new Axe(AXE_NAME, DAMAGE, 30);
        var expectedBlackMage = new BlackMage(turns,"Mago Negro",1,3,10);

        assertEquals(expectedAxe, testAxe);
        assertEquals(expectedAxe.hashCode(), testAxe.hashCode());

        assertEquals(expectedAxe, expectedAxe);
        assertEquals(expectedAxe.hashCode(), expectedAxe.hashCode());

        assertFalse(expectedAxe.equals(expectedAxe6));
        assertFalse(expectedAxe.equals(expectedAxe7));

        assertFalse(testAxe.equals(expectedBlackMage));
        assertFalse(expectedBlackMage.hashCode() == testAxe.hashCode());

        assertFalse(testAxe.equals(expectedAxe2));
        assertFalse(expectedAxe2.hashCode() == testAxe.hashCode());

        assertFalse(testAxe.equals(expectedAxe3));
        assertFalse(expectedAxe3.hashCode() == testAxe.hashCode());

        assertFalse(testAxe.equals(expectedAxe4));
        assertFalse(expectedAxe4.hashCode() == testAxe.hashCode());

        assertTrue(testAxe.equals(testAxe));
        assertTrue(testAxe.hashCode() == testAxe.hashCode());

        assertFalse(testAxe.equals(expectedAxe5));
        assertFalse(expectedAxe5.hashCode() == testAxe.hashCode());
    }
}
