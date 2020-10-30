package com.github.cc3002.finalreality.model.character;
import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class WhiteMageTest {

    protected BlockingQueue<ICharacter> turns=new LinkedBlockingQueue<>();
    protected List<ICharacter> testCharacters;

    private static final String WHITEMAGE_NAME = "Test White Mage";
    private static final String WHITEMAGE_NAME2 = "Test White Mage 2";
    private static final String WHITEMAGE_NAME3 = "Test White Mage 3";
    private static final String WHITEMAGE_NAME4 = "Test White Mage 4";
    private static final String WHITEMAGE_NAME5 = "Test White Mage 5";
    private WhiteMage testWhiteMage;
    protected IWeapon testWeappon;

    @BeforeEach
    void basicSetUpsetUp() {
        testWeappon = new Staff("Test Staff",10,10);
        testWhiteMage = new WhiteMage(turns,WHITEMAGE_NAME,50,5,20);
    }

    @Test
    void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        testWhiteMage.equip(testWeappon);
        testWhiteMage.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testWhiteMage, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }


    @Test
    void constructorTest() {
        var expectedWhiteMage = new WhiteMage(turns,WHITEMAGE_NAME,1,1,1);
        var expectedWhiteMage2 = new WhiteMage(turns,WHITEMAGE_NAME2,1,1,1);
        var expectedWhiteMage3 = new WhiteMage(turns,WHITEMAGE_NAME3,1,1,1);
        var expectedWhiteMage4 = new WhiteMage(turns,WHITEMAGE_NAME4,1,1,1);
        var expectedWhiteMage5 = new WhiteMage(turns,WHITEMAGE_NAME5,1,1,1);
        var expectedBlackMage= new BlackMage(turns,"Black Mage",1,1,1);
        var expectedWhiteMage6 = new WhiteMage(turns,WHITEMAGE_NAME,2,1,1);
        var expectedWhiteMage7 = new WhiteMage(turns,WHITEMAGE_NAME,1,2,1);
        var expectedWhiteMage8 = new WhiteMage(turns,WHITEMAGE_NAME,1,1,2);

        assertEquals(expectedBlackMage, expectedBlackMage);
        assertEquals(expectedBlackMage.hashCode(), expectedBlackMage.hashCode());

        assertEquals(expectedWhiteMage, expectedWhiteMage);
        assertEquals(expectedWhiteMage.hashCode(), expectedWhiteMage.hashCode());

        assertFalse(expectedBlackMage.equals(expectedWhiteMage2));
        assertFalse(expectedBlackMage.equals(expectedWhiteMage6));
        assertFalse(expectedBlackMage.equals(expectedWhiteMage7));
        assertFalse(expectedBlackMage.equals(expectedWhiteMage8));

        assertFalse(testWhiteMage.equals(expectedBlackMage));
        assertFalse(expectedWhiteMage.hashCode() == expectedBlackMage.hashCode());

        assertTrue(expectedWhiteMage.getMana()==expectedWhiteMage2.getMana());

        assertFalse(testWhiteMage.equals(expectedWhiteMage2));
        assertFalse(expectedWhiteMage2.hashCode() == testWhiteMage.hashCode());

        assertFalse(testWhiteMage.equals(expectedWhiteMage3));
        assertFalse(expectedWhiteMage3.hashCode() == testWhiteMage.hashCode());

        assertFalse(testWhiteMage.equals(expectedWhiteMage4));
        assertFalse(expectedWhiteMage4.hashCode() == testWhiteMage.hashCode());

        assertTrue(testWhiteMage.equals(testWhiteMage));
        assertTrue(testWhiteMage.hashCode() == testWhiteMage.hashCode());

        assertFalse(testWhiteMage.equals(expectedWhiteMage5));
        assertFalse(expectedWhiteMage5.hashCode() == testWhiteMage.hashCode());

    }

    @Test
    void equipWeaponTest() {
        testWeappon = new Staff("Test Axe",10,10);
        WhiteMage whiteMage= new WhiteMage(turns,WHITEMAGE_NAME,10,15,10);
        assertNull(whiteMage.getEquippedWeapon());
        whiteMage.equip(testWeappon);
        assertEquals(testWeappon,whiteMage.getEquippedWeapon());
    }



}
