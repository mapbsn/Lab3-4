package places.types;

public enum PlaceType {

	BATHROOM("bathroom", 1, 1),
	BEDROOM("bedroom", -1, 1),
	HALLWAY("hallway", 0, 1),
	KITCHEN("kitchen", -1, -1),
	STAIRS("stairs", 0, 0),
	HOSPITAL("Medical Center", 100, -1);

	 private final String placeType;
	 private final int x;
	 private final int y;
	 PlaceType(String placeType, int x, int y) {
	     this.placeType = placeType;
		 this.x = x;
		 this.y = y;
	 }
	 
	 @Override
	    public String toString(){
	        return placeType;
	    }
	public int getX() {
		return x;
	}
	public int getY() {
		 return y;
	}
}
