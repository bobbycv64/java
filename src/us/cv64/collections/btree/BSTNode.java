package us.cv64.collections.btree;

public class BSTNode {
	
	private int key;
	private BSTNode left;
	private BSTNode right;

	public BSTNode(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}
	
	public BSTNode() {
		this(0);
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}
}
