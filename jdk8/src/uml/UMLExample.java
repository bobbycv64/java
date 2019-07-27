// http://pages.cs.wisc.edu/~hasti/cs302/examples/UMLdiagram.html
package uml;

public class UMLExample {

	// + = public - = private
	// Constructor / method
	// signatures are reversed
	// return type in this case nothing since this is a Constructor
	// + UMLExample(string: String)
	// NOTE: Constructors return nothing, even Constructors return objects
	public UMLExample(String string) {

	}

	// - privateMethod(string: String, someInt: int, someDouble: double): int
	private int privateMethod(String string, int someInt, double someDouble) {
		return someInt;
	}

	// + main(args: String[]): void
	public static void main(String[] args) {

	}
}
