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

        c.setContents(Content.ROCKY);
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
        c.setContents(Content.ROCKY);
        assertEquals(c.getContents(), Content.ROCKY);
        c.setContents(Content.REDHILL);
        assertEquals(c.getContents(), Content.REDHILL);
        c.setContents(Content.BLACKHILL);
        assertEquals(c.getContents(), Content.BLACKHILL);
        c.setContents(Content.ONE);
        assertEquals(c.getContents(), Content.ONE);
        c.setContents(Content.TWO);
        assertEquals(c.getContents(), Content.TWO);
        c.setContents(Content.THREE);
        assertEquals(c.getContents(), Content.THREE);
        c.setContents(Content.FOUR);
        assertEquals(c.getContents(), Content.FOUR);
        c.setContents(Content.FIVE);
        assertEquals(c.getContents(), Content.FIVE);

    }
}