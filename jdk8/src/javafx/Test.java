package javafx;

public class Test {

	public static void main(String[] args) {

		boolean[] arrayOfBooleans = new boolean[3];
		int[] arrayOfIntegers = new int[10];

		for (int i = 0; i < 3; i++) {

			if (i == 2) {
				arrayOfBooleans[i] = false;
			} else {
				arrayOfBooleans[i] = true;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			System.out.print(arrayOfBooleans[i] + " ");
		}

		for (int i = 0; i < 10; i++) {
			arrayOfIntegers[i] = i * 2;
		}

		for (int i = 0; i < 10; i++) {
			System.out.print(arrayOfIntegers[i] + " ");

			if (arrayOfIntegers[i] == 12) {
				System.out.println("the value of 12 is in element number: " + i);
			}
		}
	}
}
