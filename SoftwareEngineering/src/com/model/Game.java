package com.model;

import java.io.File;

public interface Game {

    int NUMBER_OF_ROUNDS = 300000;


    public boolean loadBrain(File brain, Colour colour);

    public Colony getColony(Colour colour);

    public File getBrain(Colour colour);

    public Map getMap();

    public void setup();

    public void nextRound();

    public int getCurrentRound();

    public void start();

    public Colour getWinner();

    public String getRedPlayerName();

    public String getBlackPlayerName();







}
