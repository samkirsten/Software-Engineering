import com.model.*;
import com.model.exceptions.AntNotFoundException;
import com.view.GameGUI;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
* Created by Jacob on 26/03/2015.
*/
public class GameTest {

//    @Test
//    public void loadBrainTest(){
//        File brainFile = new File("brains/brain1.txt");
//        Colony c = new ColonyImpl(Colour.RED);
//        Map m  = new MapImpl();
//        File brainFile1 = new File("brains/brain1.txt");
//        Game game = new GameImpl(brainFile,"1",brainFile1,"2",null,m);
//      //  game.getColony(Colour.RED);
//       // System.out.println(game.loadBrain(brainFile,Colour.RED));
//        assertTrue(game.loadBrain(brainFile, Colour.RED));
//    }

    @Test
    public void testSetup() {

        File brainFile = new File("brains/brain1.txt");
        Colony c = new ColonyImpl(Colour.RED);
        Map m = new MapImpl();
        File brainFile1 = new File("brains/brain1.txt");

        m.generateMap();


        Game game = new GameImpl(brainFile, "1", brainFile1, "2", null);
        List<Position> redHill = game.getMap().getAntHill(Colour.RED);
        List<Position> blackHill = m.getAntHill(Colour.BLACK);


        for (Position p : redHill) {


            try {

                assertTrue(game.getMap().getAntAtCell(p).equals(game.getColony(Colour.RED).getAnt(p)));

            } catch (AntNotFoundException e) {
                e.printStackTrace();
            }


            //i++;


        }
    }
}
