package bodyparts;

import bodyparts.states.ArmType;
import bodyparts.states.BodyPartState;
import exceptions.ArmException;
import items.Item;

import java.util.ArrayList;

public class Arm extends BodyPart {

	public Arm() {
	}

	@Override
	public String toString() {
		return "arm";
	}
	protected int liftHeight;
	protected int bendDegree;
	{
		liftHeight = 0;
		bendDegree = 145;}
	public int getLiftHeight() {
		return liftHeight;
	}
	public void setLiftHeight(int newHeight) {
		this.liftHeight = newHeight;
	}
	public int getBendDegree() {
		return bendDegree;
	}

	public void setBendDegree(int degree) {
		this.bendDegree = degree;
	}

	public void setType(ArmType type) {
		if (type == (ArmType.LEFT)) {
			throw new ArmException
					(String.format("Nothing on this %s.", this));
			}
		setBodyPartState(BodyPartState.INJURED);
	}
	public ArmType getType(ArmType type) {
		return type;
	}
	public ArrayList<Item> carriedItems;

	{
		this.carriedItems = new ArrayList<>(); }

	public void carryItem(Item item) {
		carriedItems.add(item);

		}
	}

