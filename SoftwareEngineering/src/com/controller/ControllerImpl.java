package com.controller;
import com.model.*;
import com.view.GameGUI;

import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
* Created by Jacob on 28/03/2015.
*/
public class ControllerImpl implements GameController {

    @Override
    public List<Game> createFixtures(HashMap<String,File> brains, Tournament t) {
        return t.createFixtures(brains);
    }

    @Override
    public Game createGame(File brain1,String name1, File brain2, String name2, GameGUI gui){
        Game game = new GameImpl(brain1,name1,brain2,name2,gui);
        return game;
    }

    @Override
    public void startGame(Game game) {
        game.start();
    }

    @Override
    public void updateScores(Game game, Tournament t) {
        t.updateScores(game);
    }
}

