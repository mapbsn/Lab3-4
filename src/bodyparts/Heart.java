package bodyparts;

import humans.Human;

public class Heart extends BodyPart {
	private int heartRate;

	public Heart() {
		this.heartRate = 70;
	}
	@Override
	public String toString() {
		return "heart";
	}
	public void increaseHeartRate(int rateIncrease) {
		this.heartRate += rateIncrease;
	}
	public void decreaseHeartRate(int rateDecrease) {
		this.heartRate -= rateDecrease;
	}
	public void leapUp(String human) {
		increaseHeartRate(10);
		System.out.printf("%s's %s leaped up in his throat like a crazy jack-in-the-box.", human, this);
	}

}
