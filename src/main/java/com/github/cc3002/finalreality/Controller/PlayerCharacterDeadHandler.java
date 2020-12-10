package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.character.IPlayerCharacter;

import java.beans.PropertyChangeEvent;

public class PlayerCharacterDeadHandler implements IDeadHandler{
    private final GameController controller;

    /**
     * Creates a new Player dead Handler
     */
    public PlayerCharacterDeadHandler(GameController controller) {
        this.controller = controller;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.playerLose((IPlayerCharacter) evt.getNewValue());
    }


}
