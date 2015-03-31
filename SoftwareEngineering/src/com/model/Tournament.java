package com.model;

import com.view.GameGUI;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface Tournament {

    public List<Game> createFixtures(HashMap<String,File> brains);

    public void updateScores(Game game);

    public HashMap<String,Integer> getResults();

    public void setGUI(GameGUI gui);
}
