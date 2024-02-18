package bodyparts;

import humans.Human;

public class Eyes extends BodyPart {

	public Eyes(String name) {
		super(name);
	}

	public void open(String human) {
		System.out.printf("%s's eyes flew open again.", human);
	}

}
