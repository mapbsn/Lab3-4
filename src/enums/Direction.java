package enums;

public enum Direction {
	
	BACK("back"),
	FORWARD("forward"),
	LEFTWAY("left"),
	RIGHTWAY("right"),
	UP("up"),
	DOWN("down"),
	FROMSIDETOSIDE(" from side to side"),
	OUT("out"),
	UNDER("under"),
	INTO("into");
	
	private final String direction;
	Direction(String direction) {
		this.direction = direction;
	}
	
	@Override
	public String toString() {
		return this.direction;
	}

}
