package fundamentals.ooo;

/**
 * Class Vehicle contains Vehicle attributes and methods
 * @author rwe001
 *
 */
public class Vehicle {

	/**
	 * WEIGHT Constant attribute
	 */
	private static final int WEIGHT = 2000;
	
	/**
	 *  speed - speed attribute
	 */
	private int speed = 0;
	
	/**
	 *  weight - weight attribute
	 */
	private int weight = 0;

	/**
	 * one argument Constructor that sets the speed of the Vehicle
	 * @param speed
	 */
	public Vehicle(int speed) {
		this();
		this.speed = speed;
	}

	/**
	 * no argument Constructor that sets the weight to a constant value
	 */
	public Vehicle() {
		this.weight = WEIGHT;
	}

	/**
	 * method getSpeed returns the speed of the Vehicle
	 * @return
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * method getWeight returns the weight of the Vehicle
	 * @return
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * method setSpeed sets the speed of the Vehicle
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * method setWeight sets the weight of the Vehicle
	 * @param weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
}