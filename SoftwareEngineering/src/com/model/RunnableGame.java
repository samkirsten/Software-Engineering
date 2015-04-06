package com.model;

/**
 * Created by junho on 15. 4. 1..
 */
public class RunnableGame implements Runnable {

    Game game;


    public RunnableGame(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < Game.NUMBER_OF_ROUNDS; i++) {
            game.nextRound();
           // game.getGUI().updateGUI(game);

            if (i % 1000 == 0) {
                System.out.println("updating");
                try {
                    game.getGUI().updateGUI(game);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }     //
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
        System.out.println(game.getWinner());

        game.getGUI().signalGameEnd(game);
    }
}