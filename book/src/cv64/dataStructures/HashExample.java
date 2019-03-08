package cv64.dataStructures;

import java.util.Hashtable;

public class HashExample {

  public HashExample() {

    Hashtable ssn = new Hashtable();
    ssn.put(new Integer(1), new String("Ronald Reagan"));
    ssn.put(new Integer(2), new String("Bob Hope"));

    for (int i=1; i < ssn.size()+1; i++) {
      String s = (String)ssn.get(new Integer(i));
      System.out.println(i + ": = " + s);
    }
  }

  public static void main(String[] args) {
    new HashExample();
  }
}
