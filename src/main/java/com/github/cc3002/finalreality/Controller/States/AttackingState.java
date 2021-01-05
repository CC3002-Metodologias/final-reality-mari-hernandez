package com.github.cc3002.finalreality.Controller.States;

import com.github.cc3002.finalreality.model.character.ICharacter;

public class AttackingState extends ControllerState{

    /**
     * creates an attacking state
     */
    public AttackingState(){
        super();
    }

    /**
     * Change the state to end turn
     */
    public void endTurnState(){
        controller.setState(new EndTurnState());
    }

    /**
     * Change the state to enemies win
     */
    public void enemiesWinState(){
        controller.setState(new EnemiesWinState());
    }

    /**
     * Change the state to player win
     */
    public void playerWinState(){
        controller.setState(new PlayerWinState());
    }

    /**
     * tries to attack
     */
    public void tryToAttack(ICharacter player, ICharacter player2){
        controller.attack(player, player2);
    }

    /**
     * identifies the state
     */
    public boolean isAttackingState(){
        return true;
    }

}
