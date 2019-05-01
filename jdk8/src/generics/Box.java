package generics;

// Set Box Class as a Generic
public class Box<T> {

	// T - type parameter
	private T t = null;

	// T - type argument
	public Box(T t) {
		System.out.println("Box.Constructor: " + t);
		this.t = t;
	}

	// T - type argument
	public void set(T t) {
		System.out.println("Box.set: " + t);
		this.t = t;
	}

	// T - return a Type
	public T get() {
		System.out.println("Box.get: " + t);
		return t;
	}
}
