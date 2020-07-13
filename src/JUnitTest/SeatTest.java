package JUnitTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Auxiliry.Seat;

public class SeatTest {

	private Seat s ;
	
	@Before
	public void setUp() throws Exception {
		s=new 	Seat(0, 0);
	}
	@After
	public void tearDown() throws Exception {
		s=null;
	}
	
	@Test
	public void testSetCol() {
		s.setCol(1);
		assertEquals(Integer.valueOf(1),s.getCol());
	}
	@Test
	public void testSetRow() {
		s.setRow(2);
		assertEquals(Integer.valueOf(2),s.getRow());
	}
}
