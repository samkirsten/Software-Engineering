package com.model;

import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class TournamentImpl implements Tournament {

    private HashMap<File,Integer> resultsTable = new HashMap<File, Integer>();
    private List<Game> gamesPlayed = new ArrayList<>();

    @Override
    public List<List<File>> createFixtures(List<File> brains) {
        List<List<File>> fixtures = new ArrayList<List<File>>();
        if (brains.size() == 4) {
            for (int i = 0; i < 6; i++) {
                switch (i) {
                    case 0:
                        List<File> f1 = new ArrayList<File>();
                        f1.add(brains.get(0));
                        f1.add(brains.get(1));
                        fixtures.add(f1);
                        break;
                    case 1:
                        List<File> f2 = new ArrayList<File>();
                        f2.add(brains.get(0));
                        f2.add(brains.get(2));
                        fixtures.add(f2);
                        break;
                    case 2:
                        List<File> f3 = new ArrayList<File>();
                        f3.add(brains.get(0));
                        f3.add(brains.get(3));
                        fixtures.add(f3);
                        break;
                    case 3:
                        List<File> f4 = new ArrayList<File>();
                        f4.add(brains.get(1));
                        f4.add(brains.get(2));
                        fixtures.add(f4);
                        break;
                    case 4:
                        List<File> f5 = new ArrayList<File>();
                        f5.add(brains.get(1));
                        f5.add(brains.get(3));
                        fixtures.add(f5);
                        break;
                    default:
                        List<File> f6 = new ArrayList<File>();
                        f6.add(brains.get(2));
                        f6.add(brains.get(3));
                        fixtures.add(f6);
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                switch (i) {
                    case 0:
                        List<File> f1 = new ArrayList<File>();
                        f1.add(brains.get(0));
                        f1.add(brains.get(1));
                        fixtures.add(f1);
                        break;
                    case 1:
                        List<File> f2 = new ArrayList<File>();
                        f2.add(brains.get(0));
                        f2.add(brains.get(2));
                        fixtures.add(f2);
                        break;
                    default:
                        List<File> f3 = new ArrayList<File>();
                        f3.add(brains.get(1));
                        f3.add(brains.get(2));
                        fixtures.add(f3);
                }
            }
        }

        return fixtures;

    }

    @Override
    public void updateScores(Game game){
        Colour winner = game.getWinner();
        File red = game.getBrain(Colour.RED);
        File black = game.getBrain(Colour.BLACK);
        gamesPlayed.add(game);
        if(winner == null){
            resultsTable.put(red,resultsTable.get(red) + 1);
            resultsTable.put(black,resultsTable.get(black)+1);
        }
        else if(winner == Colour.RED){
            resultsTable.put(red,resultsTable.get(red)+2);
        }
        else{
            resultsTable.put(black,resultsTable.get(black)+2);
        }
    }


    @Override
    public HashMap<File, Integer> getResults() {
        return resultsTable;
    }

}