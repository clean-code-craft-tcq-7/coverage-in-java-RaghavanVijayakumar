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
    
    @Test
    public void assertCoolingTypelimit()
    {
      assertSame(CoolingType.PASSIVE_COOLING.upper_limit,35);
      assertSame(CoolingType.PASSIVE_COOLING.lower_limit,0);
      assertSame(CoolingType.HI_ACTIVE_COOLING.lower_limit,0);
      assertSame(CoolingType.HI_ACTIVE_COOLING.upper_limit,45);
      assertSame(CoolingType.MED_ACTIVE_COOLING.lower_limit,0);
      assertSame(CoolingType.MED_ACTIVE_COOLING.upper_limit,40);
    }
    
    @Test
    public void assertBreachTypemessage()
    {
    assertTrue(BreachType.NORMAL.message=="Temperature is normal");
    assertTrue(BreachType.TOO_HIGH.message=="Hi, the temperature is too high");
    assertTrue(BreachType.TOO_LOW.message=="Hi, the temperature is too low");
    }
}
