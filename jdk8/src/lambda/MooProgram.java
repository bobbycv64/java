package lambda;

import java.util.ArrayList;

public class MooProgram {

	private static int maxx = 0;
	private static int maxy = 0;

	// etc
	private static void computeFence(Cow cow) {
		if (cow.getX() > maxx)
			maxx = cow.getX();
	}

	private static void populateArrayList() {
		ArrayList<Cow> cows = new ArrayList<>();

		// you are going to read the input file
		// get the x, y and network the cows are on.

		// Then you are going to create the Cow object and add to the ArrayList, very
		// simple

		// you are going to have a loop reading the file and then generating cow objects
		// and adding them to the list
		// so you just loop through the file and store everything in the ArrayList
		Cow cow = new Cow(7, 5, 4); // put a Cow at coordinates 1, 2 and on network 4.
		cows.add(cow);
		cow = new Cow(0, 5, 4);
		cows.add(cow);
		cow = new Cow(10, 5, 3);
		cows.add(cow);
		cow = new Cow(5, 0, 4);
		cows.add(cow);
		cow = new Cow(0, 5, 7);
		cows.add(cow);
		cow = new Cow(10, 5, 7);
		cows.add(cow);
		cow = new Cow(5, 0, 7);
		cows.add(cow);

		// after you load the arraylist you are going to write logic for the smallest
		// pin size for the cows on the same network

		// have a loop here

		// foreach( Cow cowt : cows) {
		// Numbers.forEach((n) -> System.out.println(n));
		cows.forEach((animal) -> System.out.println("Cow Network: " + animal.getNetwork()));

		// int network = cows.get(i).getNetwork();

		// then have logic to check if the network is what you are searching for
		// this is just an example, you would not hardcode anything
		// I would use a Scanner class to get input from a user to find the network of
		// choice
		// if (network == 4) {
		// do the calculations of minx, maxx, miny, and maxy
		// very simple comparison
		//
		// Cow partOfNetwork = cows.get(i);
		// just do simple comparisons, e.g. partOfNetwork.getX() > maxx;
		// MooProgram.computeFence(partOfNetwork);
		// }

	}

	public static void main(String[] args) {
		MooProgram.populateArrayList();
	}
}
