/**
 * Created by hao-linliang on 17/03/15.
 */

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class brainTest {


    // need to create files to input



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








}
