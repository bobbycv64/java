package junit;

public class CorrectChange {

	private int cents = 0;

	public CorrectChange() {
	}

	public void setCents(int cents) {
		this.cents = cents;
	}

	public int getCents() {
		int dollars = (int) (cents / 100);
		int cnts = cents - dollars * 100;
		toString(cnts);
		return cnts;
	}

	public int getDollars() {
		return (int) (cents / 100);
	}

	public void printCorrectChange() {
		System.out.println("Your change is: " + getDollars() + " dollars and " + getCents() + " cents.");
	}

	public String toString(int cnts) {

		String string = "";
		int quarters, dimes, nickels, pennies = 0;

		quarters = cnts / 25;
		cnts = (cnts % 25);

		dimes = cnts / 10;
		cnts = (cnts % 10);

		nickels = cnts / 5;
		cnts = (cnts % 5);

		pennies = cnts;

		System.out.println("Your change is: " + getDollars() + " dollar(s), " + quarters + " quarters(s), " + dimes
				+ " dime(s), " + nickels + " nickel(s), " + pennies + " cents");

		return string;
	}

	public static void main(String[] args) {

		CorrectChange correctChange = new CorrectChange();
		correctChange.setCents(374);
		correctChange.getCents();
		correctChange.toString();
	}
}