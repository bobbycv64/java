package fundamentals.ooo;

public class Vehicle {

	private int speed = 0;
	private int weight = 0;

	public Vehicle(int speed) {
		this();
		this.speed = speed;
	}

	public Vehicle() {
		this.weight = 2000;
	}

	public int getSpeed() {
		return speed;
	}

	public int getWeight() {
		return weight;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}