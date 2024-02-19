package items;

import humans.Human;
import items.states.ItemState;
import java.util.Objects;

public abstract class Item {
    protected String description = "";
    protected ItemState state = ItemState.DEFAULT;
    private final int weight;
    private int x;
    private int y;

    protected Item(int weight, int x, int y) {
        this.weight = weight;
        this.x = x;
        this.y = y;
    }

    public abstract String toString();

    public String getDescription() {
        return description;
    }
    public int getWeight() {
        return weight;
    }
    protected void setState(ItemState state) {
        this.state = state;
    }
    protected ItemState getState() {
        return state;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int newX) {
        this.x = newX;
    }
    public void setY(int newY) {
        this.y = newY;
    }
    public int[] getPosition(int[] position) {
        return new int[]{x, y};
    }

    public void setPosition(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toString(), getState());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return (obj instanceof Item item)
                && (toString().equals(item.toString()))
                && (state.equals(item.state));
    }
}
