package lambda;

public class Cow {

	private int x = 0;
	private int y = 0;
	private int network = 0;
	
	public Cow(int x, int y, int network) {
		this.x = x;
		this.y = y;
		this.network = network;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getNetwork() {
		return network;
	}
	public void setNetwork(int network) {
		this.network = network;
	}
}
