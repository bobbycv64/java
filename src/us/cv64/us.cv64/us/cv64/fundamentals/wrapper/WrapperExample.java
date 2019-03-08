// https://www.youtube.com/watch?v=thqLx4zUeY0&t=13s
package us.cv64.fundamentals.wrapper;

/**
 * primitives are faster than objects, however frameworks use Wrappers
 */
public class WrapperExample {

	public static void main(String[] args) {
		
		int i = 0;  // primitive datatype
		Integer integer = new Integer(i);  // Boxing / Wrapping
		int j = integer.intValue();  // Unboxing / Unwrapping
		Integer value = i;	// AutoWrapping / AutoBoxing
		int k = value;  // AutoWrapping / AutoUnboxing
		String string = "123";
		int l = Integer.parseInt(string);
	}
}
