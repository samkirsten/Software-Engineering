/**
* Created by hao-linliang on 17/03/15.
*/

import org.junit.Test;

import java.io.File;
import java.nio.file.Path;

import static org.junit.Assert.*;


public class BrainTest {




    // need to create files to input

    //think maybe each cell should contain a pos?
    // clear ant from pos if its moved?



    // test through each group of correct tokens
    @Test
    public void testInstructionToken(){

        BrainImpl b = new BrainImpl();

        assertTrue(b.loadBrain(new File("../brains/file.txt")));
    }

    @Test
    public void testDirectionToken(){

        BrainImpl b2 = new BrainImpl();

        assertTrue(b2.loadBrain(file2));

    }

    @Test
    public void testConditionsToken(){

        BrainImpl b3 = new BrainImpl();

        assertTrue(b3.loadBrain(file3));

    }

    @Test
    public void testArgumentTokens(){

        BrainImpl b4 = new BrainImpl();

        assertTrue(b4.loadBrain(file4));
    }

    // Test a mix of all correct tokens
    @Test
    public void testMixOfTokens(){

        BrainImpl b5 = new BrainImpl();

        assertTrue(b5.loadbrain(file5));


    }

    // test incorrect tokens mixed with correct tokens
    @Test
    public void testFailTokens(){

        BrainImpl b6 = new BrainImpl();

        assertFalse(b6.loadBrain(file6));

      //  Brain b7 = new Brain();

        assertFalse(b6.loadBrain(file7));

     //   Brain b8 = new Brain();

        assertFalse(b6.loadBrain(file8));

      //  Brain b9 = new Brain();

        assertFalse( b6.loadBrain(file9));
    }

    @Test
    public void testCorrectWrongTokens(){

        BrainImpl b7 = new BrainImpl();

        assertFalse(b10.loadBrain(file10));

       // Brain b11 = new Brain();

        assertFalse(b7.loadBrain(file11));

       // Brain b12 = new Brain();

        assertFalse(b7.loadBrain(file12));
    }


    @Test

    public void testStepResting(){

        AntImpl a = new AntImpl();
        BrainImpl b8 = new BrainImpl();
        a.startResting();
        a.setID(1);

        assertTrue(a.isResting());

        b8.step(a.getID()); // should ant store its ID too
        assertEquals(13, a.getRemainingRest());

        b8.step(a.getID());
        assertEquals(12,a.getRemainingRest());

        b8.step(a.getID());
        assertEquals(11,a.getRemainingRest());

        b8.step(a.getID());
        assertEquals(10,a.getRemainingRest());

        b8.step(a.getID());
        assertEquals(9,a.getRemainingRest());

        b8.step(a.getID());
        assertEquals(8,a.getRemainingRest());

        b8.step(a.getID());
        assertEquals(7,a.getRemainingRest());

        b8.step(a.getID());
        assertEquals(6,a.getRemainingRest());

        b8.step(a.getID());
        assertEquals(5,a.getRemainingRest());

        b8.step(a.getID());
        assertEquals(4,a.getRemainingRest());

        b8.step(a.getID());
        assertEquals(3,a.getRemainingRest());

        b8.step(a.getID());
        assertEquals(2,a.getRemainingRest());

        b8.step(a.getID());
        assertEquals(1,a.getRemainingRest());

        b8.step(a.getID());
        assertEquals(0,a.getRemainingRest());

        assertFalse(a.isResting());


    }

    @Test
    public void testSenseTrue() throws CellAlreadyOccupiedException {

        BrainImpl b9 = new BrainImpl();
        //Cell c = new Cell();
        AntImpl a1 = new AntImpl();
        AntImpl a2 = new AntImpl();
        MapImpl map = new MapImpl();
        PositionImpl pos = new PositionImpl();
        PositionImpl pos1  = new PositionImpl();

        pos.setX(1);
        pos.setY(1);

        pos1.setX(1);
        pos1.setY(2);

        a1.setID(1);
        a2.setID(2);

        map.setAntAtCell(pos , 1);
        map.setAntAtCell(pos1, 2);

        b9.loadBrain(file14);

        int state = 3;
        int state2 = 4;
        b9.step(a1.getID());
        // checks if its taken the correct state
        assertEquals(state, a1.getState());

        // should set cell details
        b9.step(2);
        assertEquals(4,a2.getState());


    }

    @Test
    public void testMark() throws CellAlreadyOccupiedException {

        BrainImpl b10 = new BrainImpl();
        PositionImpl p = new PositionImpl();
        MapImpl m = new MapImpl();
        p.setX(1);
        p.setY(1);

        // set state of ant before hand?
        b10.loadBrain(file15);

        Ant a3 = new Ant();
        a3.setID(2);
       // Cell c = new Cell();

        m.setAntAtCell(p ,2);

       // a3.markScent(p, 1, red); // need to set marker in file
        b10.step(a3.getID());
        assertEquals(1, m.getCellScentMarker(red, p));


    }

    @Test
    public void testUnMark() throws CellAlreadyOccupiedException {

        BrainImpl b11 = new BrainImpl();
        PositionImpl p1 = new PositionImpl();
        MapImpl m1 = new MapImpl();
        p1.setX(1);
        p1.setY(1);

        b11.loadBrain(file16);
        Ant a4 = new Ant();
        a4.setID(2);

        m1.setAntAtCell(p1, 2);

        a4.markScent(p,1, red);
        b11.step(a4.getID()); // need to set file so it unmarks
        assertEquals(1, m1.getCellScentMarker(red, p1));




    }

    @Test
    public void testCantUnMarkOtherColour() throws CellAlreadyOccupiedException {

        BrainImpl b12 = new BrainImpl();
        PositionImpl p2 = new PositionImpl();
        Map m2 = new Map();
        p2.setX(1);
        p2.setY(1);

        b12.loadBrain(file17);

        Ant a6 = new Ant();
        Ant a5 = new Ant();
        a5.setColour(red);
        a6.setColour(black);
        a5.markScent(p,1, red);

        a5.setID(2);
        a6.setID(3);

        m2.setAntAtCell(p2, 3);

        b12.step(a6.getID()); // attempt to unmark a6 marker should not do it
        assertEquals(1,m1.getCellScentMarker(red,p2));



    }

    @Test

    public void testPickUpFood() throws InvalidContentCharacterException, CellAlreadyOccupiedException {

        BrainImpl b13 = new BrainImpl();
        PositionImpl p3 = new PositionImpl();
        MapImpl m3 = new MapImpl();

        p3.setX(1);
        p3.setY(1);
        m3.setCellContents(p3, (char)9);

        b13.loadBrain(file18);

        AntImpl a7 = new AntImpl();

        a7.setID(1);

        m3.setAntAtCell(p3,1);

        b13.step(1); // should set state to 1 if there is food at cell
        assertEquals((char)8, m3.getCellContents(p3));
        assertEquals(1, a7.getState());

        /////////
        /////////
        ////////

        BrainImpl b14 = new BrainImpl();
        PositionImpl p4 = new PositionImpl();
        AntImpl a8 = new AntImpl();
        MapImpl m4 = new MapImpl();

        b14.loadBrain(file19);
        p4.setX(1);
        p4.setY(1);
        a8.setID(4);
        m4.setCellContents(p4, (char) 0);

        m4.setAntAtCell(p4,2);

        b14.step(4);


        assertEquals((char)0, m4.getCellContents(p4));
        assertEquals(2, a8.getState()); // checks that it has gone to state 2 as there is no food

        ////////
        ////////
        ////////

        BrainImpl b15 = new BrainImpl();
        PositionImpl p5 = new PositionImpl();
        AntImpl a9 = new AntImpl();
        MapImpl m5 = new MapImpl();

        b15.loadBrain(file20);
        p5.setX(1);
        p5.setY(1);
        a9.setID(2);
        m5.setCellContents(p4, (char) 0);
        m5.setAntAtCell(p5,2);

        b15.step(2);

        assertEquals((char)0, m5.getCellContents(p4));
        assertEquals(2, a9.getState()); // checks that it has gone to state 2 as the ant is carrying food

    }

    @Test
    public void testDrop() throws CellAlreadyOccupiedException, InvalidContentCharacterException {

        BrainImpl b16 = new BrainImpl();
        PositionImpl p6 = new PositionImpl();
        AntImpl a10 = new AntImpl();
        MapImpl m6 = new MapImpl();
        p6.setX(1);
        p6.setY(1);

        b16.loadBrain(file21);
        a10.setID(1);
        a10.setHasFood(true); // should implement?

        m6.setAntAtCell(p6,1);

        m6.setCellContents(p6, -1);
        b16.step(1);

        assertEquals((char) 1, m6.getCellContents(p6));
        assertEquals(1, a10.getState()); // should be changed to state 1

        ///////
        ///////
        ///////

        BrainImpl b17 = new BrainImpl();
        PositionImpl p7 = new PositionImpl();
        AntImpl a11 = new AntImpl();
        MapImpl m7 = new MapImpl();

        p7.setX(1);
        p7.setY(1);

        b17.loadBrain(file22);
        a11.setID(3);
        a11.setHasFood(true);

        m7.setCellContents(p7, (char) 1);
        m7.setAntAtCell(p7, 1);

        b17.step(3);

        assertEquals((char) 2, m7.getCellContents());
        assertEquals(1, a11.getState());

        //////
        //////
        //////
        //////

        // if no food then just change state

        BrainImpl b18 = new BrainImpl();
        PositionImpl p8 = new PositionImpl();
        AntImpl a12 = new AntImpl();
        MapImpl m8 = new MapImpl();

        p8.setX(1);
        p8.setY(1);


        b18.loadBrain(file23);
        a12.setID(5);
        a12.setHasFood(false);

        m8.setCellContents(p8, (char)-1);
        m8.setAntAtCell(p8,5);

        b18.step(5);

        assertEquals(1, a12.getState());

    }

    @Test

    public void testTurnLeft() throws CellAlreadyOccupiedException {

        BrainImpl b19 = new BrainImpl();
        AntImpl a17 = new AntImpl();

        MapImpl m9 = new MapImpl();
        PositionImpl p9 = new PositionImpl();

        p9.setX(1);
        p9.setY(1);


        b19.loadBrain(file22);
        a17.setID(1);
        m9.setAntAtCell(p9,1);
        a17.setDirection(0);

        b19.step(1);

        assertEquals(5,a17.getDirection());
        assertEquals(1, a17.getState()); // checks in correct state


        b19.step(1);

        assertEquals(4,a17.getDirection());
        assertEquals(1, a17.getState()); // checks in correct state

        b19.step(1);

        assertEquals(3,a17.getDirection());
        assertEquals(1, a17.getState()); // checks in correct state

        b19.step(1);

        assertEquals(2,a17.getDirection());
        assertEquals(1, a17.getState()); // checks in correct state

        b19.step(1);

        assertEquals(1,a17.getDirection());
        assertEquals(1, a17.getState()); // checks in correct state


        b19.step(1);

        assertEquals(0,a17.getDirection());
        assertEquals(1, a17.getState()); // checks in correct state


    }

    @Test

    public void testTurnRight() throws CellAlreadyOccupiedException {

        BrainImpl b20 = new BrainImpl();
        AntImpl a18 = new AntImpl();

        MapImpl m10 = new MapImpl();
        PositionImpl p10 = new PositionImpl();

        p10.setX(1);
        p10.setY(1);


        b20.loadBrain(file23);
        a18.setID(1);
        m10.setAntAtCell(p10,1);
        a18.setDirection(0);

        b20.step(1);

        assertEquals(1,a18.getDirection());
        assertEquals(1, a18.getState()); // checks in correct state


        b20.step(1);

        assertEquals(2,a18.getDirection());
        assertEquals(1, a18.getState()); // checks in correct state

        b20.step(1);

        assertEquals(3,a18.getDirection());
        assertEquals(1, a18.getState()); // checks in correct state

        b20.step(1);

        assertEquals(4,a18.getDirection());
        assertEquals(1, a18.getState()); // checks in correct state

        b20.step(1);

        assertEquals(5,a18.getDirection());
        assertEquals(1, a18.getState()); // checks in correct state


        b20.step(1);

        assertEquals(0,a18.getDirection());
        assertEquals(1, a18.getState()); // checks in correct state

    }

    @Test

    public void testMove() throws CellAlreadyOccupiedException {

        BrainImpl b21 = new BrainImpl();
        AntImpl a19 = new AntImpl();

        MapImpl m11 = new MapImpl();
        PositionImpl p11 = new PositionImpl(); // original
        PositionImpl  p12 = new PositionImpl();// goes right
        PositionImpl p13 = new PositionImpl(); // left
        PositionImpl p14 = new PositionImpl(); // top right
        PositionImpl p15 = new PositionImpl(); // top left
        PositionImpl p16 = new PositionImpl(); // bottom right
        PositionImpl p17 = new PositionImpl(); // bottom left



        p11.setX(1);
        p11.setY(1);

        p12.setX(2);
        p12.setY(1);

        p13.setX(0);
        p13.setY(1);

        p14.setX(2);
        p14.setY(0);

        p15.setX(1);
        p15.setY(0);

        p16.setX(2);
        p16.setY(2);

        p17.setX(1);
        p17.setY(2);

        a19.setID(1);
        b21.loadBrain(file24);

        m11.setAntAtCell(p11,1);
        a19.setDirection(0);

        b21.step(1);

        assertEquals(0, m11.getAntAtCell(p11));
        assertEquals(1,m11.getAntAtCell(p12));

        // need to clear from prev cell?

        m11.setAntAtCell(p11 , 1);
        a19.setDirection(3);

        b21.step(1);

        assertEquals(0, m11.getAntAtCell(p11));
        assertEquals(1,m11.getAntAtCell(p13));

        m11.setAntAtCell(p11 , 0);
        a19.setDirection(5);

        b21.step(1);

        assertEquals(0, m11.getAntAtCell(p11));
        assertEquals(1,m11.getAntAtCell(p14));

        m11.setAntAtCell(p11 , 0);
        a19.setDirection(4);

        b21.step(1);

        assertEquals(0, m11.getAntAtCell(p11));
        assertEquals(1,m11.getAntAtCell(p15));

        m11.setAntAtCell(p11 , 0);
        a19.setDirection(1);

        b21.step(1);

        assertEquals(0, m11.getAntAtCell(p11));
        assertEquals(1,m11.getAntAtCell(p16));

        m11.setAntAtCell(p11 , 0);
        a19.setDirection(2);

        b21.step(1);

        assertEquals(0, m11.getAntAtCell(p11));
        assertEquals(1,m11.getAntAtCell(p17));

        //////
        //////

        /// checking if rocky or occupied if it is do nothing change state

        m11.setAntAtCell(p11 , 0);
        a19.setDirection(0);

        m11.setCellContents(p12, '#' );
        b21.step(1);

        assertEquals(1, m11.getAntAtCell(p11));
        assertEquals(10, a19.getState()); // make sure in correct state


        // occupied cell

        AntImpl a20 = new AntImpl();
        a20.setID(2);

        m11.setCellContents(p12, '#');
        m11.setAntAtCell(p11 , 1);
        m11.setAntAtCell(p12, 2);
        a19.setDirection(0);

        b21.step(1);

        assertEquals(1, m11.getAntAtCell(p11));
        assertEquals(11, a19.getState()); // make sure in correct state




    }

    // flip hard cause its random?



}
