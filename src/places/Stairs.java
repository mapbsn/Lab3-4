package places;

import places.types.PlaceType;

public class Stairs extends Place {
	
	public Stairs() {
		super(PlaceType.STAIRS);
	}
	
	public static class Riser extends Stairs {

		public Riser() {;

		}
		
	}

}
