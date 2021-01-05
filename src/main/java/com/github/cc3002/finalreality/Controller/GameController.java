package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.Controller.States.ControllerState;
import com.github.cc3002.finalreality.Controller.States.StartState;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GameController {

    private final BlockingQueue<ICharacter> turnsQueue;
    private int aliveEnemies = 0;
    private int alivePlayerCharacter = 0;
    private final int totalPlayerCharacter = 3;
    private String winner;
    private final ArrayList<IWeapon> inventory;
    private final ArrayList<IPlayerCharacter> party;
    private final ArrayList<Enemy> partyEnemies;
    private ICharacter playingCharacter;
    private final IDeadHandler enemyDeadHandler = new EnemyDeadHandler(this);
    private final IDeadHandler playerDeadHandler = new PlayerCharacterDeadHandler(this);
    private final IDeadHandler characterQueueHandler = new EnterToQueueHandler(this);
    private ControllerState state;
    private final Random random;

    /**
     * Creates a new Game Controller
     */
    public GameController() {

        turnsQueue = new LinkedBlockingQueue<>();
        inventory = new ArrayList<>();
        party = new ArrayList<>();
        partyEnemies = new ArrayList<>();
        setState(new StartState());
        random= new Random();
    }

    /**
     * Gets the i weapon on the inventory
     */
    public IWeapon lookForWeaponInInventory(int i){
        IWeapon theWeapon = inventory.get(i);
        return theWeapon;
    }

    /**
     * Introduce a weapon on the inventory
     */
    public void getInInventory(IWeapon weapon){
        inventory.add(weapon);
    }

    /**
     * Remove a weapon from the inventory
     */
    public void getOutOfInventory(IWeapon weapon){
        inventory.remove(weapon);
    }


    /**
     * Looks for a weapon on the invetory by its name
     */
    public IWeapon lookForWeaponInInventoryByName(String name){
        int i=0;
        for (IWeapon weapon: inventory){
            if( inventory.get(i).getName().equals(name)){
                return inventory.get(i);
            }
            i++;
        }
        return null;
    }

    /**
     * Decreases the lives of the player
     * if lives get to zero, the player looses.
     */
    public void playerLose(IPlayerCharacter player) {
        alivePlayerCharacter -= 1;
        if (alivePlayerCharacter == 0) {
            state.enemiesWinState();
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
            state.playerWinState();
            winner = "Player";
        }
    }

    /**
     * Equips a weapon from the inventory
     * to someone in the party
     */
    public void equip(IPlayerCharacter player, IWeapon weapon) {
        IWeapon actualWeapon = player.getEquippedWeapon();
        player.equip(weapon);
        if (actualWeapon == null) {
            if (player.getEquippedWeapon() != null) {
                getOutOfInventory(weapon);
            }
        } else {
            if (!actualWeapon.equals(player.getEquippedWeapon())) {
                getOutOfInventory(weapon);
                getInInventory(actualWeapon);
            }
        }
    }

    /**
     * Player 1 attacks player 2
     */
    public void attack(ICharacter player1, ICharacter player2) {
        player1.attack(player2);
        state.endTurnState();
        turnEnds();
    }

    /**
     * Insert a player in the party
     * there is maximum of 3 players in the party
     */
    public void insertParty(IPlayerCharacter playerCharacter) {
        if (party.size() < totalPlayerCharacter) {
            alivePlayerCharacter++;
            party.add(playerCharacter);
            playerCharacter.addListenerDead(playerDeadHandler);
            playerCharacter.addListenerQueue(characterQueueHandler);
        }
    }

    /**
     * Insert an enemy in the Enemies party
     * there is maximum of 5 enemies in the Enemies party
     */
    public void insertPartyEnemies(Enemy enemy) {
        int totalEnemies = 5;
        if (partyEnemies.size() < totalEnemies) {
            aliveEnemies++;
            partyEnemies.add(enemy);
            enemy.addListenerDead(enemyDeadHandler);
            enemy.addListenerQueue(characterQueueHandler);
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
        getInInventory(axe);
    }

    /**
     * Creates an Bow
     * and inserts it on the Inventory
     */
    public void createBow(String name, int damage, int weight) {
        Bow bow = new Bow(name, damage, weight);
        getInInventory(bow);
    }

    /**
     * Creates an Knife
     * and inserts it on the Inventory
     */
    public void createKnife(String name, int damage, int weight) {
        Knife knife = new Knife(name, damage, weight);
        getInInventory(knife);
    }

    /**
     * Creates an Staff
     * and inserts it on the Inventory
     */
    public void createStaff(String name, int damage, int weight) {
        Staff staff = new Staff(name, damage, weight);
        getInInventory(staff);
    }

    /**
     * Creates an Sword
     * and inserts it on the Inventory
     */
    public void createSword(String name, int damage, int weight) {
        Sword sword = new Sword(name, damage, weight);
        getInInventory(sword);
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

    public String lookForWeaponName(int i){
        IWeapon weapon = this.lookForWeaponInInventory(i);
        String name = weapon.getName();
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

    public IPlayerCharacter lookForCharacterByName(String name){
        int i=0;
        for (IPlayerCharacter player: party){
            if( party.get(i).getName().equals(name)){
                return party.get(i);
            }
            i++;
        }
        return null;

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
        return character.getEquippedWeapon();
    }

    /**
     * Looks for the weight of the i enemy that got into the Enemies party
     */
    public int lookForEnemyWeight(int i) {
        Enemy enemy = this.lookForEnemy(i);
        return enemy.getWeight();
    }

    /**
     * Gets the Weight of the weapon i on the inventory
     */
    public int lookForWeaponWeight(int i){
        IWeapon weapon= this.lookForWeaponInInventory(i);
        return weapon.getWeight();
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
     * Gets the Damage of the weapon i on the inventory
     */
    public int lookForWeaponDamage(int i){
        IWeapon weapon = this.lookForWeaponInInventory(i);
        return weapon.getDamage();

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
    public ArrayList<IWeapon> getInventory() {
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
     * State pattern
     */
    public void setState(ControllerState state){
        this.state = state;
        state.setController(this);
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
            }state.beginTurnState();
        }
    }

    /**
     * If the state its the correct one, starts the game
     */
    public void tryToGameStarter(){
        state.tryToGameStarter();
    }

    /**
     * Starts a turn
     */
    public void beginTurn(){
        playingCharacter = turnsQueue.poll();
        state.selectingState();
        if (playingCharacter.iAmA()==0){
            ICharacter player = chooseRandomPlayer();
            state.attackingState();
            tryToAttack(playingCharacter, player);
        }else if (playingCharacter.iAmA()==1){
            state.attackingState();
        }
    }

    /**
     * If the state its the correct one, attack
     */
    public void tryToAttack(ICharacter player, ICharacter player2){
        state.tryToAttack(player, player2);
    }


    /**
     * Chooses random player to attack
     */
    public ICharacter chooseRandomPlayer(){
        int partySize = getParty().size();
        int num = random.nextInt(partySize);
        ICharacter player = lookForPlayerCharacter(num);
        if(player.getPuntosDeVida()>0){
            return player;
        }else{
            chooseRandomPlayer();
        }
        return player;
    }

    /**
     *If the state its the correct one, begin turn
     */
    public void tryToBeginTurn(){
        state.tryToBeginTurn(); }

    /**
     * Ends a turn
     */
    public void turnEnds() {
        playingCharacter.waitTurn();
        state.beginTurnState();
        if(!turnsQueue.isEmpty()){
            tryToBeginTurn();
        }
    }

    /**
     * gets the number of player characters
     */
    public int getTotalPlayerCharacter(){
        return totalPlayerCharacter;
    }

    /**
     * gets the number of alive player characters
     */
    public  int getAlivePlayerCharacter(){
        return alivePlayerCharacter;
    }

    /**
     * gets the playing character
     */
    public ICharacter getPlayingCharacter(){
        return playingCharacter;
    }

}
