package humans;

import bodyparts.*;
import exceptions.TooHeavyException;
import humans.states.*;
import interfaces.Jerkable;
import interfaces.Sayable;
import interfaces.Seeable;
import interfaces.Thinkable;
import items.Item;

import enums.Direction;

public class Louis extends Human implements Sayable, Seeable, Jerkable, Thinkable {
	
	public Body body;
	public Louis(int x, int y) {
		super("Louis", x, y);
		this.body = new Body();
	}

	public void push(Direction direction, Item item) throws TooHeavyException {
		setState(State.MOVING);
		this.takeItem(item);
		this.moveItem(Direction.BACK);
		this.dropItem(item);
		System.out.printf("%s pushed %s the %s", name, direction, item.toString());
	}
	public void swing(String description, Item item) {
		setState(State.MOVING);
		body.leftLeg.setLiftHeight(4);
		body.rightLeg.setLiftHeight(4);
		System.out.printf(" and swung his feet out onto the nubs of the %s %s, ", description, item.toString());
		body.leftLeg.setLiftHeight(1);
		body.rightLeg.setLiftHeight(1);
	}
	public void tell(String person) {
		setFeeling(Feeling.ANXIETY);
		setMentalState(MentalState.READY);
		System.out.printf("%s to tell %s he'd skip the eggs, just a bowl of cereal and he'd run...", this.mentalState, person);
	}
	public void kick(String bodyPart, String description, Item item, Direction direction) throws TooHeavyException {
		setState(State.MOVING);
		body.leftLeg.setBendDegree(180);
		body.rightLeg.setBendDegree(180);
		takeItem(item);
		moveItem(Direction.BACK);
		System.out.printf("%s fast, eyes bulging, %s %s, he kicked the %s all the way %s.", state, bodyPart, description, item, direction);
		dropItem(item);
	}
	@Override
	public void see(String sight) {
		System.out.printf("%s saw %s.", name, sight);
	}
	public void lookAt(String bodyPart) {
		setFeeling(Feeling.FEAR);
		setState(State.OBSERVING);
		body.head.turnHead(Direction.RIGHT);
		System.out.printf("and suddenly he looked at his %s. There was a scratch there on the bicep, a fresh scratch, exactly where the dead branch had poked him. in the dream", bodyPart);

	}
	public void canFeel() {
		setFeeling(Feeling.HORROR);
		body.heart.increaseHeartRate(10);
		System.out.print("And he could too; it was roaring up from inside, nothing but a big cold bullet of fear.");
	}
	public void think(String thoughts1, String thoughts2) {
		setMentalState(MentalState.THINKING);
		System.out.printf("%s, he thought-%s.%n", thoughts1, thoughts2);
	}
	public void grapple() {
		setFeeling(Feeling.SELF_SOOTHING);
		setMentalState(MentalState.GRAPPLING);
		body.heart.decreaseHeartRate(5);
		System.out.printf("%s grappled for himself in those two or three seconds; he fought grimly for himself just as he had done in those moments of roaring confusion after ", name);
	}
	public void win() {
		body.heart.decreaseHeartRate(5);
		setFeeling(Feeling.RELIEF);
		System.out.print("He won.");
	}
	@Override
	public void say(String speech) {
		setMentalState(MentalState.TALKING);
		System.out.printf("'%s,' %s said", speech, name);
	}
	public void bite(String bodyPart) {
		System.out.printf("%s bit his %s", name, bodyPart);
		body.tongue.bleed(bodyPart);
	}
	public void wonder(String thoughts) {
		setMentalState(MentalState.THINKING);
		System.out.printf("His mind swirled, and somewhere deep inside, away from the action, he wondered %s.", thoughts);
	}
	public void seeInDark(String human) {
		body.closeEyes(this);
		System.out.printf("In the darkness he saw %s's silver eyes", human);
		body.openEyes(this);
	}
	public void beginToMove() {
		setState(State.MOVING);
		System.out.printf("%s began to move rapidly, putting off any further thought.", name);
	}
	public void jerk(Direction direction, Item item) throws TooHeavyException{
		body.rightArm.setLiftHeight(5);
		body.rightArm.setBendDegree(30);
		this.takeItem(item);
		moveItem(Direction.BACK);
		System.out.printf("He jerked %s %s.", item.toString(), direction);
		this.dropItem(item);
		body.rightArm.setBendDegree(180);
		body.rightArm.setLiftHeight(0);
	}
	public void tidy(Item item) {
		setState(State.TIDYING);
		body.rightArm.setLiftHeight(5);
		body.rightArm.setBendDegree(30);
		carryItem(item);
		System.out.printf("He separated out the two %s and balled them up.", item);
	}
	public void switchShower(Direction direction, Item item) throws TooHeavyException {
		body.rightArm.setLiftHeight(5);
		body.rightArm.setBendDegree(30);
		this.takeItem(item);
		moveItem(Direction.UP);
		System.out.printf("He jerked the %s %s.", item.toString(), direction);
		this.dropItem(item);
		body.rightArm.setBendDegree(180);
		body.rightArm.setLiftHeight(0);
	}
    public void step(String other, String description, Item item) {
		setState(State.STANDING);
		item.setHorizontalDistance(0);
		System.out.printf(" and stepped under the %s %s.", other, description);
	}
	public void wash() {
		setState(State.WASHING);
		body.decreaseLegDirtiness(5);
		body.increaseLegWetness(5);
		System.out.print("He washed the dirt from his feet and legs.");
	}
	public void feelBetter() {
		setFeeling(Feeling.CONFIDENCE);
		System.out.print("He began to feel better, more in control.");
	}
	public void dryOff() {
		setState(State.DRYING);
		body.decreaseLegWetness(5);
		System.out.printf("%s off, it struck him that this was how murderers must feel when they believe they have gotten rid of all the evidence.", state);
	}
	public void laugh() {
		setFeeling(Feeling.HAPPY);
		setMentalState(MentalState.LAUGHING);
		System.out.print("He began to laugh.");
	}
	public void goOn() {
		System.out.printf("He went on %s himself, but he also went on %s. He couldn't seem to stop.", this.state, this.mentalState);
	}
}

