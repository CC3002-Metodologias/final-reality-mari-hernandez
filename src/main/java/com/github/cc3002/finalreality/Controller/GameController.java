package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GameController {

    private BlockingQueue<ICharacter> turnsQueue;
    private int aliveEnemies = 0;
    private int alivePlayerCharacter = 0;
    private int totalEnemies = 5;
    private int totalPlayerCharacter = 3;
    private String winner;
    private Inventory inventory;
    private ArrayList<IPlayerCharacter> party;
    private ArrayList<Enemy> partyEnemies;
    private ICharacter playingCharacter;
    private final IDeadHandler enemyDeadHandler = new EnemyDeadHandler(this);
    private final IDeadHandler playerDeadHandler = new PlayerCharacterDeadHandler(this);


    /**
     * Creates a new Game Controller
     */
    public GameController() {

        turnsQueue = new LinkedBlockingQueue<>();
        inventory = new Inventory();
        party = new ArrayList<>();
        partyEnemies = new ArrayList<>();
    }

    /**
     * Decreases the lives of the player
     * if lives get to zero, the player looses.
     */
    public void playerLose(IPlayerCharacter player) {
        alivePlayerCharacter -= 1;
        if (alivePlayerCharacter == 0) {
            winner = "Enemy";
        }
    }

    /**
     * Decreases the lives of the enemies
     * if lives get to zero, the enemy looses.
     */
    public void enemyLose(Enemy enemy) {
        aliveEnemies -= 1;
        if (aliveEnemies == 0) {
            winner = "Player";
        }
    }

    /**
     * Equips a weapon from the inventory
     * to someone in the party
     */

    public void equip(IPlayerCharacter player, String weapon) {
        IWeapon newWeapon = inventory.lookForWeaponInInventory(weapon);
        IWeapon actualWeapon = player.getEquippedWeapon();
        player.equip(newWeapon);
        if (actualWeapon == null) {
            if (player.getEquippedWeapon() != null) {
                inventory.getOutOfInventory(newWeapon);
            }
        } else {
            if (!actualWeapon.equals(player.getEquippedWeapon())) {
                inventory.getOutOfInventory(newWeapon);
                inventory.getInInventory(actualWeapon);
            }
        }
    }

    /**
     * Player 1 attacks player 2
     */
    public void attack(ICharacter player1, ICharacter player2) {
        player1.attack(player2);
    }

    /**
     * Insert a player in the party
     * there is maximum of 3 players in the party
     */
    public void insertParty(IPlayerCharacter playerCharacter) {
        if (party.size() < totalPlayerCharacter) {
            alivePlayerCharacter++;
            party.add(playerCharacter);
            playerCharacter.addListener(playerDeadHandler);
        }
    }

    /**
     * Insert an enemy in the Enemies party
     * there is maximum of 5 enemies in the Enemies party
     */
    public void insertPartyEnemies(Enemy enemy) {
        if (partyEnemies.size() < totalEnemies) {
            aliveEnemies++;
            partyEnemies.add(enemy);
            enemy.addListener(enemyDeadHandler);
        }
    }

    /**
     * Creates a Black Mage
     * and if there is space in the party it inserts it
     */
    public void createBlackMage(String name, int puntosDeVida,
                                int defense) {
        BlackMage blackMage = new BlackMage(turnsQueue, name, puntosDeVida, defense);
        insertParty(blackMage);
    }

    /**
     * Creates a Engineer
     * and if there is space in the party it inserts it
     */
    public void createEngineer(String name, int puntosDeVida,
                               int defense) {
        Engineer engineer = new Engineer(turnsQueue, name, puntosDeVida, defense);
        insertParty(engineer);
    }

    /**
     * Creates a Knight
     * and if there is space in the party it inserts it
     */
    public void createKnight( String name, int puntosDeVida,
                             int defense) {
        Knight knight = new Knight(turnsQueue, name, puntosDeVida, defense);
        insertParty(knight);
    }

    /**
     * Creates a Thief
     * and if there is space in the party it inserts it
     */
    public void createThief(String name, int puntosDeVida,
                            int defense) {
        Thief thief = new Thief(turnsQueue, name, puntosDeVida, defense);
        insertParty(thief);
    }

    /**
     * Creates a White Mage
     * and if there is space in the party it inserts it
     */
    public void createWhiteMage( String name, int puntosDeVida,
                                int defense) {
        WhiteMage whiteMage = new WhiteMage(turnsQueue, name, puntosDeVida, defense);
        insertParty(whiteMage);
    }

    /**
     * Creates an Enemy
     * and if there is space in the Enemies party it inserts it
     */
    public void createEnemy( String name, int puntosDeVida,
                            int defense, int weight, int damage) {
        Enemy enemy = new Enemy(turnsQueue, name, puntosDeVida, defense, weight, damage);
        insertPartyEnemies(enemy);
    }

    /**
     * Creates an Axe
     * and inserts it on the Inventory
     */
    public void createAxe(String name, int damage, int weight) {
        Axe axe = new Axe(name, damage, weight);
        inventory.getInInventory(axe);
    }

    /**
     * Creates an Bow
     * and inserts it on the Inventory
     */
    public void createBow(String name, int damage, int weight) {
        Bow bow = new Bow(name, damage, weight);
        inventory.getInInventory(bow);
    }

    /**
     * Creates an Knife
     * and inserts it on the Inventory
     */
    public void createKnife(String name, int damage, int weight) {
        Knife knife = new Knife(name, damage, weight);
        inventory.getInInventory(knife);
    }

    /**
     * Creates an Staff
     * and inserts it on the Inventory
     */
    public void createStaff(String name, int damage, int weight) {
        Staff staff = new Staff(name, damage, weight);
        inventory.getInInventory(staff);
    }

    /**
     * Creates an Sword
     * and inserts it on the Inventory
     */
    public void createSword(String name, int damage, int weight) {
        Sword sword = new Sword(name, damage, weight);
        inventory.getInInventory(sword);
    }

    /**
     * Looks for the i player that got into the party
     */
    public IPlayerCharacter lookForPlayerCharacter(int i) {
        IPlayerCharacter player = party.get(i);
        return player;
    }

    /**
     * Looks for the i enemy that got into the Enemies party
     */
    public Enemy lookForEnemy(int i) {
        Enemy enemy = partyEnemies.get(i);
        return enemy;
    }

    /**
     * Looks for the name of the i player that got into the party
     */
    public String lookForCharacterName(int i) {
        IPlayerCharacter character = this.lookForPlayerCharacter(i);
        String name = character.getName();
        return name;
    }

    /**
     * Looks for the name of the i enemy that got into the Enemies party
     */
    public String lookForEnemiesName(int i) {
        Enemy enemy = this.lookForEnemy(i);
        String name = enemy.getName();
        return name;
    }

    /**
     * Looks for the HP of the i player that got into the party
     */
    public int lookForCharacterPuntosDeVida(int i) {
        IPlayerCharacter character = this.lookForPlayerCharacter(i);
        int puntosDeVida = character.getPuntosDeVida();
        return puntosDeVida;
    }

    /**
     * Looks for the HP of the i enemy that got into the Enemies party
     */
    public int lookForEnemiesPuntosDeVida(int i) {
        Enemy enemy = this.lookForEnemy(i);
        int puntosDeVida = enemy.getPuntosDeVida();
        return puntosDeVida;
    }

    /**
     * Looks for the defense of the i player that got into the party
     */
    public int lookForCharacterDefense(int i) {
        IPlayerCharacter character = this.lookForPlayerCharacter(i);
        int defense = character.getDefense();
        return defense;
    }

    /**
     * Looks for the defense of the i enemy that got into the Enemies party
     */
    public int lookForEnemiesDefense(int i) {
        Enemy enemy = this.lookForEnemy(i);
        int defense = enemy.getDefense();
        return defense;
    }

    /**
     * Looks for the weapon equipped by the i player that got into the party
     */
    public IWeapon lookForPlayerCharacterWeapon(int i) {
        IPlayerCharacter character = this.lookForPlayerCharacter(i);
        IWeapon weapon = character.getEquippedWeapon();
        return weapon;
    }

    /**
     * Looks for the weight of the i enemy that got into the Enemies party
     */
    public int lookForEnemyWeight(int i) {
        Enemy enemy = this.lookForEnemy(i);
        int weight = enemy.getWeight();
        return weight;
    }

    /**
     * Looks for the damage of the i enemy that got into the Enemies party
     */
    public int lookForEnemyDamage(int i) {
        Enemy enemy = this.lookForEnemy(i);
        int damage = enemy.getDamage();
        return damage;
    }

    /**
     * Get the party
     */
    public ArrayList<IPlayerCharacter> getParty() {
        return party;
    }

    /**
     * Get the inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * get the Enemies party
     */
    public ArrayList<Enemy> getPartyEnemies() {
        return partyEnemies;
    }

    /**
     * gets the winner
     */
    public String getWinner() {
        return winner;
    }

    /**
     * Starts a turn
     */
    public ICharacter turnsBegin() {
        ICharacter playing = turnsQueue.poll();
        return playing;
    }

    /**
     * Ends a turn
     */
    public void turnEnds(ICharacter character) {
        character.waitTurn();
    }

    /**
     * Enters all the players to the queue
     */
    public void gameStarter(){
        if(party.size()==totalPlayerCharacter){
            for (var character : party) {
                character.waitTurn();
            }
            for (var enemy : partyEnemies) {
                enemy.waitTurn();
            }
        }
    }
}
