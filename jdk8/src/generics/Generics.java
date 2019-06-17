package generics;

/**
 * https://docs.oracle.com/javase/tutorial/java/generics/types.html The most
 * commonly used type parameter names are:
 * 
 * E - Element (used extensively by the Java Collections Framework) K - Key N -
 * Number T - Type V - Value S,U,V etc. - 2nd, 3rd, 4th types
 * 
 * @param <T>
 * 
 * Type inference
 * @see https://docs.oracle.com/javase/tutorial/java/generics/genTypeInference.html
 * 
 * Bounded Type Parameters
 * @see https://docs.oracle.com/javase/tutorial/java/generics/bounded.html
 */
public class Generics<T> {

	private T t;

	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
	}

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	public static void main(String[] args) {

		Generics<Integer> integerGenerics = new Generics<>();
		Generics<Double> doubleGenerics = new Generics<>();
		Integer t = new Integer(64);
		Double d = new Double(64.64);

		integerGenerics.set(t);
		t = integerGenerics.get();
		System.out.println("Integer t: " + t);

		doubleGenerics.set(d);
		d = doubleGenerics.get();
		System.out.println("Double  d: " + d);

		Pair<Integer, String> p1 = new OrderedPair<>(1, "apple");
		Pair<Integer, String> p2 = new OrderedPair<>(2, "orange");
		boolean same = Generics.<Integer, String>compare(p1, p2);
		System.out.println("Same     : " + same);
	}
}
