package humans;

import enums.Direction;
import exceptions.HumanNotCarryingAnythingException;
import exceptions.TooHeavyException;
import humans.states.*;
import items.Item;
import places.Place;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Human {
	
	public final String name;
	protected State state = State.DEFAULT;
	protected Feeling feeling = Feeling.DEFAULT;

	private Item carriedItem;
	private int itemCount = 0;

	protected Human(String name) {
		this.name = name;
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
	 protected void setFeeling(Feeling feeling) {
		 this.feeling = feeling;
	 }
	protected Feeling getFeeling() {
		return this.feeling;
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
	public void moveItem(Direction direction, Item... i) {
		if (carriedItem == null) {
			throw new HumanNotCarryingAnythingException(
					String.format("%s isn't carrying anything", this.getName())
			);
		}
		for (Item item : i) {
			carriedItem = item;
			switch (direction) {
				case RIGHTWAY -> {
					item.setPosition(item.getX() + 1, item.getY());
				}
				case LEFTWAY -> {
					item.setPosition(item.getX() - 1, item.getY());
				}
				case BACK -> {
					item.setPosition(item.getX(), item.getY() - 1);
				}
				case FORWARD -> {
					item.setPosition(item.getX(), item.getY() + 1);
				}
			}
			System.out.printf("%s moved %s", name, item);
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
	public void move(Place startingPoint, Place destination) {
		startingPoint.leave(this);
		System.out.printf("%s went from %s to %s%n", this.getName(), startingPoint, destination);
		destination.appearAt(this);
	}

	public void moveWithinPlace(Direction direction, Place place) {
		System.out.printf("%s was moving %s in the %s%n", name, direction, place);
	}


	@Override
	public int hashCode() {
		return Objects.hash(name, getFeeling(),
				getState());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		return (obj instanceof Human human)
				&& (feeling.equals(human.feeling)
				&& state.equals(human.state)
				&& name.equals(human.name));
	}
 
}