package places.types;

public enum PlaceType {

	BATHROOM("bathroom"),
	BEDROOM("bedroom"),
	HALLWAY("hallway"),
	KITCHEN("kitchen"),
	STAIRS("stairs"),
	MEDICALCENTER("Medical Center");

	 private final String placeType;
	 PlaceType(String placeType) {
	     this.placeType = placeType;
	 }
	 
	 @Override
	    public String toString(){
	        return placeType;
	    }
}
