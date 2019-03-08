package cv64.jsp.utilities;

public class DriverUtilities {

	public static String makeURL(String host, String databaseName, int vendor) {

		if (vendor == ORACLE) {
			return("jdbc:oracle:thin:@" + host + ":1521:" + databaseName);
		} else if (vendor == SYBASE) {
			return("jdbc:sybase:Tds:" + host  + ":1521" +
			    "?SERVICENAME=" + databaseName);
		} else if (vendor == MYSQL) {
			return("jdbc:mysql://" + host + ":3306/" + databaseName);
		} else if (vendor == MS) {
			return("jdbc:odbc:" + databaseName);
		} else {
			return(null);
		}
	}

	public static String getDriver(int vendor) {

		if (vendor == ORACLE) {
			return("oracle.jdbc.driver.OracleDriver");
		} else if (vendor == SYBASE) {
			return("com.sybase.jdbc.SybDriver");
		} else if (vendor == MYSQL) {
			return("org.gjt.mm.mysql.Driver");
		} else if (vendor == MS) {
			return("sun.jdbc.odbc.JdbcOdbcDriver");
		} else {
			return(null);
		}
	}

	public static int getVendor(String vendorName) {

		if (vendorName.equalsIgnoreCase("oracle")) {
			return(ORACLE);
		} else if (vendorName.equalsIgnoreCase("sybase")) {
			return(SYBASE);
		} else if (vendorName.equalsIgnoreCase("mysql")) {
			return(MYSQL);
		} else {
			return(UNKNOWN);
		}
	}

	public static final int ORACLE = 1;
	public static final int SYBASE = 2;
	public static final int MYSQL = 3;
	public static final int MS = 666;
	public static final int UNKNOWN = -1;
}
