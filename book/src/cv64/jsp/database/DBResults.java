package cv64.jsp.database;

import java.sql.Connection;
import java.util.StringTokenizer;
import java.util.Vector;

import cv64.jsp.beans.Database;

public class DBResults {

	public DBResults(Connection connection, int columnCount, String[] columnNames) {

		connection_ = connection;
		columnCount_ = columnCount;
		columnNames_ = columnNames;
		rowData_ = new String[columnCount];
		queryResults_ = new Vector();
	}

	public void addRow(String[] row) {
		queryResults_.addElement(row);
	}

	public String getCell(int row, int column) {
		return ((String[])queryResults_.elementAt(row))[column];
	}

	public int getColumnCount() {
		return(columnCount_);
	}

	public String[] getColumnNames() {
		return(columnNames_);
	}

	public Connection getConnection() {
		return(connection_);
	}

	public String[] getRow(int index) {
		return((String[])queryResults_.elementAt(index));
	}

	public int getRowCount() {
		return(queryResults_.size());
	}

	public void setDatabaseBean(Database database) {
		database_ = database;
	}

	public String toHTMLTable() {

		String urlCart = database_.getURLCart();
		String urlDescription = database_.getURLDescription();
		String urlImages = database_.getURLImages();
		String urlResponse = database_.getURLResponse();

		StringBuffer stringBuffer = new StringBuffer("");
		stringBuffer.append("<center><table border=1><tr bgcolor=\"#FFAD00\"><td>");
		stringBuffer.append("<TR BGCOLOR=\"" + headingColor_ + "\">\n");

		// Heading
		stringBuffer.append("<TH>Add To Cart<TH>Quantity");

		for(int col=0; col < getColumnCount(); col++) {
			stringBuffer.append("<TH>" + columnNames_[col]);
		}

		// Detail Rows
		for(int row=0; row < getRowCount(); row++) {

			stringBuffer.append("\n<TR>\n");
			String[] rowData = getRow(row);

			// append %20 in place of space in URL
			String description = "";
			StringTokenizer token =
			    new StringTokenizer(rowData[DESCRIPTION]);

			while (token.hasMoreTokens()) {
				description += token.nextToken() + "%20";
			}

			stringBuffer.append(
			    "<TD><a href=\"" + urlResponse + "?itemID=" +
			    rowData[ITEM_ID] + "&description=" + description +
			    "&price=" + rowData[PRICE] +
			    "&quantity=1\"><center><img src=\"" + urlImages +
			    "AddCart.jpg\" " + "height=37 width=76></center></TD>");

			stringBuffer.append("<TD><FORM ACTION=\"" + urlResponse + "\">\n" +
					    "<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\"\n" +
					    "VALUE=\"" + rowData[ITEM_ID] + "\">\n" +

					    "<INPUT TYPE=\"HIDDEN\" NAME=\"description\"\n" +
					    "VALUE=\"" + rowData[DESCRIPTION] + "\">\n" +

					    "<INPUT TYPE=\"HIDDEN\" NAME=\"price\"\n" +
					    "VALUE=\"" + rowData[PRICE] + "\">\n" +

					    "<INPUT TYPE=\"TEXT\" NAME=\"quantity\"\n" +
					    "SIZE=3 VALUE=\"" + QUANTITY + "\">\n" + "<SMALL>\n");

			stringBuffer.append("<INPUT TYPE=\"SUBMIT\"\n "+
			    "VALUE=\"Add To Cart\">\n" +
			    "</SMALL>\n" + "</FORM>\n</TD>");

			for(int col=0; col < getColumnCount(); col++) {

				// part number - column 0
				if (col == ITEM_ID) {
					stringBuffer.append("<TD>" + rowData[col] + "</a>");
				}

				// detailed description - column 1
				else if (col == DESCRIPTION) {
					stringBuffer.append("<TD><a href=" + urlDescription +
					rowData[0] +  ".jsp>" + rowData[col] + "</a>");

				// non linked columns
				} else {
					stringBuffer.append("<TD>" + rowData[col]);
				}
			}
		}

		stringBuffer.append("\n</TABLE>");
		return(stringBuffer.toString());
	}

	private static final String headingColor_ = "#FFAD00";
	private static final int ITEM_ID = 0;
	private static final int DESCRIPTION = 1;
	private static final int PRICE = 2;
	private static final int QUANTITY = 0;

	private Connection connection_;
	private int columnCount_;
	private String[] columnNames_;
	private Database database_;
	private Vector queryResults_;
	private String[] rowData_;
}
