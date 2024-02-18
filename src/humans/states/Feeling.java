package humans.states;

public enum Feeling {
	
	DEFAULT("default"),
	ANXIETY("anxiety"),
	FEAR("fear"),
	HORROR("horror"),
	RELIEF("relief"),
	SELFSOOTHING("self-soothing"),
	CONFIDENCE("confidence"),
	HAPPY("happy");
	
	private final String feeling;
	Feeling(String feeling) {
		this.feeling = feeling;
	}
	
	@Override
	public String toString() {
		return this.feeling;
	}

}
