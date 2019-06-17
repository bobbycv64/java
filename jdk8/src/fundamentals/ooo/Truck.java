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
	 *  fwd - four wheel drive
	 */
	private boolean fwd;
	
	/**
	 * torque of a Truck
	 */
	private int torque;

	/**
	 * isFourWheel returns if Truck is Four Wheel Drive
	 * @return fwd - true or false if the vehicle is Four Wheel Drive 
	 */
	public boolean isFourWheel() {
		return fwd;
	}

	/**
	 * 
	 * @return
	 */
	public int getTorque() {
		return torque;
	}

	public void setFourWheel(boolean fwd) {
		this.fwd = fwd;
	}

	public void setTorque(int torque) {
		this.torque = torque;
	}
}