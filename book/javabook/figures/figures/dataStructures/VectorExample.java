import java.util.Vector;

public class VectorExample {

  public VectorExample() {

    Vector ssn = new Vector(2,5);
    System.out.println("Capacity: " + ssn.capacity());

    ssn.addElement(new Person("Ronald Reagan","1"));
    ssn.addElement(new Person("Bob Hope","2"));
    ssn.addElement(new Person("Mickey Mouse","3"));
    ssn.addElement(new Person("Donald Duck","4"));

    for (int i=0; i < ssn.size(); i++) {
      Person person = (Person)ssn.elementAt(i);
      System.out.println(i + ": = " + 
        person.getName() + " " + person.getSSN());
    }

    System.out.println("Capacity: " + ssn.capacity());
    ssn.trimToSize();
    System.out.println("Capacity: " + ssn.capacity());
  }

  public static void main(String[] args) {
    new VectorExample();
  }
}