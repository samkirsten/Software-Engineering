
import com.model.AntImpl;
import com.model.Colour;
import com.model.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
* Created by Tina on 3/15/2015.
*/
public class AntTest {

    AntImpl testAnt;

    @Before
    public void initialize(){
        testAnt = new AntImpl(1, Colour.RED,new Position(0,0));
    }

    @Test
    public void test_GetDirection() {

        //for the range 0-5, it should be able to input into direction
            for (int i=0;i<6;i++){
                testAnt.setDirection(i);
                int result = testAnt.getDirection();
                assertEquals(i, result);
            }

        // for direction other than 0-6, input should not be set into direction
            testAnt.setDirection(6);
            int result = testAnt.getDirection();
            assertNotEquals(6,result);

    }



    @Test
    public void test_GetState() {
        //test if state is in range 0-9999
        testAnt.setState(1);
        int result = testAnt.getState();
        assertEquals(1, result);

        //test if state is out of range
        testAnt.setState(10000);
        int result2 = testAnt.getState();
        assertFalse(10000 == result2);

    }

    @Test
    public void test_Resting() {
        //test for first round, ant should be not resting
            assertFalse(testAnt.isResting());


        //test for the next 14 round, ant should be resting
            for (int i=1;i<15;i++){
                testAnt.incrementRest();
                assertEquals(15 - i, testAnt.getRemainingRest());
                assertTrue(testAnt.isResting());
            }


        //test for the 15th round, ant should end resting
        testAnt.incrementRest();
        assertFalse(testAnt.isResting());


    }


    @Test
    public void test_hasFood(){
        //ant shouldn't have food once created
        assertFalse(testAnt.hasFood);


        //ant should have food after bring set
        testAnt.setHasFood(true);
        assertTrue(testAnt.hasFood);
    }
//    @Test
//    public void test_MarkScent(){
//        com.model.Position testPos = new com.model.Position(1,1) ;
//        com.model.Map testMap = new com.model.Map();
//        com.model.Colour testColor = new com.model.Colour();
//        com.model.AntImpl testAnt = new com.model.AntImpl(1,testColor,0,0,0,false);
//
//        //set marker in ANT class
//            testAnt.markScent(testPos, 1);
//
//        //get marker in MAP class
//            assertEquals(1, testMap.getCellScentMarker(testColor,testPos));
//    }
//
//    @Test
//    public void test_killEnemyAnt(){
//
//    }



}
