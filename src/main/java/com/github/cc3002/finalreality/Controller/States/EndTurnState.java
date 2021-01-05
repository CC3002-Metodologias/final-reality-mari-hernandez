package com.github.cc3002.finalreality.Controller.States;

public class EndTurnState extends ControllerState {

    /**
     * creates an end turn state
     */
    public EndTurnState(){
        super();
    }

    /**
     * change the state to begin turn
     */
    public void beginTurnState(){
        controller.setState(new BeginTurnState());
    }
}
