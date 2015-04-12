package com.model;

import com.view.GameGUI;

import java.io.File;

public interface Game {

    int NUMBER_OF_ROUNDS = 300000;


    public boolean loadBrain(File brain, Colour colour);

    public Colony getColony(Colour colour);

    public File getBrain(Colour colour);

    public Map getMap();

    public void nextRound();

//    public String getBlackPlayerName();
//
//    public String getRedPlayerName();

    public int getCurrentRound();

    public Colour getWinner();

    public String getWinnerName();

    public String getBlackPlayerName();

    public String getRedPlayerName();

    public GameGUI getGUI();

    public void start();

    public boolean loadMap(File map);

    public void setup();

    




}
