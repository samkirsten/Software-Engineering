package com.model;

/**
 * Created by junho on 15. 4. 1..
 */
public class RunnableGame implements Runnable {

    Game game;

    public RunnableGame(Game game){
        this.game = game;
    }
    @Override
    public void run() {
        for (int i = 0; i < Game.NUMBER_OF_ROUNDS; i++) {
            //game.nextRound();
            if(i % 1000 == 0) {
                game.getMap().generateMap();
                game.getGUI().updateGUI(game);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

        game.getGUI().signalGameEnd(game);
    }
}