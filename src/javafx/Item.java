package javafx;

public class Item {

	private int index = 0;
	private String firstName = "";
	private String lastName = "";

	public Item(int index, String firstName, String lastName) {
		this.index = index;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Item() {
		this(0, "", "");
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
