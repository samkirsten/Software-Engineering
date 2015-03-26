
import org.junit.*;
import org.junit.Test;
import javax.swing.text.Position;

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


        antList = new HashMap<Integer,AntImpl>() ;

        ant1 = new AntImpl();
        ant1.setID(1);
        ant1.setColour(color);
      //  ant1.setPosition( new Position(0,0));

        ant2 = new AntImpl();
        ant2.setID(2);
        ant2.setColour(color);

        ant3 = new AntImpl();
        ant3.setID(2);
        ant3.setColour(color);


        antList.put(ant1.getID(), ant1);
        antList.put(ant2.getID(), ant2);
        antList.put(ant3.getID(), ant3);

        colony = new ColonyImpl(color, antList);
    }


    @Test
    public void test_GetAnt_with_ID() throws AntNotFoundException {

        //test if the output of getting ant with ID=1 is the same object with the original ANT
        AntImpl output1 = colony.getAnt(1);
        assertSame(ant1, output1);


        AntImpl output2 = colony.getAnt(2);
        assertSame(ant2, output2);

        AntImpl output3 = colony.getAnt(3);
        assertSame(ant3, output3);
    }

    @Test
    public void test_GetAnt_with_position() throws AntNotFoundException{

        //go through the list and search

//        AntImpl output1 = colony.getAnt( new Position(0,0));
//        assertSame(ant1, output1);

    }



    @Test
    public void test_is_ant_alive(){

        //for ant exist, is should return true
        for (int i=0;i<3;i++){
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

        File testFile = new File("testing");
        assertTrue(colony.loadBrain(testFile));
        assertSame(testFile, colony.getBrain());

    }


    @Test
    public void test_getColonyColour(){
        assertEquals(color , colony.getColonyColour());
    }


    @Test
    public void test_remove(){
        //remove ant at 0,0 which is ant1, it should be deleted from the list

//        colony.remove(new Position(0,0));
//        assertFalse(colony.isAntAlive(1));

    }

}
