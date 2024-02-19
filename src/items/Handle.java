package items;

public class Handle extends Item {

    public Handle(int x, int y) {
        super(3, x, y);
    }

    @Override
    public String toString() {
        return "handle";
    }

    public String getDescription() {
        return "the shower handle on";
    }
}
