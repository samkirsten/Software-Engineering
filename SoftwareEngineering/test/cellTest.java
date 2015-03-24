//import org.junit.*;
//import static org.junit.Assert.*;
//
//public class CellTest {
//
//	@Test
//	public void testRocky(){
//		Cell c = new Cell();
//
//		c.setContents("#");
//		assertTrue(c.isRocky());
//		assertEquals(c.getContents, "#");
//
//		c.setContents(".");
//		assertFalse(c.isRocky());
//		assertEquals(c.getContents, ".");
//	}
//
//	@Test
//	public void testAnt(){
//		Cell c = new Cell();
//
//		c.setAnt(30);
//		assertEquals(c.getAnt, 30);
//	}
//
//	@Test
//	public void testScentMark(){
//		Cell c = new Cell();
//
//		assertEquals(c.getScentMark(), 0);     // default value of Scent mark;
//
//		c.setScentMark(10);
//		assertEquals(c.getScentMark(), 10);
//	}
//
//	@Test
//	public void testContents(){
//		Cell c = new Cell();
//
//		assertEquals(c.getContents, ".");		// default value of Contents
//
//		c.setContents("+");
//		assertEquals(c.getContents, "+");
//
//		c.setContents("-");
//		assertEquals(c.getContents, "-");
//
//		c.setContents("2");
//		assertEquals(c.getContents, "2");
//
//		c.setContents("4");
//		assertEquals(c.getContents, "4");
//	}
//}