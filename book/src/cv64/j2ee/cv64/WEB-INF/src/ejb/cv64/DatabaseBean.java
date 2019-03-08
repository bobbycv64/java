package cv64;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.EJBContext;
import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.NoSuchEntityException;
import javax.ejb.ObjectNotFoundException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseBean implements EntityBean {

  private Connection connection       = null;
  private EntityContext entityContext = null;

  private String myField              = "";
  private String myKey                = "";

/************************* Interface Methods *************************/

  public String getMyField() {
    return myField;
  }

  public String getMyKey() {
    return myKey;
  }

/************************* EJB Callback Methods *************************/

  public String ejbCreate(String myField, String myKey) throws CreateException {

    try {
        insertRow(myField, myKey);
    } catch (Exception exception) {
        throw new EJBException("DatabaseBean.ejbCreate: " + exception.getMessage());
    }

    this.myKey = myKey;
    this.myField = myField;

    return myKey;
  }

  public String ejbFindByMyKey(String myKey) throws FinderException {

    boolean result;

    try {
      result = selectByMyKey(myKey);

    } catch (Exception exception) {
        throw new EJBException("DatabaseBean.ejbFindByMyKey: " + exception.getMessage());
    }
    if (result) {
        return myKey;
    } else {
        throw new ObjectNotFoundException("Row for myKey " + myKey + " not found.");
    }
  }

  public Collection ejbFindByMyField(String myField) throws FinderException {

    Collection result;

    try {
        result = selectByMyField(myField);
    } catch (Exception exception) {
        throw new EJBException("DatabaseBean.ejbFindByMyField " + exception.getMessage());
    }
    return result;
  }

  public void ejbRemove() {

    try {
        deleteRow(myKey);
    } catch (Exception exception) {
        throw new EJBException("DatabaseBean.ejbRemove: " + exception.getMessage());
    }
  }

  public void setEntityContext(EntityContext entityContext) {

    this.entityContext = entityContext;

    try {
        makeConnection();
    } catch (Exception exception) {
        throw new EJBException("DatabaseBean.setEntityContext: " + exception.getMessage());
    }
  }

  public void unsetEntityContext() {

    try {
        connection.close();
    } catch (SQLException exception) {
        throw new EJBException("DatabaseBean.unsetEntityContext: " + exception.getMessage());
    }
  }

  public void ejbActivate() {
    myKey = (String)entityContext.getPrimaryKey();
  }

  public void ejbPassivate() {
    myKey = null;
  }

  public void ejbLoad() {

    try {
        loadRow();
    } catch (Exception exception) {
        throw new EJBException("DatabaseBean.ejbLoad: " + exception.getMessage());
    }
  }

  public void ejbStore() {

    try {
        storeRow();
    } catch (Exception exception) {
        throw new EJBException("DatabaseBean.ejbStore: " + exception.getMessage());
    }
  }

  public void ejbPostCreate(String myField, String myKey) {}

/************************* Database Methods *************************/

  private void makeConnection() throws NamingException, SQLException {

    String databaseConnection   = "jdbc:mysql://localhost:3306/cv64";
    String databaseDriver       = "org.gjt.mm.mysql.Driver";
    String jndiName             = "java:comp/env/jdbc/MySQL";
    String username             = "username";
    String password             = "password";
    boolean mySQL               = true;

    if (!mySQL) {
// This is normally how you get a database connection using the J2EE deployment tool

      jndiName = "java:comp/env/jdbc/MSAccess";

      InitialContext initialContext = new InitialContext();
      DataSource dataSource = (DataSource)initialContext.lookup(jndiName);
      connection = dataSource.getConnection(username, password);

    } else {

// Couldn't get MySQL to work through the J2EE Deployment tool so connected
// to the database through the following block

      try {
          Class.forName(databaseDriver).newInstance();
          connection = DriverManager.getConnection(databaseConnection, username, password);

      } catch (Exception exception) {
          System.err.println("DatabaseBean.makeConnection: " + exception.getMessage());
      }
    }
  }

  private void insertRow(String myField, String myKey) throws SQLException {

    String statement = "insert into myTable values ( ? , ? )";
    PreparedStatement preparedStatement = connection.prepareStatement(statement);

    preparedStatement.setString(1, myField);
    preparedStatement.setString(2, myKey);
    preparedStatement.executeUpdate();
    preparedStatement.close();
  }

  private void deleteRow(String myKey) throws SQLException {

    String statement = "delete from myTable where myKey = ? ";
    PreparedStatement preparedStatement = connection.prepareStatement(statement);

    preparedStatement.setString(1, myKey);
    preparedStatement.executeUpdate();
    preparedStatement.close();
  }

  private boolean selectByMyKey(String myKey) throws SQLException {

    String statement = "select myKey " + "from myTable where myKey = ? ";
    PreparedStatement preparedStatement = connection.prepareStatement(statement);

    preparedStatement.setString(1, myKey);
    ResultSet resultSet = preparedStatement.executeQuery();
    boolean result = resultSet.next();
    preparedStatement.close();
    return result;
  }

  private Collection selectByMyField(String myField) throws SQLException {

    String statement = "select myKey from myTable where myField = ? ";
    PreparedStatement preparedStatement = connection.prepareStatement(statement);

    preparedStatement.setString(1, myField);
    ResultSet resultSet = preparedStatement.executeQuery();
    ArrayList arrayList = new ArrayList();

    while (resultSet.next()) {
      String myKey = resultSet.getString(1);
      arrayList.add(myKey);
    }

    preparedStatement.close();
    return arrayList;
  }

  private void loadRow() throws SQLException {

    String statement = "select myField from myTable where myKey = ? ";
    PreparedStatement preparedStatement = connection.prepareStatement(statement);

    preparedStatement.setString(1, this.myKey);
    ResultSet resultSet = preparedStatement.executeQuery();

    if (resultSet.next()) {
        this.myField = resultSet.getString(1);
        preparedStatement.close();
    } else {
        preparedStatement.close();
        throw new NoSuchEntityException("Row for myKey " + myKey + " not found in database.");
    }
  }

  private void storeRow() throws SQLException {

    String statement = "update myTable set myField =  ? where myKey = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(statement);

    preparedStatement.setString(1, myField);
    preparedStatement.setString(2, myKey);
    int rowCount = preparedStatement.executeUpdate();
    preparedStatement.close();

    if (rowCount == 0) {
      throw new EJBException("Storing row for myKey " + myKey + " failed.");
    }
  }
}