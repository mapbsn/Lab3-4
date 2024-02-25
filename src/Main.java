import exceptions.TooHeavyException;
import humans.*;
import items.*;
import others.Reality;
import places.*;

import java.util.Arrays;
import java.util.List;

import enums.Direction;
import places.types.PlaceType;

public class Main {
	public static void main (String[] args) throws TooHeavyException {

		Bed bed = new Bed(-1, 1);
		Blanket blanket = new Blanket(-1, 1);
		Rug rug = new Rug(-1, 1);
		Shower shower = new Shower(1, 1);

		Louis louis = new Louis(-1, 1);
		Rachel rachel = new Rachel(-1, -1);
		Pascow pascow = new Pascow(100, -1);

		World world = new World();
		world.putPlaces(PlaceType.BATHROOM, PlaceType.KITCHEN, PlaceType.BEDROOM, PlaceType.HALLWAY, PlaceType.STAIRS, PlaceType.HOSPITAL);
		world.putHumans(louis, rachel, pascow);
		world.putItems(bed, blanket, rug, shower);

		Reality reality = new Reality();

		rachel.say("'One egg or two?'");
		louis.push(Direction.BACK, blanket);
		louis.swing(louis.feet, Direction.OUT, rug.getDescription(), rug);
		louis.tell(rachel.getName());

		System.out.print("and the words died in his throat.");

		louis.feet.beFilthy();
		louis.heart.leapUp(louis.getName());
		louis.kick(louis.eyes, louis.eyes.getDescription(), louis.teeth, louis.teeth.getDescription(), blanket, Direction.BACK);
		bed.littered();
		bed.sheets.beDirty();

		List<String> rachelQuotes = Arrays.asList (
				"'Louis?'",
				"'Louis?'",
				"'Louis, did you go back to sleep?'",
				"'One egg or two?'"
	    );
		
		Talking.talk(rachelQuotes, rachel);

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
		
		Thinking.think(louisThoughts, louis);
		louis.canFeel();
		reality.shimmer();
		louis.think("Reality-the real reality,", "was those needles, the filth on the sheets, the bloody scratch on his bare arm.");
		Thinking.think(louisThoughts, louis);
		Talking.talk(rachelQuotes, rachel);
		rachel.move(Direction.RIGHTWAY);
		rachel.move(Direction.UP);
		rachel.checkPlace();
		rachel.come(Direction.UP, rachel.getPlace());
		Talking.talk(rachelQuotes, rachel);
		louis.grapple();
		pascow.beBrought(Direction.INTO, pascow.getPlace(), blanket);
		louis.win();
		Thinking.think(louisThoughts, louis);
		louis.say("'I'm awake,'");
		louis.bite(louis.tongue);
		louis.wonder("if he had always been within touching distance of such mad irrationalities; if everyone was");
		Talking.talk(rachelQuotes, rachel);
		rachel.stop(rachel.getPlace());
		Thinking.think(louisThoughts, louis);
		louis.say("'Two. Scrambled,'");
		rachel.say("'Good for you,'");
		rachel.move(Direction.DOWN);
		rachel.move(Direction.LEFTWAY);
		rachel.checkPlace();
		louis.seeInDark(pascow.getName(), pascow.eyes.toString());
		louis.beginToMove(louis.getPlace());
		louis.jerk(Direction.BACK, bed.sheets);
		blanket.beOkay();
		louis.takeItem(bed.sheets);
		louis.move(Direction.RIGHTWAY);
		louis.checkPlace();
		louis.tidy(Direction.OUT, bed.sheets);
		louis.dropItem(bed.sheets);
		louis.move(Direction.RIGHTWAY);
		louis.checkPlace();
		louis.switchShower(Direction.UP, shower.handle);
		louis.step(Direction.UNDER, shower.water.toString(), shower.water.getDescription(), shower);
		louis.wash(louis.feet, louis.legs);
		louis.feelBetter();
		louis.dryOff();
		louis.laugh();
		louis.goOn();
	}
}
