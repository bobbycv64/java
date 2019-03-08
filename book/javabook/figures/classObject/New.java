public class New {
  
  public static void main(String[] args) {

    int int1;					// declare the primative integer type
    String string1;				// declare the object string of class String

    int1 = 10;					// assign 10 to the primative integer i
    string1 = new String("message");	// assign message to the object string of class String

    int int2 = 10;				// declare and assign to the primative integer j
    String string2 = new String("message");// declare and assign to the object string

    String string3 = null;			// declare and point to no object

    System.out.println("Integer1: " + int1);
    System.out.println("Integer2: " + int2);
    System.out.println("String1:  " + string1);
    System.out.println("String2:  " + string2);
    System.out.println("String3:  " + string3);
  }
}