package cv64.fundamentals;

public class Strings {

  public static void main(String[] args) {

    // empty string
    String string = "";

    // Initialization and assignment for a string
    String message = "message";

    // Concatenation example
    String one = "cv";
    String two = "64";
    String three = "";
    three = one + " " + two;

    // three = cv 64
    System.out.println("string three equals: " + three);

    // Substring example
    String four = "cv64";
    String five = four.substring(2,2);

    // five = 64
    System.out.println("string five equals: " + five);
  }
}
