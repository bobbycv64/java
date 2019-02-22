package us.cv64.collections.fundamentals;

public class ArrayMethods {

	private static int[] digits = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
	private static int[] upArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
	private static int[] downArray = { 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
	private static int[] pairsArray = { 0, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 11, 12, 13, 14 };

	public void init() {

		for (int i = 0; i < digits.length; i++) {
			digits[i] += 5;
		}
	}

	public void setup() {

		for (int i = 0; i < digits.length; i++) {

			if (i % 2 == 0) {
				digits[i] = i;
			} else
				digits[i] = -1;
		}
	}

	public void reverse() {

		int index = digits.length - 1;
		int temp = 0;

		for (int i = 0; i < digits.length / 2; i++) {
			temp = digits[i];
			digits[i] = digits[index];
			digits[index] = temp;
			index--;
		}
	}

	public void oddEven() {

		int zero = 0;
		int even = 0;
		int odd = 0;

		for (int i = 0; i < digits.length; i++) {

			if (digits[i] == 0) {
				zero++;
			} else if (i % 2 == 0) {
				even++;
			} else
				odd++;
		}

		System.out.println("Zero: " + zero);
		System.out.println("Even: " + even);
		System.out.println("Odd : " + odd);
	}

	public String direction() {

		boolean upOrder = false;
		boolean downOrder = false;
		boolean noOrder = false;

		for (int i = 0; i < digits.length - 1; i++) {

			if (digits[i] < digits[i + 1]) {
				upOrder = true;
			} else if (digits[i] > digits[i + 1]) {
				downOrder = true;
			} else {
				noOrder = true;
			}
		}
		if ((upOrder == true) && (downOrder == false) && (noOrder == false)) {
			return "upOrder";
		}
		if ((upOrder == false) && (downOrder == true) && (noOrder == false)) {
			return "downOrder";
		}

		return "noOrder";
	}

	public double average() {

		double mean = 0;
		for (int i = 0; i < digits.length; i++) {
			mean += digits[i];
		}

		return mean / digits.length;
	}

	public void posNeg() {

		int positive = 0;
		int negative = 0;

		for (int i = 0; i < digits.length; i++) {

			if (digits[i] >= 0) {
				positive++;
			} else {
				negative++;
			}
		}

		System.out.println("Positive: " + positive);
		System.out.println("Negative: " + negative);
	}

	public int pairs() {

		int count = 0;

		for (int i = 0; i < pairsArray.length - 1; i++) {
			if (pairsArray[i] == pairsArray[i + 1]) {
				count++;
				i++;
			}
		}

		return count;
	}
}
