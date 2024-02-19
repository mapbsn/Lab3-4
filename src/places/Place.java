package places;

import exceptions.InvalidPlaceException;
import humans.Human;
import places.types.PlaceType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import items.*;

public abstract class Place {
	protected Place(PlaceType placeType) {

			this.placeType = placeType;
	    }
	    public final PlaceType placeType;

	protected ArrayList<Human> humans = new ArrayList<>();
	protected ArrayList<Item> items = new ArrayList<>();
	public void appearAt(Human name) {
		if (humans.contains(name)){
			throw new InvalidPlaceException(
					String.format("%s is already in the %s.%n", name, placeType)
			);
		}
		humans.add(name);
		System.out.printf("%s is now in the %s%n", name, placeType);
	}

	public void leave(Human human) {
		if (!humans.contains(human)) {
			throw new InvalidPlaceException(
					String.format("%s is not in the %s.%n", human.getName(), placeType)
			);
		}
		humans.remove(human);
		System.out.printf("%s left the %s%n", human.getName(), placeType);
	}

	public void placePeople(Human... h) {
		for (Human human : h) {
			humans.add(human);
			this.checkPlace(human, placeType);
		}
	}
	public void checkPlace(Human human, PlaceType placeType) {
		if (humans.contains(human)) {
			System.out.printf("%s is in the %s", human.getName(), placeType);
		}
		throw new InvalidPlaceException(
				String.format("%s is not in the %s", human.getName(), placeType)
		);
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

	public void removeItem(Item item) {
		if (!items.contains(item)) {
			throw new InvalidPlaceException(
					String.format("%s is not in the %s.%n", item.toString(), placeType)
			);
		}
		items.remove(item);
		System.out.printf("%s no more in the %s%n", item.toString(), placeType);
	}

	public void placeMultiple(Item[] items){
		for (Item item : items) placeItem(item);
	}

		@Override
		public int hashCode(){
			return Objects.hash(placeType, humans, items);
		}

		@Override
		public boolean equals(Object obj){
			if (this == obj) return true;
			return (obj instanceof Place place)
					&& placeType.equals(place.placeType)
					&& humans.equals(place.humans)
					&& items.equals(place.items);
	}

}
