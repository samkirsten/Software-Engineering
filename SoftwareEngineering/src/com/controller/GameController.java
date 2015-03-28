package com.controller;

import com.model.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface GameController {


    public Colour beginSingleGame(File brain1, File brain2, Game g);

    public HashMap<File,Integer> beginTournametGame(File brain1, File brain2, Tournament t);

    public List<List<File>> createFixtures(File brains, Tournament t);


}
