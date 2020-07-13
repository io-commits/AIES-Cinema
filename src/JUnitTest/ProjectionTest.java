package JUnitTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import Auxiliry.Projection;

public class ProjectionTest {
	
	private Projection p;
	@Before
	public void setUp() throws Exception {
		 p=new Projection(0, 0.0, 0, 0, "no name","no date","no time") ;
	}
	@After
	public void tearDown() throws Exception {
		p=null;
	}
		
	@Test
	public void test_setpId() {
		p.setpId(1);
		assertEquals(Integer.valueOf(1),p.getpId());
	}

	@Test
	public void test_setTicketPrice() {
		p.setTicketPrice(1.1);
		assertEquals(Double.valueOf(1.1),p.getTicketPrice());
	}
	
	@Test
	public void test_setTicketsSold() {
		p.setTicketsSold(100);
		assertEquals(Integer.valueOf(100),p.getTicketsSold());
	}
	
	@Test
	public void test_setpMovie() {
		p.setpMovie(10);
		assertEquals(Integer.valueOf(10),p.getpMovie());
	}
	@Test
	public void test_setpTheaterString() {
		p.setpTheaterString("New Theater");
		assertEquals("New Theater",p.getpTheaterString());
	}
	
	@Test
	public void test_setpDateString() {
		p.setpDateString("1/2/2020");
		assertEquals("1/2/2020",p.getpDateString());
	}
	
	@Test
	public void test_setpTimeProjectedString() {
		p.setpTimeProjectedString("14:20");
		assertEquals("14:20",p.getpTimeProjectedString());
	}
}



