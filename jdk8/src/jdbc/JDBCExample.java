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
		System.out.println("-------- JDBC Example ------------");
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
			System.out.println("JDBC Driver Registered");

			connection = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
			System.out.println("Connection Successful");

		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver Missing");
			e.printStackTrace();

		} catch (SQLException e) {
			System.err.println("JDBCExample.getConnection: Connection Failed");
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

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				String column1 = resultSet.getString(1);
				System.out.println("Column1: " + column1);
			}

		} catch (SQLException e) {
			System.err.println("JDBCExample.getResults: Statement / ResultSet Failed");
			e.printStackTrace();

			// final clean up of resultSet and statement
		} finally {
			if (resultSet != null) {
				resultSet = null;
			}

			if (statement != null) {
				statement = null;
			}
		}
	}

	/**
	 * closes the database connection
	 */
	private void closeConnection() {
		if (connection != null) {
			connection = null;
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