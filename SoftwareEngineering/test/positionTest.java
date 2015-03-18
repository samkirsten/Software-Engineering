
import org.junit.*;
import static org.junit.Assert.*;


public class positionTest{

	// Test X coordinate - getter
	@Test
	public void testX(){
		Position p = new Position(1,2);
		p.setX(3);
		assertEquals(p.getX, 3);
	}

	// Test Y coordinate - getter 
	@Test
	public void testY(){
		Position p = new Position(1,2);
		p.setY(3);
		assertEquals(p.getY, 3);
	}
}