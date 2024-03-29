package items;

import exceptions.NullValueException;
import interfaces.CheckPlace;
import places.types.PlaceType;

import java.util.Objects;

public abstract class Item implements CheckPlace {
    protected String description = "";
    private final int weight;
    private int horizontalDistance;
    private int verticalDistance;
    protected PlaceType place;
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
    public PlaceType getPlace() {
        return place;
    }

    public void setPlace(PlaceType place) {
        this.place = place;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void checkPlace() {
        setPlace(null);
        PlaceType[] places = PlaceType.values();
        for (PlaceType place : places) {
            if (place.getX() == getX() && place.getY() == getY()) {
                setPlace(place);
            }
        }
        if (getPlace() == null) throw new NullValueException(
                String.format("%s is nowhere to find", this),null
        );
    }
    public int getHorizontalDistance() {
        return this.horizontalDistance;
    }
    public void setHorizontalDistance(int distance) {
        this.horizontalDistance = distance;
    }
    public int getVerticalDistance() {
        return this.verticalDistance;
    }
    public void setVerticalDistance(int distance) {
        this.verticalDistance = distance;
    }
    @Override
    public int hashCode() {
        return Objects.hash(toString(), getPlace(). getX(), getY());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return (obj instanceof Item item)
                && (toString().equals(item.toString()))
                && (place.equals(item.place));
    }
}
