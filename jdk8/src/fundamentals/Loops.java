package fundamentals;

public class Loops {

	public Loops() {
		whileExample();
		doWhileExample();
		forExample();
	}
	
	private void whileExample() {
		
		int i = 0;
		
		// while loops execute 0 to many times
		while (i < 3) {
			System.out.println("whileExample");
			i++;
		}
	}
	
	private void doWhileExample() {
		int i = 0;
		
		// do while loops execute 1 to many times
		do {
			System.out.println("doWhileExample");
			i++;
		} while (i < 3);
	}
	
	private void forExample() {
		
		// for loops execute a number of times
		for (int i = 0; i < 3; i++) {
			System.out.println("forExample");
		}
	}
	
	public static void main(String[] args) {
		new Loops();
	}
}
