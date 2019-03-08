package cv64.hierarchy;
//Inheritance Main Program
public class Inheritance {

  public static void main(String[] args) {

    // Initializing objects
    Automobile geo = new Automobile("Geo", 1993,"Metro");
    Aircraft f14 = new Aircraft("F14", 1972,"F14-D",60000);
    Ship cv64  = new Ship("CV64", 1961,"cva",90000);

    // Prints out all the current values of the objects
    // using both the actual class and superclass methods
    System.out.println(geo.toString());
    System.out.println(f14.toString());
    System.out.println(cv64.toString());

    // Setting various attributes
    geo.setHorsePower(60);
    cv64.setModel("cv");

    // Using the Vehicle class defined getName method
    System.out.println("\nGeo Name: " + geo.getName());

    // Prints out all the current values of the objects
    // using both the actual class and superclass methods
    System.out.println(geo.toString());
    System.out.println(f14.toString());
    System.out.println(cv64.toString());
  }
}
