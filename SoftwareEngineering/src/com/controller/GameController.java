package com.controller;

import com.model.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface GameController {

    public List<List<File>> createFixtures(List<File> brains, Tournament t);

    public void nextRound(Game game);

    /**
     * Returns a new game with the black and red anthills flipped on the same map
     * @param game
     * @return
     */
    public Game changeSides(Game game);

    public Game createGame(File brain1, File brain2);


    /**
     * Updates the results of the game and appends it to the tournament objects
     * @param game
     * @param tournament
     */
    public void updateScores(Game game, Tournament tournament);

}
