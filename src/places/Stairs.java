package places;

import places.types.PlaceType;

public class Stairs extends Place {
	
	public Stairs(String name, PlaceType placeType) {
		super(name, PlaceType.STAIRS);
	}
	
	public static class Riser extends Stairs {

		public Riser(String name, PlaceType placeType) {
			super(name, PlaceType.STAIRS);

		}
		
	}

}
