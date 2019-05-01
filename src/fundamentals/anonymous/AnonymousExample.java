// https://www.youtube.com/watch?v=V7yVbG9_xkM
// don't ever do this, just showing
package fundamentals.anonymous;

class A {
	public void show() {
		System.out.println("Class A");
	}
}

public class AnonymousExample {

	public static void main(String[] args) {
		
		A a = new A() {
			public void show() {
				System.out.println("Class Anonymous");
			}
		};
		
		a.show();
	}
}
