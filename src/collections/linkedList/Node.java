/**
 * Node - simple class of a Node in a linked list
 * @author cv64
 */
package collections.linkedList;

public class Node {

	// Content - data object, AKA the top part of the node
	private Content content = null;

	// Node - pointer to a Node, AKA the bottom part of the node
	private Node next = null;

	/**
	 * Constructor the builds a Node object
	 * 
	 * @param content - data object
	 * @param next - pointer to a Node
	 */
	public Node(Content content, Node next) {
		this.content = content;
		this.next = next;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}