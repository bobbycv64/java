package interfaceExample;

public class Message {

	private String id;
	private String message;
	private boolean isHowler;
	private boolean returnReceipt;

	public Message() {
		this.id = "000";
		this.message = "Default message";
		this.isHowler = false;
		this.returnReceipt = false;

	}

	public Message(String id, String message, boolean isHowler, boolean returnReceipt) {
		this.id = id;
		this.message = message;
		this.isHowler = isHowler;
		this.returnReceipt = returnReceipt;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean getIsHowler() {
		return isHowler;
	}

	public void setIsHowler(boolean isHowler) {
		this.isHowler = isHowler;
	}

	public boolean getReturnReceipt() {
		return returnReceipt;
	}

	public void setReturnReceipt(boolean returnReceipt) {
		this.returnReceipt = returnReceipt;
	}

	public void howl() {
		if (getIsHowler()) {
			System.out.println(getMessage().toUpperCase());
		}
	}

	@Override
	public String toString() {
		return "Message{" + "id=" + id + ", message=" + message + ", isHowler=" + isHowler + ", returnReceipt="
				+ returnReceipt + '}';
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Message)) {
			return false;
		}

		Message other = (Message) obj;
		if (getId().equals(other.getId()) && getMessage().equals(other.getMessage())
				&& getIsHowler() == other.getIsHowler() && getReturnReceipt() == other.getReturnReceipt()) {
			return true;
		} else {
			return false;
		}
	}

}