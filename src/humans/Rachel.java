package humans;

import humans.states.Feeling;
import humans.states.State;
import interfaces.Sayable;
import interfaces.Stoppable;
import places.Place;
import enums.Direction;

public class Rachel extends Human implements Sayable, Stoppable {

	public Rachel(String name) {
		super(name);
	}

	@Override
	public void say(String speech) {
		setState(State.TALKING);
		System.out.printf("'%s,' %s called.%n", speech, name);
	}
	public void come(Direction direction, String place) {
		setFeeling(Feeling.ANXIETY);
		setState(State.WALKING);
		System.out.printf("%s was coming %s the %s.%n", name, direction, place);
	}
	@Override
	public void stop(String place) {
		setFeeling(Feeling.RELIEF);
		setState(State.STANDING);
		System.out.printf("She had stopped on the second or third %s. %n", place);
	}





}
	
	