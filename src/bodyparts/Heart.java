package bodyparts;

import humans.Human;

public class Heart extends BodyPart {

	public Heart(String name) {
		super(name);
	}
	
	public void leapUp(String person) {
		System.out.printf("%s's %s leaped up in his throat like a crazy jack-in-the-box.", person, name);
	}

}
