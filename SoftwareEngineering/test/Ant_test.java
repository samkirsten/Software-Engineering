
import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by Tina on 3/15/2015.
 */
public class Ant_test {


    @Test
    public void testGetDirection() {
        Ant testAnt = new Ant();
        testAnt.setDirection(1);
        int result = testAnt.getDirection();
        assertEquals(1, result);

    }

    @Test
    public void testGetState() {
        Ant testAnt = new Ant();
        testAnt.setState(1);
        int result = testAnt.getState();
        assertEquals(1, result);

    }

    @Test
    public void test_Resting() {
        Ant testAnt = new Ant();
        assertFalse();


    }



}
