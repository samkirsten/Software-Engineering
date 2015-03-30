import com.model.Colour;
import com.model.Game;
import com.model.GameImpl;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
* Created by Jacob on 26/03/2015.
*/
public class GameTest {

    @Test
    public void loadBrainTest(){
        Game game = new GameImpl();
        File brainFile = new File("brains/brain1.txt");
        assertTrue(game.loadBrain(new File("brains/brain1.txt"), Colour.RED));

        assertEquals(game.getColony(Colour.RED).getBrain(),brainFile);
    }
//
//    @Test
//    public void setColonyTest(){
//        com.model.Game game = new GameImpl();
//        com.model.Colony colony = new com.model.ColonyImpl(com.model.Colour.RED,new com.model.BrainImpl());
//        com.model.Map map = new com.model.MapImpl();
//        game.setColony(colony,map.getAnthill(com.model.Colour.RED));
//        assertEquals(game.getColony(com.model.Colour.RED),colony);
//    }



}
