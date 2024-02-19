package items;

import interfaces.Dirtiable;
import items.states.ItemState;

public class Blanket extends Item implements Dirtiable {

    public Blanket(int x, int y) {
        super(3, x, y);
    }

    @Override
    public String toString() {
        return "blanket";
    }

    public void beOkay() {
        setState(ItemState.CLEAN);
        this.decreaseDirtiness(5);
        System.out.printf("%s was okay.", this.toString());
    }
    private int dirtinessLevel;

    @Override
    public void adjustDirtiness(int level) {
        dirtinessLevel += level;
        System.out.printf("Dirtiness level adjusted: %d%n", dirtinessLevel);
    }

    @Override
    public void decreaseDirtiness(int level) {
        dirtinessLevel -= level;
        System.out.printf("Dirtiness level decreased: %d%n", dirtinessLevel);
    }
}
