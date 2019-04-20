package jdk8;

import java.util.Scanner;

public class StringManipulation {

	public static void main(String[] args) {

		String digitalBase = "0123456789"; // base 10
		String hexBase = "0123456789abcdef"; // base 16

		String sN = "00bd";
		String sN1 = "abbd00";
		String sN2 = "aabd00";

		// sets the default base for the program
		int base = hexBase.length();

		/// char[] arrBase = base.toCharArray(); // Character array of base
		char[] arrsN = sN.toCharArray();
		char[] arrsN2 = sN2.toCharArray();

		// System.out.println(arrBase.length);
		/// System.out.println("Method 1: " + checkValidity(arrBase));
		/// System.out.println("Method 2: " + checkInIt(arrBase, arrsN));
		System.out.println("Method 3:   " + leadingZeros(arrsN));
		System.out.println("Method 4lt: " + compareLessThan(sN1, sN2));
		System.out.println("Method 4gt: " + compareGreaterThan(sN1, sN2));
		System.out.println("Method 4eq: " + compareEqual(sN1, sN2));

		// System.out.println("Method 5: " + countStrings(sN1, sN2, base));
		System.out.println("Method 5:   " + countStrings("d4", "f2", base));
		System.out.println("Method 6:   " + countingAlgorithm(sN1, sN2, base));
		System.out.println("Method 7:   " + addColumnDigits(sN1, sN2, base));
		System.out.println("Method 8:   " + isEven(sN1, base));
		System.out.println("Method 9:   " + countNumbers(base));
	}

	// remove characters that look like leading zeros, return the remaining
	// ill loop through sN for any leading zeros
	// when i find them i will delete by
	// 00bd
	// look at how many leading zeros
	// first i=0 zeros = 1
	// second i=1 zeros =2
	// third i = 2 zeros = 2
	// fourth i = 2 zeros = 2
	// done loop
	// char answer = Arrays.copyOfRange(answer, zeros, sN.length);

	// return answer;
	static String leadingZeros(char[] charArray) { // Method 3

		String string = "";
		boolean leadingZero = false;

		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if ((charArray[i] != '0') || (leadingZero == true)) {
				leadingZero = true;
				string += charArray[i]; // concatenating the character to the String object
			}
		}

		/*
		 * mkyong - google - mkyong ArrayList List<String> myArray = new ArrayList<>();
		 * myArray.add("Bobby"); myArray.add("Brandon"); myArray.add("Rebby");
		 * 
		 * String name = myArray.get(1); int theSize = myArray.size();
		 */

		return string;

	}

	// A method to compare 2 strings sN1 and sN2. Return True if sN1 < sN2.
	// Use it to make 2 more methods of comparisons: sN1 >sN2 and sN1 ==sN2
	static boolean compareLessThan(String sN1, String sN2) {
		int compare = sN1.compareTo(sN2);
		if (compare < 0)
			return true;
		else
			return false;
	}

	// A method to compare 2 strings sN1 and sN2. Return True if sN1 < sN2.
	// Use it to make 2 more methods of comparisons: sN1 >sN2 and sN1 ==sN2
	static boolean compareGreaterThan(String sN1, String sN2) {
		int compare = sN1.compareTo(sN2);
		if (compare > 0)
			return true;
		else
			return false;
	}

	// A method to compare 2 strings sN1 and sN2. Return True if sN1 < sN2.
	// Use it to make 2 more methods of comparisons: sN1 >sN2 and sN1 ==sN2
	static boolean compareEqual(String sN1, String sN2) {
		int compare = sN1.compareTo(sN2);
		if (compare == 0)
			return true;
		else
			return false;
	}

	// A method to count from string sN1 to string sN2 where the two strings are
	// given.
	static String countStrings(String sN1, String sN2, int base) {

		String string = "";
		int one = 0;
		int two = 0;

		if (compareLessThan(sN1, sN2)) {
			one = Integer.parseInt(sN1, base);
			two = Integer.parseInt(sN2, base);
		} else {
			one = Integer.parseInt(sN2, base);
			two = Integer.parseInt(sN1, base);
		}

		for (int i = one; i <= two; i++) {
			string += Integer.toHexString(i) + " "; // converts decimal to hex
		}

		return string;
	}

	// A method to add two strings sN1 to sN2 using counting algorithm
	static String countingAlgorithm(String sN1, String sN2, int base) {

		int one = Integer.parseInt(sN1, base);
		int two = Integer.parseInt(sN2, base);

		String decimalString = Integer.toString(one + two);
		String hexString = Integer.toHexString(one + two);

		return "Decimal: " + decimalString + " = Hex: " + hexString;
	}

	// A method to add two strings sN1 to sN2 by adding column digits with carry. An
	// additional method to fill 'zeros' to one of the strings to make both sN1 and
	// sN2 are of equal length.
	static String addColumnDigits(String sN1, String sN2, int base) {

		while (sN1.length() < sN2.length()) {
			sN1 = "0" + sN1;
		}

		while (sN2.length() < sN1.length()) {
			sN2 = "0" + sN2;
		}

		return countingAlgorithm(sN1, sN2, base);
	}

	// A method to determine string sN is EVEN or ODD.
	// It is used to create a method to print all EVEN numbers (same for ODD)
	// between two given
	// numbers sN1 and sN2 (Please see Lab2).
	// Note: Given a base, a given number is EVEN if its last digit (the unit) has
	// index in base at 0th,
	// 2nd, 4th, etc...
	static boolean isEven(String sN1, int base) {

		int value = Integer.parseInt(sN1, base);

		return (value % 2 == 0);
	}

	// A method to count from sN1 to sN2 where sN1 and sN2 are inputted from
	// keyboard.
	static String countNumbers(int base) {

		// System.in - get input from keyboard
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the first String (sN1)");
		String sN1 = scanner.next();
		System.out.println("Enter the second String (sN2)");
		String sN2 = scanner.next();
		System.out.println("Enter true for even or false for odd");
		boolean evenOrOdd = scanner.nextBoolean();
		scanner.close();

		String string = "";
		int one = 0;
		int two = 0;

		if (compareLessThan(sN1, sN2)) {
			one = Integer.parseInt(sN1, base);
			two = Integer.parseInt(sN2, base);
		} else {
			one = Integer.parseInt(sN2, base);
			two = Integer.parseInt(sN1, base);
		}

		for (int i = one; i <= two; i++) {
			boolean add2String = isEven(Integer.toHexString(i), base);

			if (add2String == evenOrOdd) {
				string += Integer.toHexString(i) + " "; // converts decimal to hex
			}
		}

		return string;
	}

	static boolean checkInIt(char[] base, char[] sN) { // Method 2
		// set value to sN to make assumption be true of the characters
		boolean answer = false;
		int val = 0;
		for (int i = 0; i < sN.length; i = i + 1) {
			for (int j = 0; j < base.length; j = j + 1) {
				if (sN[i] == base[j]) { // if sN and base are equal
					// looking for invalid characters, then return true

					val = val + 1;
				}
			}
		}
		// after loop is done checking if val = 2
		if (val == sN.length) {
			answer = true;
		}
		return answer;
	}

	static boolean checkValidity(char[] arr) { // Method 1
		boolean valid = true;
		for (int i = 0; i < arr.length; i++) {
			int val = 0; // val is the number of repeated chars
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					val++;
				}
				if (val >= 2) { // if the number of repeated chars is more than 2 its false
					valid = false;
				}
			}
		}
		return valid;

	}

}
