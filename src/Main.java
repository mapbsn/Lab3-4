import bodyparts.states.BodyPartState;
import humans.*;
import bodyparts.*;
import bodyparts.states.ArmType;
import humans.states.State;
import items.*;
import others.Reality;
import others.World;
import places.*;
import places.types.PlaceType;
import java.util.Arrays;
import java.util.List;

import enums.Direction;

public class Main {
	public static void main (String[] args) {

		Bedroom bedroom = new Bedroom("bedroom", PlaceType.SECONDFLOOR);
		Kitchen kitchen = new Kitchen("kitchen", PlaceType.FIRSTFLOOR);
		Hallway hallway = new Hallway("hallway", PlaceType.FIRSTFLOOR);
		Stairs stairs = new Stairs("stairs", PlaceType.STAIRS);
		Stairs.Riser riser = new Stairs.Riser("riser", PlaceType.STAIRS);
		MedicalCenter medicalcenter = new MedicalCenter("Medical Center", PlaceType.OUTSIDE);
		Bathroom bathroom = new Bathroom("bathroom", PlaceType.FIRSTFLOOR);
		World world = new World(new Place[]{bedroom, kitchen, hallway, stairs, riser, medicalcenter, bathroom});

		Bed bed = new Bed("bed");
		Bed.Blanket blanket = new Bed.Blanket("blankets");
		Bed.Rug rug = new Bed.Rug("rug");
		Bed.Sheets sheets = new Bed.Sheets("sheets");
		Shower shower = new Shower("shower");
		Shower.Handle handle = new Shower.Handle("handle");
		Shower.Water water = new Shower.Water("water");

		Louis louis = new Louis("Louis");
		Rachel rachel = new Rachel("Rachel");
		Pascow pascow = new Pascow("Pascow");

		Reality reality = new Reality("Reality");

		bedroom.appearAt(louis);
		kitchen.appearAt(rachel);
		medicalcenter.appearAt(pascow);

		bedroom.placeMultiple(new Item[]{bed, blanket, rug, sheets});
		bathroom.placeMultiple(new Item[]{shower, handle, water});

		rachel.say("'One egg or two?'");
		louis.push(Direction.BACK, blanket.getName());
		louis.swing(Direction.OUT, rug.getDescription(), rug.getName());
		louis.tell(rachel.getName());

		System.out.print("and the words died in his throat.");

		Legs legs = new Legs("legs");
		Legs.Feet feet = new Legs.Feet("feet");
		Heart heart = new Heart("heart");
		Eyes eyes = new Eyes("eyes");
		Tongue tongue = new Tongue("tongue");
		Arm arm = new Arm("arm");

		feet.beFilthy();
		heart.leapUp(louis.getName());
		louis.kick(Direction.BACK);
		bed.littered();
		sheets.beDirty();

		List<String> rachelQuotes = Arrays.asList (
				"'Louis?'",
				"'Louis?'",
				"'Louis, did you go back to sleep?'",
				"'One egg or two?'"
	    );
		
		Talking.talk(rachelQuotes);
		
		louis.see("a few errant pine needles on his knees,");
		louis.lookAt(arm.getName());
		try {
			arm.setType(ArmType.getRandomArmType());
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
		rachel.changePlace(world.getPlace(rachel), stairs);
		rachel.come(Direction.UP, stairs.getName());
		Talking.talk(rachelQuotes);
		louis.grapple();
		pascow.beBrought(Direction.INTO, medicalcenter.getName(), blanket.getName());
		louis.win();
		Thinking.think(louisThoughts);
		louis.say("'I'm awake,'");
		tongue.bleed(tongue.getName());
		louis.wonder("if he had always been within touching distance of such mad irrationalities; if everyone was");
		Talking.talk(rachelQuotes);
		rachel.stop(riser.getName());
		Thinking.think(louisThoughts);
		louis.say("'Two. Scrambled,'");
		rachel.say("'Good for you,'");
		rachel.changePlace(stairs, kitchen);
		louis.close(eyes.getName());
		louis.see("Pascow's silver eyes.");
		eyes.open(louis.getName());
		louis.move();
		louis.jerk(sheets.getDescription());
		blanket.beOkay();
		louis.takeItem(sheets, bedroom);
		louis.tidy(Direction.OUT, sheets.getName());
		louis.changePlace(bedroom, stairs);
		louis.changePlace(stairs, hallway);
		louis.dropItem(sheets, hallway);
		louis.changePlace(hallway, bathroom);
		louis.jerk(handle.getDescription());
		louis.step(Direction.UNDER, water.getName(), water.getDescription());
		louis.wash(feet.getName(), legs.getName(), BodyPartState.CLEAN);
		louis.feelBetter();
		louis.dryOff();
		louis.laugh();
		louis.goOn(State.DRYING, State.LAUGHING);
	}
}
