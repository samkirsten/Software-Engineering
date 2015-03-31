<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream
>>>>>>> Stashed changes
import com.model.*;
import com.model.exceptions.AntNotFoundException;
import com.view.GameGUI;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
<<<<<<< Updated upstream
 * Created by Jacob on 26/03/2015.
 */
public class GameTest {

    // making loadBrain private?
=======
* Created by Jacob on 26/03/2015.
*/
public class GameTest {

    // making loadBrain private?
=======
//import com.model.*;
//import com.model.exceptions.AntNotFoundException;
//import com.view.GameGUI;
//import org.junit.Test;
//
//import java.io.File;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
///**
//* Created by Jacob on 26/03/2015.
//*/
//public class GameTest {
//
////    @Test
////    public void loadBrainTest(){
//<<<<<<< Updated upstream
////        File brainFile = new File("brains/brain1.txt");
////        Colony c = new ColonyImpl(Colour.RED);
////        Map m  = new MapImpl();
////        File brainFile1 = new File("brains/brain1.txt");
////        Game game = new GameImpl(brainFile,"1",brainFile1,"2",null,m);
////      //  game.getColony(Colour.RED);
////       // System.out.println(game.loadBrain(brainFile,Colour.RED));
////        assertTrue(game.loadBrain(brainFile, Colour.RED));
////    }
//
>>>>>>> Stashed changes
>>>>>>> Stashed changes
//    @Test
//    public void loadBrainTest(){
//        File brainFile = new File("brains/brain1.txt");
//        Colony c = new ColonyImpl(Colour.RED);
<<<<<<< Updated upstream
//        Map m  = new MapImpl();
//        File brainFile1 = new File("brains/brain1.txt");
//        Game game = new GameImpl(brainFile,"1",brainFile1,"2",null,m);
//      //  game.getColony(Colour.RED);
//       // System.out.println(game.loadBrain(brainFile,Colour.RED));
//        assertTrue(game.loadBrain(brainFile, Colour.RED));
//    }
=======
//        Map m = new MapImpl();
//        File brainFile1 = new File("brains/brain1.txt");
//
//        m.generateMap();
//
//
//        Game game = new GameImpl(brainFile, "1", brainFile1, "2", null);
//        List<Position> redHill = game.getMap().getAntHill(Colour.RED);
//        List<Position> blackHill = m.getAntHill(Colour.BLACK);
//=======
////        Game game = new GameImpl();
////        File brainFile = new File("brains/brain1.txt");
////        assertTrue(game.loadBrain(new File("brains/brain1.txt"), Colour.RED));
////
////        assertEquals(game.getColony(Colour.RED).getBrain(),brainFile);
////    }
////
////    @Test
////    public void setColonyTest(){
////        com.model.Game game = new GameImpl();
////        com.model.Colony colony = new com.model.ColonyImpl(com.model.Colour.RED,new com.model.BrainImpl());
////        com.model.Map map = new com.model.MapImpl();
////        game.setColony(colony,map.getAnthill(com.model.Colour.RED));
////        assertEquals(game.getColony(com.model.Colour.RED),colony);
////    }
//>>>>>>> Stashed changes
//
//
//        for (Position p : redHill) {
//
//
//            try {
//
//                assertTrue(game.getMap().getAntAtCell(p).equals(game.getColony(Colour.RED).getAnt(p)));
//
//            } catch (AntNotFoundException e) {
//                e.printStackTrace();
//            }
//
//
//            //i++;
//
//
//        }
//    }
<<<<<<< Updated upstream
>>>>>>> Stashed changes

    @Test
    public void testSetup() {

        File brainFile = new File("brains/brain1.txt");

        Map m = new MapImpl();
        File brainFile1 = new File("brains/brain1.txt");

        m.generateMap();


        Game game = new GameImpl(brainFile, "1", brainFile1, "2", null);
        List<Position> redHill = game.getMap().getAntHill(Colour.RED);
        List<Position> blackHill = game.getMap().getAntHill(Colour.BLACK);


        for (Position p : redHill) {


            try {

                assertTrue(game.getMap().getAntAtCell(p).equals(game.getColony(Colour.RED).getAnt(p)));

            } catch (AntNotFoundException e) {
                e.printStackTrace();
            }



        }

        for(Position p1 : blackHill){

            try {

                assertTrue(game.getMap().getAntAtCell(p1).equals(game.getColony(Colour.BLACK).getAnt(p1)));

            } catch (AntNotFoundException e) {
                e.printStackTrace();
            }

        }


        ///////
        ///////
        ///////
        ////// Testing constructor with map as input



        File brainFile2 = new File("brains/brain1.txt");

        Map m1 = new MapImpl();
        File brainFile3 = new File("brains/brain1.txt");

        m1.generateMap();


        Game game1 = new GameImpl(brainFile2, "1", brainFile3, "2", null,m1);
        List<Position> redHill1 = m1.getAntHill(Colour.RED);
        List<Position> blackHill1 = m1.getAntHill(Colour.BLACK);




        for (Position p : redHill1) {


            try {

                assertTrue(m1.getAntAtCell(p).equals(game1.getColony(Colour.RED).getAnt(p)));

            } catch (AntNotFoundException e) {
                e.printStackTrace();
            }



        }

        for(Position p1 : blackHill1){

            try {

                assertTrue(m1.getAntAtCell(p1).equals(game1.getColony(Colour.BLACK).getAnt(p1)));

            } catch (AntNotFoundException e) {
                e.printStackTrace();
            }

        }




    }






}
<<<<<<< Updated upstream
=======
=======
//}
>>>>>>> Stashed changes
>>>>>>> Stashed changes
