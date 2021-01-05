package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

  protected BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();
  private static final String ENEMY_NAME = "Test Enemy";
  private static final String ENEMY_NAME2 = "Test Enemy 2";
  private Enemy testEnemy;

  @BeforeEach
  void basicSetUpsetUp() {
    testEnemy = new Enemy(turns,ENEMY_NAME,50,5,10,10);
  }

  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    testEnemy.waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(200);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testEnemy, turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  void constructorTest() {
    var expectedEnemy = new Enemy(turns, ENEMY_NAME, 1, 3, 10,10);
    var expectedEnemy2 = new Enemy(turns, ENEMY_NAME2, 1, 3, 10,10);
    var expectedEnemy3 = new Enemy(turns, ENEMY_NAME, 2, 3, 10,10);
    var expectedEnemy4 = new Enemy(turns, ENEMY_NAME, 1, 4, 10,10);
    var expectedEnemy5 = new Enemy(turns, ENEMY_NAME, 1, 3, 11,10);
    var expectedEnemy6 = new Enemy(turns, ENEMY_NAME, 1, 3, 10,20);
    var expectedEnemy7 = new Enemy(turns, ENEMY_NAME, 1, 3, 10,10);
    var expectedBlackMage = new BlackMage(turns, ENEMY_NAME, 1, 3);

    assertEquals(expectedBlackMage, expectedBlackMage);
    assertEquals(expectedBlackMage.hashCode(), expectedBlackMage.hashCode());

    assertEquals(expectedEnemy, expectedEnemy);
    assertEquals(expectedEnemy.hashCode(), expectedEnemy.hashCode());

    assertFalse(expectedEnemy.equals(expectedEnemy2));
    assertFalse(expectedEnemy.equals(expectedEnemy3));
    assertFalse(expectedEnemy.equals(expectedEnemy4));
    assertFalse(expectedEnemy.equals(expectedEnemy5));
    assertFalse(expectedEnemy.equals(expectedEnemy6));
    assertFalse(expectedEnemy.equals(expectedBlackMage));
    assertTrue(expectedEnemy.equals(expectedEnemy7));

    assertEquals(expectedEnemy.iAmA(),0 );
  }
  @Test
  void attackTest() {
    Knight testKnight = new Knight(turns,"Knight test", 50, 5);
    testEnemy.attack(testKnight);
    assertTrue(testKnight.getPuntosDeVida() == 45);
    Enemy testEnemy2 = new Enemy(turns,ENEMY_NAME,0,5,10,10);
    testEnemy2.attack(testKnight);
    assertTrue(testKnight.getPuntosDeVida() == 45);

  }
}