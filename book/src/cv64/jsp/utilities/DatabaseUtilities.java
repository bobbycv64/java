package cv64.jsp.utilities;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.SQLException;

import cv64.jsp.database.DBResults;
import cv64.jsp.exception.ExceptionHandler;

public class DatabaseUtilities {

	public static Connection createTable(Connection connection, String username,
	    String password, String tableName, String tableFormat, String[] tableRows,
	    boolean close) {

		try {
			Statement statement = connection.createStatement();

			try {
				statement.execute("DROP TABLE " + tableName);

			} catch(Exception exception) {
				new ExceptionHandler(exception,
				    "DatabaseUtilities.createTable() ");
			}

			String createCommand =
				"CREATE TABLE " + tableName + " " + tableFormat;

			statement.execute(createCommand);
			String insertPrefix =
				"INSERT INTO " + tableName + " VALUES";

			for(int i=0; i<tableRows.length; i++) {
				statement.execute(insertPrefix + tableRows[i]);
			}

			if (close) {
				connection.close();
				return(null);
			} else {
				return(connection);
			}
		} catch(SQLException exception) {
			new ExceptionHandler(exception,
				"DatabaseUtilities.createTable()");
			return(null);
		}
	}

	public static Connection createTable(String driver, String url,
	    String username, String password, String tableName, String tableFormat,
	    String[] tableRows,	boolean close) {

		try {
			Class.forName(driver);
			Connection connection =
				DriverManager.getConnection(url, username, password);

			return(createTable(connection, username, password,
			    tableName, tableFormat, tableRows, close));

		} catch(Exception exception) {
			new ExceptionHandler(exception,
				"DatabaseUtilities.createTable()");
			return(null);
		}
	}

	public static DBResults getQueryResults(String driver, String url,
	    String username, String password, String query, boolean close) {

		try {
			Class.forName(driver);
			Connection connection =
			    DriverManager.getConnection(url, username, password);
			return(getQueryResults(connection, query, close));

		} catch(Exception exception) {
			new ExceptionHandler(exception,
				"DatabaseUtilities.getQueryResults()");
		}

		return(null);
	}

	public static DBResults getQueryResults(Connection connection,
	    String query, boolean close) {

		try {
			DatabaseMetaData dbMetaData = connection.getMetaData();

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			ResultSetMetaData resultsMetaData = resultSet.getMetaData();
			int columnCount = resultsMetaData.getColumnCount();
			String[] columnNames = new String[columnCount];

			for(int i=1; i < columnCount+1; i++) {
				columnNames[i-1] =
				    resultsMetaData.getColumnName(i).trim();
			}

			DBResults dbResults = new DBResults(connection,
			    columnCount, columnNames);

			while(resultSet.next()) {

				String[] row = new String[columnCount];
				for(int i=1; i<columnCount+1; i++) {
					String entry = resultSet.getString(i);

					if (entry != null) {
						entry = entry.trim();
					}

					row[i-1] = entry;
				}

				dbResults.addRow(row);
			}

			if (close) {
				connection.close();
			}

			return(dbResults);
		} catch (Exception exception) {
			new ExceptionHandler(exception,
				"DatabaseUtilities.getQueryResults()");
			return(null);
		}
	}


	private static String makeRow(String[] entries, int entryWidth) {

		String row = "|";

		for(int i=0; i<entries.length; i++) {
			row = row + padString(entries[i], entryWidth, " ");
			row = row + " |";
		}

		return(row);
	}

	private static String makeSeparator(int entryWidth, int columnCount) {

		String entry = padString("", entryWidth+1, "-");
		String separator = "+";

		for(int i=0; i < columnCount; i++) {
			separator = separator + entry + "+";
		}

		return(separator);
	}

	private static String padString(String orig, int size, String padChar) {

		if (orig == null) {
			orig = "<null>";
		}

		StringBuffer buffer = new StringBuffer("");
		int extraChars = size - orig.length();

		for(int i=0; i<extraChars; i++) {
			buffer.append(padChar);
		}

		buffer.append(orig);
		return(buffer.toString());
	}

	public static void printTable(String driver, String url, String username,
	    String password, String tableName, int entryWidth, boolean close) {

		String query = "SELECT * FROM " + tableName;
		DBResults results = getQueryResults(driver, url, username,
		    password, query, close);

		printTableData(tableName, results, entryWidth);
	}

	public static void printTable(Connection connection, String tableName,
	    int entryWidth, boolean close) {

		String query = "SELECT * FROM " + tableName;
		DBResults results =
			getQueryResults(connection, query, close);
		printTableData(tableName, results, entryWidth);
	}

	public static void printTableData(String tableName, DBResults results,
	    int entryWidth) {

		if (results == null) {
			return;
		}

		System.out.println(tableName + ":");

		String underline = padString("", tableName.length()+1, "=");
		System.out.println(underline);
		int columnCount = results.getColumnCount();
		String separator = makeSeparator(entryWidth, columnCount);
		System.out.println(separator);
		String row = makeRow(results.getColumnNames(), entryWidth);
		System.out.println(row);
		System.out.println(separator);
		int rowCount = results.getRowCount();

		for(int i=0; i<rowCount; i++) {
			row = makeRow(results.getRow(i), entryWidth);
			System.out.println(row);
		}

		System.out.println(separator);
	}
}
