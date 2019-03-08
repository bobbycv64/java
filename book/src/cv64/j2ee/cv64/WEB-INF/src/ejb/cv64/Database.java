package cv64;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

public interface Database extends EJBObject {

   public String getMyField() throws RemoteException;
   public String getMyKey() throws RemoteException;
}
