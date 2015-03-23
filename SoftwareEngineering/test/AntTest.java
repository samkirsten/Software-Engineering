
import org.junit.*;
import org.junit.Test;

import javax.swing.text.Position;

import java.util.Map;

import static org.junit.Assert.*;


/**
 * Created by Tina on 3/15/2015.
 */
public class AntTest {


    @Test
    public void test_GetDirection() {

        //for the range 0-5, it should be able to input into direction
            for (int i=0;i<6;i++){
                Ant testAnt = new Ant();
                testAnt.setDirection(i);
                int result = testAnt.getDirection();
                assertEquals(i, result);
            }

        // for direction other than 0-6, input should not be set into direction
            Ant testAnt = new Ant();
            testAnt.setDirection(6);
            int result = testAnt.getDirection();
            assertFalse(6 == result);

    }


    //stat range ??
    @Test
    public void test_GetState() {
        Ant testAnt = new Ant();
        testAnt.setState(1);
        int result = testAnt.getState();
        assertEquals(1, result);

    }

    @Test
    public void test_Resting() {
        //test for first round, ant should be not resting
            Ant testAnt = new Ant();
            assertFalse(testAnt.isResting());

        //test for the next 14 round, ant should be resting
            for (int i=1;i<15;i++){
                testAnt.incrementRest();
                assertEqual(14-i,getRemainingRest());
                assertTrue(testAnt.isResting());
            }


        //test for the 15th round, ant should end resting
        testAnt.incrementRest();
        assertFalse(testAnt.isResting());


    }


    @Test
    public void test_MarkScent(){
        Position testPos = new Position(1,1) ;
        Map testMap = new Map();
        Color testColor = new Color();
        Ant testAnt = new Ant(1,testColor,0,0,0,false);

        //set marker in ANT class
            testAnt.markScent(testPos, 1);

        //get marker in MAP class
            assertEqual(1, testMap.getCellScentMarker(testColor,testPos));
    }

    @Test
    public void test_killEnemyAnt(){

    }

    @Test
    public void test_hasFood(){

    }


}
