// https://www.mkyong.com/jdbc/how-to-connect-to-mysql-with-jdbc-driver-java/
package jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {

	// private static final String DATABASE = "jdbc:mysql://localhost:3306/mysql";
	private static final String DATABASE = "jdbc:mariadb://localhost:3306/mysql";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	public static void main(String[] argv) {

		System.out.println("-------- MySQL JDBC Connection Testing ------------");

		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
		String sql = "select user from user";

		try {
			connection = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {

				String username = resultSet.getString("User");
				System.out.println("Username: " + username);
			}

			if (connection != null) {
				System.out.println("You made it, take control your database now!");
			} else {
				System.out.println("Failed to make connection!");
			}

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	}
}