package others;

import exceptions.InvalidPlaceException;
import humans.Human;
import items.Item;
import places.Place;
import places.types.PlaceType;

import java.util.ArrayList;
import java.util.List;

public class World {
    public World(Place[] places) {
        this.places.addAll(List.of(places));
    }

    public  final ArrayList<Place> places = new ArrayList<>();
    private final ArrayList<Human> humans = new ArrayList<>();
    private final ArrayList<Item> items = new ArrayList<>();


    public Place getPlace(Human human) throws InvalidPlaceException {
        for (Place place : places) if (place.contains(human)) return place;
        throw new InvalidPlaceException(String.format("Place for %s doesn't exist", human));
    }

    public Place getPlace(Item item) throws InvalidPlaceException {
        for (Place place : places) if (place.contains(item)) return place;
        throw new InvalidPlaceException(String.format("Place for %s doesn't exist", item));
    }
}
