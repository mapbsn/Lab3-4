package humans;

import bodyparts.Eyes;
import humans.states.State;
import items.Item;
import places.Place;

import enums.Direction;

public class Pascow extends Human {

	public Eyes eyes;
	public Pascow() {
		super("Pascow");
		this.eyes = new Eyes();
	}

	public void beBrought(Direction direction, Place place, Item item) {
		setState(State.DYING);
		System.out.printf("%s had been brought %s the %s, %s in a %s.", name, direction, place.toString(), state, item.toString());
	}
		
}
