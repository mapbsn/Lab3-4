package humans;

import enums.Direction;
import exceptions.HumanNotCarryingAnythingException;
import exceptions.InvalidPlaceException;
import exceptions.TooHeavyException;
import humans.states.*;
import interfaces.CheckPlace;
import items.Item;
import places.types.PlaceType;

import java.util.Objects;

public abstract class Human implements CheckPlace {
	
	public final String name;
	private int x;
	private int y;
	protected PlaceType place;
	protected State state = State.DEFAULT;
	protected MentalState mentalState = MentalState.DEFAULT;
	protected Feeling feeling = Feeling.DEFAULT;

	private Item carriedItem;

	protected Human(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	 public String getName() {
	        return name;
	    }
	 
	 protected void setState(State state) {
		this.state = state;
     }
	 protected State getState() {
		return this.state;
	 }
	 protected void setMentalState(MentalState mentalState) {this.mentalState = mentalState;}
	 protected MentalState getMentalState() {return this.mentalState;}
	 protected void setFeeling(Feeling feeling) {
		 this.feeling = feeling;
	 }
	protected Feeling getFeeling() {
		return this.feeling;
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
		System.out.printf("%s is now in the %s", this.name, this.place);
		if (getPlace() == null) throw new InvalidPlaceException(
				String.format("%s is nowhere to find", this.name)
		);
	}
	public void move(Direction direction) {
		switch(direction) {
			case RIGHTWAY -> {
				setX(getX() + 1);
				setY(getY());
			}
			case LEFTWAY -> {
				setX(getX() - 1);
				setY(getY());
			}
			case UP -> {
				setX(getX());
				setY(getY() + 1);
			}
			case DOWN -> {
				setX(getX());
				setY(getY() - 1);
			}
		}
		System.out.printf("%s moved %s", this.name, direction);
	}
	public void takeItem(Item... i) throws TooHeavyException {
		int weight = 0;
		for (Item item : i) {
			carriedItem = item;
			weight += carriedItem.getWeight();}
		if (weight >= 15) throw new TooHeavyException(String.format("Too heavy for %s", this.getName())
		);
		else {
			System.out.printf("%s took %s", name, carriedItem);
		}

	}
	public void carryItem(Item... i) {
		if (carriedItem == null) {
			throw new HumanNotCarryingAnythingException(
					String.format("%s isn't carrying anything", this.getName())
			);
		}
		for (Item item : i) {
			item.setX(this.getX());
			item.setY(this.getY());
		}
	}

	public void moveItem(Direction direction, Item... i) {
		if (carriedItem == null) {
			throw new HumanNotCarryingAnythingException(
					String.format("%s isn't carrying anything", this.getName())
			);
		}
		for (Item item : i) {
			switch(direction) {
				case FORWARD -> {
					item.setHorizontalDistance(0);
				}
				case BACK -> {
					item.setHorizontalDistance(5);
				}
				case UP -> {
					item.setVerticalDistance(5);
				}
				case DOWN -> {
					item.setVerticalDistance(-5);
				}
			}
		}
	}

	public void dropItem(Item... i) {
		if (carriedItem == null) {
			throw new HumanNotCarryingAnythingException(
					String.format("%s isn't carrying anything", this.getName()));}
		int weight = carriedItem.getWeight();
		for (Item item : i) {
			weight -= carriedItem.getWeight();
			carriedItem = null;
			System.out.printf("%s dropped %s", name, item);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, getFeeling(),
				getState(), getMentalState(), getPlace(), getX(), getY());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		return (obj instanceof Human human)
				&& (feeling.equals(human.feeling)
				&& state.equals(human.state)
				&& mentalState.equals(human.mentalState)
				&& place.equals(human.place)
				&& name.equals(human.name));
	}
 
}