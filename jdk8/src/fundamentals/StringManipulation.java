package fundamentals;

public class StringManipulation {

	String string = "-3.2*2i";

	public StringManipulation() {

		parseComplexNumber(string);
	}

	public static void parseComplexNumber(String string) {

		double d = 0;
		String real = "";
		String imag = "";
		int negative = 1;
		String operator = "";
		String removeSpaces = string.replaceAll(" ", "");
		String digits = removeSpaces.replaceAll("[^0-9.*/+-]", "");

		if (digits.startsWith("+")) {
			digits = digits.substring(1, digits.length());
		} else if (digits.startsWith("-")) {
			digits = digits.substring(1, digits.length());
			negative = -1;
		}

		if (digits.indexOf("+") != -1) {
			operator = "+";
			real = digits.substring(0, digits.indexOf("+"));
			imag = digits.substring(digits.indexOf("+") + 1, digits.length());
			d = Double.parseDouble(real) * negative + Double.parseDouble(imag);
		} else if (digits.indexOf("-") != -1) {
			operator = "-";
			real = digits.substring(0, digits.indexOf("-"));
			imag = digits.substring(digits.indexOf("-") + 1, digits.length());
			d = Double.parseDouble(real) * negative - Double.parseDouble(imag);
		}
		if (digits.indexOf("*") != -1) {
			operator = "*";
			real = digits.substring(0, digits.indexOf("*"));
			imag = digits.substring(digits.indexOf("*") + 1, digits.length());
			d = Double.parseDouble(real) * negative * Double.parseDouble(imag);
		}
		if (digits.indexOf("/") != -1) {
			operator = "/";
			real = digits.substring(0, digits.indexOf("/"));
			imag = digits.substring(digits.indexOf("/") + 1, digits.length());
			d = Double.parseDouble(real) * negative / Double.parseDouble(imag);
		}

		System.out.println(d);

		// MyDouble myDouble = new MyDouble(d);

		// ComplexNumber complexNumber = new ComplexNumber(myDouble);

		// return complexNumber;

	}

	public static void main(String[] args) {
		new StringManipulation();
	}
}
