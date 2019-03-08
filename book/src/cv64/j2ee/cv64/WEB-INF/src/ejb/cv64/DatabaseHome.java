package cv64;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;

public interface DatabaseHome extends EJBHome {

  public Database create(String field, String key)
    throws RemoteException, CreateException;

  public Collection findByMyField(String field)
    throws FinderException, RemoteException;

  public Database findByMyKey(String key)
    throws FinderException, RemoteException;
}
