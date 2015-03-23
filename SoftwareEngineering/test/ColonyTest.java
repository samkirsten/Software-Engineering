
import org.junit.*;
import org.junit.Test;

import javax.swing.text.Position;

import java.util.HashMap;

import static org.junit.Assert.*;


/**
 * Created by Tina on 3/15/2015.
 */
public class ColonyTest {

    Colour color ;

    //list or hash map ?
    HashMap<int,Ant> antList ;
    Ant ant1 ;
    Ant ant2 ;
    Ant ant3 ;

    Brain brain ;
    Position hill ;
    int food ;
    int maxAnts ;
    Colony colony ;


    @Before
    public void initialize() {
      //  color = new Colour(RED);
        color = Colour.RED; // this is how to initialise an enum
        antList = new HashMap<int,Ant>() ;
        ant1 = new AntImpl(1,color,0,0,0,false);
        ant2 = new AntImpl(2,color,0,0,0,false);
        ant3 = new AntImpl(3,color,0,0,0,false);

        //Brain ?
        brain = new Brain();
        food = 0;
        maxAnts = 10;
        hill = new Position(1,1);

        antList.add(ant1.getID() , ant1);
        antList.add(ant2.getID() , ant2);
        antList.add(ant3.getID() , ant3);

        colony = new ColonyImpl(color, antList, brain, food, hill, maxAnts);
    }


    @Test
    public void test_GetAnt_with_ID() {

        //test if the output of getting ant with ID=1 is the same object with the original ANT
        Ant output1 = colony.getAnt(1);
        assertSame(ant1, output);

        Ant output2 = colony.getAnt(2);
        assertSame(ant2, output);

        Ant output3 = colony.getAnt(3);
        assertSame(ant3, output);
    }

    @Test
    public void test_GetAnt_with_position(){

        //go through the list and search

    }



    @Test
    public void test_is_ant_alive(){

        //for ant exist, is should return true
        for (int i=0;i<3;i++){
            assertTrue(colony.isAntAlive(i));
        }

        //for ant that doesnt exist, should return false
        assertFalse(colony.isAntAlive(4));
    }

    @Test
    public void test_getNumberOfAnts(){
        assertEquals(3, colony.getNumberOfAnts());
    }

    @Test
    public void test_food(){

        assertEquals( 0, colony.getFoodInColony());

        colony.incrementFood();
        assertEquals( 1, colony.getFoodInColony());


    }

    @Test
    public void test_brain(){
        assertTrue(colony.loadBrain(brain));
        File testFile = new File();
        assertSame(brain, testFile);

    }


    @Test
    public void test_getColonyColour(){
        assertEqual(color , colony.getColonyColour());
    }

  /*  @Test
    public void test_setAntHill() {
        List<Position> test_pos = new List<Position>() ;

        //make a list of position for the hill
        for (int x=0;x<7;x++){
            for (int y=0;y<7;y++){
                test_pos.add(new Position(x,y));

            }
        }

        //where to access the cells ?
        //.....
    }*/

    @Test
    public void test_remove(){
        //does MAP contains colony, colony contains cells ?
        //if MAP contains cells, how to access the cells ?
    }

}
