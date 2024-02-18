package humans;

import humans.states.State;
import places.Place;

import enums.Direction;

public class Pascow extends Human {

	public Pascow(String name) {
		super(name);
	}

	public void beBrought(Direction direction, String place, String item) {
		setState(State.DYING);
		System.out.printf("%s had been brought %s the %s, %s in a %s.", name, direction, place, state, item);
	}
		
}
