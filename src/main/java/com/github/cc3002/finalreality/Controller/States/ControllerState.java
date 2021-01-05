package com.github.cc3002.finalreality.Controller.States;

import com.github.cc3002.finalreality.Controller.GameController;
import com.github.cc3002.finalreality.model.character.ICharacter;

public class ControllerState {
    protected GameController controller;

    public void setController(GameController controller){
        this.controller = controller;
    }

    public void beginTurnState(){}

    public void attackingState(){}

    public void endTurnState(){}

    public void enemiesWinState(){}

    public void playerWinState(){}

    public void selectingState(){}

    public void startState(){}


    public boolean isBeginTurnState(){
        return false;
    }

    public boolean isSelectingState(){
        return false;
    }

    public boolean isAttackingState(){
        return false;
    }

    public boolean isEnemiesWinState(){
        return false;
    }

    public boolean isEndTurnState(){
        return false;
    }

    public boolean isPlayersWinState(){
        return false;
    }


    public void tryToGameStarter() {
    }

    public void tryToBeginTurn() {
    }

    public void tryToAttack(ICharacter player, ICharacter player2){
    }
}
