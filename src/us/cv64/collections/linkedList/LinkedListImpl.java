/**
 * LinkedListImpl - simple class example of a single linked list
 * @author cv64
 */
package us.cv64.collections.linkedList;

public class LinkedListImpl {

	// current node
	private Node node = null;
	
	// next node
	private Node next = null;

	public LinkedListImpl() {

		for (int i = 0; i < 3; i++) {

			// create new node, Content is the data, next is the next pointer
			node = new Node(new Content(i), next);

			// set the next node to equal the new node
			next = node;

			System.out.println("Data: " + node.getContent().getData());
		}

		System.out.println("End Constructor");
	}

	public static void main(String[] args) {
		new LinkedListImpl();

		System.out.println("End Program");
	}
}