package cv64.fundamentals;

public class ConditionalFlowControl {

  public static void main(String[] args) {

    int smallInt = 13;
    int largeInt = 64;

    //  == is a logical comparison, not assignment.
    if (smallInt == largeInt) {
        System.out.println("This will never execute");
    } else {
        System.out.println(smallInt + " isn't equal to " + largeInt);
    }

    if (smallInt < largeInt) {
      System.out.println(smallInt + " is smaller than " + largeInt);
    }

    if (smallInt > largeInt) {
        System.out.println("This will never execute");
    } else {
        System.out.println(smallInt + " is smaller than " + largeInt);
    }
  }
}
