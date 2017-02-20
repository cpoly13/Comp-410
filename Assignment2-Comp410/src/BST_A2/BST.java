package BST_A2;

public class BST implements BST_Interface {
	public BST_Node root;
	int size;

	public BST() {
		size = 0;
		root = null;
	}

	@Override
	// used for testing, please leave as is
	public BST_Node getRoot() {
		return root;
	}

	@Override
	public boolean insert(String s) {

		if (this.contains(s)) {
			return false;
		}

		else {
			BST_Node node = new BST_Node(s, null);
			if (size == 0) {
				root = node;
				size++;
				return true;
			}

			else {
				size++;
				return root.insertNode(node);

			}
		}

	}

	@Override
	public boolean remove(String s) {

		if (size == 0) {
			return false;
		}
		if (root.data.equals(s)) {
			BST_Node maxHolder;
			if (root.left == null && root.right == null) {
				root = null;
				size = 0;
				return true;
			} else if (root.left != null && root.right != null) {
				maxHolder = root.left.findMax();
				root.data = maxHolder.data;
				root.left.removeNode(maxHolder.data);
				size--;
				return true;
			}

			else {
				if (root.left != null) {
					root = root.left;
					root.parent = null;
					size--;
					return true;
				}

				else {
					root = root.right;
					root.parent = null;
					size--;
					return true;
				}
			}
		}

		else {

			if (root.removeNode(s)) {
				size--;
				return true;
			}

			else {
				return false;
			}
		}
	}

	@Override
	public String findMin() {

		if (size == 0) {
			return null;
		}

		return root.findMin().data;

	}

	@Override
	public String findMax() {
		if (size == 0) {
			return null;
		}
		return root.findMax().data;
	}

	@Override
	public boolean empty() {

		return (size == 0);

	}

	@Override
	public boolean contains(String s) {

		if (size == 0) {
			return false;
		}

		else {

			return root.containsNode(s);
		}

	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public int height() {
		if(size==0){
			return -1;
		}
		return root.getHeight();
	}

}
