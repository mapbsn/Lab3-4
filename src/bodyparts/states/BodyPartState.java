package bodyparts.states;

public enum BodyPartState {
	
	DEFAULT("default"),
	DIRTY("dirty"),
	CLEAN("clean"),
	INJURED("injured");
	
	private final String state;
	BodyPartState(String state) {
		this.state = state;	
	}
	
	@Override
	public String toString() {
        return this.state;
    }

}
