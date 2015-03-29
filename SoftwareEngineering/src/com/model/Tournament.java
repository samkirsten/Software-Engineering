package com.model;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface Tournament {

    public List<List<File>> createFixtures(List<File> brains);

    public void updateScores(Game game);

    public HashMap<File,Integer> getResults();
}
