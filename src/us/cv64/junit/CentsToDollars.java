package us.cv64.junit;

public class CentsToDollars {

	private int cents = 0;

	public CentsToDollars() {
	}

	public void setCents(int cents) {
		this.cents = cents;
	}

	public int getCents() {
		int dollars = (int) (cents / 100);
		int cnts = cents - dollars * 100;
		return cnts;
	}

	public int getDollars() {
		return (int) (cents / 100);
	}

	public void printResults() {
		System.out.println("That is: " + getDollars() + " dollars and " + getCents() + " cents.");
	}

	public static void main(String[] args) {

		CentsToDollars centsToDollars = new CentsToDollars();
		centsToDollars.setCents(327);
		centsToDollars.printResults();
	}
}
