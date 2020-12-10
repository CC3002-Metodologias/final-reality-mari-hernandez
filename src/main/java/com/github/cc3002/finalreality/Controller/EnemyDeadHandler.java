package com.github.cc3002.finalreality.Controller;

import com.github.cc3002.finalreality.model.character.Enemy;

import java.beans.PropertyChangeEvent;

public class EnemyDeadHandler implements IDeadHandler{
    private final GameController controller;

    /**
     * Creates a new Enemy dead Handler
     */
    public EnemyDeadHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.enemyLose((Enemy) evt.getNewValue());
    }

}
