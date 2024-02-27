package humans.states;

public enum Feeling {

	DEFAULT(0),
	ANXIETY(3),
	FEAR(7),
	HORROR(10),
	SELF_SOOTHING(4),
	RELIEF(2),
	CONFIDENCE(1),
	HAPPY(0);

    private final int fear;
	Feeling(int fear) {
		this.fear = fear;
    }
	public int getFear() {
		return fear;
	}
}
