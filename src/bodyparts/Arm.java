package bodyparts;

import bodyparts.states.ArmType;
import bodyparts.states.BodyPartState;
import exceptions.ArmException;

public class Arm extends BodyPart {

	public Arm(String name) {
		super(name);
	}
	
	public void setType(ArmType type) {
		if (type == (ArmType.RIGHT)) {
			setBodyPartState(BodyPartState.INJURED);
			System.out.print("There was a scratch there on the bicep, a fresh scratch, exactly where the dead branch had poked him. in the dream.");
		} else {
			throw new ArmException("Nothing on this arm.");
		}
	}
}
