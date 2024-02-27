package humans;

import humans.states.State;
import items.Item;

import enums.Direction;
import places.types.PlaceType;

public class Pascow extends Human {

	public Pascow(int x, int y) {
		super("Pascow", x, y);
	}

	public void beBrought(PlaceType place, Item item) {
		setState(State.DYING);
		System.out.printf("%s had been brought into the %s, %s in a %s.", name, place, state, item.toString());
	}
		
}
