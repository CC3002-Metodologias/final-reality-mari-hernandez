package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.Controller.GameController;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class turnTest {
    private GameController testController;
    private LinkedBlockingQueue turns = new LinkedBlockingQueue<>();

    @BeforeEach
    void setUp() {
        testController = new GameController();
        testController.createBlackMage( "Black Mage Test ", 10, 3);
        testController.createBlackMage( "Black Mage Test 2", 10, 3);
        testController.createBlackMage( "Black Mage Test 3", 10, 3);

        testController.createEnemy( "Enemy Test", 10, 4, 15, 15);

        testController.createKnife("Knife", 100, 5);
        testController.createKnife("Knife 2", 5, 35);
        testController.createKnife("Knife 3", 5, 55);

        testController.equip(testController.lookForPlayerCharacter(0),"Knife" );
        testController.equip(testController.lookForPlayerCharacter(1),"Knife 2" );
        testController.equip(testController.lookForPlayerCharacter(2),"Knife 3" );
    }


    @Test
    void controllerTest() throws InterruptedException {
        testController.gameStarter();
        Thread.sleep(5000);

        ICharacter playing = testController.turnsBegin();
        testController.attack(playing,testController.lookForEnemy(0));
        assertTrue(testController.lookForEnemiesPuntosDeVida(0)==0);
        testController.turnEnds(playing);

        assertTrue(testController.getWinner().equals("Player"));


    }




}

