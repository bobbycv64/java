package java18w.generics;

/**
 * https://docs.oracle.com/javase/tutorial/java/generics/types.html
 * The most commonly used type parameter names are:

E - Element (used extensively by the Java Collections Framework)
K - Key
N - Number
T - Type
V - Value
S,U,V etc. - 2nd, 3rd, 4th types
 * @param <T>
 */
public class Generics<T> {

	private T t;
	
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
	}
}
