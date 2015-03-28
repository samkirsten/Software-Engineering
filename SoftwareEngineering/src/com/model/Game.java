package com.model;

import java.io.File;

public interface Game {

    int NUMBER_OF_ROUNDS = 300000;


    public boolean loadBrain(File brain, Colour colour);

    public void setColony(Colony colony);

    public Colony getColony(Colour colour);

    public void setMap(Map map);

    public Map getMap();

    public Colour start();

    public int getCurrentRound();








}
