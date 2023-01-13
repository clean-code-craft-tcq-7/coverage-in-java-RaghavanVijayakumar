package TypewiseAlert;

public class TypewiseAlert {
	public static void checkAndAlert(AlertTarget alertTarget, BatteryCharacter batteryChar, double temperatureInC) {

		BreachType breachType = BreachAnalyzer.classifyTemperatureBreach(batteryChar.coolingType, temperatureInC);
 
		if(alertTarget==AlertTarget.TO_CONTROLLER) {
			AlertTarget.sendToController(breachType);
		}else {
			AlertTarget.sendToEmail(breachType);
		}
	
	}

}
