package cv64.jsp.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseBean {

	public DatabaseBean() { 		KeyBean keyBean = new KeyBean();

		try {
			setExpired(keyBean.isExpired());

		} catch (Exception exception) {
			System.err.println("DatabaseBean()");
			System.err.println(exception.getMessage());
			System.exit(0);
		}
	}

	public void close() {
		try {
			if (connection_ != null) {
				connection_ = null;
			}

			if (statement_ != null) {
				statement_ = null;
			}

		} catch (Exception exception) {
			System.err.println("DatabaseBean.close()");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
	}

	public String getColumnNames() {

		StringBuffer buffer = new StringBuffer();

		try {
			ResultSetMetaData resultsMetaData = resultSet_.getMetaData();
			int columnCount = resultsMetaData.getColumnCount();

			for(int i=1; i < columnCount + 1; i++) {
				buffer.append(resultsMetaData.getColumnName(i).trim());
				buffer.append("\n");
			}

		} catch (SQLException exception) {
			System.err.println("DatabaseBean()");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}

		return buffer.toString();
	}

	public String getCompanyName() { return companyName_; }
	public Connection getConnection() { return connection_; }
	public String getDirectory() { return directory_; }
	public String getDatabaseDriver() { return databaseDriver_; }
	public String getDatabaseName() { return databaseName_; }
	public String getDatabaseTableName() { return databaseTableName_; }
	public String getDatabaseURL() { return databaseURL_; }
	private boolean getExpired() { return expired_; }

	public void getInstance() {

		try {
			if (expired_) return;

			if (connection_ != null) {
				connection_ = null;
			}

			if (statement_ != null) {
				statement_ = null;
			}

			connection_ =
			    DriverManager.getConnection(databaseURL_, username_, password_);

			statement_ = connection_.createStatement();

		} catch (SQLException exception) {
			System.err.println("DatabaseBean() - SQLException");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
	}

	public String getQuery() { return query_; }
	public String getQueryList() { return queryList_; }

	public String getResults() {

		StringBuffer buffer = new StringBuffer();

		try {
			ResultSetMetaData resultsMetaData = resultSet_.getMetaData();
			int columnCount = resultsMetaData.getColumnCount();

			while(resultSet_.next()) {

				for(int i=1; i < columnCount+1; i++) {
					buffer.append(resultSet_.getString(i).trim() + " ");
				}
				buffer.append("<br>");
			}

		} catch (SQLException exception) {
			if (DEBUG) {
				buffer.append("<br>DatabaseBean.getResults() - SQLException");
				buffer.append("<br>" + exception.getMessage());
			} else {
				System.err.println("DatabaseBean.getResults() - SQLException");
				System.err.println(exception.getMessage());
				exception.printStackTrace();
			}

		} catch (Exception exception) {
			if (DEBUG) {
				buffer.append("<br>DatabaseBean.getResults() - Exception");
				buffer.append("<br>" + exception.getMessage());
			} else {
				System.err.println("DatabaseBean.getResults() - Exception");
				System.err.println(exception.getMessage());
				exception.printStackTrace();
			}
		} finally {
			return buffer.toString();
		}
	}

	public String getResultsTable() {

		if (DEBUG) System.out.println("DatabaseBean.getResultsTable()");

		StringBuffer buffer = new StringBuffer();

		try {
			ResultSetMetaData resultsMetaData = resultSet_.getMetaData();
			int columnCount = resultsMetaData.getColumnCount();

			// Table
			buffer.append("<table border=1><tr bgcolor=\"#FFAD00\"><td>");
			buffer.append("<tr bgcolor=\"" + HEADING_COLOR + "\">\n");

			// Heading
			for(int i=1; i < columnCount + 1; i++) {
				buffer.append("<th>" +
				    resultsMetaData.getColumnName(i).trim() + "</th>");
			}

			// Detail
			while(resultSet_.next()) {

				buffer.append("<tr>");
				for(int i=1; i < columnCount+1; i++) {

					String result = resultSet_.getString(i).trim();
					buffer.append("<td>" + result + "</td>");
				}
				buffer.append("</tr>");
			}

			buffer.append("</table>");

		} catch (SQLException exception) {
			if (DEBUG) {
				buffer.append("<br>DatabaseBean.getResultsTable() - SQLException");
				buffer.append("<br>" + exception.getMessage());
			} else {
				System.err.println("DatabaseBean.getResultsTable() - SQLException");
				System.err.println(exception.getMessage());
				exception.printStackTrace();
			}

		} catch (Exception exception) {
			if (DEBUG) {
				buffer.append("<br>DatabaseBean.getResultsTable() - Exception");
				buffer.append("<br>" + exception.getMessage());
			} else {
				System.err.println("DatabaseBean.getResultsTable() - Exception");
				System.err.println(exception.getMessage());
				exception.printStackTrace();
			}
		} finally {
			return buffer.toString();
		}
	}

	public String getResultsTableLink() {

		if (DEBUG) System.out.println("DatabaseBean.getResultsTable()");

		StringBuffer buffer = new StringBuffer();

		try {
			ResultSetMetaData resultsMetaData = resultSet_.getMetaData();
			int columnCount = resultsMetaData.getColumnCount();

			// Table
			buffer.append("<table border=1><tr bgcolor=\"#FFAD00\"><td>");
			buffer.append("<tr bgcolor=\"" + HEADING_COLOR + "\">\n");

			// Heading
			buffer.append("<th>More Info</th>");

			for(int i=1; i < columnCount + 1; i++) {
				buffer.append("<th>" +
				    resultsMetaData.getColumnName(i).trim() + "</th>");
			}

			// Detail
			while(resultSet_.next()) {

				buffer.append("<tr>");
				for(int i=1; i < columnCount+1; i++) {

					String result = resultSet_.getString(i).trim();

					// make a link in the first column
					if (i == 1) {
						buffer = getURL(buffer, result);

					// make no links
					} else {
						buffer.append("<td>" + result + "</td>");
					}
				}
				buffer.append("</tr>");
			}

			buffer.append("</table>");

		} catch (SQLException exception) {
			if (DEBUG) {
				buffer.append("<br>DatabaseBean.getResultsTable() - SQLException");
				buffer.append("<br>" + exception.getMessage());
			} else {
				System.err.println("DatabaseBean.getResultsTable() - SQLException");
				System.err.println(exception.getMessage());
				exception.printStackTrace();
			}

		} catch (Exception exception) {
			if (DEBUG) {
				buffer.append("<br>DatabaseBean.getResultsTable() - Exception");
				buffer.append("<br>" + exception.getMessage());
			} else {
				System.err.println("DatabaseBean.getResultsTable() - Exception");
				System.err.println(exception.getMessage());
				exception.printStackTrace();
			}
		} finally {
			return buffer.toString();
		}
	}

	public ResultSet getResultSet() { return resultSet_; }
	public String getServerName() { return serverName_; }
	public String getServerPort() { return serverPort_; }
	public Statement getStatement() { return statement_; }

	private StringBuffer getURL(StringBuffer buffer, String result) {

		buffer.append("<td><form action=\"http://");
		buffer.append(getServerName() + ":" + getServerPort());
//		buffer.append("/servlet/Forwarder?pageReference=");
		buffer.append("/" + getDirectory() + "/");
		buffer.append(result + ".jsp" + "\" method=post >");
		buffer.append("<input type = \"submit\" name=\"keyValue\" value=\"");
		buffer.append(result + "\"></form></td>");
		buffer.append("<td>" + result + "</td>");

		return buffer;
	}
/*
	private StringBuffer getURL(StringBuffer buffer, String result) {

		buffer.append("<td><form action=\"http://");
		buffer.append(getServerName() + ":" + getServerPort());
		buffer.append("/servlet/Forwarder?pageReference=");
		buffer.append("/" + getDirectory() + "/");
		buffer.append(result + "\" method=post >");
		buffer.append("<input type = \"submit\" name=\"keyValue\" value=\"");
		buffer.append(result + "\"></form></td>");
		buffer.append("<td>" + result + "</td>");

		return buffer;
	}
*/
	public void performQuery() {

		if (DEBUG) System.out.println("DatabaseBean.performQuery()");

		String query = query = "select " + getQueryList() + " from " +
		    getDatabaseTableName() + " where ";

		// implied % at the end
		query += keyName_ + " like '" + keyValue_ + "%';";

		if (DEBUG) System.out.println("Query: " + query);

		try {
			resultSet_ = statement_.executeQuery(query);
		} catch (SQLException exception) {
			System.err.println("DatabaseBean.getSetQuery()");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
	}

	public void setCompanyName(String companyName) {
		companyName_ = companyName;
	}

	public void setDatabaseDriver(String databaseDriver) {
		databaseDriver_ = databaseDriver;
	}

	public void setDatabaseName(String databaseName) {
		databaseName_ = databaseName;
	}

	public void setDatabaseTableName(String databaseTableName) {
		databaseTableName_ = databaseTableName;
	}

	public void setDatabaseURL(String databaseURL) {
		databaseURL_ = databaseURL;
	}

	public void setDirectory(String directory) { directory_ = directory; }

	private void setExpired(boolean expired) { expired_ = expired; }

	public void setParameters(String keyName1, String keyValue1,
	    String keyName2, String keyValue2) {

		if (!keyValue1.equals("")) {
			keyName_ = keyName1;
			keyValue_ = keyValue1;

		} else if (!keyValue2.equals("")) {
			keyName_ = keyName2;
			keyValue_ = keyValue2;

		} else {
			keyName_ = "";
			keyValue_ = "";
		}
	}

	public void setQueryList(String queryList) { queryList_ = queryList; }
	public void setServerName(String serverName) { serverName_ = serverName; }
	public void setServerPort(String serverPort) { serverPort_ = serverPort; }

	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("Company Name: " + companyName_ + "<br>");
		stringBuffer.append("Connection: " + connection_ + "<br>");
		stringBuffer.append("Database Driver: " + databaseDriver_ + "<br>");
		stringBuffer.append("Database Name: " + databaseName_ + "<br>");
		stringBuffer.append("Database Table Name: " + databaseTableName_ + "<br>");
		stringBuffer.append("Database URL: " + databaseURL_ + "<br>");
		stringBuffer.append("Directory: " + directory_ + "<br>");
		stringBuffer.append("KeyName: " + keyName_ + "<br>");
		stringBuffer.append("KeyValue: " + keyValue_ + "<br>");
		stringBuffer.append("Query: " + query_ + "<br>");
		stringBuffer.append("Query List: " + queryList_ + "<br>");
		stringBuffer.append("ResultSet: " + resultSet_ + "<br>");
		stringBuffer.append("Server Name: " + serverName_ + "<br>");
		stringBuffer.append("Server Port: " + serverPort_ + "<br>");
		stringBuffer.append("Session: " + session_ + "<br>");
		stringBuffer.append("Statement: " + statement_ + "<br>");

		return stringBuffer.toString();
	}

	private static boolean expired_ = true;
	private static final boolean DEBUG = false;
	private static final String HEADING_COLOR = "#FFAD00";
	private static final int QUANTITY = 0;
	private static final int MAX_SIZE_QUERY = 10;

	private Connection connection_ = null;
	private ResultSet resultSet_ = null;
	private Statement statement_ = null;
	private String username_ = "";
	private String password_ = "";

	private String companyName_ = "";
	private String databaseDriver_ = "";
	private String databaseName_ = "";
	private String databaseTableName_ = "";
	private String databaseURL_ = "";
	private String directory_ = "";
	private String keyName_ = "";
	private String keyValue_ = "";
	private String query_ = "";
	private String queryList_ = "";
	private String serverName_ = "";
	private String serverPort_ = "";
	private String session_ = "";
}
