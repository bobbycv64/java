package cv64.jsp.beans;

public class Item {

	public Item(String itemID, String description, String price,
	    int quantity) {

		this.itemID = itemID;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public Item() {
		this("", "", "", 0);
	}

	public void display() {
		System.out.println("Item.toString()");

		System.out.println(price + description + itemID);
	}

	public String getDescription() {
		return(description);
	}

	public String getItemID() {
		return(itemID);
	}

	public String getPrice() {
		return(price);
	}

	public int getQuantity() {
		return quantity;
	}

	public double getTotalPrice() {

		double price = 1.00;
//		double price = Double.parseDouble(getUnitPrice());
		return(getQuantity() * price);
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setItem(String itemID, String description, String price,
	    int quantity) {

		setItemID(itemID);
		setDescription(description);
		setPrice(price);
		setQuantity(quantity);
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public synchronized String toHTMLTable() {

		StringBuffer stringBuffer = new StringBuffer("");
		stringBuffer.append("<center><table border=1><tr bgcolor=\"#FFAD00\"><td>");
		stringBuffer.append("<TR BGCOLOR=\"" + headingColor_ + "\">");

		// Heading
		stringBuffer.append("<TH>Attribute<TH>Value</TR>");

		// Details
		stringBuffer.append("<TR><TD>Item ID</TD><TD>" +
		    getItemID() + "</TD></TR>");
		stringBuffer.append("<TR><TD>Description</TD><TD>" +
		    getDescription() + "</TD></TR>");
		stringBuffer.append("<TR><TD>Price</TD><TD>" +
		    getPrice() + "</TD></TR>");
		stringBuffer.append("<TR><TD>Quantity</TD><TD>" +
		    getQuantity() + "</TD></TR>");

		stringBuffer.append("</TABLE>");
		return(stringBuffer.toString());
	}

	private static final String headingColor_ = "#FFAD00";
	private String price;
	private String description;
	private String itemID;
	private int quantity;
}
