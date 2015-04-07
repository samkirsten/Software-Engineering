
import com.model.*;
import com.model.exceptions.CellAlreadyOccupiedException;
import com.model.exceptions.InvalidContentCharacterException;
import org.junit.Test;
import static org.junit.Assert.*;


public class MapTest {

    @Test // should also test the rocky borders
    public void testGenerateMapTest(){
        MapImpl m = new MapImpl();
        m.generateMap();

        assertEquals(127,m.getArray("red"));
        assertEquals(127,m.getArray("black"));
        assertEquals(275,m.getArray("food"));
        assertEquals(610,m.getArray("rocky"));
    }

    @Test // this test is wrong
    public void testClearMap(){
        MapImpl m = new MapImpl();
        m.generateMap();
        Cell[][] m1 =  m.getMap();

        Position p = new Position(1,1);
        Position p1 = new Position(1,2);
        Position p2= new Position(1,3);
        Position p3 = new Position(1,4);
        Ant a = new AntImpl(1,Colour.RED,p);
        Ant a1 = new AntImpl(2,Colour.RED,p1);
        Ant a2= new AntImpl(3,Colour.RED,p2);
        Ant a3 = new AntImpl(4,Colour.RED,p3);
        try {
            m.setAntAtCell(p,a);
            m.setAntAtCell(p1,a1);
            m.setAntAtCell(p2,a2);
            m.setAntAtCell(p3,a3);
        } catch (CellAlreadyOccupiedException e) {
            e.printStackTrace();
        }


        assertEquals(a,m.getAntAtCell(p));
        assertEquals(a1,m.getAntAtCell(p1));
        assertEquals(a2,m.getAntAtCell(p2));
        assertEquals(a3,m.getAntAtCell(p3));

        m.clearMap();

        assertEquals(null,m.getAntAtCell(p));
        assertEquals(null,m.getAntAtCell(p1));
        assertEquals(null,m.getAntAtCell(p2));
        assertEquals(null,m.getAntAtCell(p3));

        Cell[][] m2 = m.getMap();

        for(int x = 0; x < 150; x++){
            for(int b = 0; b < 150; b++){
                assertEquals(m1[x][b].getContents(),m2[x][b].getContents());
            }
        }

    }

    @Test // should also check if a empty cell is rocky and should return false
    public void testSellIsRocky(){
        MapImpl m = new MapImpl();
        m.generateMap();
        Cell[][] map = m.getMap();

        Position p = new Position(5,5);
        map[5][5].setContents(Content.EMPTY);
        assertFalse(map[5][5].isRocky());
        map[5][5].setContents(Content.ROCKY);
        assertTrue(map[5][5].isRocky());
    }

    @Test
    public void testCellContent() throws InvalidContentCharacterException {
        MapImpl m = new MapImpl();
        m.generateMap();
        Cell[][] map = m.getMap();

        Position p = new Position(5,5);
        m.setCellContents(p,Content.EMPTY);
        assertEquals(m.getCellContents(p), Content.EMPTY);
        m.setCellContents(p,Content.REDHILL);
        assertEquals( m.getCellContents(p),Content.REDHILL);
        m.setCellContents(p,Content.BLACKHILL);
        assertEquals( m.getCellContents(p),Content.BLACKHILL);
        m.setCellContents(p,Content.ONE);
        assertEquals( m.getCellContents(p),Content.ONE);
        m.setCellContents(p,Content.TWO);
        assertEquals( m.getCellContents(p),Content.TWO);
        m.setCellContents(p,Content.THREE);
        assertEquals( m.getCellContents(p),Content.THREE);
        m.setCellContents(p,Content.FOUR);
        assertEquals( m.getCellContents(p),Content.FOUR);
        m.setCellContents(p,Content.FIVE);
        assertEquals( m.getCellContents(p),Content.FIVE);
        m.setCellContents(p,Content.SIX);
        assertEquals( m.getCellContents(p),Content.SIX);
        m.setCellContents(p,Content.SEVEN);
        assertEquals( m.getCellContents(p),Content.SEVEN);

    }

    @Test
    public void testCellScentMarker(){
        MapImpl m = new MapImpl();
        m.generateMap();

        Position p = new Position(5,5);
        m.setCellScentMarker(p,3);
        assertEquals(-1,m.getCellScentMarker(Colour.BLACK,p));
        assertEquals(3,m.getCellScentMarker(Colour.RED,p));

        m.setCellScentMarker(p,8);
        assertEquals(8,m.getCellScentMarker(Colour.BLACK,p));
        assertEquals(-1,m.getCellScentMarker(Colour.RED,p));


    }

    @Test
    public void testAntAtCell() throws CellAlreadyOccupiedException {
        MapImpl m = new MapImpl();
        m.generateMap();

        assertNull(m.getAntAtCell(new Position(5,5)));

        Ant ant = new AntImpl(1, Colour.RED,new Position(5,5));
        m.setAntAtCell(new Position(5,5),ant);
        assertEquals(m.getAntAtCell(new Position(5,5)),ant);

    }

    @Test
    public void getAdjacentEnemyAnts() throws CellAlreadyOccupiedException {
        MapImpl m = new MapImpl();
        m.generateMap();

        Ant ant1 = new AntImpl(1, Colour.BLACK,new Position(5,5));
        Ant ant2 = new AntImpl(1, Colour.RED,new Position(4,5));
        Ant ant3 = new AntImpl(1, Colour.RED,new Position(6,5));
        Ant ant4 = new AntImpl(1, Colour.RED,new Position(5,4));
        Ant ant5 = new AntImpl(1, Colour.RED,new Position(6,4));
        Ant ant6 = new AntImpl(1, Colour.RED,new Position(5,6));
        Ant ant7 = new AntImpl(1, Colour.RED,new Position(5,6));

        m.setAntAtCell(new Position(5, 5), ant1);
        assertEquals(0, m.getAdjacentEnemyAnts(new Position(5, 5), Colour.RED));

        m.setAntAtCell(new Position(4, 5), ant2);
        assertEquals(1, m.getAdjacentEnemyAnts(new Position(5, 5), Colour.RED));

        m.setAntAtCell(new Position(6,5),ant3);
        assertEquals(2,m.getAdjacentEnemyAnts(new Position(5,5),Colour.RED));

        m.setAntAtCell(new Position(5,4),ant4);
        assertEquals(3,m.getAdjacentEnemyAnts(new Position(5,5),Colour.RED));

        m.setAntAtCell(new Position(6,4),ant5);
        assertEquals(4,m.getAdjacentEnemyAnts(new Position(5,5),Colour.RED));

        m.setAntAtCell(new Position(5,6),ant6);
        assertEquals(5,m.getAdjacentEnemyAnts(new Position(5,5),Colour.RED));

        m.setAntAtCell(new Position(6,6),ant7);
        assertEquals(6,m.getAdjacentEnemyAnts(new Position(5,5),Colour.RED));



    }
}
