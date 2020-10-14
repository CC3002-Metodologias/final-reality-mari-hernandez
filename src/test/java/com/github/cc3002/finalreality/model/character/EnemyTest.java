package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest  {

  protected BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();
  private static final String ENEMY_NAME = "Test Enemy";
  private static final String ENEMY_NAME2 = "Test Enemy 2";
  private static final String ENEMY_NAME3 = "Test Enemy 3";
  private static final String ENEMY_NAME4 = "Test Enemy 4";
  private static final String ENEMY_NAME5 = "Test Enemy 5";
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
    var expectedEnemy = new Enemy(turns,ENEMY_NAME,1,1,1,1);
    var expectedEnemy2 = new Enemy(turns,ENEMY_NAME2,1,1,1,1);
    var expectedEnemy3 = new Enemy(turns,ENEMY_NAME3,5,1,4,1);
    var expectedEnemy4 = new Enemy(turns,ENEMY_NAME4,1,5,1,1);
    var expectedEnemy5 = new Enemy(turns,ENEMY_NAME5,1,1,1,2);
    var expectedWhiteMage= new WhiteMage(turns,"White Mage",1,1,1);
    var expectedEnemy6 = new Enemy(turns,ENEMY_NAME,2,1,1,1);
    var expectedEnemy7 = new Enemy(turns,ENEMY_NAME,1,2,1,1);
    var expectedEnemy8 = new Enemy(turns,ENEMY_NAME,1,1,2,1);
    var expectedEnemy9 = new Enemy(turns,ENEMY_NAME,1,1,1,2);
    assertEquals(expectedWhiteMage, expectedWhiteMage);
    assertEquals(expectedWhiteMage.hashCode(), expectedWhiteMage.hashCode());

    assertEquals(expectedEnemy, expectedEnemy);
    assertEquals(expectedEnemy.hashCode(), expectedEnemy.hashCode());

    assertFalse(expectedEnemy.equals(expectedEnemy2));
    assertFalse(expectedEnemy.equals(expectedEnemy6));
    assertFalse(expectedEnemy.equals(expectedEnemy7));
    assertFalse(expectedEnemy.equals(expectedEnemy8));
    assertFalse(expectedEnemy.equals(expectedEnemy9));

    assertFalse(testEnemy.equals(expectedWhiteMage));
    assertFalse(expectedEnemy.hashCode() == expectedWhiteMage.hashCode());

    assertFalse(testEnemy.equals(expectedEnemy2));
    assertFalse(expectedEnemy2.hashCode() == testEnemy.hashCode());

    assertFalse(testEnemy.equals(expectedEnemy3));
    assertFalse(expectedEnemy3.hashCode() == testEnemy.hashCode());

    assertFalse(testEnemy.equals(expectedEnemy4));
    assertFalse(expectedEnemy4.hashCode() == testEnemy.hashCode());

    assertTrue(testEnemy.equals(testEnemy));
    assertTrue(testEnemy.hashCode() == testEnemy.hashCode());

    assertFalse(testEnemy.equals(expectedEnemy5));
    assertFalse(expectedEnemy5.hashCode() == testEnemy.hashCode());

  }

}