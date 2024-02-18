package places.types;

public enum PlaceType {

	FIRSTFLOOR("first floor"),
	SECONDFLOOR("second floor"),
	STAIRS("stairs"),
	OUTSIDE("outside");

	 private final String placeType;
	 PlaceType(String placeType) {
	     this.placeType = placeType;
	 }
	 
	 @Override
	    public String toString(){
	        return placeType;
	    }
}
