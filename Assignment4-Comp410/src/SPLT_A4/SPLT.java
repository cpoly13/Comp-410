package SPLT_A4;

public class SPLT implements SPLT_Interface {
	public BST_Node root;
	private int size;

	public SPLT() {
		this.size = 0;
	}

	public BST_Node getRoot() { // please keep this in here! I need your root
								// node to test your tree!
		return root;
	}

	@Override
	public void insert(String s) {
		// TODO Auto-generated method stub

		BST_Node node = new BST_Node(s, null);
		if (size == 0) {
			root = node;
			size++;

		}

		else {

			BST_Node toRoot = root.insertNode(node);

			if (toRoot.justMade == true) {
				size++;
			}
			root = toRoot;

		}

	}

	@Override
	public void remove(String s) {
		// TODO Auto-generated method stub

		if (contains(s)) {

			BST_Node l = root.left;

			BST_Node r = root.right;
			root.left = null;
			root.right = null;
			size--;
			if (l != null) {
				l.parent = null;
				root = l;
				l.findMax();
				l.right = r;

				if (r != null) {
					r.parent = l;
				}

			}

			else {
				if (r != null) {
					r.parent = null;
					root = r;
					r.findMax();
				}

			}

			

		}

	}

	@Override
	public String findMin() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return null;
		}
		BST_Node toRoot = root.findMin();
		root = toRoot;

		return toRoot.data;

	}

	@Override
	public String findMax() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return null;
		}
		BST_Node toRoot = root.findMax();
		root = toRoot;

		return toRoot.data;

	}

	@Override
	public boolean empty() {

		return (size == 0);
	}

	@Override
	public boolean contains(String s) {
		// TODO Auto-generated method stub
		if (size == 0) {
			return false;
		}

		else {

			BST_Node toRoot = root.containsNode(s);

			root = toRoot;
			return (toRoot.data.equals(s));

		}

	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public int height() {

		if (size == 0) {
			return -1;
		}
		return root.getHeight();
	}

}