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
        b.checkBrain(file);
        assertTrue(true);
    }

    public void testDirectionToken(){

        Brain b2 = new Brain();
        b2.checkBrain(file2);
        assertTrue(true);

    }

    public void testConditionsToken(){

        Brain b3 = new Brain();
        b3.checkBrain(file3);
        assertTrue(true);

    }
    public void testArgumentTokens(){

        Brain b4 = new Brain();
        b4.checkBrain(file4);
        assertTrue(true);
    }

    // Test a mix of all correct tokens
    @Test
    public void testMixOfTokens(){

        Brain b5 = new Brain();
        b5.checkBrain(file5);
        assertTrue(true);

    }


    // test incorrect tokens mixed with correct tokens
    @Test
    public void testFailTokens(){

        Brain b6 = new Brain();
        b6.checkBrain(file6);
        assertFalse(false);
    }

    public void testCorrectWrongTokens(){

        Brain b7 = new Brain();
        b7.checkBrain(file7);
        assertFalse(false);
    }

    public void testCorrectWrongTokens2(){

        Brain b8 = new Brain();
        b8.checkBrain(file8);
        assertFalse(false);

    }




}
