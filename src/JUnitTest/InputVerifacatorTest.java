package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;
import Auxiliry.InputVerifacator;
public class InputVerifacatorTest {

	@Test
	public void verifyYearTest() throws Exception {
			assertEquals(Integer.valueOf(1992),Integer.valueOf(InputVerifacator.verifyYear("1992")));
	}

	@Test
	public void verifyDoubleTest() throws Exception {
			assertEquals(Double.valueOf(12.5),Double.valueOf(InputVerifacator.verifyDouble("TicketPrice","12.5")));
	}
	@Test
	public void verifyNameStringTest() throws Exception {
			assertEquals("Imax",InputVerifacator.verifyName("TheaterName","Imax"));
	}
	@Test
	public void verifyDateTest() throws Exception {
			assertEquals("2001-02-05",InputVerifacator.verifyDate("2001-02-05"));
	}
	@Test
	public void verifyTimeTest() throws Exception {
			assertEquals("01:02",InputVerifacator.verifyTime("01:02"));
	}
	@Test
	public void verifyTheatreRangeItemTest() throws Exception {
			assertEquals(Integer.valueOf(3),Integer.valueOf(InputVerifacator.verifyTheatreRangeItem("TheaterName","3",5)));
	}
	
	@Test
	public void verifyIdTest() throws Exception {
			assertEquals(Integer.valueOf(204578932),Integer.valueOf(InputVerifacator.verifyId("204578932")));
	}
}

