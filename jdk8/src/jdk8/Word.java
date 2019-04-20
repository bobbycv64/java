package jdk8;

import java.util.Random;

// Also create an instance variable of type 
// Random to be used by the getters to come up with the random words.  Create getters 
// (getArticle(), getNoun(), etc.) that use the random number generator to randomly 
// select a word and return it to the calling client.
public class Word {

	String[] article;
	String[] noun;
	String[] verb;
	String[] preposition;

	// Word no argument Constructor
	// Create a Word class that contains the four word arrays and set the values of
	// the
	// arrays in the constructor for the class. 
	public Word() {
		article = new String[] { "the", "a", "one", "some", "any" };

		noun = new String[] { "boy", "girl", "dog", "town", "car" };

		verb = new String[] { "drove", "jumped", "ran", "walked", "skipped" };

		preposition = new String[] { "to", "from", "over", "under", "on" };
	}

	public String getArticle() {
		int index = getRandomNumberInRange(0, 4); // gets a random number for the index
		return article[index]; // returns the value at the index of the array article
	}

	public String getNoun() {
		// return noun[selection.nextInt(noun.length)];
		return "";
	}

	public String getVerb() {
		// return verb[selection.nextInt(verb.length)];
		return "";
	}

	public String getPreposition() {
		// return preposition[selection.nextInt(preposition.length)];
		return "";
	}

	// Random Number Generator
	// https://www.mkyong.com/java/java-generate-random-integers-in-a-range/
	// Also create an instance variable of type
	// Random to be used by the getters to come up with the random words.

	// this methods takes two integers number for a range of values
	// the minimum value in your case will be what number = 0, all arrays start with
	// 0
	// the maximum value is the last element index, for article would be 4
	private static int getRandomNumberInRange(int min, int max) {

		// this is a check to make sure that the minimum value is not greater than
		// or equal to maximum value
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		// we are calling the Random Class that is provided by Java
		// calling the Constructor Random and return an object random of type Random
		Random random = new Random();

		// the random object calls the nextInt method, passes in the equation
		// is returned a random integer, which is then returned back to the caller
		return random.nextInt((max - min) + 1) + min;
	}

	public static void main(String[] args) {
		// SecureRandom selection = new SecureRandom();
		Word word = new Word(); // calls the Constructor and returns a word object.
		System.out.println(word.getArticle()); // calls getArticle and returns a random string
	}
}