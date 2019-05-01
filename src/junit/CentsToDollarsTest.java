package junit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CentsToDollarsTest {

	private static CentsToDollars centsToDollars = null;

	// Before the JUnit executes - do some setup
	@Before
	public void setUp() throws Exception {
		centsToDollars = new CentsToDollars();
	}

	@Test
	public void getCents() throws Exception {
		centsToDollars.setCents(5344);
		System.out.println("getCents: " + centsToDollars.getCents());
	}

	@Test
	public void getDollars() throws Exception {
		centsToDollars.setCents(5344);
		System.out.println("getDollars: " + centsToDollars.getDollars());
	}

	@Ignore
	public void printResults() throws Exception {
		centsToDollars.setCents(327);
		centsToDollars.printResults();
	}
}