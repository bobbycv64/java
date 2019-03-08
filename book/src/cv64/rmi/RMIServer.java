package cv64.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer extends UnicastRemoteObject implements RMICommon {

  public RMIServer() throws RemoteException {}

  public String getMessage() throws RemoteException {

    return message_;
  }

  public static void main(String[] args) {
    try {
      System.out.println("Creating RMIServer Object");
      RMIServer rmiServer = new RMIServer();
      System.out.println("Rebinding RMIServer");
      Naming.rebind("RMITest", rmiServer);
      System.out.println("RMIServer waiting for Client requests");

    } catch (Exception exception) {
        System.out.println(exception.getMessage());
    }
  }

 private final String message_ = "Message from RMIServer";
}
