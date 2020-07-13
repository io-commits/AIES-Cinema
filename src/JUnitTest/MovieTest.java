package JUnitTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import Auxiliry.Movie;

public class MovieTest {

	private Movie m;
	@Before
	public void setUp() throws Exception {
		m=new Movie(0, 0, 0.0, "no name", "no director","no desc");
	}
	@After
	public void tearDown() throws Exception {
		m=null;
	}

	
	@Test
	public void test_setmId() {
		m.setmId(1);
		assertEquals(Integer.valueOf(1),m.getmId());
	}
	@Test
	public void test_setYearPublished() {
		m.setYearPublished(2019);
		assertEquals(Integer.valueOf(2019),m.getYearPublished());
	}
	@Test
	public void test_setDuration() {
		m.setDuration(3.5);
		assertEquals(Double.valueOf(3.5),m.getDuration());
	}
	@Test
	public void test_setTicketsSold() {
		m.setTicketsSold(20);
		assertEquals(Integer.valueOf(20),m.getTicketsSold());
	}
	@Test
	public void test_setMoneyEarned() {
		m.setMoneyEarned(1000.1);
		assertEquals(Double.valueOf(1000.1),m.getMoneyEarned());
	}
	
	@Test
	public void test_setMovieName() {
		m.setMovieName("Shrek");
		assertEquals("Shrek",m.getMovieName());
	}
	
	@Test
	public void test_setDirector() {
		m.setDirector("Hayao Miyazaki");
		assertEquals("Hayao Miyazaki",m.getDirector());
	}
	@Test
	public void test_setDescription() {
		m.setDescription("Awesome movie");
		assertEquals("Awesome movie",m.getDescription());
	}
}




