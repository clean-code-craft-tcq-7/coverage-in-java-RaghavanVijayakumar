package TypewiseAlert;

public enum CoolingType {
	   PASSIVE_COOLING(0,35),
	      HI_ACTIVE_COOLING(0,45),
	      MED_ACTIVE_COOLING(0,40);

	public final int lower_limit;
	public final int upper_limit;
	
		CoolingType(int lower_limit, int upper_limit) {
			this.lower_limit=lower_limit;
			this.upper_limit=upper_limit;
		}

		 public int getUpperLimit() {
		        return upper_limit;
		    }
		 
		 public int getLowerLimit() {
		        return lower_limit;
		    }
}
