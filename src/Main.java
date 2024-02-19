import exceptions.TooHeavyException;
import humans.*;
import humans.states.State;
import items.*;
import others.Reality;
import others.World;
import places.*;

import java.util.Arrays;
import java.util.List;

import enums.Direction;

public class Main {
	public static void main (String[] args) throws TooHeavyException {

		Bedroom bedroom = new Bedroom();
		Kitchen kitchen = new Kitchen();
		Hallway hallway = new Hallway();
		Stairs stairs = new Stairs();
		Stairs.Riser riser = new Stairs.Riser();
		MedicalCenter medicalcenter = new MedicalCenter();
		Bathroom bathroom = new Bathroom();
		World world = new World(new Place[]{bedroom, kitchen, hallway, stairs, riser, medicalcenter, bathroom});

		Bed bed = new Bed();
		Blanket blanket = new Blanket(1, 10);
		Rug rug = new Rug(1, 10);
		Shower shower = new Shower(10, 10);

		Louis louis = new Louis();
		Rachel rachel = new Rachel();
		Pascow pascow = new Pascow();

		Reality reality = new Reality();

		bedroom.appearAt(louis);
		kitchen.appearAt(rachel);
		medicalcenter.appearAt(pascow);

		bedroom.placeMultiple(new Item[]{bed, blanket, rug});
		bathroom.placeMultiple(new Item[]{shower});

		rachel.say("'One egg or two?'");
		louis.push(Direction.BACK, blanket);
		louis.swing(louis.feet, Direction.OUT, rug.getDescription(), rug);
		louis.tell(rachel.getName());

		System.out.print("and the words died in his throat.");

		louis.feet.beFilthy();
		louis.heart.leapUp(louis.getName());
		louis.kick(louis.eyes, louis.eyes.getDescription(), louis.teeth, louis.teeth.getDescription(), Direction.BACK);
		bed.littered();
		bed.sheets.beDirty();

		List<String> rachelQuotes = Arrays.asList (
				"'Louis?'",
				"'Louis?'",
				"'Louis, did you go back to sleep?'",
				"'One egg or two?'"
	    );
		
		Talking.talk(rachelQuotes);
		
		louis.see("a few errant pine needles on his knees,");
		try {
			louis.lookAt(louis.arm.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<String> louisThoughts = Arrays.asList(
				"I’m going to scream. I can feel it.",
				"I’m going to scream and then I’ll go crazy and I won’t have to worry about it anymore-",
				"The thought which tipped the scales was that she must not see him this way, his feet muddy and coated with needles, the blankets tossed back onto the floor to reveal the muck-splashed ground sheet.",
				"Thank God."
				);
		
		Thinking.think(louisThoughts);
		louis.canFeel();
		reality.shimmer();
		louis.think("Reality-the real reality,", "was those needles, the filth on the sheets, the bloody scratch on his bare arm.");
		Thinking.think(louisThoughts);
		Talking.talk(rachelQuotes);
		rachel.move(world.getPlace(rachel), stairs);
		rachel.come(Direction.UP, world.getPlace(rachel));
		Talking.talk(rachelQuotes);
		louis.grapple();
		pascow.beBrought(Direction.INTO, medicalcenter, blanket);
		louis.win();
		Thinking.think(louisThoughts);
		louis.say("'I'm awake,'");
		louis.bite(louis.tongue);
		louis.wonder("if he had always been within touching distance of such mad irrationalities; if everyone was");
		Talking.talk(rachelQuotes);
		rachel.stop(riser);
		Thinking.think(louisThoughts);
		louis.say("'Two. Scrambled,'");
		rachel.say("'Good for you,'");
		rachel.move(world.getPlace(rachel), kitchen);
		louis.seeInDark(pascow.getName(), pascow.eyes.toString());
		louis.beginToMove(bedroom);
		louis.jerk(Direction.FORWARD, bed.sheets);
		blanket.beOkay();
		louis.tidy(world.getPlace(louis), hallway, Direction.OUT, bed.sheets);
		louis.dropItem(bed.sheets);
		louis.move(world.getPlace(louis), bathroom);
		louis.jerk(Direction.UP, shower.handle);
		louis.step(bathroom, Direction.UNDER, shower.water.toString(), shower.water.getDescription());
		louis.wash(louis.feet, louis.legs);
		louis.feelBetter();
		louis.dryOff();
		louis.laugh();
		louis.goOn(State.DRYING, State.LAUGHING);
	}
}
