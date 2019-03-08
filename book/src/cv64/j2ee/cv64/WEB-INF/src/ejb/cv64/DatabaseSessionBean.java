package cv64;

import java.rmi.RemoteException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class DatabaseSessionBean implements SessionBean {

   public String getMyField(String myField) {

      return myField;
   }

   public DatabaseSessionBean() {}
   public void ejbCreate() {}
   public void ejbRemove() {}
   public void ejbActivate() {}
   public void ejbPassivate() {}
   public void setSessionContext(SessionContext sessionContext) {}
}
