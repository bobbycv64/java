<%@ page import="cv64.*,
	 java.rmi.RemoteException,
	 java.util.*,
	 javax.ejb.*,
	 javax.naming.*,
	 javax.rmi.PortableRemoteObject,
	 java.rmi.RemoteException"
%>

<%!
  private Database database = null;
  private DatabaseHome home = null;
  private Collection collection = null;
  private Iterator iterator = null;
  private String myField = "";
  private String myKey = "";

  public void jspInit() {

    try {

      InitialContext ic = new InitialContext();
      Object objRef = ic.lookup("java:comp/env/ejb/MySQL");
      home = (DatabaseHome)PortableRemoteObject.narrow(objRef, DatabaseHome.class);

    } catch (Exception exception) {
        System.out.println("Exception: " + exception.getMessage());
    }
  }

  public void jspDestroy() {
    database = null;
  }

%>

<html>
  <head>
    <title>Database - MySQL Example</title>
  </head>

  <body bgcolor="white">
    <h1><b><center>Database</center></b></h1>

    <form method="get"><br>

      <table cellpadding="2" cellspacing="2" border="0"
        style="text-align: left; width: 300px; margin-left: auto; margin-right: auto;">
        <tbody>

          <tr>
            <td style="vertical-align: top;"> My Field Value:</td>
            <td style="vertical-align: top;"><input type="text" name="myField" size="25"></td>
          </tr>
          <tr>
            <td style="vertical-align: top;"> My Key Value:</td>
            <td style="vertical-align: top;"><input type="text" name="myKey" size="25"></td>
          </tr>
        </tbody>
      </table>

      <p><center><input type="submit" value="Submit">
      <input type="reset" value="Reset"></center>
    </form><br><br>

<%
      try {
        myField = request.getParameter("myField");
        myKey = request.getParameter("myKey");

        database = home.create(myField, myKey);

        collection = home.findByMyField(myField);
        iterator = collection.iterator();

        while (iterator.hasNext()) {
      	  database = (Database)iterator.next();
%>

MyField: <%= database.getMyField() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
MyKey:   <%= database.getMyKey() %><br>

<%
        }

      } catch (Exception exception) {
          System.out.println("Exception: " + exception.getMessage());
      }
%>
  </body>
</html>