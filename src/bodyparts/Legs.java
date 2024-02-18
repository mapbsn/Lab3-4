package bodyparts;

import bodyparts.states.BodyPartState;

public class Legs extends BodyPart {

	 public Legs(String name) {
		super(name);
	}

	public static class Feet extends Legs {

		public Feet(String name) {
			super(name);
		}

		public void beFilthy() {
			setBodyPartState(BodyPartState.DIRTY);
			System.out.printf("His feet were filthy with dirt and pine needles..%n");
		}
	}
}
