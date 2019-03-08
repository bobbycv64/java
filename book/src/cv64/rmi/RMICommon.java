package cv64.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMICommon extends Remote {

  String getMessage() throws RemoteException;
}
