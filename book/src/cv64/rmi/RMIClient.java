package cv64.rmi;

import java.rmi.RMISecurityManager;
import java.rmi.Naming;

public class RMIClient {

  public static void main(String[] args) {

    try {
      System.out.println("Setting Security Manager...");
      System.setSecurityManager(new RMISecurityManager());

	System.out.println("Looking up: " + url_);
      RMICommon rmiCommon = (RMICommon)Naming.lookup(url_);
      System.out.println(rmiCommon.getMessage());

    } catch (Exception exception) {
        System.out.println("RMIClient Exception: " + exception.getMessage());
    }

    System.exit(0);
  }

  private final static String url_ = "rmi://127.0.0.1/RMITest";
}
