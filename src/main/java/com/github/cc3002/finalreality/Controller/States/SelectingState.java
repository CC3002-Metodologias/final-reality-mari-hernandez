package com.github.cc3002.finalreality.Controller.States;

public class SelectingState extends ControllerState{

    /**
     * creates an attacking state
     */
    public void attackingState(){
        controller.setState(new AttackingState());
    }
}
