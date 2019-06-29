// https://www.mkyong.com/jdbc/how-to-connect-to-mysql-with-jdbc-driver-java/
package jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * database example program
 * 
 * @author RWE001
 *
 */
public class JDBCExample {

	// private static final String DATABASE = "jdbc:mysql://localhost:3306/mysql";
	private static final String DATABASE = "jdbc:mariadb://localhost:3306/mysql";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	private Connection connection = null;
	private String sql = "show tables";

	public JDBCExample() {
		System.out.println("JDBCExample()");
		getConnection();
		getResults();
		closeConnection();
	}

	/**
	 * gets the database connection
	 */
	private void getConnection() {

		try {
			Class.forName("org.mariadb.jdbc.Driver"); // Class.forName("com.mysql.jdbc.Driver");
			System.out.println("JDBCExample.getConnection(): JDBC Driver Registered");

			connection = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
			System.out.println("JDBCExample.getConnection(): Connection Successful");

		} catch (ClassNotFoundException e) {
			System.out.println("JDBCExample.getConnection(): JDBC Driver Missing");
			e.printStackTrace();

		} catch (SQLException e) {
			System.err.println("JDBCExample.getConnection(): Connection Failed");
			e.printStackTrace();
		}
	}

	/**
	 * uses the connection to access the database, creates a database statement and
	 * gets the results of the statement
	 */
	private void getResults() {
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.createStatement();

			System.out.println("JDBCExample.getResults(): SQL: " + sql);
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				String column1 = resultSet.getString(1);
				System.out.println("JDBCExample.getResults(): Column1: " + column1);
			}

		} catch (SQLException e) {
			System.err.println("JDBCExample.getResults(): Statement / ResultSet Failed");
			e.printStackTrace();

			// final clean up of resultSet and statement
		} finally {
			System.out.println("JDBCExample.getResults(): finally");
			if (resultSet != null) {
				resultSet = null;
				System.out.println("JDBCExample.getResults(): resultSet closed");
			}

			if (statement != null) {
				statement = null;
				System.out.println("JDBCExample.getResults(): statement closed");
			}
		}
	}

	/**
	 * closes the database connection
	 */
	private void closeConnection() {
		System.out.println("JDBCExample.closeConnection()");
		if (connection != null) {
			connection = null;
			System.out.println("JDBCExample.closeConnection(): connection closed");
		}
	}

	/**
	 * start the JDBC Example program and calls the no argument Constructor
	 * 
	 * @param argc
	 */
	public static void main(String[] argc) {

		new JDBCExample();
	}
}