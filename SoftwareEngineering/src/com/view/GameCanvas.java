package com.view;


        import com.model.Cell;
        import com.model.CellImpl;
        import com.model.Colour;
        import com.model.Map;
        import com.model.exceptions.AntNotFoundException;

        import java.awt.*;
        import java.awt.image.BufferStrategy;
        import java.util.Random;

        import javax.swing.Timer;

// OK this the class where we will draw and where computations
// will be done in another thread
public class GameCanvas extends Canvas implements Runnable {
    // back color LightYellow
    Color backColor = new Color(255, 255, 150);
    // my Swing timer
    Timer timer;
    private Cell[][] map = new CellImpl[150][150];
    private CellImg ci = new CellImg(3,map);
    // the deltaDegree we will apply to each balls times the gravity for the angle
    int deltaDegree;
    // the size of the ball in pixels
    final int BALLSIZE = 48, HALF_SIZE = BALLSIZE / 2, QUARTER_SIZE = HALF_SIZE / 2;
    // for the computation of the postion and the repaint
    Dimension size;
    int centerX, centerY;
    // a boolean to synchronize computation and drawing
    boolean computationDone = false;
    // a boolean to ask the treat to stop
    boolean threadStop = false;

    // this is a Canvas but I wont't let the system when to repaint it I will do it myself
    GameCanvas(Map map1) {
        super();
        map1.generateMap();
?        this.deltaDegree = deltaDegree;
        // so ignore System's paint request I will handle them
        setIgnoreRepaint(true);
        // determine initial position of the balls

        // build Chrono that will call me
        Chrono chrono = new Chrono(this);
        // ask the chrono to calll me every 60 times a second so every 16 ms (set say 15 for the time it takes to paint)
        timer = new Timer(15, chrono);
        timer.start();
    }

    // my own paint method that repaint off line and switch the displayed buffer
    // according to the VBL
    public synchronized void myRepaint() {
        // computation a lot longer than expected (more than 15ms)... ignore it
        if(!computationDone) {
            return;
        }

        // ok doing the repaint on the not showed page
        BufferStrategy strategy = getBufferStrategy();
        Graphics g = strategy.getDrawGraphics();
        // erase all what I had
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int j=0;j<150;j++) {
            for (int i=0;i<150;i++) {
                try {
                    if (map[i][j].getContents() == '+') {
                        ci.drawHex(i, j, g2, Color.RED);
                    } else if (map[i][j].getContents() == '-') {
                        ci.drawHex(i, j, g2, Color.BLACK);
                    } else if (map[i][j].getContents() == '#') {
                        ci.drawHex(i, j, g2, Color.gray);
                    } else if (map[i][j].getContents() == '.') {
                        ci.drawHex(i, j, g2, Color.WHITE);
                    } else if (map[i][j].getContents() == '9') {
                        ci.drawHex(i, j, g2, new Color(1, 138, 5));
                    } else if (map[i][j].getContents() == '8') {
                        ci.drawHex(i, j, g2, new Color(2, 171, 23));
                    } else if (map[i][j].getContents() == '7') {
                        ci.drawHex(i, j, g2, new Color(1, 208, 31));
                    } else if (map[i][j].getContents() == '6') {
                        ci.drawHex(i, j, g2, new Color(0, 238, 38));
                    } else if (map[i][j].getContents() == '5') {
                        ci.drawHex(i, j, g2, new Color(4, 255, 43));
                    } else if (map[i][j].getContents() == '4') {
                        ci.drawHex(i, j, g2, new Color(104, 255, 120));
                    } else if (map[i][j].getContents() == '3') {
                        ci.drawHex(i, j, g2, new Color(147, 255, 156));
                    } else if (map[i][j].getContents() == '2') {
                        ci.drawHex(i, j, g2, new Color(189, 255, 194));
                    } else if (map[i][j].getContents() == '1') {
                        ci.drawHex(i, j, g2, new Color(218, 255, 221));
                    } else if (map[i][j].getAnt() != null) {
                        if(map[i][j].getAnt().getColour() == Colour.RED){
                            ci.drawHex(i, j, g2, new Color(252, 227, 39));
                        }
                        if(map[i][j].getAnt().getColour() == Colour.BLACK){
                            ci.drawHex(i, j, g2, new Color(205, 97, 139));
                        }
                    }else{

                    }
                }catch (AntNotFoundException e){
                    e.printStackTrace();
                }

            }
        }
        if(g != null)
            g.dispose();
        // show next buffer
        strategy.show();
        // synchronized the blitter page shown
        Toolkit.getDefaultToolkit().sync();
        // ok I can be called again
        computationDone = false;
    }

    public void run() {
        // in double for sin/cos calculation
        double width, height;

        // loop forever
        for(;;) {
            // my father ask me to stop
            if(threadStop) {
                // stop the timer called every 15ms
                timer.stop();
                // and exit myself from the run method
                return;
            }
            // test if the computation where already done without a paint
            if(computationDone) {
                try {
                    Thread.sleep(1L);		// if it the case sleep a milli
                    continue;				// try again
                }
                catch(Exception e) {
                }
            }
            // else compute the new position
            size = this.getSize();
            centerX = size.width / 2 - HALF_SIZE;
            centerY = size.height / 2 - HALF_SIZE;
            width = size.width / 3.0;
            height = size.height / 3.0;
            // tell myRepaint() that new positions have been calculated
            computationDone = true;
        }
    }


//        // draw the ball at the last computed position
//        void myRepaint(Graphics g) {
//            // set graphics to color of ball
//            g.setColor(color);
//            // draw it
//            g.fillOval(x, y, BALLSIZE, BALLSIZE);
//        }
    }
