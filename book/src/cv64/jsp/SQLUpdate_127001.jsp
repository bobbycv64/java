<%@ page import="java.sql.*" %>

<center><h1>Java ServerPages (JSP) and Java Database Connection (JDBC) Update Example</h1>

<%! int columnCount = 0; %>
<%! int updateStatus = 0; %>
<%! String password = ""; %>
<%! String url = "jdbc:mysql://127.0.0.1:3306/cv64database"; %>
<%! String username = ""; %>
<%! Connection connection = null; %>
<%! Statement statement = null; %>

<%! String[] sqlCommand = new String[2]; %>

<%
sqlCommand[0] = "insert into cv64 values ('one','two',);";
sqlCommand[1] = "insert into cv64 values ('three','four',);";
%>

<%
try {
	Class.forName("com.mysql.jdbc.Driver");
%>
Connecting to Database<br>
<%
	System.out.println ("\nConnecting to Database\n");
	connection = DriverManager.getConnection(url, "", "");
	System.out.println ("Connected to Database");

	System.out.println("getAutoCommit():" + connection.getAutoCommit());
	System.out.println("getCatalog():" + connection.getCatalog());
	System.out.println("isClosed():" + connection.isClosed());
	System.out.println("isReadOnly():" + connection.isReadOnly());
%>
Creating Statement<br>
<%
	System.out.println("\nCreating Statement\n");
	statement = connection.createStatement();	
	System.out.println("\nStatement Created\n");
%>
Executing SQL Command<br>
<%
	System.out.println("\nExecuting SQL Command\n");

	for (int i=0; i < 2; i++) {
		updateStatus = statement.executeUpdate(sqlCommand[i]);
		System.out.println("\nUpdate Status: " + updateStatus + "\n");
%>
Update Status: <%= updateStatus %><br>
<%
	}
	connection.close();

} catch(SQLException exception) {

	System.out.println("Message:   " + exception.getMessage ());
}
%>
</center>