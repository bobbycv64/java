/**
 * Content Class the contains a data integer with getters and setters for the data integer
 * @author cv64
 */
package collections.linkedList;

public class Content implements INode {

	private int data = 0;
	
	/*
	private String string = "abc";
	private double bigNumber = 3;
	private float halfNumber = 1.5f;
	private Object object = null;
	*/

	public Content(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
