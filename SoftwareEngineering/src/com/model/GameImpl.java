
package com.model;
import com.model.exceptions.CellAlreadyOccupiedException;
import com.view.GameGUI;

import java.io.File;
import java.util.List;

public class GameImpl implements Game {

    Colony red;
    Colony black;
    Map map = new MapImpl();
    int redFood = 0;
    int blackFood = 0;
    int currentRound = 0;
    String redPlayerName;
    String blackPlayerName;
    GameGUI gui;

    public GameImpl(File brain1, String name1, File brain2, String name2, GameGUI gui){
        loadBrain(brain1,Colour.RED);
        loadBrain(brain2, Colour.BLACK);
        red = new ColonyImpl(Colour.RED);
        black = new ColonyImpl(Colour.BLACK);
        redPlayerName = name1;
        blackPlayerName = name2;
        map.generateMap();
        setup();
    }

    public GameImpl(File brain1, String name1, File brain2, String name2, GameGUI gui, Map map){
        loadBrain(brain1,Colour.RED);
        loadBrain(brain2,Colour.BLACK);
        red = new ColonyImpl(Colour.RED);
        black = new ColonyImpl(Colour.BLACK);
        redPlayerName = name1;
        blackPlayerName = name2;
        this.map = map;
        map.clearMap();
        setup();
    }

    public String getBlackPlayerName() {
        return blackPlayerName;
    }

    public String getRedPlayerName() {
        return redPlayerName;
    }

    @Override
    public void start(){
        for(int i=0;i<Game.NUMBER_OF_ROUNDS;i++){
            nextRound();
            if(i % 100 == 0)
                gui.updateGUI(this);
        }
    }



    @Override
    public boolean loadBrain(File brain, Colour colour) {
        red = new ColonyImpl(colour);
        black = new ColonyImpl(colour);


        Brain brainClass = new BrainImpl(map,getColony(colour));
        boolean passed = true;

        if(colour == Colour.RED){
            passed = brainClass.loadBrain(brain);
            if(passed){
                red.setBrain(brainClass);
            }
        }
        else{
            passed = brainClass.loadBrain(brain);
            if(passed){
                black.setBrain(brainClass);
            }
        }

        return passed;
    }

    @Override
    public Colony getColony(Colour colour) {
        if(colour==Colour.RED){
            return red;
        }
        else{
            return black;
        }
    }

    @Override
    public File getBrain(Colour colour) {
        if(colour==Colour.RED){
            return red.getBrain().getLoadedFile();
        }
        else{
            return black.getBrain().getLoadedFile();
        }
    }

    @Override
    public int getCurrentRound(){
        return currentRound;
    }

    @Override
    public Map getMap() {
        return map;
    }

    private void generateAnts(){


        List<Position> redHill = map.getAntHill(Colour.RED);
        List<Position> blackHill = map.getAntHill(Colour.BLACK);

        red.reset();
        black.reset();

        int id = 0;


        for(Position p : redHill){


           red.addAnt(new AntImpl(id,Colour.RED,p));

            Ant ant = new AntImpl(id,Colour.RED,p);
            red.addAnt(ant);
            try {
                map.setAntAtCell(p,ant);
            } catch (CellAlreadyOccupiedException e) {
                e.printStackTrace();
            }

            id++;
        }

        for(Position p : blackHill){
            Ant ant = new AntImpl(id,Colour.BLACK,p);
            black.addAnt(ant);
            try {
                map.setAntAtCell(p,ant);
            } catch (CellAlreadyOccupiedException e) {
                e.printStackTrace();
            }
            id++;
        }
    }

    private void setup(){
        currentRound = 0;
        map.clearMap();

        generateAnts();

    }

//
//    @Override
//    public Colour start() {
//
//        currentRound = 0;
//        map.clearMap();
//
//        generateAnts();
//
//        for(int i = 0; i<Game.NUMBER_OF_ROUNDS;i++){
//            next();
//            currentRound++;
//        }
//
//        redFood = red.getFoodInColony();
//        blackFood = black.getFoodInColony();
//
//        return getWinner();
//
//
//    }

    @Override
    public void nextRound() {
        for(int i=0;i<red.getNumberOfAnts();i++){
            red.getBrain().step(i);
        }
        for (int i=0;i<black.getNumberOfAnts();i++){
            black.getBrain().step(i);
        }
        currentRound++;
    }


    /**
     * R = Red win
     * B = Black win
     * D = Draw
     *
     * @return R, B or D, depending on the outcome of the game.
     */
    @Override
    public Colour getWinner() {
        if(red.getFoodInColony()>black.getFoodInColony()){
            return Colour.RED;
        }
        else if(black.getFoodInColony()>red.getFoodInColony()){
            return Colour.BLACK;
        }
        else
            return null;
    }


}
