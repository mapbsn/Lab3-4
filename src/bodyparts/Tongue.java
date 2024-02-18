package bodyparts;

import bodyparts.states.BodyPartState;

public class Tongue extends BodyPart {
    public Tongue(String name) {
        super(name);
    }

    public void bleed(String bodyPart) {
        setBodyPartState(BodyPartState.INJURED);
        System.out.printf("His %s was bleeding from the sudden, involuntary bite he had given it.", bodyPart);
    }
}
