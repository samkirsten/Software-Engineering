/**
 * Created by hao-linliang on 17/03/15.
 */

import com.model.*;
import com.model.exceptions.CellAlreadyOccupiedException;
import com.model.exceptions.InvalidContentCharacterException;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;


public class BrainTest {




    // need to create files to input

    //think maybe each cell should contain a pos?
    // clear ant from pos if its moved?



    // test through each group of correct tokens
    @Test
    public void testInstructionToken(){
        Colony c = new ColonyImpl(null);
        Map m = new MapImpl();

        Brain b = new BrainImpl(m,c);

        assertTrue(b.loadBrain(new File("brains/file.txt")));
    }

//    @Test
//    public void testDirectionToken(){
//
//        ColonyImpl c = new ColonyImpl(null);
//        MapImpl m = new MapImpl();
//
//        BrainImpl b2 = new BrainImpl(m,c);
//
//        assertTrue(b2.loadBrain(new File("brains/file1.txt")));
//
//    }
//
//    @Test
//    public void testConditionsToken(){
//
//        ColonyImpl c = new ColonyImpl(null);
//        MapImpl m = new MapImpl();
//
//        BrainImpl b3 = new BrainImpl(m,c);
//
//        assertTrue(b3.loadBrain(new File("brains/file2.txt")));
//
//    }
//
//    @Test
//    public void testArgumentTokens(){
//
//        ColonyImpl c = new ColonyImpl(null);
//        MapImpl m = new MapImpl();
//
//        BrainImpl b4 = new BrainImpl(m,c);
//
//        assertTrue(b4.loadBrain(new File("brains/file3.txt")));
//    }
//
//    // Test a mix of all correct tokens
//    @Test
//    public void testMixOfTokens(){
//
//        ColonyImpl c = new ColonyImpl(null);
//        MapImpl m = new MapImpl();
//
//        BrainImpl b5 = new BrainImpl(m,c);
//
//        assertTrue(b5.loadBrain(new File("brains/file4.txt")));
//
//
//    }
//
//    // test incorrect tokens mixed with correct tokens
//    @Test
//    public void testFailTokens(){
//
//        ColonyImpl c = new ColonyImpl(null);
//        MapImpl m = new MapImpl();
//
//        Brain b6 = new BrainImpl(m,c);
//        Brain b7 = new BrainImpl(m,c);
//        Brain b8 = new BrainImpl(m,c);
//        Brain b9 = new BrainImpl(m,c);
//        Brain b10 = new BrainImpl(m,c);
//        Brain b11= new BrainImpl(m,c);
//        Brain b12 = new BrainImpl(m,c);
//        Brain b13 = new BrainImpl(m,c);
//
//        assertFalse(b6.loadBrain(new File("brains/file5.txt")));
//
//        assertFalse(b7.loadBrain(new File("brains/file6.txt")));
//
//        assertFalse(b8.loadBrain(new File("brains/file7.txt")));
//
//        assertFalse(b9.loadBrain(new File("brains/file8.txt")));
//
//        assertFalse(b10.loadBrain(new File("brains/file10.txt")));
//
//        assertFalse(b11.loadBrain(new File("brains/file11.txt")));
//
//        assertFalse(b12.loadBrain(new File("brains/file12.txt")));
//
//        assertFalse(b13.loadBrain(new File("brains/file9.txt"))); // need to check why this fails
//    }
//
//    @Test
//    public void testCorrectWrongTokens(){
//
//        ColonyImpl c = new ColonyImpl(null);
//        MapImpl m = new MapImpl();
//
//        BrainImpl b7 = new BrainImpl(m,c);
//
//        assertFalse(b7.loadBrain(new File("brains/file13.txt")));
//
//        assertFalse(b7.loadBrain(new File("brains/file14.txt")));
//
//        assertFalse(b7.loadBrain(new File("brains/file15.txt")));
//    }
//
//
//    @Test
//    public void testStepResting(){
//
//
//        Colony c = new ColonyImpl(Colour.BLACK);
//        BrainImpl b8 = new BrainImpl(null,c);
//        AntImpl a = new AntImpl(1,Colour.BLACK,null);
//
//
//        c.addAnt(a);
//
//        a.startResting();
//
//        assertTrue(a.isResting());
//
//        assertEquals(14,a.getRemainingRest());
//
//        b8.step(a.getID()); // should ant store its ID too
//
//        assertEquals(13, a.getRemainingRest());
//
//        b8.step(a.getID());
//
//        assertEquals(12, a.getRemainingRest());
//
//        b8.step(a.getID());
//        assertEquals(11,a.getRemainingRest());
//
//        b8.step(a.getID());
//        assertEquals(10,a.getRemainingRest());
//
//        b8.step(a.getID());
//        assertEquals(9,a.getRemainingRest());
//
//        b8.step(a.getID());
//        assertEquals(8,a.getRemainingRest());
//
//        b8.step(a.getID());
//        assertEquals(7,a.getRemainingRest());
//
//        b8.step(a.getID());
//        assertEquals(6,a.getRemainingRest());
//
//        b8.step(a.getID());
//        assertEquals(5,a.getRemainingRest());
//
//        b8.step(a.getID());
//        assertEquals(4,a.getRemainingRest());
//
//        b8.step(a.getID());
//        assertEquals(3,a.getRemainingRest());
//
//        b8.step(a.getID());
//        assertEquals(2,a.getRemainingRest());
//
//        b8.step(a.getID());
//        assertEquals(1,a.getRemainingRest());
//
//        b8.step(a.getID());
//        assertEquals(15,a.getRemainingRest());
//
//        assertFalse(a.isResting());
//
//
//    }
//
//    @Test
//    public void testSenseTrue() throws CellAlreadyOccupiedException { /// breaks
//
//        MapImpl map = new MapImpl();
//        Colony c = new ColonyImpl(Colour.RED);
//        BrainImpl b9 = new BrainImpl(map, c);
//
//        map.generateMap();
//        Position pos = new Position(1,1);
//        Position pos1  = new Position(2,1);
//
//
//        AntImpl a1 = new AntImpl(1,Colour.RED,pos);
//        AntImpl a2 = new AntImpl(2,Colour.RED,pos1);
//
//        c.addAnt(a1);
//        c.addAnt(a2);
//
//
//        a1.setPosition(pos);
//
//        map.setAntAtCell(pos , a1);
//        map.setAntAtCell(pos1, a2);
//
//        b9.loadBrain(new File("brains/file16.txt"));
//
//        int state = 1;
//        int state2 = 2;
//        b9.step(a1.getID());
//
//        // checks if its taken the correct state
//        assertEquals(state, a1.getState());
//
//        b9.step(a1.getID());
//
//        assertEquals(0,a1.getState());
//
//        // should set cell details
////        b9.step(2);
////        assertEquals(4,a2.getState());
//
//
//    }
//
//    @Test
//    public void testMark() throws CellAlreadyOccupiedException {
//
//        MapImpl m = new MapImpl();
//
//        Colony c= new ColonyImpl(Colour.RED);
//
//        BrainImpl b10 = new BrainImpl(m,c);
//
//        m.generateMap();
//        Position p = new Position(1,1);
//
//        AntImpl a3 = new AntImpl(2,Colour.RED,p);
//
//        c.addAnt(a3);
//
//
//        m.setAntAtCell(p ,a3);
//        // set state of ant before hand?
//        b10.loadBrain(new File("brains/file17.txt"));
//
//
//
//        // com.model.Cell c = new com.model.Cell();
//
//
//
//       // m.setCellScentMarker(p,1);
//        b10.step(a3.getID());
//        System.out.println(m.getCellScentMarker((Colour.RED) , p));
//        assertEquals(1, m.getCellScentMarker(Colour.RED, p));
//
//
//
//    }
//
//    @Test
//    public void testUnMark() throws CellAlreadyOccupiedException {
//
//        MapImpl m1 = new MapImpl();
//        Colony c = new ColonyImpl(Colour.BLACK);
//        BrainImpl b11 = new BrainImpl(m1,c);
//        Position p1 = new Position(1,1);
//        AntImpl a4 = new AntImpl(2,Colour.BLACK,p1);
//
//
//
//
//        m1.generateMap();
//
//        c.addAnt(a4);
//
//            // id colour pos
//        m1.setAntAtCell(p1, a4);
//
//
//        b11.loadBrain(new File("brains/file18.txt"));
//
//        m1.setCellScentMarker(p1,7);
//
//        b11.step(a4.getID()); // need to set file so it unmarks
//
//        assertEquals(1, a4.getState());
//
//
//        assertEquals(0, m1.getCellScentMarker(Colour.BLACK, p1));  /// setScent should be int not char change this, jun needs to fix the get for default 0
//
//
//
//
//    }
//
//    @Test
//    public void testCantUnMarkOtherColour() throws CellAlreadyOccupiedException {
//
//
//        Map m2 = new MapImpl();
//        Colony c = new ColonyImpl(Colour.BLACK);
//
//        BrainImpl b12 = new BrainImpl(m2,c);
//        m2.generateMap();
//        Position p2 = new Position(1,1);
//
//
//        AntImpl a6 = new AntImpl(3,Colour.BLACK,p2);
//
//
//
//        a6.setColour(Colour.BLACK);
//
//        a6.setID(3);
//
//        a6.setPosition(p2);
//
//
//        c.addAnt(a6);
//
//
//        m2.setAntAtCell(p2, a6);
//
//        b12.loadBrain(new File("brains/file19.txt"));
//
//        m2.setCellScentMarker(p2,1);
//
//        b12.step(a6.getID()); // attempt to unmark a6 marker should not do it
//
//        assertEquals(-1,m2.getCellScentMarker(Colour.RED,p2));
//        assertEquals(1,a6.getState());
//
//
//
//    }
//
//    @Test
//
//    public void testPickUpFood() throws InvalidContentCharacterException, CellAlreadyOccupiedException {
//
//
//        MapImpl m3 = new MapImpl();
//        Colony c = new ColonyImpl(Colour.RED);
//
//        BrainImpl b13 = new BrainImpl(m3,c);
//        Position p3 = new Position(1,1);
//        m3.generateMap();
//
//
//        AntImpl a7 = new AntImpl(1,Colour.RED,p3);
//
//        a7.setHasFood(false);
//        m3.setAntAtCell(p3,a7);
//
//        c.addAnt(a7);
//
//        char testChar = '9';
//
//        m3.setCellContents(p3, testChar);
//
//        b13.loadBrain(new File("brains/file20.txt"));
//
//
//
//
//        b13.step(1); // should set state to 1 if there is food at cell
//        assertEquals(1, a7.getState());
//        char ch = m3.getCellContents(p3);
//        assertEquals((char) 8, Character.getNumericValue(ch) );
//
//
//        /////////
//        /////////
//        ////////
//        Colony col = new ColonyImpl(Colour.RED);
//        MapImpl m4 = new MapImpl();
//        BrainImpl b14 = new BrainImpl(m4,col);
//        Position p4 = new Position(1,1);
//        AntImpl a8 = new AntImpl(4,Colour.RED,p4);
//
//        m4.generateMap();
//
//        col.addAnt(a8);
//
//        m4.setCellContents(p4, '.');
//
//        m4.setAntAtCell(p4,a8);
//
//        b14.loadBrain(new File("brains/file21.txt"));
//
//
//        b14.step(a8.getID());
//
//
//        assertEquals(2, a8.getState());
//        assertEquals('.', m4.getCellContents(p4));
//         // checks that it has gone to state 2 as there is no food
////
////        ////////
////        ////////
////        ////////
//
//        MapImpl m5 = new MapImpl();
//        Colony col1 = new ColonyImpl(Colour.RED);
//        BrainImpl b15 = new BrainImpl(m5,col1);
//        Position p5 = new Position(1,1);
//        AntImpl a9 = new AntImpl(2,Colour.RED,p5);
//
//        m5.generateMap();
//        col1.addAnt(a9);
//        b15.loadBrain(new File("brains/file22.txt"));
//
//
//        m5.setCellContents(p4, '.');
//        m5.setAntAtCell(p5,a9);
//        a9.setHasFood(true);
//
//        b15.step(2);
//
//        assertEquals(('.'), m5.getCellContents(p4));
//        assertEquals(2, a9.getState()); // checks that it has gone to state 2 as the ant is carrying food
//
//    }
//
////    @Test
////    public void testDrop() throws com.model.com.model.exceptions.CellAlreadyOccupiedException, com.model.com.model.exceptions.InvalidContentCharacterException {
////
////        com.model.BrainImpl b16 = new com.model.BrainImpl();
////        PositionImpl p6 = new PositionImpl();
////        com.model.AntImpl a10 = new com.model.AntImpl();
////        com.model.MapImpl m6 = new com.model.MapImpl();
////        p6.setX(1);
////        p6.setY(1);
////
////        b16.loadBrain(file21);
////        a10.setID(1);
////        a10.setHasFood(true); // should implement?
////
////        m6.setAntAtCell(p6,1);
////
////        m6.setCellContents(p6, -1);
////        b16.step(1);
////
////        assertEquals((char) 1, m6.getCellContents(p6));
////        assertEquals(1, a10.getState()); // should be changed to state 1
////
////        ///////
////        ///////
////        ///////
////
////        com.model.BrainImpl b17 = new com.model.BrainImpl();
////        PositionImpl p7 = new PositionImpl();
////        com.model.AntImpl a11 = new com.model.AntImpl();
////        com.model.MapImpl m7 = new com.model.MapImpl();
////
////        p7.setX(1);
////        p7.setY(1);
////
////        b17.loadBrain(file22);
////        a11.setID(3);
////        a11.setHasFood(true);
////
////        m7.setCellContents(p7, (char) 1);
////        m7.setAntAtCell(p7, 1);
////
////        b17.step(3);
////
////        assertEquals((char) 2, m7.getCellContents());
////        assertEquals(1, a11.getState());
////
////        //////
////        //////
////        //////
////        //////
////
////        // if no food then just change state
////
////        com.model.BrainImpl b18 = new com.model.BrainImpl();
////        PositionImpl p8 = new PositionImpl();
////        com.model.AntImpl a12 = new com.model.AntImpl();
////        com.model.MapImpl m8 = new com.model.MapImpl();
////
////        p8.setX(1);
////        p8.setY(1);
////
////
////        b18.loadBrain(file23);
////        a12.setID(5);
////        a12.setHasFood(false);
////
////        m8.setCellContents(p8, (char)-1);
////        m8.setAntAtCell(p8,5);
////
////        b18.step(5);
////
////        assertEquals(1, a12.getState());
////
////    }
////
////    @Test
////
////    public void testTurnLeft() throws com.model.com.model.exceptions.CellAlreadyOccupiedException {
////
////        com.model.BrainImpl b19 = new com.model.BrainImpl();
////        com.model.AntImpl a17 = new com.model.AntImpl();
////
////        com.model.MapImpl m9 = new com.model.MapImpl();
////        PositionImpl p9 = new PositionImpl();
////
////        p9.setX(1);
////        p9.setY(1);
////
////
////        b19.loadBrain(file22);
////        a17.setID(1);
////        m9.setAntAtCell(p9,1);
////        a17.setDirection(0);
////
////        b19.step(1);
////
////        assertEquals(5,a17.getDirection());
////        assertEquals(1, a17.getState()); // checks in correct state
////
////
////        b19.step(1);
////
////        assertEquals(4,a17.getDirection());
////        assertEquals(1, a17.getState()); // checks in correct state
////
////        b19.step(1);
////
////        assertEquals(3,a17.getDirection());
////        assertEquals(1, a17.getState()); // checks in correct state
////
////        b19.step(1);
////
////        assertEquals(2,a17.getDirection());
////        assertEquals(1, a17.getState()); // checks in correct state
////
////        b19.step(1);
////
////        assertEquals(1,a17.getDirection());
////        assertEquals(1, a17.getState()); // checks in correct state
////
////
////        b19.step(1);
////
////        assertEquals(0,a17.getDirection());
////        assertEquals(1, a17.getState()); // checks in correct state
////
////
////    }
////
////    @Test
////
////    public void testTurnRight() throws com.model.com.model.exceptions.CellAlreadyOccupiedException {
////
////        com.model.BrainImpl b20 = new com.model.BrainImpl();
////        com.model.AntImpl a18 = new com.model.AntImpl();
////
////        com.model.MapImpl m10 = new com.model.MapImpl();
////        PositionImpl p10 = new PositionImpl();
////
////        p10.setX(1);
////        p10.setY(1);
////
////
////        b20.loadBrain(file23);
////        a18.setID(1);
////        m10.setAntAtCell(p10,1);
////        a18.setDirection(0);
////
////        b20.step(1);
////
////        assertEquals(1,a18.getDirection());
////        assertEquals(1, a18.getState()); // checks in correct state
////
////
////        b20.step(1);
////
////        assertEquals(2,a18.getDirection());
////        assertEquals(1, a18.getState()); // checks in correct state
////
////        b20.step(1);
////
////        assertEquals(3,a18.getDirection());
////        assertEquals(1, a18.getState()); // checks in correct state
////
////        b20.step(1);
////
////        assertEquals(4,a18.getDirection());
////        assertEquals(1, a18.getState()); // checks in correct state
////
////        b20.step(1);
////
////        assertEquals(5,a18.getDirection());
////        assertEquals(1, a18.getState()); // checks in correct state
////
////
////        b20.step(1);
////
////        assertEquals(0,a18.getDirection());
////        assertEquals(1, a18.getState()); // checks in correct state
////
////    }
////
////    @Test
////
////    public void testMove() throws com.model.com.model.exceptions.CellAlreadyOccupiedException {
////
////        com.model.BrainImpl b21 = new com.model.BrainImpl();
////        com.model.AntImpl a19 = new com.model.AntImpl();
////
////        com.model.MapImpl m11 = new com.model.MapImpl();
////        PositionImpl p11 = new PositionImpl(); // original
////        PositionImpl  p12 = new PositionImpl();// goes right
////        PositionImpl p13 = new PositionImpl(); // left
////        PositionImpl p14 = new PositionImpl(); // top right
////        PositionImpl p15 = new PositionImpl(); // top left
////        PositionImpl p16 = new PositionImpl(); // bottom right
////        PositionImpl p17 = new PositionImpl(); // bottom left
////
////
////
////        p11.setX(1);
////        p11.setY(1);
////
////        p12.setX(2);
////        p12.setY(1);
////
////        p13.setX(0);
////        p13.setY(1);
////
////        p14.setX(2);
////        p14.setY(0);
////
////        p15.setX(1);
////        p15.setY(0);
////
////        p16.setX(2);
////        p16.setY(2);
////
////        p17.setX(1);
////        p17.setY(2);
////
////        a19.setID(1);
////        b21.loadBrain(file24);
////
////        m11.setAntAtCell(p11,1);
////        a19.setDirection(0);
////
////        b21.step(1);
////
////        assertEquals(0, m11.getAntAtCell(p11));
////        assertEquals(1,m11.getAntAtCell(p12));
////
////        // need to clear from prev cell?
////
////        m11.setAntAtCell(p11 , 1);
////        a19.setDirection(3);
////
////        b21.step(1);
////
////        assertEquals(0, m11.getAntAtCell(p11));
////        assertEquals(1,m11.getAntAtCell(p13));
////
////        m11.setAntAtCell(p11 , 0);
////        a19.setDirection(5);
////
////        b21.step(1);
////
////        assertEquals(0, m11.getAntAtCell(p11));
////        assertEquals(1,m11.getAntAtCell(p14));
////
////        m11.setAntAtCell(p11 , 0);
////        a19.setDirection(4);
////
////        b21.step(1);
////
////        assertEquals(0, m11.getAntAtCell(p11));
////        assertEquals(1,m11.getAntAtCell(p15));
////
////        m11.setAntAtCell(p11 , 0);
////        a19.setDirection(1);
////
////        b21.step(1);
////
////        assertEquals(0, m11.getAntAtCell(p11));
////        assertEquals(1,m11.getAntAtCell(p16));
////
////        m11.setAntAtCell(p11 , 0);
////        a19.setDirection(2);
////
////        b21.step(1);
////
////        assertEquals(0, m11.getAntAtCell(p11));
////        assertEquals(1,m11.getAntAtCell(p17));
////
////        //////
////        //////
////
////        /// checking if rocky or occupied if it is do nothing change state
////
////        m11.setAntAtCell(p11 , 0);
////        a19.setDirection(0);
////
////        m11.setCellContents(p12, '#' );
////        b21.step(1);
////
////        assertEquals(1, m11.getAntAtCell(p11));
////        assertEquals(10, a19.getState()); // make sure in correct state
////
////
////        // occupied cell
////
////        com.model.AntImpl a20 = new com.model.AntImpl();
////        a20.setID(2);
////
////        m11.setCellContents(p12, '#');
////        m11.setAntAtCell(p11 , 1);
////        m11.setAntAtCell(p12, 2);
////        a19.setDirection(0);
////
////        b21.step(1);
////
////        assertEquals(1, m11.getAntAtCell(p11));
////        assertEquals(11, a19.getState()); // make sure in correct state
////
////
////
////
////    }
////
////    // flip hard cause its random?



}
