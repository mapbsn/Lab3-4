package bodyparts;

import bodyparts.states.BodyPartState;
import interfaces.Dirtiable;

public class Legs extends BodyPart implements Dirtiable {

	 public Legs() {
	}

	@Override
	public String toString() {
		return "legs";
	}
	protected int liftHeight;
	protected int bendDegree;
	 {
	 liftHeight = 0;
	 bendDegree = 30;}
	public int getLiftHeight() {
		return liftHeight;
	}
	public void setLiftHeight(int newHeight) {
		this.liftHeight = newHeight;
	}
	public int getBendDegree() {
		 return bendDegree;
	}

	public void setBendDegree(int degree) {
		this.bendDegree = degree;
	}

	private int dirtinessLevel;

	public void adjustDirtiness(int level) {
		dirtinessLevel += level;
		System.out.printf("Dirtiness level adjusted: %d%n", dirtinessLevel);
	}

	public void decreaseDirtiness(int level) {
		dirtinessLevel -= level;
		System.out.printf("Dirtiness level decreased: %d%n", dirtinessLevel);
	}
	private int wetnessLevel;
	public void increaseWetness(int level) {
		wetnessLevel += level;
		System.out.printf("Wetness level increased: %d%n", wetnessLevel);
	}
	public void decreaseWetness(int level) {
		wetnessLevel -= level;
		System.out.printf("Wetness level decreased: %d%n", wetnessLevel);
	}

	public static class Feet extends Legs {

		public Feet(){
		}

		@Override
		public String toString() {
			return "feet";
		}

		public void beFilthy() {
			adjustDirtiness(5);
			setBodyPartState(BodyPartState.DIRTY);
			System.out.printf("His feet were filthy with dirt and pine needles..%n");
		}
	}
}
