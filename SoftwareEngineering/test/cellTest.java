import org.junit.*;
import static org.junit.Assert.*;

public class CellTest {

	@Test
	public void testRocky(){
		com.model.Cell c = new com.model.Cell();

		c.setContents("#");
		assertTrue(c.isRocky());
		assertEquals(c.getContents, "#");

		c.setContents(".");
		assertFalse(c.isRocky());
		assertEquals(c.getContents, ".");
	}

	@Test
	public void testAnt(){
		com.model.Cell c = new com.model.Cell();

		c.setAnt(30);
		assertEquals(c.getAnt, 30);
	}

	@Test
	public void testScentMark(){
		com.model.Cell c = new com.model.Cell();

		assertEquals(c.getScentMark(), 0);     // default value of Scent mark;

		c.setScentMark(10);
		assertEquals(c.getScentMark(), 10);
	}

	@Test
	public void testContents(){
		com.model.Cell c = new com.model.Cell();

		assertEquals(c.getContents, ".");		// default value of Contents

		c.setContents("+");
		assertEquals(c.getContents, "+");

		c.setContents("-");
		assertEquals(c.getContents, "-");

		c.setContents("2");
		assertEquals(c.getContents, "2");

		c.setContents("4");
		assertEquals(c.getContents, "4");
	}
}