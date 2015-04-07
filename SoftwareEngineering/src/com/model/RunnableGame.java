package com.model;

import java.util.Timer;
import java.util.TimerTask;

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
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            game.getGUI().updateGUI(game);
//

        }     //
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

       // System.out.println(game.getWinner());


         //   game.getGUI().updateGUI(game);




        System.out.println("winner "+ game.getWinner());

        game.getGUI().signalGameEnd(game);
    }
}