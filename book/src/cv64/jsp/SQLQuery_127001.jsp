<%@ page import="java.sql.*" %>

<center><h1> Java ServerPages (JSP) and Java Database Connection (JDBC) Query Example</h1>

<%! int columnCount = 0; %>
<%! String[] columnNames = null; %>
<%! String columnName = null; %>
<%! String entry = null; %>
<%! String password = ""; %>
<%! String query = "select * from cv64"; %>
<%! String url = "jdbc:mysql://127.0.0.1:3306/cv64us"; %>
<%! String username = ""; %>
<%! Connection connection = null; %>
<%! ResultSet resultSet = null; %>
<%! ResultSetMetaData resultsMetaData = null; %>
<%! Statement statement = null; %>

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
Executing Query<br><br>
<h2>Column Names</h2>
<%
	System.out.println("\nExecuting Query\n");
	resultSet = statement.executeQuery(query);
	resultsMetaData = resultSet.getMetaData();
	columnCount = resultsMetaData.getColumnCount();
	columnNames = new String[columnCount];
	System.out.println("\nResults Received\n");

	// print out column names
	System.out.println("\n***** Column Names *****\n");
	for(int i=1; i < columnCount+1; i++) {
		columnName = resultsMetaData.getColumnName(i).trim();
		System.out.println(columnName);
%>

<%= columnName %><br>

<%
	}
%>

<br><h2>Record Entries</h2></center>

<%
	// print out records
	System.out.println("\n\n***** Records *****\n");
	while(resultSet.next()) {

		String[] row = new String[columnCount];
			
		for(int i=1; i<columnCount+1; i++) {
			entry = resultSet.getString(i) + ",";
			System.out.print(entry);

%>

<%= entry %>

<%
		}
		System.out.println("");

%>
<br><br>
<%
	}

	connection.close();

} catch(SQLException exception) {

	System.out.println("Message:   " + exception.getMessage ());
}
%>