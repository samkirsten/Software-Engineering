/**
 * Created by junho on 15. 3. 30..
 */
import com.model.exceptions.AntNotFoundException;
import org.junit.Test;
import com.model.*;
import static org.junit.Assert.*;


public class CellTest {

    @Test
    public void TestRocky(){
        Cell c = new CellImpl();

        assertFalse(c.isRocky());

        c.setContents('#');
        assertTrue(c.isRocky());
    }

    @Test
    public void TestScentMark(){
        Cell c = new CellImpl();

        assertEquals(c.getScentMark(),0);

        c.setScentMark(10);
        assertEquals(c.getScentMark(),10);
    }

    @Test
    public void TestAnt() throws AntNotFoundException {
        Cell c = new CellImpl();
        Ant ant = new AntImpl(1, Colour.RED,new Position(0,0));

        assertNull(c.getAnt());

        c.setAnt(ant);
        assertEquals(c.getAnt(),ant);
    }

    @Test
    public void TestContent(){
        Cell c = new CellImpl();
        c.setContents('#');
        assertEquals(c.getContents(),'#');
        c.setContents('+');
        assertEquals(c.getContents(),'+');
        c.setContents('-');
        assertEquals(c.getContents(),'-');
        c.setContents('1');
        assertEquals(c.getContents(),'1');
        c.setContents('2');
        assertEquals(c.getContents(),'2');
        c.setContents('3');
        assertEquals(c.getContents(),'3');
        c.setContents('4');
        assertEquals(c.getContents(),'4');
        c.setContents('5');
        assertEquals(c.getContents(),'5');

    }
}