package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.character.Enemy;

import java.beans.PropertyChangeEvent;

public class EnterToQueueHandler implements IDeadHandler{
    private final GameController controller;

    /**
     * Creates a new enter to queue Handler
     */
    public EnterToQueueHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.tryToBeginTurn();
    }

}
