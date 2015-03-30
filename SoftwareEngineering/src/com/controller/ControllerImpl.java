//package com.controller;
//import com.model.*;
//import com.view.GameGUI;
//
//import java.io.File;
//import java.util.HashMap;
//import java.util.List;
//
///**
//* Created by Jacob on 28/03/2015.
//*/
//public class ControllerImpl implements GameController {
//
//    @Override
//    public List<List<File>> createFixtures(List<File> brains, Tournament t) {
//        return t.createFixtures(brains);
//    }
//
//    @Override
//    public Game createGame(File brain1, File brain2){
//        Game game = new GameImpl(brain1,brain2);
//        return game;
//    }
//
//
//    @Override
//    public void nextRound(Game game) {
//        game.nextRound();
//    }
//
//    @Override
//    public Game changeSides(Game game){
//        File brain1 = game.getBrain(Colour.BLACK);
//        File brain2 = game.getBrain(Colour.RED);
//        Map map = game.getMap();
//
//        return new GameImpl(brain1,brain2,map);
//    }
//
//    @Override
//    public void updateScores(Game game, Tournament t) {
//        t.updateScores(game);
//    }
//}
//
