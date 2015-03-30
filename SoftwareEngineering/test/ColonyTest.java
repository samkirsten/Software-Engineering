
import com.model.*;
import com.model.exceptions.AntNotFoundException;
import org.junit.*;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;

import static org.junit.Assert.*;


/**
* Created by Tina on 3/15/2015.
*/
public class ColonyTest {

    Colour color ;
    HashMap<Integer,AntImpl> antList ;
    AntImpl ant1 ;
    AntImpl ant2 ;
    AntImpl ant3 ;

    Colony colony ;

    @Before
    public void initialize() {

        color = Colour.RED; // this is how to initialise an enum


        colony = new ColonyImpl(color);


        ant1 = new AntImpl(1,color,new Position(0,0));
        ant2 = new AntImpl(2,color,new Position(0,1));
        ant3 = new AntImpl(3,color,new Position(0,2));

       // ant1.setPosition( new com.model.Position(0,0));


        colony.addAnt(ant1);
        colony.addAnt(ant2);
        colony.addAnt(ant3);


    }


    @Test
    public void test_GetAnt_with_ID() throws AntNotFoundException {

        //test if the output of getting ant with ID=1 is the same object with the original ANT
        Ant output1 = colony.getAnt(1);
        assertEquals(ant1, output1);


        Ant output2 = colony.getAnt(2);
        assertEquals(ant2, output2);

        Ant output3 = colony.getAnt(3);
        assertEquals(ant3, output3);
    }

    @Test
    public void test_GetAnt_with_position() throws AntNotFoundException{

        //go through the list and search

//        com.model.AntImpl output1 = colony.getAnt( new com.model.Position(0,0));
//        assertSame(ant1, output1);

    }



    @Test
    public void test_is_ant_alive(){

        //for ant exist, is should return true
        for (int i=1;i<4;i++){
            assertTrue(colony.isAntAlive(i));
        }

        //for ant that doesn't exist, should return false
        assertFalse(colony.isAntAlive(4));
    }

    @Test
    public void test_getNumberOfAnts(){
        assertEquals(3, colony.getNumberOfAnts());
    }

    @Test
    public void test_food(){

        //initially colony should have no food
        assertEquals( 0, colony.getFoodInColony());

        //after incrementing, colony should have 1 food
        colony.incrementFood();
        assertEquals( 1, colony.getFoodInColony());


    }

    @Test
    public void test_brain(){

        MapImpl testMap = new MapImpl();
        ColonyImpl testColony = new ColonyImpl(Colour.RED);
        BrainImpl testBrain = new BrainImpl(testMap,testColony);

        testColony.setBrain(testBrain);
        assertEquals(testBrain, testColony.getBrain());

    }




    @Test
    public void test_getColonyColour(){
        assertEquals(color , colony.getColonyColour());
    }


    @Test
    public void test_remove() throws AntNotFoundException {
        //remove ant at 0,0 which is ant1, it should be deleted from the list

        colony.remove(1);
        assertFalse(colony.isAntAlive(1));

    }

}
