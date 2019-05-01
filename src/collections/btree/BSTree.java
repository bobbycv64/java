package collections.btree;

public class BSTree {

	BSTNode root = null;

	public BSTree() {}

	public void insert(int key) {
		root = insert(root, key);
	}

	public BSTNode insert(BSTNode node, int key) {
		if (node == null)
			node = new BSTNode(key);
		else {
			if (key <= node.getKey())
				insert(node.getLeft(), key);
			else
				insert(node.getRight(), key);
		}
		return node;
	}

	public BSTNode delete(BSTNode root, int x) {
		BSTNode p, p2, n;
		if (root.getKey() == x) {
			BSTNode lt, rt;
			lt = root.getLeft();
			rt = root.getRight();
			if (lt == null && rt == null)
				return null;
			else if (lt == null) {
				p = rt;
				return p;
			} else if (rt == null) {
				p = lt;
				return p;
			} else {
				p2 = rt;
				p = rt;
				while (p.getLeft() != null)
					p = p.getLeft();
				p.setLeft(lt);
				return p2;
			}
		}
		if (x < root.getKey()) {
			n = delete(root.getLeft(), x);
			root.setLeft(n);
		} else {
			n = delete(root.getRight(), x);
			root.setRight(n);
		}
		return root;
	}

	public boolean search(int val) {
		return search(root, val);
	}

	/* Function to search for an element recursively */
	private boolean search(BSTNode r, int val) {
		boolean found = false;
		while ((r != null) && !found) {
			int rval = r.getKey();
			if (val < rval)
				r = r.getLeft();
			else if (val > rval)
				r = r.getRight();
			else {
				found = true;
				break;
			}
			found = search(r, val);
		}
		return found;
	}

	public void inorder() {
		inorder(root);
	}

	private void inorder(BSTNode r) {
		if (r != null) {
			inorder(r.getLeft());
			System.out.print(r.getKey() + " ");
			inorder(r.getRight());
		}
	}

	public BSTNode getroot() {
		return root;
	}

	public int nodeHeight(BSTNode root) {
		if (root == null)
			return 0;

		int left = nodeHeight(root.getLeft());
		int right = nodeHeight(root.getRight());

		if (left == -1 || right == -1)
			return -1;

		if (Math.abs(left - right) > 1) {
			return -1;
		}

		return Math.max(left, right) + 1;
	}

	public int getLevel(BSTNode root, int level) {
		return level;
	}
}
