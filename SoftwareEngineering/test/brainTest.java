/**
 * Created by hao-linliang on 17/03/15.
 */

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class BrainTest {


    // need to create files to input

    //think maybe each cell should contain a pos?
    // clear ant from pos if its moved?



    // test through each group of correct tokens
    @Test
    public void testInstructionToken(){

        Brain b = new Brain();
        b.loadBrain(file);
        assertTrue(true);
    }

    @Test
    public void testDirectionToken(){

        Brain b2 = new Brain();
        b2.loadBrain(file2);
        assertTrue(true);

    }

    @Test
    public void testConditionsToken(){

        Brain b3 = new Brain();
        b3.loadBrain(file3);
        assertTrue(true);

    }

    @Test
    public void testArgumentTokens(){

        Brain b4 = new Brain();
        b4.loadBrain(file4);
        assertTrue(true);
    }

    // Test a mix of all correct tokens
    @Test
    public void testMixOfTokens(){

        Brain b5 = new Brain();
        b5.loadbrain(file5);
        assertTrue(true);


    }

    // test incorrect tokens mixed with correct tokens
    @Test
    public void testFailTokens(){

        Brain b6 = new Brain();
        b6.loadBrain(file6);
        assertFalse(false);

      //  Brain b7 = new Brain();
        b6.loadBrain(file7);
        assertFalse(false);

     //   Brain b8 = new Brain();
        b6.loadBrain(file8);
        assertFalse(false);

      //  Brain b9 = new Brain();
        b6.loadBrain(file9);
        assertFalse(false);
    }

    @Test
    public void testCorrectWrongTokens(){

        Brain b7 = new Brain();
        b10.loadBrain(file10);
        assertFalse(false);

       // Brain b11 = new Brain();
        b7.loadBrain(file11);
        assertFalse(false);

       // Brain b12 = new Brain();
        b7.loadBrain(file12);
        assertFalse(false);
    }


    @Test

    pubic void testStepResting(){

        Ant a = new Ant();
        Brain b8 = new Brain();
        a.setResting();
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
        assertEquals(8,a.getRegetRemainingReststing());

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

        Brain b9 = new Brain();
        //Cell c = new Cell();
        Ant a1 = new Ant();
        Ant a2 = new Ant();
        Map map = new Map();
        Position pos = new Position();
        Position pos1  = new Position();

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

        Brain b10 = new Brain();
        Position p = new Position();
        Map m = new Map();
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

        Brain b11 = new Brain();
        Position p1 = new Position();
        Map m1 = new Map();
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

        Brain b12 = new Brain();
        Position p2 = new Position();
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

        Brain b13 = new Brain();
        Position p3 = new Position();
        Map m3 = new Map();

        p3.setX(1);
        p3.setY(1);
        m3.setCellContents(p3, (char)9);

        b13.loadBrain(file18);
        Ant a7 = new Ant();
        a7.setID(1);

        m3.setAntAtCell(p3,1);

        b13.step(1); // should set state to 1 if there is food at cell
        assertEquals((char)8, m3.getCellContents(p3));
        assertEquals(1, a7.getState());

        /////////
        /////////
        ////////

        Brain b14 = new Brain();
        Position p4 = new Position();
        Ant a8 = new Ant();
        Map m4 = new Map();

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

        Brain b15 = new Brain();
        Position p5 = new Position();
        Ant a9 = new Ant();
        Map m5 = new Map();

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
    pubic void testDrop() throws CellAlreadyOccupiedException, InvalidContentCharacterException {

        Brain b16 = new Brain();
        Position p6 = new Position();
        Ant a10 = new Ant();
        Map m6 = new Map();
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

        Brain b17 = new Brain();
        Position p7 = new Position();
        Ant a11 = new Ant();
        Map m7 = new Map();

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

        Brain b18 = new Brain();
        Position p8 = new Position();
        Ant a12 = new Ant();
        Map m8 = new Map();

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

        Brain b19 = new Brain();
        Ant a17 = new Ant();

        Map m9 = new Map();
        Position p9 = new Position();

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

        Brain b20 = new Brain();
        Ant a18 = new Ant();

        Map m10 = new Map();
        Position p10 = new Position();

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

        Brain b21 = new Brain();
        Ant a19 = new Ant();

        Map m11 = new Map();
        Position p11 = new Position(); // original
        Position  p12 = new Position();// goes right
        Position p13 = new Position(); // left
        Position p14 = new Position(); // top right
        Position p15 = new Position(); // top left
        Position p16 = new Position(); // bottom right
        Position p17 = new Position(); // bottom left



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

        m11.setCellIsRocky(p12, true);
        b21.step(1);

        assertEquals(1, m11.getAntAtCell(p11));
        assertEquals(10, a19.getState()); // make sure in correct state


        // occupied cell

        Ant a20 = new Ant();
        a20.setID(2);

        m11.setCellIsRocky(p12, false);
        m11.setAntAtCell(p11 , 1);
        m11.setAntAtCell(p12, 2);
        a19.setDirection(0);

        b21.step(1);

        assertEquals(1, m11.getAntAtCell(p11));
        assertEquals(11, a19.getState()); // make sure in correct state



    }

    // flip hard cause its random?



}
