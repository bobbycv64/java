package us.cv64.general;

public class RunArray {
	public static void main(String[] args) {

		ArrayMethods arrayMethods = new ArrayMethods();
		arrayMethods.init();
		arrayMethods.setup();
		arrayMethods.reverse();
		arrayMethods.oddEven();
		arrayMethods.direction();
		System.out.println("Average: " + arrayMethods.average());
		arrayMethods.posNeg();
		arrayMethods.pairs();
		System.out.println("Order: " + arrayMethods.direction());
		System.out.println("Pairs: " + arrayMethods.pairs());
		System.out.println("End Program");
	}
}
