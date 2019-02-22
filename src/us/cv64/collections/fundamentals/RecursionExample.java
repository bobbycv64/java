package us.cv64.collections.fundamentals;

public class RecursionExample {

	public RecursionExample() {

	}

	public static int recursiveFactorial(int n) {
		System.out.println("recursiveFactorial(" + n + ")");
		if (n == 1) {
			return 1;
		} else {
			int i = recursiveFactorial(n - 1);
			System.out.println("return n * i : " + (n * i) + "\t n: " + n + "\t i: " + i);
			return n * i;
		}
	}

	public static void main(String[] args) {

		RecursionExample recursionExample = new RecursionExample();
		int factorial = recursionExample.recursiveFactorial(5);

		System.out.println("factorial: " + factorial);
	}
}
