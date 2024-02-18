package enums;

public enum Direction {
	
	BACK("back"),
	UP("up"),
	DOWN("down"), 
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
