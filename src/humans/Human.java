package humans;

import humans.states.*;
import items.Item;
import places.Place;

import java.util.Objects;

public abstract class Human {
	
	public final String name;
	protected State state = State.DEFAULT;
	protected Feeling feeling = Feeling.DEFAULT;

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
	public void changePlace(Place start, Place destination) {
		start.leave(this);
		System.out.printf("%s went from %s to %s.", name, start, destination);
		destination.appearAt(this);
	}

	public void takeItem(Item item, Place start) {
		start.deleteItem(item);
		System.out.printf("%s took %s", name, item);
	}

	public void dropItem(Item item, Place destination) {
		destination.placeItem(item);
		System.out.printf("%s dropped %s", name, item);
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