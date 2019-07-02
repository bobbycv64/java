// https://www.mkyong.com/jdbc/how-to-connect-to-mysql-with-jdbc-driver-java/
package jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * database example program
 */
public class JDBCExample {

	// if using mysql uncomment
	// private static final String DATABASE = "jdbc:mysql://localhost:3306/mysql";

	// if using mariadb uncomment
	private static final String DATABASE = "jdbc:mariadb://localhost:3306/mysql";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	private Connection connection = null;

	public JDBCExample() {
		System.out.println("JDBCExample()");
		getConnection();
		executeQueryExample();
		executeUpdateExample();
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
	 * READONLY - SELECT This examples performs the executeQuery method which is
	 * (select) statement Uses the connection to access the database, creates a
	 * database statement and gets the results of the statement.
	 */
	private void executeQueryExample() {
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "select * from example.table1";

		try {
			statement = connection.createStatement();

			System.out.println("JDBCExample.executeQueryExample(): SQL: " + sql);
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				String column1 = resultSet.getString(1);
				System.out.println("JDBCExample.executeQueryExample(): Column1: " + column1);
			}

		} catch (SQLException e) {
			System.err.println("JDBCExample.executeQueryExample(): Statement / ResultSet Failed");
			e.printStackTrace();

			// final clean up of resultSet and statement
		} finally {
			System.out.println("JDBCExample.executeQueryExample(): finally");
			if (resultSet != null) {
				resultSet = null;
				System.out.println("JDBCExample.executeQueryExample(): resultSet closed");
			}

			if (statement != null) {
				statement = null;
				System.out.println("JDBCExample.executeQueryExample(): statement closed");
			}
		}
	}

	/**
	 * WRITE - INSERT INTO, UPDATE, DELETE This examples performs the executeUpdate
	 * method which are (insert, update, delete) statements Uses the connection to
	 * access the database, creates a database statement and gets the results of the
	 * statement.
	 */
	private void executeUpdateExample() {
		Statement statement = null;
		String sql = "insert into example.table1 values "
				+ "(4, 'steve', '1313 Mockingbird Lane', 'Mockingbird Heights', 'AZ', 00000)";
		int rows = 0;

		try {
			statement = connection.createStatement();

			System.out.println("JDBCExample.executeUpdateExample(): SQL: " + sql);
			rows = statement.executeUpdate(sql);

			System.out.println("JDBCExample.executeUpdateExample(): rows updated: " + rows);

		} catch (SQLException e) {
			System.err.println("JDBCExample.executeUpdateExample(): Statement / ResultSet Failed");
			e.printStackTrace();

			// final clean up of resultSet and statement
		} finally {
			System.out.println("JDBCExample.executeUpdateExample(): finally");

			if (statement != null) {
				statement = null;
				System.out.println("JDBCExample.executeUpdateExample(): statement closed");
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