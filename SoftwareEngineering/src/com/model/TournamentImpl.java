package com.model;

import com.view.GameGUI;

import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class TournamentImpl implements Tournament {

    private HashMap<String,Integer> resultsTable = new HashMap<>();
    private List<Game> fixtures = new ArrayList<>();
    private GameGUI gui;

    @Override
    public List<Game> createFixtures(HashMap<String,File> brains) {


        List<String> names = new ArrayList<>(brains.keySet());
        List<File> brainFiles = new ArrayList<>();

        for(String name : names) {
            File brainFile = brains.get(name);
            brainFiles.add(brainFile);
        }

        if (brains.size() == 4) {
            for (int i = 0; i < 6; i++) {
                Game tempGame = null;
                switch (i) {
                    case 0:
                        tempGame = new GameImpl(brainFiles.get(0),names.get(0),brainFiles.get(1),names.get(1),gui);
                        fixtures.add(tempGame);
                        fixtures.add(new GameImpl(brainFiles.get(0),names.get(0),brainFiles.get(1),names.get(1),gui,tempGame.getMap()));
                        break;
                    case 1:
                        tempGame = new GameImpl(brainFiles.get(0),names.get(0),brainFiles.get(2),names.get(2),gui);
                        fixtures.add(tempGame);
                        fixtures.add(new GameImpl(brainFiles.get(0),names.get(0),brainFiles.get(2),names.get(2),gui,tempGame.getMap()));
                        break;
                    case 2:
                        tempGame = new GameImpl(brainFiles.get(0),names.get(0),brainFiles.get(3),names.get(3),gui);
                        fixtures.add(tempGame);
                        fixtures.add(new GameImpl(brainFiles.get(0),names.get(0),brainFiles.get(3),names.get(3),gui,tempGame.getMap()));
                        break;
                    case 3:
                        tempGame = new GameImpl(brainFiles.get(1),names.get(1),brainFiles.get(2),names.get(2),gui);
                        fixtures.add(tempGame);
                        fixtures.add(new GameImpl(brainFiles.get(1),names.get(1),brainFiles.get(2),names.get(2),gui,tempGame.getMap()));
                        break;
                    case 4:
                        tempGame = new GameImpl(brainFiles.get(1),names.get(1),brainFiles.get(3),names.get(3),gui);
                        fixtures.add(tempGame);
                        fixtures.add(new GameImpl(brainFiles.get(1),names.get(1),brainFiles.get(3),names.get(3),gui,tempGame.getMap()));
                        break;
                    case 5:
                        tempGame = new GameImpl(brainFiles.get(2),names.get(2),brainFiles.get(3),names.get(3),gui);
                        fixtures.add(tempGame);
                        fixtures.add(new GameImpl(brainFiles.get(2),names.get(2),brainFiles.get(3),names.get(3),gui,tempGame.getMap()));
                        break;
                }
            }
        }
        else if(brains.size()==3){
            for (int i = 0; i < 3; i++) {
                Game tempGame = null;
                switch (i) {
                    case 0:
                        tempGame = new GameImpl(brainFiles.get(0),names.get(0),brainFiles.get(1),names.get(1),gui);
                        fixtures.add(tempGame);
                        fixtures.add(new GameImpl(brainFiles.get(0),names.get(0),brainFiles.get(1),names.get(1),gui,tempGame.getMap()));
                        break;
                    case 1:
                        tempGame = new GameImpl(brainFiles.get(0),names.get(0),brainFiles.get(2),names.get(2),gui);
                        fixtures.add(tempGame);
                        fixtures.add(new GameImpl(brainFiles.get(0),names.get(0),brainFiles.get(2),names.get(2),gui,tempGame.getMap()));
                        break;
                    case 2:
                        tempGame = new GameImpl(brainFiles.get(1),names.get(1),brainFiles.get(2),names.get(2),gui);
                        fixtures.add(tempGame);
                        fixtures.add(new GameImpl(brainFiles.get(1),names.get(1),brainFiles.get(2),names.get(2),gui,tempGame.getMap()));
                        break;
                }
            }
        }
        else{
            fixtures.add(new GameImpl(brainFiles.get(0),names.get(0),brainFiles.get(1),names.get(1),gui));
        }

        return fixtures;

    }


    @Override
    public void updateScores(Game game){
        Colour winner = game.getWinner();
        if(winner == null){
            resultsTable.put(game.getRedPlayerName(),resultsTable.get(game.getRedPlayerName()) + 1);
            resultsTable.put(game.getBlackPlayerName(),resultsTable.get(game.getBlackPlayerName())+1);
        }
        else if(winner == Colour.RED){
            resultsTable.put(game.getRedPlayerName(),resultsTable.get(game.getRedPlayerName())+2);
        }
        else{
            resultsTable.put(game.getBlackPlayerName(),resultsTable.get(game.getBlackPlayerName())+2);
        }
    }


    @Override
    public HashMap<String, Integer> getResults() {
        return resultsTable;
    }

}