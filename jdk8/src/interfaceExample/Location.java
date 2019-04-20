package interfaceExample;

import java.util.ArrayList;

public class Location {

	private String name;
	// private ArrayList<Bird> aviary = new ArrayList<Bird>();
	private ArrayList<Bird> aviary;

	public Location(String name) {

		this.name = name;
		this.aviary = new ArrayList<Bird>();

		// private ArrayList<Bird>aviary = new ArrayList<Bird>();

	}

	public String getName() {
		return name;
	}

	
	// Set the Message on your Messenger to null (they are no longer carrying a Message)
	public void receiveMessage(Message msg, Messenger messenger) {

		System.out.println("Message Received at " + name + ": " + msg.getMessage());

		if (messenger instanceof Bird) {

			System.out.println("messenger is a Bird");
			messenger.setMessage();
			aviary.add((Bird) messenger);

		}
	}

	public void sendMessage(Message msg, Location destination, int distance) {
		System.out.println(msg);

	}

	private Message createRR(Message msg) {
		Message rr = new Message(msg.getId() + "RR", "Recieved message " + msg.getId() + " at location " + getName(),
				false, false);
		return rr;
	}

	@Override
	public String toString() {
		return "Location{" + "name=" + name + ", aviary=" + aviary + '}';
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Location)) {
			return false;
		} else {
			Location other = (Location) obj;
			if (getName().equalsIgnoreCase(other.getName())) {
				return true;
			} else {
				return false;
			}
		}
	}

}
