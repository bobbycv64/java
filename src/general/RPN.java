//https://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/
package general;

import java.util.Stack;

public class RPN {

	public RPN() {

	}

	public int evalRPN(String[] tokens) {

		int returnValue = 0;

		String operators = "+-*/";

		Stack<String> stack = new Stack<String>();

		for (String t : tokens) {
			if (!operators.contains(t)) {
				stack.push(t);
			} else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				int index = operators.indexOf(t);
				switch (index) {
				case 0:
					stack.push(String.valueOf(a + b));
					break;
				case 1:
					stack.push(String.valueOf(b - a));
					break;
				case 2:
					stack.push(String.valueOf(a * b));
					break;
				case 3:
					stack.push(String.valueOf(b / a));
					break;
				}
			}
		}

		returnValue = Integer.valueOf(stack.pop());

		return returnValue;

	}

	public static void main(String[] args) {
		RPN rpn = new RPN();
		System.out.println(rpn.evalRPN(args));
	}
}