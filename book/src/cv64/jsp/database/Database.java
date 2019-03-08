package cv64.jsp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cv64.jsp.exception.ExceptionHandler;

/**
 *  The <code>ExceptionHandler</code> returns the name of the exception that occured.
 *
 *  @author cv64, Inc.
 */
public class Database {

	void close() throws SQLException {

		try {
			connection_.commit();
			connection_.close();
		} catch (SQLException exception) {
			throw(exception);
		}
	}

	public void init() {

		try {
			Class.forName(driver_);
			open();   // open the database
			select(); // SQL Selection
			close();  // close the database
		} catch (Exception exception) {
			new ExceptionHandler(exception, "Database.init()");
		}
	}

	void open() throws SQLException {

		try {
			connection_ = DriverManager.getConnection(dsn_, username_, password_);
			connection_.setAutoCommit(false);
		} catch (SQLException exception) {
			throw(exception);
		}
	}

	void select() throws SQLException {

		Statement statement;
		String query;
		ResultSet resultSet;
		boolean more;

		query = "select * from radiationelectronicsnet where Field1='00-815984-30'";

		statement = connection_.createStatement();
		resultSet = statement.executeQuery( query );

		more = resultSet.next();
		if(!more) {
			System.out.println("No rows found.");
			return;
		}

		while(more) {

			System.out.println( "Misc1: " + resultSet.getString( "Field1" ) );
			System.out.println( "Misc2: " + resultSet.getString( "Field2" ) );
			System.out.println( "Misc3: " + resultSet.getString( "Field3" ) );
			System.out.println( "Misc4: " + resultSet.getString( "Field4" ) );
			System.out.println( "Misc5: " + resultSet.getString( "Field5" ) );
			more = resultSet.next();
		}

		resultSet.close();
		statement.close();
	}

	public static void main(String args[]) {
		Database database = new Database();
		database.init();
	}

	private static final String driver_ = "sun.jdbc.odbc.JdbcOdbcDriver";
	private static final String dsn_ = "jdbc:odbc:reDatabase";
	private static final String username_ = "Admin";
	private static final String password_ = "";
	private Connection connection_;
}
