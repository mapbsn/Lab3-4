package humans;

import bodyparts.BodyPart;
import bodyparts.states.ArmType;
import bodyparts.states.BodyPartState;
import humans.states.*;
import interfaces.Jerkable;
import interfaces.Sayable;
import interfaces.Seeable;
import interfaces.Thinkable;
import items.Item;

import enums.Direction;

public class Louis extends Human implements Sayable, Seeable, Jerkable, Thinkable {
	
	public Louis(String name) {
		super(name);
	}

	public void push(Direction direction, String item) {
		setState(State.MOVING);
		System.out.printf("%s pushed %s the %s", name, direction, item);
	}
	public void swing(Direction direction, String description, String item) {
		System.out.printf(" and swung his feet %s onto the nubs of the %s %s, ", direction, description, item);
	}
	public void tell(String person) {
		setFeeling(Feeling.ANXIETY);
		setState(State.READY);
		System.out.printf("%s to tell %s he'd skip the eggs, just a bowl of cereal and he'd run...", this.state, person);
	}
	public void kick(Direction direction) {
		setState(State.MOVING);
		System.out.printf("%s fast, eyes bulging, teeth clamped unfeelingly, he kicked the covers all the way %s.", state, direction);
	}
	@Override
	public void see(String sight) {
		System.out.printf("%s saw %s.", name, sight);
	}
	public void lookAt(String bodyPart) {
		setFeeling(Feeling.FEAR);
		setState(State.OBSERVING);
		Runnable run = () -> System.out.printf("and suddenly he looked at his %s.", bodyPart);
	}
	public void canFeel() {
		setFeeling(Feeling.HORROR);
		System.out.print("And he could too; it was roaring up from inside, nothing but a big cold bullet of fear.");
	}
	public void think(String thoughts1, String thoughts2) {
		setState(State.THINKING);
		System.out.printf("%s, he thought-%s.%n", thoughts1, thoughts2);
	}
	public void grapple() {
		setFeeling(Feeling.SELFSOOTHING);
		setState(State.GRAPPLING);
		System.out.printf("%s grappled for himself in those two or three seconds; he fought grimly for himself just as he had done in those moments of roaring confusion after ", name);
	}
	public void win() {
		setFeeling(Feeling.RELIEF);
		System.out.print("He won.");
	}
	@Override
	public void say(String speech) {
		setState(State.TALKING);
		System.out.printf("'%s,' %s said", speech, name);
	}
	public void wonder(String thoughts) {
		setState(State.THINKING);
		System.out.printf("His mind swirled, and somewhere deep inside, away from the action, he wondered %s.", thoughts);
	}
	public void close(String bodyPart) {
		System.out.printf("He closed his %s briefly in %s, but in the darkness", bodyPart, this.feeling);
	}
	public void move() {
		setState(State.MOVING);
		System.out.printf("%s began to move rapidly, putting off any further thought.", name);
	}
	public void jerk(String item) {
		System.out.printf("He jerked %s.", item);
	}
	public void tidy(Direction direction, String item) {
		setState(State.TIDYING);
		System.out.printf("He separated %s the two %s and balled them up.", direction, item);
	}
    public void step(Direction direction, String item, String description) {
		setState(State.STANDING);
		System.out.printf(" and stepped %s the %s %s.", direction, item, description);
	}
	public void wash(String bodyPart1, String bodyPart2, BodyPartState state) {
		setState(State.WASHING);
		System.out.printf("He washed the dirt from his %s and %s.", bodyPart1, bodyPart2);
	}
	public void feelBetter() {
		setFeeling(Feeling.CONFIDENCE);
		System.out.print("He began to feel better, more in control.");
	}
	public void dryOff() {
		setState(State.DRYING);
		System.out.printf("%s off, it struck him that this was how murderers must feel when they believe they have gotten rid of all the evidence.", state);
	}
	public void laugh() {
		setFeeling(Feeling.HAPPY);
		setState(State.LAUGHING);
		System.out.print("He began to laugh.");
	}
	public void goOn(State state1, State state2) {
		System.out.printf("He went on %s himself, but he also went on %s. He couldn't seem to stop.", state1, state2);
	}
}

