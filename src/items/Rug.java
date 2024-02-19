package items;

public class Rug extends Item {


    public Rug(int x, int y) {
        super(3, x, y);
    }


    @Override
    public String toString() {
        return "rug";
    }

    @Override
    public String getDescription() {
        return "hooked";
    }
}
