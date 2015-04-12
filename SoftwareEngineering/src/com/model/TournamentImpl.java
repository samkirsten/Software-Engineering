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


    /**
     * Create the fixtures which each brain has to play each other
     * @param brains
     * @return  A list of games objects which contain information of which players and playing each other
     */
    @Override
    public List<Game> createFixtures(HashMap<String,File> brains) {

        this.gui = gui;
        List<String> names = new ArrayList<>(brains.keySet());
        List<File> brainFiles = new ArrayList<>();

        for(String name : names) {
            File brainFile = brains.get(name);
            brainFiles.add(brainFile);
        }

        if (brains.size() == 4) {  // creating fixtures for if there is 4 players
            for (int i = 0; i < 6; i++) {
                Game tempGame = null;
                switch (i) {
                    case 0:
                        tempGame = new GameImpl(brainFiles.get(0),names.get(0),brainFiles.get(1),names.get(1),gui);  // create a new game object and add to the list
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
            for (int i = 0; i < 3; i++) {  // creating fixtures for if there is 3 players
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

        else if(brains.size() == 2){  // creating a fixture for a single game

            fixtures.add(new GameImpl(brainFiles.get(0),names.get(0),brainFiles.get(1),names.get(1),gui));
        }


        if(brains.size() == 2){  // setting up the results table with the names of the players for each case of number of players

            resultsTable.put(names.get(0),0);
            resultsTable.put(names.get(1),0);
        }
        else if(brains.size() == 3){

            resultsTable.put(names.get(0),0);
            resultsTable.put(names.get(1),0);
            resultsTable.put(names.get(2),0);

        }else if(brains.size() == 4){


            resultsTable.put(names.get(0),0);
            resultsTable.put(names.get(1),0);
            resultsTable.put(names.get(2),0);
            resultsTable.put(names.get(3),0);
        }

        return fixtures;

    }

    /**
     * Update the scores after each game has ended
     * @param game
     */
    @Override
    public void updateScores(Game game){

        Colour winner = game.getWinner();
        int oldRedValue = resultsTable.get(game.getRedPlayerName());
        int oldBlackValue = resultsTable.get(game.getBlackPlayerName());

        if(winner == null){

            resultsTable.put(game.getRedPlayerName(), oldRedValue + 1);
            resultsTable.put(game.getBlackPlayerName(), oldBlackValue + 1);

        } else if(winner == Colour.RED){

            resultsTable.put(game.getRedPlayerName(), oldRedValue + 2);
        }
        else{
            resultsTable.put(game.getRedPlayerName(), oldBlackValue + 2);
        }
    }

    /**
     * Get the results of the tournamanet
     * @return A hashmap with the player name as key and integer as the score of that player
     */
    @Override
    public HashMap<String, Integer> getResults() {
        return resultsTable;
    }

    /**
     * Setting the GUI for the tournament
     * @param gui
     */
    @Override
    public void setGUI(GameGUI gui) {
        this.gui = gui;
    }

}