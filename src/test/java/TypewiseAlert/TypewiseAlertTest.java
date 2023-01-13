package TypewiseAlert;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TypewiseAlertTest 
{
    @Test
    public void infersBreachAsPerLimits()
    {
      assertTrue(BreachAnalyzer.inferBreach(12, 20, 30) == BreachType.TOO_LOW);
      assertTrue(BreachAnalyzer.inferBreach(35, 10, 35) == BreachType.NORMAL);
      assertTrue(BreachAnalyzer.inferBreach(45, 10, 40) == BreachType.TOO_HIGH);
      assertTrue(BreachAnalyzer.inferBreach(10, 10, 30) == BreachType.NORMAL);
      assertFalse(BreachAnalyzer.inferBreach(45, 10, 30) == BreachType.NORMAL);
      assertFalse(BreachAnalyzer.inferBreach(12, 20, 30) == BreachType.NORMAL);
    }
}
