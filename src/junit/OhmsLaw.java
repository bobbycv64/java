package junit;

import java.util.Scanner;

public class OhmsLaw {

	private static int volts = 0;
	private static int current = 0;
	private static int resistance = 0;

	public OhmsLaw() {
	}

	public void getCurrent() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter Voltage (V): ");
		volts = scanner.nextInt();

		System.out.print("Please enter Resistance (ohms): ");
		resistance = scanner.nextInt();

		current = (int) (volts + 0.0) / resistance;

		System.out.println("current: " + current + " amps = " + volts + " volts * " + resistance + " ohms");

		scanner.close();
	}

	public static void main(String[] args) {

		OhmsLaw ohmsLaw = new OhmsLaw();
		ohmsLaw.getCurrent();
	}
}