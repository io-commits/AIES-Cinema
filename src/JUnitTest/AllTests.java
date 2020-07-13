package JUnitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CustomerTest.class, InputVerifacatorTest.class, MovieTest.class, ProjectionTest.class, SeatTest.class,
		TicketTest.class })
public class AllTests {

}
