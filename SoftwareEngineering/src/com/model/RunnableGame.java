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
            System.out.println(i);
            if (i % 1000 == 0) {
                System.out.println("updating");
                game.getGUI().updateGUI(game);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println(i);
        }     //
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
            game.getGUI().updateGUI(game);


<<<<<<< Updated upstream
        }
=======
        System.out.println(game.getWinner());

>>>>>>> Stashed changes
        game.getGUI().signalGameEnd(game);
    }
}