package humans.states;

public enum State {

    DEFAULT("default"),
    OBSERVING("observing"),
    MOVING("moving"),
    WALKING("walking"),
    TIDYING("tidying"),
    DRYING("drying"),
    WASHING("washing"),
    STANDING("standing"),
    DYING("dying");

    private final String state;
    State(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return this.state;
    }
}
