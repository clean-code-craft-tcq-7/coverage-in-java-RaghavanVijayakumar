package TypewiseAlert;

public enum AlertTarget {
	TO_CONTROLLER, TO_EMAIL;
	
	public static boolean raiseAlert(BreachType breachType) {
		return breachType!=BreachType.NORMAL;
	}

	public static void sendToController(BreachType breachType) {
		int header = 0xfeed;
		System.out.printf("%d : %s\n", header, breachType);
	}

	public static void sendToEmail(BreachType breachType) {
		String recepient = "a.b@c.com";
		if(raiseAlert(breachType))
			System.out.printf("To: %s\n", recepient);
			System.out.println(breachType.getMessage());
		}
	}

