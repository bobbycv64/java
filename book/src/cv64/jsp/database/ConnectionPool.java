package cv64.jsp.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

import cv64.jsp.exception.ExceptionHandler;

public class ConnectionPool implements Runnable {

public ConnectionPool(String driver, String url, String username,
	    String password, int initialConnections, int maxConnections,
	    boolean waitIfBusy) throws Exception {

		if (debug_) System.out.println("ConnectionPool(Driver: " +
		    driver + ", URL: " + url + ", Username: " + username +
		    ", Password: " + password + ", Initial Connections: " +
		    initialConnections + ", Maximum Connections: " + maxConnections +
		    ", Wait If Busy: " + waitIfBusy + ")");

		driver_ = driver;
		url_ = url;
		username_ = username;
		password_ = password;
		maxConnections_ = maxConnections;
		waitIfBusy_ = waitIfBusy;

		if (initialConnections > maxConnections) {
			initialConnections = maxConnections;
		}

		availableConnections_ = new Vector(initialConnections);
		busyConnections_ = new Vector();

		for(int i=0; i < initialConnections; i++) {
			availableConnections_.addElement(makeNewConnection());
		}
	}

	public synchronized void closeAllConnections() {

		if (debug_) System.out.println("ConnectionPool.closeAllConnections()");

		closeConnections(availableConnections_);
		availableConnections_ = new Vector();
		closeConnections(busyConnections_);
		busyConnections_ = new Vector();
	}

	private void closeConnections(Vector connections) { 		if (debug_) System.out.println("ConnectionPool.closeConnections()");

		try {
			for(int i=0; i < connections.size(); i++) {
				Connection connection =
				    (Connection)connections.elementAt(i);

				if (!connection.isClosed()) {
					connection.close();
				}
			}
		} catch (SQLException exception) {
			new ExceptionHandler(exception, "Database.closeConnections()");
		}
	}

	public synchronized void free(Connection connection) {

		if (debug_) System.out.println("ConnectionPool.free()");

		busyConnections_.removeElement(connection);
		availableConnections_.addElement(connection);
		notifyAll();
	}

	public synchronized Connection getConnection() throws SQLException { 		if (debug_) System.out.println("ConnectionPool.getConnection()");

		if (!availableConnections_.isEmpty()) {
			Connection existingConnection =
			    (Connection)availableConnections_.lastElement();

			int lastIndex = availableConnections_.size() - 1;
			availableConnections_.removeElementAt(lastIndex);

			if (existingConnection.isClosed()) {
				notifyAll();
				return(getConnection());
			} else {
				busyConnections_.addElement(existingConnection);
				return(existingConnection);
			}
		} else {
			if ((totalConnections() < maxConnections_) && !connectionPending_) {
				makeBackgroundConnection();
			} else if (!waitIfBusy_) {
				throw new SQLException("Connection limit reached");
			}

			try {
				wait();
			} catch (InterruptedException exception) {
				new ExceptionHandler(exception,
				    "ConnectionPool.getConnection()");
			}

			return(getConnection());
		}
	}

	private void makeBackgroundConnection() { 		if (debug_) System.out.println("ConnectionPool.makeBackgroundConnection()");

		connectionPending_ = true; 		try {
			Thread connectThread = new Thread(this);
			connectThread.start();
		} catch (OutOfMemoryError exception) {
			new ExceptionHandler(exception.getMessage(),
			    "ConnectionPool.makeBackgroundConnection()");
		}
	}

	private Connection makeNewConnection() throws SQLException { 		if (debug_) System.out.println("ConnectionPool.makeNewConnection()");

		try {
			System.out.println("ConnectionPool.makeNewConnection() " +
			    "Class.forName(" + driver_ + ")");

			Class.forName(driver_); 			System.out.println("ConnectionPool.makeNewconnection() " +
			    "URL: " + url_ + ", Username: " + username_ +
			    ", Password: " + password_);

			Connection connection =
			    DriverManager.getConnection(url_, username_, password_);

			return(connection);

		} catch (ClassNotFoundException cnfe) {
			throw new SQLException("ConnectionPool.makeNewConnection() " +
			    "Can't find class for driver: " + driver_);
		}
	}

	public void run() {

		if (debug_) System.out.println("ConnectionPool.run()");

		try {
			Connection connection = makeNewConnection();
			synchronized(this) {
				availableConnections_.addElement(connection);
				connectionPending_ = false;
				notifyAll();
			}

		} catch (Exception exception) {
			new ExceptionHandler(exception, "ConnectionPool.run()");
		}
	}

	public synchronized String toString() { 		if (debug_) System.out.println("ConnectionPool.toString()");

		String info = "ConnectionPool(" + url_ + "," + username_ + ")" +
		    ", available=" + availableConnections_.size() +
		    ", busy=" + busyConnections_.size() + ", max=" + maxConnections_;

		return(info);
	}

	public synchronized int totalConnections() {

		if (debug_) System.out.println("ConnectionPool.totalConnections()");

		return(availableConnections_.size() +
		busyConnections_.size());
	}

	private static final boolean debug_ = true;

	private Vector availableConnections_, busyConnections_;
	private String driver_, url_, username_, password_;
	private int maxConnections_;
	private boolean waitIfBusy_;
	private boolean connectionPending_ = false;
}
