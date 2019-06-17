package fundamentals.ooo;

/**
 * This is an example of a general familiarization of Object Oriented Computing Program
 * 
 * cd ~/git/cv64/website/bobbyU/computing/java/jdk8/src
 * javadoc -sourcepath * -d ../javadoc -verbose -author -private
 * 
 * @author rwe001
 *
 */
public class Example {

	/**
	 * main method - instructs the Java Virtual Machine (JVM) where to start
	 * @param args - command line arguments
	 */
	public static void main(String[] args) {

		Vehicle car = new Vehicle();
		Vehicle geo = new Vehicle(40);
		Truck ram = new Truck();
		Truck dakota = new Truck();

		car.setSpeed(50);
		ram.setSpeed(100);
		ram.setTorque(5000);
		dakota.setSpeed(70);

		System.out.println("Car speed:    " + car.getSpeed() + ":" + car.getWeight());
		System.out.println("Geo speed:    " + geo.getSpeed() + ":" + geo.getWeight());
		System.out.println("Ram speed:    " + ram.getSpeed() + ":" + ram.getWeight());
		System.out.println("Ram Torque:   " + ram.getTorque() + ":" + ram.getWeight());
		System.out.println("Dakota speed: " + dakota.getSpeed() + ":" + dakota.getWeight());
	}
}