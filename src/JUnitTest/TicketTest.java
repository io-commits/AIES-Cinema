package JUnitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import Auxiliry.Customer;
import Auxiliry.Projection;
import Auxiliry.Seat;
import Auxiliry.Ticket;

public class TicketTest {
	private Ticket t;
	@Before
	public void setUp() throws Exception {
		t=new Ticket(0,new Seat(1,1),new Projection(0, 0.0, 0, 0, "no name","no date","no time"),new Customer (0,"initilaze"));
	}

	@After
	public void tearDown() throws Exception {
		t=null;
	}

	@Test
	public void test_setTicketId() {
		t.setTicketId(15);
		assertEquals(Integer.valueOf(15),t.getTicketId());
	}
	
	@Test
	public void test_settSeat() {
		Seat s=new Seat(2,5);
		t.settSeat(s);
		assertSame(s,t.gettSeat());
	}
	
	@Test
	public void test_settProjection() {
		Projection p=new Projection(3, 11.5, 20, 5, "Superbad","1/2/2015","14:30");
		t.settProjection(p);
		assertSame(p,t.gettProjection());
	}

	@Test
	public void test_settCustomError() {
		Customer c=new Customer(11,"Jackson King");
		t.setCustomer(c);
		assertSame(c,t.getCustomer());
	}
}





