import java.util.Vector;

public class SimpleVectorExample {

  public SimpleVectorExample() {

    Vector vector = new Vector();
    vector.addElement(new Integer(1));
    vector.addElement(new Integer(2));
    vector.addElement(new Integer(3));

    for (int i=0; i < vector.size(); i++) {
      Integer key = (Integer)vector.elementAt(i);
      System.out.println(i + ": = " + key);
    }
  }

  public static void main(String[] args) {
    new SimpleVectorExample();
  }
}