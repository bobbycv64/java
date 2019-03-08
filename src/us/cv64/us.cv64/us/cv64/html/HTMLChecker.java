// https://www.callicoder.com/java-stack/
package us.cv64.html;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class HTMLChecker {

	private static final String FILENAME = "myHTML.html";
	private Stack<String> stack = new Stack<>();
	private int lineNumber = 1;

	public HTMLChecker() {
		readFile();
	}

	private void readFile() {

		Scanner scanner = null;
		String record = "";

		try {
			scanner = new Scanner(new File(FILENAME));

			while (scanner.hasNext()) {
				record = scanner.nextLine();
				reformat(record);
			}

		} catch (IOException exception) {
			exception.printStackTrace();

		} finally {

			try {
				scanner.close();

			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}

	private void reformat(String record) {

		StringTokenizer stringTokenizer = new StringTokenizer(record);
		String token = stringTokenizer.nextToken("<");

		while (stringTokenizer.hasMoreTokens()) {
			validTag("<" + token, lineNumber);
			token = stringTokenizer.nextToken("<");
		}
		validTag("<" + token, lineNumber++);
	}

	private boolean validTag(String record, int lineNumber) {

		System.out.println("validTag: " + record);

		String element = record.substring(0, 2);

		// pop off stack
		if (record.substring(0, 2).equals("</")) {
			String lastElement = stack.lastElement();
			String currentElement = "<" + record.substring(2, record.length());

			if (stack.lastElement().equals(currentElement)) {
				stack.pop();
			} else {
				System.err.println("\nError on line " + lineNumber + ", " + lastElement + " tag expected.\n");
				return false;
			}

			// push on stack
		} else if (record.substring(0, 1).equals("<")) {

			stack.push(record);
		}

		return true;
	}

	public static void main(String[] args) {
		new HTMLChecker();
	}
}