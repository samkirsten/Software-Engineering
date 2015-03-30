
import com.model.*;
import com.model.exceptions.CellAlreadyOccupiedException;
import com.model.exceptions.InvalidContentCharacterException;
import org.junit.Test;
import static org.junit.Assert.*;


public class MapTest {

    @Test
    public void testGenerateMapTest(){
        MapImpl m = new MapImpl();
        m.generateMap();

        assertEquals(m.getArray("red"),127);
        assertEquals(m.getArray("black"),127);
        assertEquals(m.getArray("food"),275);
    }

    @Test
    public void testClearMap(){
        MapImpl m = new MapImpl();
        m.generateMap();
        Cell[][] m1 =  m.getMap();
        m.clearMap();
        Cell[][] m2 = m.getMap();

        for(int a = 0; a < 150; a++){
            for(int b = 0; b < 150; b++){
                assertEquals(m1[a][b],m2[a][b]);
            }
        }

    }

    @Test
    public void testSellIsRocky(){
        MapImpl m = new MapImpl();
        m.generateMap();
        Cell[][] map = m.getMap();

        Position p = new Position(5,5);
        map[5][5].setContents('.');
        assertFalse(map[5][5].isRocky());
        map[5][5].setContents('#');
        assertTrue(map[5][5].isRocky());
    }

    @Test
    public void testCellContent() throws InvalidContentCharacterException {
        MapImpl m = new MapImpl();
        m.generateMap();
        Cell[][] map = m.getMap();

        Position p = new Position(5,5);
        m.setCellContents(p,'.');
        assertEquals(m.getCellContents(p), '.');
        m.setCellContents(p,'+');
        assertEquals( m.getCellContents(p),'+');
        m.setCellContents(p,'-');
        assertEquals( m.getCellContents(p),'-');
        m.setCellContents(p,'1');
        assertEquals( m.getCellContents(p),'1');
        m.setCellContents(p,'2');
        assertEquals( m.getCellContents(p),'2');
        m.setCellContents(p,'3');
        assertEquals( m.getCellContents(p),'3');
        m.setCellContents(p,'4');
        assertEquals( m.getCellContents(p),'4');
        m.setCellContents(p,'5');
        assertEquals( m.getCellContents(p),'5');
        m.setCellContents(p,'6');
        assertEquals( m.getCellContents(p),'6');
        m.setCellContents(p,'7');
        assertEquals( m.getCellContents(p),'7');

    }

    @Test
    public void testCellScentMarker(){
        MapImpl m = new MapImpl();
        m.generateMap();

        Position p = new Position(5,5);
        m.setCellScentMarker(p,3);
        assertEquals(m.getCellScentMarker(Colour.BLACK,p),3);
        assertEquals(m.getCellScentMarker(Colour.RED,p),-1);
        m.setCellScentMarker(p,8);
        assertEquals(m.getCellScentMarker(Colour.BLACK,p),-1);
        assertEquals(m.getCellScentMarker(Colour.RED,p),8);


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

        m.setAntAtCell(new Position(5,5),ant1);
        assertEquals(m.getAdjacentEnemyAnts(new Position(5,5),Colour.BLACK),0);
        m.setAntAtCell(new Position(4,5),ant2);
        assertEquals(m.getAdjacentEnemyAnts(new Position(5,5),Colour.BLACK),1);
        m.setAntAtCell(new Position(6,5),ant3);
        assertEquals(m.getAdjacentEnemyAnts(new Position(5,5),Colour.BLACK),2);
        m.setAntAtCell(new Position(5,4),ant4);
        assertEquals(m.getAdjacentEnemyAnts(new Position(5,5),Colour.BLACK),3);

    }
}
