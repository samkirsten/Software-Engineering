//package com.model;
//
//
//import java.util.Timer;
//import java.util.TimerTask;
//
///**
// * Created by junho on 15. 4. 1..
// */
//public class RunnableGame implements Runnable {
//
//    Game game;
//    Timer timer = new Timer();
//    TimerTask tt = new TimerTask() {
//        @Override
//        public void run() {
//            game.getGUI().updateGUI(game);
//        }
//    };
//
//
//    public RunnableGame(Game game) {
//        this.game = game;
//    }
//
//    @Override
//    public void run() {
//        long startTime = System.currentTimeMillis();
//        timer.scheduleAtFixedRate(tt,0,400);
//        for (int i = 0; i < Game.NUMBER_OF_ROUNDS; i++) {
//            game.nextRound();
//           // game.getGUI().updateGUI(game);
//
//        }     //
//        timer.cancel();
//        long endTime = System.currentTimeMillis();
//        long totalTime = endTime - startTime;
//        System.out.println(totalTime);
//        System.out.println(game.getWinner());
//            game.getGUI().updateGUI(game);
//
//        game.getGUI().signalGameEnd(game);
//    }
//}

package com.model;

import com.model.exceptions.AntNotFoundException;

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
        for (int i = 0; i < 1000; i++) {
            game.nextRound();
<<<<<<< HEAD
            if (i % 1000 == 0) {
=======
//            System.out.println(i);
            if (i % 500 == 0) {
>>>>>>> origin/master
                game.getGUI().updateGUI(game);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

<<<<<<< HEAD
=======
            System.out.println(i);
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            game.getGUI().updateGUI(game);
//
>>>>>>> origin/master

            }
        }     //
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
        game.getGUI().updateGUI(game);

<<<<<<< HEAD

        System.out.println(game.getWinner());

        try {
            game.getGUI().signalGameEnd(game);
        } catch (AntNotFoundException e) {
            e.printStackTrace();
        }
=======
       // System.out.println(game.getWinner());


         //   game.getGUI().updateGUI(game);

        System.out.println("winner "+ game.getWinner());

        game.getGUI().signalGameEnd(game);
>>>>>>> origin/master
    }
}