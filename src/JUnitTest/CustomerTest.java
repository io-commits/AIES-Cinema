package JUnitTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import Auxiliry.Customer;


public class CustomerTest {

	private Customer c;
	
	@Before
	public void setUp() throws Exception {
		c = new Customer (0,"initilaze");
	}
	@After
	public void tearDown() throws Exception {
		c=null;
	}

	@Test
	public void test_getcId_and_setcId() {
		c.setcId(1);
		assertEquals(Integer.valueOf(1),c.getcId());
	}
	
	@Test
	public void test_getCustomerNameString_and_setCustomerNameString() {
		c.setCustomerName("jacob");
		assertEquals("jacob",c.getCustomerName());
	}

}
