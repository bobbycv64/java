package interfaceExample;

public class Bird implements Messenger {

	private Location destination;
	private int distanceTodestination;
	private int wingspan;



	public Bird() {

		this.destination = new Location("Unknown");
		this.distanceTodestination = 0;
		this.wingspan = 0;
	}

	public Bird(Location inDestination, int inDistanceToDestination, int inWingSpan) {
		setDestination(inDestination);
		setDistanceToDestination(inDistanceToDestination);
		setWingSpan(inWingSpan);
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}

	public int getDistanceToDestination() {
		return distanceTodestination;
	}

	public void setDistanceToDestination(int distanceToDestination) {
		this.distanceTodestination = distanceTodestination;
	}

	public int getWingSpan() {
		return wingspan;
	}

	public void setWingSpan(int wingspan) {
		this.wingspan = wingspan;
	}

	@Override
	public String toString() {
		return "Bird{" + "destination=" + destination + ", distanceTodestination=" + distanceTodestination
				+ ", wingspan=" + wingspan + '}';
	}


	@Override
	public void setMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCarryingCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Trave(int time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isOutforDelivery() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSpeed(int travelSpeed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeMessage() {
		// TODO Auto-generated method stub
		
	}

}
