package places;

import exceptions.InvalidPlaceException;
import humans.Human;
import places.types.PlaceType;
import java.util.ArrayList;
import java.util.Objects;
import items.*;

public abstract class Place {

	protected Place(String placeName, PlaceType placeType) {

			this.placeName = placeName;
			this.placeType = placeType;
	    }
	    public final String placeName;
	    public final PlaceType placeType;
	    
	    public String getName() {
	    	return this.placeName;
	    }

	    protected ArrayList<Human> humans = new ArrayList<>();
		protected ArrayList<Item> items = new ArrayList<>();
		public void appearAt(Human name) {
			if (humans.contains(name)){
				throw new InvalidPlaceException(
						String.format("%s is already in the %s.%n", name, placeName)
				);
			}
			humans.add(name);
			System.out.printf("%s is now in the %s%n", name, placeName);
		}

	    public void leave(Human name) {
			if (!humans.contains(name)) {
			     throw new InvalidPlaceException(
					String.format("%s is not in the %s.%n", name, placeName)
			     );
		    }
			humans.remove(name);
			System.out.printf("%s left the %s%n", name, placeName);
		}

	    public boolean contains(Human person){
		    return humans.contains(person);
	    }
	    public boolean contains(Item item){
		return items.contains(item);
	}

		public void placeItem(Item item) {
		    if (items.contains(item)){
				 throw new InvalidPlaceException(
					String.format("%s is already in the %s.%n", item, this)
			     );
			}
		    items.add(item);
		    System.out.printf("%s is now in the %s%n", item, this);
	    }

		public void deleteItem(Item item) {
			if (!items.contains(item)) {
				throw new InvalidPlaceException(
						String.format("%s is not in the %s.%n", item, placeName)
				);
			}
			items.remove(item);
			System.out.printf("%s no more in the %s%n", item, placeName);
		}

	    public void placeMultiple(Item[] items){
		    for (Item item : items) placeItem(item);
	   }

	@Override
	public int hashCode(){
		return Objects.hash(placeName, placeType, humans, items);
	}

	@Override
	public boolean equals(Object obj){
		if (this == obj) return true;
		return (obj instanceof Place place)
				&& placeName.equals(place.placeName)
				&& placeType.equals(place.placeType)
				&& humans.equals(place.humans)
				&& items.equals(place.items);
	}

}
