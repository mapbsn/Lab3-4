package interfaces;

import enums.Direction;
import exceptions.TooHeavyException;
import items.Item;

public interface Jerkable {
    void jerk(Direction direction, Item item) throws TooHeavyException;
}
