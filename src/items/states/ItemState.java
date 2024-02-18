package items.states;

public enum ItemState {

    DEFAULT("default"),
    DIRTY("dirty"),
    TOSSED("tossed");

    private final String state;
    ItemState(String state) { this.state = state;
    }
    @Override
    public String toString() {
        return this.state;
    }
}