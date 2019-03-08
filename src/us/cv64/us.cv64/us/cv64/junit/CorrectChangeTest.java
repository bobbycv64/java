package us.cv64.junit;

	import org.junit.Before;
	import org.junit.Ignore;
	import org.junit.Test;

	public class CorrectChangeTest {

		private static CorrectChange correctChange = null;

		// Before the JUnit executes - do some setup
		@Before
		public void setUp() throws Exception {
			correctChange = new CorrectChange();
		}

		@Test
		public void getCents() throws Exception {
			correctChange.setCents(5344);
			correctChange.getCents();
		}
	}