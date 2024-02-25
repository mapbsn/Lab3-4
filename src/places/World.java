package places;

import java.util.ArrayList;
import java.util.Arrays;

import humans.*;
import items.Item;
import places.types.PlaceType;

public class World {

    public final ArrayList<PlaceType> places;

    {
        places = new ArrayList<>();
    }

    private final ArrayList<Human> humans;

    {
        humans = new ArrayList<>();
    }
    private final ArrayList<Item> items;
    { items = new ArrayList<>();}

    public void putHumans(Human... h) {
        for (Human human : h) {
            humans.add(human);
            human.checkPlace();
        }
    }

    public void putItems(Item... i) {
        for (Item item : i) {
            items.add(item);
            item.checkPlace();
        }
    }

    public void putPlaces(PlaceType... p) {
        places.addAll(Arrays.asList(p));
    }
}