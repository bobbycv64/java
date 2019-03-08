package cv64.interfaces;

public class Interfaces {

  public static void main(String[] args) {

  // Create object myClass which implements two interfaces A and B
  MyClass myClass = new MyClass();

  // Print results from myClass's methods
  System.out.println("myClass.getA1(): " + myClass.getA1());
  System.out.println("myClass.getA2(): " + myClass.getA2());
  System.out.println("myClass.getB1(): " + myClass.getB1());
  System.out.println("myClass.getB2(): " + myClass.getB2());
  System.out.println();

  // Cast myClass's interfaces to 2 interface types
  InterfaceA interfaceA = (InterfaceA)myClass;
  InterfaceB interfaceB = (InterfaceB)myClass;

  // Print interface results
  System.out.println("interfaceA.getA1(): " + interfaceA.getA1());
  System.out.println("interfaceA.getA2(): " + interfaceA.getA2());
  System.out.println("interfaceB.getB1(): " + interfaceB.getB1());
  System.out.println("interfaceB.getB2(): " + interfaceB.getB2());

  // These commands won't compile because their interfaces have no such methods
  // System.out.println("interfaceA.getB1(): " + interfaceA.getB1());
  // System.out.println("interfaceA.getB2(): " + interfaceA.getB2());
  // System.out.println("interfaceB.getA1(): " + interfaceB.getA1());
  // System.out.println("interfaceB.getA2(): " + interfaceB.getA2());
  }
}
