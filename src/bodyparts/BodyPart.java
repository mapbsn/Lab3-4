package bodyparts;

import bodyparts.states.BodyPartState;
import humans.Human;
import java.util.Objects;

public abstract class BodyPart {
	protected BodyPart(String name) {
		this.name = name;
	}
	public final String name;
	protected BodyPartState state = BodyPartState.DEFAULT;

	public String getName() {
		return this.name;
	}
	public BodyPart setBodyPartState(BodyPartState state) {
		this.state = state;
		return null;
	}
	protected BodyPartState getBodyPartState() {
		return state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, getBodyPartState());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		return (obj instanceof BodyPart bodyPart)
				&& (state.equals(bodyPart.state)
				&& name.equals(bodyPart.name));
	}

}
