package com.github.cc3002.finalreality.Controller.States;

public class BeginTurnState extends ControllerState{

    /**
     * creates an begin turn state
     */
    public BeginTurnState(){
        super();
    }

    /**
     * change the state to selecting
     */
    public void selectingState(){
        controller.setState(new SelectingState());
    }

    /**
     * tries to begin turn
     */
    public void tryToBeginTurn(){
        controller.beginTurn();
    }

    @Override
    public boolean isBeginTurnState(){
        return true;
    }
}
