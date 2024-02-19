package humans;

import bodyparts.Arm;
import bodyparts.*;
import bodyparts.Eyes;
import bodyparts.states.ArmType;
import bodyparts.states.BodyPartState;
import exceptions.ArmException;
import exceptions.HumanNotCarryingAnythingException;
import exceptions.TooHeavyException;
import humans.states.*;
import interfaces.Jerkable;
import interfaces.Sayable;
import interfaces.Seeable;
import interfaces.Thinkable;
import items.Item;

import enums.Direction;
import places.Place;
import places.types.PlaceType;

import javax.print.attribute.standard.MediaSize;

public class Louis extends Human implements Sayable, Seeable, Jerkable, Thinkable {
	
	public Eyes eyes;
	public Arm arm;
	public Heart heart;
	public Legs legs;
	public Legs.Feet feet;
	public Head head;
	public Head.Tongue tongue;
	public Head.Teeth teeth;
	public Louis() {
		super("Louis");
		this.eyes = new Eyes();
		this.arm = new Arm();
		this.heart = new Heart();
		this.legs = new Legs();
		this.feet = new Legs.Feet();
		this.head = new Head();
		this.tongue = new Head.Tongue();
		this.teeth = new Head.Teeth();
	}

	public void push(Direction direction, Item item) throws TooHeavyException {
		setState(State.MOVING);
		this.takeItem(item);
		this.moveItem(Direction.BACK, item);
		this.dropItem(item);
		System.out.printf("%s pushed %s the %s", name, direction, item.toString());
	}
	public void swing(BodyPart bodyPart, Direction direction, String description, Item item) {
		setState(State.MOVING);
		legs.setLiftHeight(4);
		feet.setLiftHeight(5);
		System.out.printf(" and swung his %s %s onto the nubs of the %s %s, ", bodyPart.toString(), direction, description, item.toString());
		legs.setLiftHeight(1);
		feet.setLiftHeight(1);
	}
	public void tell(String person) {
		setFeeling(Feeling.ANXIETY);
		setState(State.READY);
		System.out.printf("%s to tell %s he'd skip the eggs, just a bowl of cereal and he'd run...", this.state, person);
	}
	public void kick(BodyPart bodyPart1, String description, BodyPart bodyPart2, String description2, Direction direction) {
		setState(State.MOVING);
		legs.setBendDegree(180);
		System.out.printf("%s fast, %s %s, %s %s unfeelingly, he kicked the covers all the way %s.", state, bodyPart1.toString(), description, bodyPart2.toString(), description2, direction);
	}
	@Override
	public void see(String sight) {
		System.out.printf("%s saw %s.", name, sight);
	}
	public void lookAt(String bodyPart) throws ArmException {
		setFeeling(Feeling.FEAR);
		setState(State.OBSERVING);
		arm.setType(ArmType.getRandomArmType());
		head.turnHead(Direction.RIGHTWAY);
		{
			System.out.printf("and suddenly he looked at his %s. There was a scratch there on the bicep, a fresh scratch, exactly where the dead branch had poked him. in the dream", bodyPart);
		}
	}
	public void canFeel() {
		setFeeling(Feeling.HORROR);
		heart.increaseHeartRate(10);
		System.out.print("And he could too; it was roaring up from inside, nothing but a big cold bullet of fear.");
	}
	public void think(String thoughts1, String thoughts2) {
		setState(State.THINKING);
		System.out.printf("%s, he thought-%s.%n", thoughts1, thoughts2);
	}
	public void grapple() {
		setFeeling(Feeling.SELFSOOTHING);
		setState(State.GRAPPLING);
		heart.decreaseHeartRate(5);
		System.out.printf("%s grappled for himself in those two or three seconds; he fought grimly for himself just as he had done in those moments of roaring confusion after ", name);
	}
	public void win() {
		heart.decreaseHeartRate(5);
		setFeeling(Feeling.RELIEF);
		System.out.print("He won.");
	}
	@Override
	public void say(String speech) {
		setState(State.TALKING);
		System.out.printf("'%s,' %s said", speech, name);
	}
	public void bite(BodyPart bodyPart) {
		tongue.bleed(bodyPart);
		System.out.printf("%s bit his %s", name, bodyPart);
	}
	public void wonder(String thoughts) {
		setState(State.THINKING);
		System.out.printf("His mind swirled, and somewhere deep inside, away from the action, he wondered %s.", thoughts);
	}
	public void seeInDark(String human, String bodyPart) {
		eyes.close(name, eyes.toString());
		System.out.printf("In the darkness he saw %s's %s", human, bodyPart);
		eyes.open(name, eyes.toString());
	}
	public void beginToMove(Place place) {
		setState(State.MOVING);
		this.moveWithinPlace(Direction.FROMSIDETOSIDE, place);
		System.out.printf("%s began to move rapidly, putting off any further thought.", name);
	}
	public void jerk(Direction direction, Item item) throws TooHeavyException{
		arm.setLiftHeight(5);
		arm.setBendDegree(30);
		this.takeItem(item);
		this.moveItem(direction, item);
		this.dropItem(item);
		arm.setBendDegree(180);
		arm.setLiftHeight(0);
		System.out.printf("He jerked %s %s.", item.toString(), direction);
	}
	public void tidy(Place startingPoint, Place destination, Direction direction, Item item) throws TooHeavyException {
		setState(State.TIDYING);
		arm.setLiftHeight(5);
		arm.setBendDegree(30);
		this.takeItem(item);
		System.out.printf("He separated %s the two %s and balled them up.", direction, item);
	}
    public void step(Place place, Direction direction, String other, String description) {
		setState(State.STANDING);
		this.moveWithinPlace(Direction.FORWARD, place);
		System.out.printf(" and stepped %s the %s %s.", direction, other, description);
	}
	public void wash(BodyPart bodyPart1, BodyPart bodyPart2) {
		setState(State.WASHING);
		legs.decreaseDirtiness(5);
		feet.decreaseDirtiness(5);
		legs.setBodyPartState(BodyPartState.CLEAN);
		feet.setBodyPartState(BodyPartState.CLEAN);
		legs.increaseWetness(5);
		feet.increaseWetness(5);
		System.out.printf("He washed the dirt from his %s and %s.", bodyPart1.toString(), bodyPart2.toString());
	}
	public void feelBetter() {
		setFeeling(Feeling.CONFIDENCE);
		System.out.print("He began to feel better, more in control.");
	}
	public void dryOff() {
		setState(State.DRYING);
		legs.decreaseWetness(5);
		feet.decreaseWetness(5);
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

