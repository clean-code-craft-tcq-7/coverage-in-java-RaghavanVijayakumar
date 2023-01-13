package TypewiseAlert;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlerterTest {
	private final ByteArrayOutputStream AlertMessage = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(AlertMessage));
	}

	@After
	public void cleanUpStreams() {
	  System.setOut(null);
	}
	
	
	@Test
    public void assertRaiseAlert()
    {
      assertTrue(AlertTarget.raiseAlert(BreachType.TOO_HIGH));
      assertTrue(AlertTarget.raiseAlert(BreachType.TOO_LOW));
      assertFalse(AlertTarget.raiseAlert(BreachType.NORMAL));
}
	
	public void assertController(BreachType breachType) {
		AlertTarget.sendToController(breachType);
		assertTrue(AlertMessage.toString().contains(breachType.toString()));
		AlertMessage.reset();
	}
	
	
	@Test
	public void assertSendController() {
		assertController(BreachType.TOO_HIGH);
		assertController(BreachType.TOO_LOW);
		assertController(BreachType.NORMAL);	
	}
	
	
	public void assertEmailcontent(BreachType breachType) {
		AlertTarget.sendToEmail(breachType);
		assertTrue(AlertMessage.toString().contains(breachType.getMessage()));
		AlertMessage.reset();
	}
	
	@Test
	
	public void assertSendEmail() {
		assertEmailcontent(BreachType.TOO_HIGH);
		assertEmailcontent(BreachType.TOO_LOW);
	}
}
