package cv64.jsp.beans;

import java.util.Vector;

public class Cart {

	public Cart() {
		itemsOrdered_ = new Vector();
	}

	public void display() {

		Item item = null;

		System.out.println("Cart.toString()");

		for (int i=0; i < itemsOrdered_.size(); i++) {
			item = (Item)itemsOrdered_.elementAt(i);

			System.out.println(item.getItemID());
			System.out.println(item.getDescription());
			System.out.println(item.getPrice());
		}
	}

	public Vector getItemsOrdered() {
		return(itemsOrdered_);
	}

	public String getLastItemOrdered() {
		Item item = (Item)itemsOrdered_.elementAt(itemsOrdered_.size()-1);

		return item.toHTMLTable();
	}

	public String getURLDescription() {
		return urlDescription_;
	}

	public String getURLResponse() {
		return urlResponse_;
	}

	public synchronized void orderItem(Item orderItem) {

		if (debug_) {
			System.out.println("Cart.orderItem()");
		}

		// always replace same item
		for(int i=0; i < itemsOrdered_.size(); i++) {

			Item item = (Item)itemsOrdered_.elementAt(i);

			if (item.getItemID().equals(orderItem.getItemID())) {

				// add items with quantity greater than 1
				if (orderItem.getQuantity() > 0) {
					itemsOrdered_.setElementAt(orderItem, i);
                               // remove items with quantity less than or equal to 0
				} else {
					itemsOrdered_.removeElementAt(i);
				}

				return;
			}
		}

		// add all new items with quantity greater than 1
		if (orderItem.getQuantity() > 0) {
			itemsOrdered_.addElement(orderItem);
		}
	}

	public void setURLDescription(String urlDescription) {
		urlDescription_ = urlDescription;
	}

	public void setURLResponse(String urlResponse) {
		urlResponse_ = urlResponse;
	}

	/**
	 * http://127.0.0.1:8080/cv64/CatalogOrder?itemID=123&description=abc&price=15&quantity=5
	 */
	public synchronized String toHTMLTable() {

		Item item = null;

		StringBuffer stringBuffer = new StringBuffer("");
		stringBuffer.append("<center><table border=1><tr bgcolor=\"#FFAD00\"><td>");
		stringBuffer.append("<TR BGCOLOR=\"" + headingColor_ + "\">\n");

		// Heading
		stringBuffer.append("<TH>Part Number<TH>Description<TH>Price" +
		    "<TH>Quantity<TH>Item Total");

		for (int i=0; i < itemsOrdered_.size(); i++) {
			item = (Item)itemsOrdered_.elementAt(i);

			stringBuffer.append("<TR><TD>" + item.getItemID() + "</TD>");
			stringBuffer.append("<TD><a href=" + urlDescription_ +
			item.getItemID() + ".jsp>" + item.getDescription() + "</a></TD>");
			stringBuffer.append("<TD>" + item.getPrice() + "</TD>");

			stringBuffer.append("<td><FORM ACTION=\"" + urlResponse_ + "\">\n" +

					    "<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\"\n" +
					    "VALUE=\"" + item.getItemID() + "\">\n" +

					    "<INPUT TYPE=\"HIDDEN\" NAME=\"description\"\n" +
					    "VALUE=\"" + item.getDescription() + "\">\n" +

					    "<INPUT TYPE=\"HIDDEN\" NAME=\"price\"\n" +
					    "VALUE=\"" + item.getPrice() + "\">\n" +

					    "<INPUT TYPE=\"TEXT\" NAME=\"quantity\"\n" +
					    "SIZE=3 VALUE=\"" + item.getQuantity() +

					    "\">\n" + "<SMALL>\n<INPUT TYPE=\"SUBMIT\"\n "+
					    "VALUE=\"Update Order\">\n" +
					    "</SMALL>\n" + "</FORM>\n");

			stringBuffer.append("<TD>" + item.getTotalPrice() + "</TD></TR>");
		}

		stringBuffer.append("\n</TABLE>");
		return(stringBuffer.toString());
	}

	private static final boolean debug_ = true;
	private static final String headingColor_ = "#FFAD00";
	private Vector itemsOrdered_;
	private String urlDescription_;
	private String urlResponse_;
}
