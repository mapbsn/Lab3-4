package humans.states;

public enum MentalState {
    DEFAULT("default"),
    READY("ready"),
    THINKING("thinking"),
    TALKING("talking"),
    LAUGHING("laughing"),
    GRAPPLING("grappling");

    private final String mentalState;
    MentalState(String mentalState) {this.mentalState = mentalState;}
    @Override
    public String toString() {
        return this.mentalState;
    }
}
