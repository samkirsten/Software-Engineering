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
        assertTrue(game.loadBrain(new File("brains/brain1.txt"),Colour.RED));

        assertEquals(game.getColony(Colour.RED).getBrain(),brainFile);



    }

}
