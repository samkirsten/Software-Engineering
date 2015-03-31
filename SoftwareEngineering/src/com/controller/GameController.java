package com.controller;

import com.model.*;
import com.view.GameGUI;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface GameController {

    public List<Game> createFixtures(HashMap<String,File> brains, Tournament t);

    public void startGame(Game game);

    public Game createGame(File brain1, String name1, File brain2, String name2, GameGUI gui);

    /**
     * Updates the results of the game and appends it to the tournament objects
     * @param game
     * @param tournament
     */
    public void updateScores(Game game, Tournament tournament);

}
