package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.Bow;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class EngineerTest  {

    protected BlockingQueue<ICharacter> turns=new LinkedBlockingQueue<>();
    private static final String ENGINEER_NAME = "Test Engineer";
    private static final String ENGINEER_NAME2 = "Test Engineer 2";
    private Engineer testEngineer;
    protected IWeapon testWeappon;

    @BeforeEach
    void basicSetUpsetUp() {
        testWeappon = new Axe("Test Axe",10,10);
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
        var expectedEngineer = new Engineer(turns, ENGINEER_NAME, 1, 3);
        var expectedEngineer2 = new Engineer(turns, ENGINEER_NAME2, 1, 3);
        var expectedEngineer3 = new Engineer(turns, ENGINEER_NAME, 2, 3);
        var expectedEngineer4 = new Engineer(turns, ENGINEER_NAME, 1, 4);
        var expectedEngineer5 = new Engineer(turns, ENGINEER_NAME, 1, 3);
        var expectedBlackMage = new BlackMage(turns, ENGINEER_NAME, 1, 4);

        assertEquals(expectedBlackMage, expectedBlackMage);
        assertEquals(expectedBlackMage.hashCode(), expectedBlackMage.hashCode());

        assertEquals(expectedEngineer, expectedEngineer);
        assertEquals(expectedEngineer.hashCode(), expectedEngineer.hashCode());

        assertNotEquals(expectedEngineer2, expectedEngineer);
        assertNotEquals(expectedEngineer3, expectedEngineer);
        assertNotEquals(expectedEngineer4, expectedEngineer);
        assertEquals(expectedEngineer5, expectedEngineer);
        assertFalse(expectedEngineer.equals(expectedBlackMage));

    }

    @Test
    void equipWeaponTest() {
        testWeappon = new Axe("Test Axe",10,10);
        Engineer engineer= new Engineer(turns,ENGINEER_NAME,10,15);
        assertNull(engineer.getEquippedWeapon());
        engineer.equip(testWeappon);
        assertEquals(testWeappon,engineer.getEquippedWeapon());
    }

    @Test
    void attackTest() {
        testEngineer= new Engineer(turns, ENGINEER_NAME, 50, 5);
        Knight testKnight = new Knight(turns, "Knight test", 50, 5);
        Engineer testEngineer2 = new Engineer(turns, "Engineer", 0, 5);
        Axe testAxe= new Axe("Axe", 10, 10);
        Bow testBow= new Bow("Bow", 10, 10);

        testEngineer.equip(testAxe);
        testEngineer.attack(testKnight);
        assertEquals(testKnight.getPuntosDeVida(), 45);

        testEngineer.equip(testBow);
        testEngineer.attack(testKnight);
        assertEquals(testKnight.getPuntosDeVida(), 40);

        testEngineer2.attack(testKnight);
        assertEquals(testKnight.getPuntosDeVida(), 40);

    }



}





