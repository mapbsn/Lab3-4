package items;

import interfaces.Dirtiable;
import items.states.ItemState;

public class Bed extends Item implements Dirtiable {


    public Sheets sheets;
    public Needles needles;
    public Bed() {
        super(40, 1, 10);
        this.sheets = new Sheets(1, 10);
        this.needles = new Needles(-100, 0);
    }

    public void littered() {
        setState(ItemState.DIRTY);
        this.adjustDirtiness(5);
        needles.setX(this.getX());
        needles.setY(this.getY());
        System.out.printf("The foot of the %s was littered with %s.", this.toString(), needles.toString());
    }
    private int dirtinessLevel;

    @Override
    public String toString() {
        return "bed";
    }

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
