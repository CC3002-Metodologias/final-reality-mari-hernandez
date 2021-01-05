package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.Controller.GameController;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.*;
import javafx.scene.text.Font;

import java.util.Random;

/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public class FinalReality extends Application {
  private final GameController controller = new GameController();
  private Stage window;
  private int height =  600;
  private int width = 787;
  private Scene firstScene,instructions, selectCharacters, selectWeapons, startGame,enemiesWin, playerWin;
  Label CharactersLabel =new Label();
  Random rnd = new Random();
  int contador =1;
  int contadorParty=0;
  int contadorEnemigos=0;
  HashMap<String,String> listaCharacterImages = new HashMap<>();
  HashMap<String,String> listaWeaponsImages = new HashMap<>();
  private String blackMageImage ="https://i.imgur.com/hSSQppN.png";
  private String engineerImage = "https://i.imgur.com/mszPCDB.png";
  private String knightImage = "https://i.imgur.com/MMV2I2S.png";
  private String thiefImage = "https://i.imgur.com/L5oSafX.png";
  private String whiteMageImage= "https://i.imgur.com/nqyxNNT.png";
  private String enemieImage = "https://i.imgur.com/EotgSfW.png";
  private String axeImage = "https://i.imgur.com/9QfsWKh.png";
  private String bowImage = "https://i.imgur.com/twITQFy.png";
  private String knifeImage = "https://i.imgur.com/4tQdYVM.png";
  private String staffImage = "https://i.imgur.com/9bPwHWa.png";
  private String swordImage ="https://i.imgur.com/bHB2aR0.png";


  public static void main(String[] args) { launch(args); }


  @Override
  public void start(Stage primaryStage) throws FileNotFoundException {
    window=primaryStage;
    window.setTitle("Final Reality");
    Scene scene = mainMenu();
    window.setScene(scene);
    window.setResizable(false);
    window.show();
  }

  /**
   *creates the scene Main menu
   */
  private Scene mainMenu() throws FileNotFoundException {
    //Background image
    Image image1 = new Image("https://i.imgur.com/oPLXJnp.png");
    ImageView background = new ImageView(image1);
    background.setMouseTransparent(true);
    background.setFitWidth(width);
    background.setFitHeight(height);

    //Start the game button
    Button buttonStartGame = new Button("Start Game ");
    buttonStartGame.setOnAction(action -> {
      try {
        selectCharacters = selectCharacters();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
      window.setScene(selectCharacters);
    });
    buttonStartGame.setLayoutX(width/2-30);
    buttonStartGame.setLayoutY((2*height)/3);

    //Instruction button
    Button buttonInstructions = new Button("Instructions ");
    buttonInstructions.setOnAction(action -> {
      instructions = InstructionsScene();
      window.setScene(instructions);
    });
    buttonInstructions.setLayoutX(width/2-30);
    buttonInstructions.setLayoutY((2*height)/3+30);

    Group group= new Group();
    group.getChildren().addAll(background,buttonStartGame,buttonInstructions);
    return new Scene(group,width,height);
  }

  /**
   *
   * Creates the scene Instructions
   */
  private Scene InstructionsScene(){
    Group group = new Group();

    //Background image
    Image image1 = new Image("https://i.imgur.com/PzePwyk.png");
    ImageView background = new ImageView(image1);
    background.setMouseTransparent(true);
    background.setFitWidth(width);
    background.setFitHeight(height);

    //Back button
    Button buttonBack = new Button("Back");
    buttonBack.setOnAction(action -> {
      try {
        firstScene = mainMenu();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
      window.setScene(firstScene);
    });
    buttonBack.setLayoutX(80);
    buttonBack.setLayoutY((height-100));

    //Title
    Label sceneTitle = new Label("Instructions");
    sceneTitle.setFont(new Font("Adobe Fan Heiti Std B",30));
    sceneTitle.setLayoutX(width/3+20);
    sceneTitle.setLayoutY(30);

    //Instructions
    Label instructions = new Label("This game is inspired by Final Fantasy,\n"+
            " To play you need to choose a party conformed by 3 characters \n"+
            "between BlackMage, Engineer, Knight, Thief and  WhiteMage.\n"+
            " Each of your characters need to equip a weapon, depending on the \n"+
            "type of your character.\n"+
            "* Black Mages can equip a Knife or a Staff\n"+
            "* Engineers can equip an Axe and a Bow\n"+
            "* Knights can equip a Sword, an Axe and a Knife\n"+
            "* Thiefs can equip a Sword, a Staff and a Bow\n"+
            "* White Mages can equip a Staff \n"+
            " The game will automatically choose you a weapon, but you can change\n" +
            "it when its your characters turn.\n" +
            "  If you choose a weapon your character cant equip you will continue \n" +
            "to have your old weapon.\n"+
            " The number of enemies is different in every game, and it can be \n" +
            "between 2 and 5.\n"+
            "                                       I hope you enjoy this game!\n");
    instructions.setFont(new Font("Adobe Fan Heiti Std B",15.5));
    instructions.setLayoutX(width/8);
    instructions.setLayoutY(100);

    group.getChildren().addAll(background,buttonBack,sceneTitle,instructions);
    return new Scene(group,width,height);

  }

  /**
   *Creates the select Characters Scene
   */
  private Scene selectCharacters() throws FileNotFoundException{
    Group group = new Group();

    //Background image
    Image image1 = new Image("https://i.imgur.com/DXq3ghC.png");
    ImageView background = new ImageView(image1);
    background.setMouseTransparent(true);
    background.setFitWidth(width);
    background.setFitHeight(height);

    //Characters
    List<String> buttons = Arrays.asList("BlackMage", "Engineer", "Knight","Thief", "WhiteMage");
    Label Name = new Label("Black Mage's Name");
    Label Name2 = new Label("Engineer's Name");
    Label Name3 = new Label("Knight's Name");
    Label Name4 = new Label("Thief's Name");
    Label Name5 = new Label("White Mage's Name");

    TextField textNameBlackMage = new TextField();
    textNameBlackMage.setText("");
    Button buttonBlackMage = new Button("Create Black Mage");

    TextField textNameEngineer = new TextField();
    textNameEngineer.setText("");
    Button buttonEngineer = new Button("Create Engineer");

    TextField textNameKnight = new TextField();
    textNameKnight.setText("");
    Button buttonKnight= new Button("Create Knight");

    TextField textNameThief = new TextField();
    textNameThief.setText("");
    Button buttonThief = new Button("Create Thief");

    TextField textNameWhiteMage = new TextField();
    textNameWhiteMage.setText("");
    Button buttonWhiteMage = new Button("Create White Mage");


    for (String button : buttons) {
      switch (button) {
        case "BlackMage":

          buttonBlackMage.setOnAction(action -> {
            controller.createBlackMage(textNameBlackMage.getText(), 40, 6);
            listaCharacterImages.put(textNameBlackMage.getText(),blackMageImage);
            controller.createKnife("Basic Knife",6, 6);
            listaWeaponsImages.put("Basic Knife", knifeImage);
            controller.equip(controller.lookForPlayerCharacter(contadorParty),controller.lookForWeaponInInventoryByName("Basic Knife"));
            textNameBlackMage.setText("");
            contadorParty+=1;
          });
          break;
        case "Engineer":

          buttonEngineer.setOnAction(action -> {
            controller.createEngineer(textNameEngineer.getText(), 50, 8);
            listaCharacterImages.put(textNameEngineer.getText(),engineerImage);
            controller.createAxe("Basic Axe",16,20);
            listaWeaponsImages.put("Basic Axe", axeImage);
            controller.equip(controller.lookForPlayerCharacter(contadorParty),controller.lookForWeaponInInventoryByName("Basic Axe"));
            textNameEngineer.setText("");
            contadorParty+=1;
          });
          break;

        case "Knight":

          buttonKnight.setOnAction(action -> {
            controller.createKnight(textNameKnight.getText(), 80, 10);
            listaCharacterImages.put(textNameKnight.getText(), knightImage);
            controller.createSword("Basic Sword", 15, 12);
            listaWeaponsImages.put("Basic Sword", swordImage);
            controller.equip(controller.lookForPlayerCharacter(contadorParty),controller.lookForWeaponInInventoryByName("Basic Sword"));
            textNameKnight.setText("");
            contadorParty+=1;
          });
          break;
        case "Thief":

          buttonThief.setOnAction(action -> {
            controller.createThief(textNameThief.getText(), 45, 8);
            listaCharacterImages.put(textNameThief.getText(), thiefImage);
            controller.createBow("Basic Bow", 15, 12);
            listaWeaponsImages.put("Basic Bow", bowImage);
            controller.equip(controller.lookForPlayerCharacter(contadorParty),controller.lookForWeaponInInventoryByName("Basic Bow"));
            textNameThief.setText("");
            contadorParty+=1;
          });
          break;
        case "WhiteMage":

          buttonWhiteMage.setOnAction(action -> {
            controller.createWhiteMage(textNameWhiteMage.getText(), 60, 8);
            listaCharacterImages.put(textNameWhiteMage.getText(), whiteMageImage);
            controller.createStaff("Basic Staff", 10,18);
            listaWeaponsImages.put("Basic Staff", staffImage);
            controller.equip(controller.lookForPlayerCharacter(contadorParty),controller.lookForWeaponInInventoryByName("Basic Staff"));
            textNameWhiteMage.setText("");
            contadorParty+=1;
          });
          break;
      }
    }
    GridPane root = new GridPane();
    root.setHgap(5);
    root.setVgap(30);
    root.setPadding(new Insets(20));
    root.setLayoutY(60);

    VBox vBoxBlackMage = new VBox();
    vBoxBlackMage.setSpacing(3);
    vBoxBlackMage.getChildren().add(Name);
    vBoxBlackMage.getChildren().add(textNameBlackMage);
    root.addRow(1, vBoxBlackMage);
    root.addRow(10, buttonBlackMage);

    VBox vBoxEngineer = new VBox();
    vBoxEngineer.setSpacing(3);
    vBoxEngineer.getChildren().add(Name2);
    vBoxEngineer.getChildren().add(textNameEngineer);
    root.addRow(1, vBoxEngineer);
    root.addRow(10, buttonEngineer);

    VBox vBoxKnight = new VBox();
    vBoxKnight.setSpacing(3);
    vBoxKnight.getChildren().add(Name3);
    vBoxKnight.getChildren().add(textNameKnight);
    root.addRow(1, vBoxKnight);
    root.addRow(10, buttonKnight);

    VBox vBoxThief = new VBox();
    vBoxThief.setSpacing(3);
    vBoxThief.getChildren().add(Name4);
    vBoxThief.getChildren().add(textNameThief);
    root.addRow(1, vBoxThief);
    root.addRow(10, buttonThief);

    VBox vBoxWhiteMage= new VBox();
    vBoxWhiteMage.setSpacing(3);
    vBoxWhiteMage.getChildren().add(Name5);
    vBoxWhiteMage.getChildren().add(textNameWhiteMage);
    root.addRow(1, vBoxWhiteMage);
    root.addRow(10, buttonWhiteMage);

    //Button next
    Button buttonNext = new Button("Next");
    buttonNext.setOnAction(action -> {
      if(contadorParty==3){
        createEnemiesForTheGame();
        createInventory();
        try {
          startGame = startGame();
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
        controller.tryToGameStarter();
        window.setScene(startGame);

      }
    });
    buttonNext.setLayoutX(width*10/11 -40);
    buttonNext.setLayoutY((height-100));


    //button back
    Button buttonBack = new Button("Back");
    buttonBack.setOnAction(action -> {
      try {
        firstScene = mainMenu();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
      window.setScene(firstScene);
    });
    buttonBack.setLayoutX(60);
    buttonBack.setLayoutY((height-100));

    //Contador personajes
    CharactersLabel.setLayoutX(width/3);
    CharactersLabel.setLayoutY((height-100));

    //Title
    Label sceneTitle = new Label("Choose your party");
    sceneTitle.setFont(new Font("Adobe Fan Heiti Std B",30));
    sceneTitle.setLayoutX(width/3);
    sceneTitle.setLayoutY(30);

    group.getChildren().addAll(background,buttonBack,root,sceneTitle,CharactersLabel,buttonNext);
    startAnimator("Primero");
    return new Scene(group,width,height);

  }

  /**
   * Creates between 2 and 5 enemies
   */
  private void createEnemiesForTheGame() {
    int size = rnd.nextInt(4)+2;
    contadorEnemigos=size;
    for (int i=0; i<size; i++){
      controller.createEnemy("Enemy"+i,
              rnd.nextInt(20)+20,
              rnd.nextInt(6)+4,
              20+2*i,
              rnd.nextInt(20)+5
      );
    }
  }

  /**
   * creates 5 weapons for the inventory
   */
  private void createInventory(){
    controller.createBow("Advanced Bow",16,22);
    listaWeaponsImages.put("Advanced Bow", bowImage);
    controller.createAxe("Advanced Axe", 20, 25);
    listaWeaponsImages.put("Advanced Axe", axeImage);
    controller.createKnife("Advanced Knife", 8, 14);
    listaWeaponsImages.put("Advanced Knife", knifeImage);
    controller.createStaff("Advanced Staff", 11, 18);
    listaWeaponsImages.put("Advanced Staff", staffImage);
    controller.createSword("Advanced Sword", 17, 23);
    listaWeaponsImages.put("Advanced Sword", swordImage);
  }


  /**
   *cretaes the select Weapons scene
   */
  private Scene selectWeapons(ICharacter name) throws FileNotFoundException{

    //Background Image
    Image image1 = new Image("https://i.imgur.com/PzePwyk.png");
    ImageView background = new ImageView(image1);
    background.setMouseTransparent(true);
    background.setFitWidth(width);
    background.setFitHeight(height);

    //Title of the scene
    Label sceneTitle = new Label("Choose "+ name.getName()  +"'s weapon");
    sceneTitle.setFont(new Font("Adobe Fan Heiti Std B",30));
    sceneTitle.setLayoutX(width/3);
    sceneTitle.setLayoutY(30);

    //weapons
    List<IWeapon> listOfWeapons =controller.getInventory();
    HBox hBoxWeapons =new HBox();
    int i=1;
    for( IWeapon weapon: listOfWeapons){
      String nameW = controller.lookForWeaponName(i-1);
      Label weaponName =new Label(nameW);
      weaponName.setBackground(new Background(new BackgroundFill(Color.rgb(100, 223, 221, 0.5), new CornerRadii(4.0), new Insets(-5.0))));

      Label weaponDamage =new Label("Damage "+ controller.lookForWeaponDamage(i-1));
      weaponDamage.setBackground(new Background(new BackgroundFill(Color.rgb(100, 223, 221, 0.5), new CornerRadii(4.0), new Insets(-5.0))));

      Label weaponWeight =new Label("Weight : "+ controller.lookForWeaponWeight(i-1));
      weaponWeight.setBackground(new Background(new BackgroundFill(Color.rgb(100, 223, 221, 0.5), new CornerRadii(4.0), new Insets(-5.0))));

      Image image3 = new Image(listaWeaponsImages.get(nameW));
      ImageView weaponImage = new ImageView(image3);
      weaponImage.setFitHeight(40*2);
      weaponImage.setFitWidth(28*3);

      Button equipButton = new Button("Equip "+nameW);
      equipButton.setOnAction(actionEvent -> {
        controller.equip(controller.lookForCharacterByName(name.getName()), controller.lookForWeaponInInventoryByName(nameW));
        try {
          startGame = startGame();
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
        window.setScene(startGame);
      });


      GridPane gridPane=new GridPane();
      gridPane.add(weaponName,1,0);
      gridPane.add(weaponImage,1,1);
      gridPane.add(weaponDamage,1,2);
      gridPane.add(weaponWeight,1,3);
      gridPane.add(equipButton,1,4);
      gridPane.setHgap(10);

      hBoxWeapons.getChildren().add(gridPane);
      i+=1;
    }
    hBoxWeapons.setLayoutY(height/4+45);
    hBoxWeapons.setLayoutX(30);

    //back button
    Button buttonBack = new Button("Back");
    buttonBack.setOnAction(action -> {
      try {
        startGame = startGame();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
      window.setScene(startGame);
    });
    buttonBack.setLayoutX(60);
    buttonBack.setLayoutY((height-100));


    Group group = new Group();
    group.getChildren().addAll(background, sceneTitle,buttonBack,hBoxWeapons);

    return new Scene(group,width,height);
  }

  /**
   * Creates the scene start game
   */
  private Scene startGame() throws FileNotFoundException{
    //background image
    Image image1 = new Image("https://i.imgur.com/SRWAnN0.jpg");
    ImageView background = new ImageView(image1);
    background.setMouseTransparent(true);
    background.setFitWidth(width);
    background.setFitHeight(height);

    //enemies
    List<Enemy> listOfEnemies = controller.getPartyEnemies();
    HBox hBoxEnemies =new HBox();
    int x=1;
    for( Enemy enemy: listOfEnemies){
      Label enemyName =new Label(controller.lookForEnemiesName(x-1));
      enemyName.setCenterShape(true);
      enemyName.setBackground(new Background(new BackgroundFill(Color.rgb(100, 223, 221, 0.5), new CornerRadii(4.0), new Insets(-5.0))));

      Label enemyPuntosDeVida =new Label("Life : "+controller.lookForEnemiesPuntosDeVida(x-1));
      enemyPuntosDeVida.setBackground(new Background(new BackgroundFill(Color.rgb(100, 223, 221, 0.5), new CornerRadii(5.0), new Insets(-5.0))));

      Label enemyDamage =new Label("Damage "+ controller.lookForEnemyDamage(x-1));
      enemyDamage.setBackground(new Background(new BackgroundFill(Color.rgb(100, 223, 221, 0.5), new CornerRadii(5.0), new Insets(-5.0))));

      Label enemyDefense =new Label("Defense : "+ controller.lookForEnemiesDefense(x-1));
      enemyDefense.setBackground(new Background(new BackgroundFill(Color.rgb(100, 223, 221, 0.5), new CornerRadii(5.0), new Insets(-5.0))));

      Image image2 = new Image(enemieImage);
      ImageView enemyImage = new ImageView(image2);
      enemyImage.setFitHeight(40*4);
      enemyImage.setFitWidth(28*3.5);

      Button attackButton = new Button("Attack "+ controller.lookForEnemiesName(x-1));
      int finalX = x;
      attackButton.setOnAction(actionEvent -> {
        controller.tryToAttack(controller.getPlayingCharacter(),controller.lookForEnemy(finalX -1));
        try {
          startGame =startGame();
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
        window.setScene(startGame);
      });

      GridPane gridPane=new GridPane();
      gridPane.add(enemyName,1,0);
      gridPane.add(enemyImage,1,1);
      gridPane.add(enemyPuntosDeVida,1,2);
      gridPane.add(enemyDamage,1,3);
      gridPane.add(enemyDefense,1,4);
      gridPane.add(attackButton,1,5);
      gridPane.setHgap(5);

      hBoxEnemies.getChildren().add(gridPane);
      x+=1;
    }

    //players
    List<IPlayerCharacter> listOfPlayers=controller.getParty();
    HBox hBoxPlayers =new HBox();
    int k=1;
    for( IPlayerCharacter player: listOfPlayers){

      Label characterName =new Label(controller.lookForCharacterName(k-1));
      characterName.setBackground(new Background(new BackgroundFill(Color.rgb(249, 223, 221, 0.5), new CornerRadii(4.0), new Insets(-5.0))));

      Label characterPuntosDeVida =new Label("Life : "+controller.lookForCharacterPuntosDeVida(k-1));
      characterPuntosDeVida.setBackground(new Background(new BackgroundFill(Color.rgb(249, 223, 221, 0.5), new CornerRadii(4.0), new Insets(-5.0))));

      Label characterWeapon =new Label("Weapon "+ controller.lookForPlayerCharacterWeapon(k-1).getName());
      characterWeapon.setBackground(new Background(new BackgroundFill(Color.rgb(249, 223, 221, 0.5), new CornerRadii(4.0), new Insets(-5.0))));

      Label characterDamage =new Label("Damage "+ controller.lookForPlayerCharacterWeapon(k-1).getDamage());
      characterDamage.setBackground(new Background(new BackgroundFill(Color.rgb(249, 223, 221, 0.5), new CornerRadii(4.0), new Insets(-5.0))));

      Label characterDefense =new Label("Defense : "+ controller.lookForCharacterDefense(k-1));
      characterDefense.setBackground(new Background(new BackgroundFill(Color.rgb(249, 223, 221, 0.5), new CornerRadii(4.0), new Insets(-5.0))));


      Image image3 = new Image(listaCharacterImages.get(controller.lookForCharacterName(k-1)));
      ImageView characterImage = new ImageView(image3);
      characterImage.setFitHeight(40*5);
      characterImage.setFitWidth(28*3.5);


      GridPane gridPane=new GridPane();
      gridPane.add(characterName,1,0);
      gridPane.add(characterImage,1,1);
      gridPane.add(characterPuntosDeVida,1,2);
      gridPane.add(characterWeapon, 1, 3);
      gridPane.add(characterDefense,1,4);
      gridPane.add(characterDamage,1,5);

      hBoxPlayers.getChildren().add(gridPane);
      k+=1;
    }
    hBoxPlayers.setLayoutY(height/2);
    hBoxPlayers.setLayoutX(width/6);
    hBoxPlayers.setSpacing(10);

    hBoxEnemies.setLayoutY(40);
    hBoxEnemies.setLayoutX((width*10)/14 - ((width)*contadorEnemigos^(contadorEnemigos*contadorEnemigos))/(12));

    Button buttonInventory = new Button("Inventory");
    buttonInventory.setOnAction(action -> {
      try {
        selectWeapons = selectWeapons(controller.getPlayingCharacter());
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
      window.setScene(selectWeapons);
    });
    buttonInventory.setLayoutX(width*3/4);
    buttonInventory.setLayoutY(height/1.5);


    //A quien le toca jugar
    CharactersLabel.setLayoutX(width/6);
    CharactersLabel.setLayoutY((height/4));
    CharactersLabel.setBackground(new Background(new BackgroundFill(Color.rgb(249, 223, 221, 0.5), new CornerRadii(4.0), new Insets(-5.0))));
    startAnimator("segundo");

    Group group = new Group();
    group.getChildren().addAll(background,hBoxEnemies,hBoxPlayers,buttonInventory,CharactersLabel);
    return new Scene(group,width,height);
  }

  private void startAnimator(String s) {
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(final long now) {
        int totalCharacters = controller.getTotalPlayerCharacter();
        int totalChosenCharacters = controller.getAlivePlayerCharacter();
        if(s=="Primero"){
        CharactersLabel.setText("You have chosen " + totalChosenCharacters + " of "+ totalCharacters +" that you need to choose\n"+
        "If you don't select 3 characters the game wont start!");
      }else if (s=="segundo"){
          if(!(controller.getPlayingCharacter() ==null)){
          CharactersLabel.setText("Its the turn of "+ controller.getPlayingCharacter().getName());
        }}
      }
    };
    timer.start();
  }
}