package bodyparts;

import bodyparts.states.BodyPartState;

import java.util.Objects;

public abstract class BodyPart {
	protected BodyPart() {
	}
	protected BodyPartState state = BodyPartState.DEFAULT;

	public abstract String toString();

	public void setBodyPartState(BodyPartState state) {
		this.state = state;
	}
	protected BodyPartState getBodyPartState() {
		return state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getBodyPartState());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		return (obj instanceof BodyPart bodyPart)
				&& (state.equals(bodyPart.state));
	}

}
