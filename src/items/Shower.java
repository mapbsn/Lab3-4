package items;

import others.Water;

public class Shower extends Item {
    public Water water;
    public Handle handle;
    public Shower(int x, int y) {
        super(100, x, y);
        this.water = new Water();
        this.handle = new Handle(x, y);
    }
    @Override
    public String toString() {
        return "shower";
    }
}
