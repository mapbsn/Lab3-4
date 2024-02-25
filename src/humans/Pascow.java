package humans;

import bodyparts.Eyes;
import humans.states.State;
import items.Item;

import enums.Direction;
import places.types.PlaceType;

public class Pascow extends Human {

	public Eyes eyes;
	public Pascow(int x, int y) {
		super("Pascow", x, y);
		this.eyes = new Eyes();
	}

	public void beBrought(Direction direction, PlaceType place, Item item) {
		setState(State.DYING);
		System.out.printf("%s had been brought %s the %s, %s in a %s.", name, direction, place, state, item.toString());
	}
		
}
