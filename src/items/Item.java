package items;

import humans.Human;
import items.states.ItemState;
import java.util.Objects;

public abstract class Item {

    public final String name;
    protected String description = "";
    protected ItemState state = ItemState.DEFAULT;


    protected Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    protected void setState(ItemState state) {
        this.state = state;
    }

    protected ItemState getState() {
        return state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getState());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return (obj instanceof Item item)
                && (state.equals(item.state)
                && name.equals(item.name));
    }
}
