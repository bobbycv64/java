package generics;

/**
 * https://docs.oracle.com/javase/tutorial/java/generics/index.html autoboxing -
 * convert primitive to Object, e.g. int to Integer unboxing - convert Object to
 * primitive, e.g. Integer to int
 */
public class Driver {

	public static void singleTypeParameter() {
		// create an Integer Type with value 64
		Integer setInteger = new Integer(64);

		// call Box Constructor and and define the Box type as Integer
		Box<Integer> integerBox = new Box<>(64);

		// set the Integer Type with value 64 in the Box Class
		integerBox.set(setInteger);

		// get the Integer Type from the Box Class
		Integer getInteger = integerBox.get();

		// print the Integer type
		System.out.println("Driver:  " + getInteger);
	}

	public static void multipleTypeParameters() {
		Pair<String, Integer> pair1 = new OrderedPair<String, Integer>("CV", 64);
		Pair<String, String> pair2 = new OrderedPair<String, String>("USS", "Constellation");
		OrderedPair<String, Box<Integer>> pair3 = new OrderedPair<>("CV", new Box<Integer>(64));

		System.out.println("pair1.key: " + pair1.getKey() + " pair1.value: " + pair1.getValue());
		System.out.println("pair2.key: " + pair2.getKey() + " pair2.value: " + pair2.getValue());
		System.out.println("pair3.key: " + pair3.getKey() + " pair3.value: " + pair3.getValue().get());
	}

	public static <T> void main(String[] args) {

		singleTypeParameter();
		multipleTypeParameters();
	}
}
