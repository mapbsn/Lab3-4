package humans;

import humans.states.Feeling;
import humans.states.MentalState;
import humans.states.State;
import interfaces.Sayable;
import interfaces.Stoppable;
import enums.Direction;
import places.types.PlaceType;

public class Rachel extends Human implements Sayable, Stoppable {

	public Rachel(int x, int y) {
		super("Rachel", x, y);
	}

	@Override
	public void say(String speech) {
		setMentalState(MentalState.TALKING);
		System.out.printf("'%s,' %s called.%n", speech, name);
	}
	public void come(Direction direction, PlaceType place) {
		setFeeling(Feeling.ANXIETY);
		setState(State.WALKING);
		System.out.printf("%s was coming %s the %s", this.name, direction, place);
	}
	@Override
	public void stop(PlaceType place) {
		setFeeling(Feeling.RELIEF);
		setState(State.STANDING);
		System.out.printf("She had stopped on the %s. %n", place);
	}


	@Override
	public String getName() {
		return "Rachel";
	}
}
	
	