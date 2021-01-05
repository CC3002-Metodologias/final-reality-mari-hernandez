package com.github.cc3002.finalreality.Controller.States;

public class StartState extends ControllerState{
    /**
     * creates an start state
     */
    public StartState(){
        super();
    }

    /**
     * change state to begin turn
     */
    public void beginTurnState(){
        controller.setState(new BeginTurnState());
    }

    /**
     * tries to start the game
     */
    public void tryToGameStarter(){
        controller.gameStarter();
    }

}
