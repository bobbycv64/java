import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam {

	private int abc = 1;
	private ArrayList<Integer> nbrs = new ArrayList<>();

	public Exam() {
		// test5();
		System.out.println(whathappens("RECEPTION"));
	}

	private void methoda() {
		int abc = 2;

		System.out.println(abc);
	}

	private void test2() {
		Scanner scanner = new Scanner(System.in);
		int test = -1;

		try {
			int x = scanner.nextInt();
			test = 0;
		} catch (NullPointerException e1) {
			test = 1;
		} catch (InputMismatchException e2) {
			test = 2;
		} catch (Exception e3) {
			test = 3;
		}
	}

	private void test3() {
		int[] x = { 3, 6, 12, 24, 26, 48 };
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
	}

	private void test4() {

		nbrs.add(new Integer(0));
		nbrs.add(new Integer(0));
		nbrs.add(new Integer(4));
		nbrs.add(new Integer(2));
		nbrs.add(new Integer(5));
		nbrs.add(new Integer(0));
		nbrs.add(new Integer(3));
		nbrs.add(new Integer(0));

		int k = 0;
		Integer zero = new Integer(0);
		while (k < nbrs.size()) {
			Integer a = nbrs.get(k);
			if (nbrs.get(k).equals(zero))
				nbrs.remove(k);
			k++;
		}
	}

	private void test5() {
		int[] q = { 30, 35 };
		System.out.println(q[1] % q[0]);
	}
	
	private void test6() {
		for (int x = 0; x < 10; x++) {
			
		}
		
		System.out.println("x=" + x);
	}

	private String whathappens(String s) {
		String s1 = s.substring(0, 1);
		String s2 = s.substring(1, s.length() - 1);
		String s3 = s.substring(s.length() - 1);
		if (s.length() <= 3)
			return s3 + s2 + s1;
		else
			return s1 + whathappens(s2) + s3;
	}

	public static void main(String[] args) {
		new Exam();
	}
}
