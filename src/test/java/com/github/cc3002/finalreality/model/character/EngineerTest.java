package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class EngineerTest  {


    protected BlockingQueue<ICharacter> turns=new LinkedBlockingQueue<>();
    protected List<ICharacter> testCharacters;

    private static final String ENGINEER_NAME = "Test Engineer";
    private static final String ENGINEER_NAME2 = "Test Engineer 2";
    private static final String ENGINEER_NAME3 = "Test Engineer 3";
    private static final String ENGINEER_NAME4 = "Test Engineer 4";
    private static final String ENGINEER_NAME5 = "Test Engineer 5";

    private Engineer testEngineer;
    protected IWeapon testWeappon;



    @BeforeEach
    void basicSetUpsetUp() {
        testWeappon = new Staff("Test Staff",10,10);
        testEngineer = new Engineer(turns,ENGINEER_NAME,10,10);
    }

    @Test
    void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        testEngineer.equip(testWeappon);
        testEngineer.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testEngineer, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void constructorTest() {
        var expectedEngineer = new Engineer(turns, ENGINEER_NAME, 1, 5);
        var expectedEngineer2 = new Engineer(turns, ENGINEER_NAME2, 1, 5);
        var expectedEngineer3 = new Engineer(turns, ENGINEER_NAME3, 1, 10);
        var expectedEngineer4 = new Engineer(turns, ENGINEER_NAME4, 1, 5);
        var expectedEngineer5 = new Engineer(turns, ENGINEER_NAME5, 1, 5);
        var expectedWhiteMage = new WhiteMage(turns, "White Mage", 1, 5,5);
        var expectedEngineer6 = new Engineer(turns, ENGINEER_NAME, 2, 5);
        var expectedEngineer7 = new Engineer(turns, ENGINEER_NAME, 1, 2);
        assertEquals(expectedWhiteMage, expectedWhiteMage);
        assertEquals(expectedWhiteMage.hashCode(), expectedWhiteMage.hashCode());

        assertEquals(expectedEngineer, expectedEngineer);
        assertEquals(expectedEngineer.hashCode(), expectedEngineer.hashCode());

        assertFalse(expectedEngineer.equals(expectedEngineer2));
        assertFalse(expectedEngineer.equals(expectedEngineer6));
        assertFalse(expectedEngineer.equals(expectedEngineer7));

        assertFalse(testEngineer.equals(expectedWhiteMage));
        assertFalse(expectedEngineer.hashCode() == expectedWhiteMage.hashCode());

        assertFalse(testEngineer.equals(expectedEngineer2));
        assertFalse(expectedEngineer2.hashCode() == testEngineer.hashCode());

        assertFalse(testEngineer.equals(expectedEngineer3));
        assertFalse(expectedEngineer3.hashCode() == testEngineer.hashCode());

        assertFalse(testEngineer.equals(expectedEngineer4));
        assertFalse(expectedEngineer4.hashCode() == testEngineer.hashCode());

        assertTrue(testEngineer.equals(testEngineer));
        assertTrue(testEngineer.hashCode() == testEngineer.hashCode());

        assertFalse(testEngineer.equals(expectedEngineer5));
        assertFalse(expectedEngineer5.hashCode() == testEngineer.hashCode());


    }

    @Test
    void equipWeaponTest() {
        Engineer engineer= new Engineer(turns,ENGINEER_NAME,10,15);
        assertNull(engineer.getEquippedWeapon());
        engineer.equip(testWeappon);
        assertEquals(testWeappon,engineer.getEquippedWeapon());
    }


}





