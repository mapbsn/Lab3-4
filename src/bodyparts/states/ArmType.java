package bodyparts.states;

import java.util.Random;

public enum ArmType {
	
	RIGHT("right"),
	LEFT("left");
	
	private final String type;
	ArmType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type;
	}
	
	public static ArmType getRandomArmType() {
		ArmType[] type = ArmType.values();
		Random random = new Random();
        int randomIndex = random.nextInt(type.length);
        return type[randomIndex];
	}

}
