package humans.states;

public enum State {

    DEFAULT("default"),
    READY("ready"),
    OBSERVING("observing"),
    THINKING("thinking"),
    GRAPPLING("grappling"),
    TALKING("talking"),
    LAUGHING("laughing"),
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
