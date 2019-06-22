package fundamentals.ooo;

/**
 * Class Truck contains Truck attributes and methods
 * @author rwe001
 *
 */
public class Truck extends Vehicle {
	public Truck() {
	}

	/**
	 *  fourWheelDrive - four wheel drive attribute
	 */
	private boolean fourWheelDrive;
	
	/**
	 * torque - torque rating of a Truck
	 */
	private int torque;

	/**
	 * isFourWheel method returns if the Truck is Four Wheel Drive
	 * @return
	 */
	public boolean isFourWheel() {
		return fourWheelDrive;
	}

	/**
	 * getTorque method returns the torque rating of a Truck
	 * @return
	 */
	public int getTorque() {
		return torque;
	}

	/**
	 * setFourWheel method sets true if truck is four wheel drive otherwise false
	 * @param fourWheelDrive
	 */
	public void setFourWheel(boolean fourWheelDrive) {
		this.fourWheelDrive = fourWheelDrive;
	}

	/**
	 * setTorque method sets the torque rating of a Truck
	 * @param torque
	 */
	public void setTorque(int torque) {
		this.torque = torque;
	}
}