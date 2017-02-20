package BST_A2;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	BST_Node parent;

	BST_Node(String data, BST_Node parent) {
		this.data = data;
		this.parent = parent;
	}

	// --- used for testing ----------------------------------------------
	//
	// leave these 3 methods in, as is

	public String getData() {
		return data;
	}

	public BST_Node getLeft() {
		return left;
	}

	public BST_Node getRight() {
		return right;
	}

	// --- end used for testing -------------------------------------------

	// --- fill in these methods ------------------------------------------
	//
	// at the moment, they are stubs returning false
	// or some appropriate "fake" value
	//
	// you make them work properly
	// add the meat of correct implementation logic to them

	// you MAY change the signatures if you wish...
	// make the take more or different parameters
	// have them return different types
	//
	// you may use recursive or iterative implementations

	public boolean containsNode(String s) {

		if (data.equals(s)) {
			return true;
		}

		else if (left == null && right == null) {

			return false;
		}

		else if (left == null) {

			return right.containsNode(s);
		}

		else if (right == null) {
			return left.containsNode(s);
		}

		else {
			return (left.containsNode(s) || right.containsNode(s));

		}
	}

	public boolean insertNode(BST_Node n) {
		if (left == null && right == null) {
			if (n.getData().compareTo(data) < 0) {
				n.parent = this;
				left = n;
				return true;
			} else {
				n.parent = this;
				right = n;
				return true;
			}
		}

		else if (left == null) {
			if (n.getData().compareTo(data) < 0) {
				n.parent = this;
				left = n;
				return true;
			}

			else {
				
				return right.insertNode(n);

			}
		}

		else if (right == null) {
			if (n.getData().compareTo(data) > 0) {
				n.parent = this;
				right = n;
				return true;
			}

			else {
				return left.insertNode(n);

			}
		}

		else {
			if (n.getData().compareTo(data) > 0) {
				return right.insertNode(n);

			}

			else {
				return left.insertNode(n);
			}
		}
	}

	public boolean removeNode(String s) {
		BST_Node temp;

		temp = this;

		if (this.data != s) {

			if (right == null && left == null) {
				return false;
			} else if (s.compareTo(data) > 0) {
				if (right != null) {
					return right.removeNode(s);
				}

				else {
					return left.removeNode(s);
				}
			}

			else if (s.compareTo(data) < 0) {
				if (left != null) {
					return left.removeNode(s);
				}

				else {
					return right.removeNode(s);
				}
			}

		}

		else {

			if (right == null && left == null) {
				if (parent.left.equals(this)) {
					parent.left = null;
					return true;
				}

				else {
					parent.right = null;
					return true;
				}
			}

			if (right != null && left != null) {
				BST_Node maxHolder;
				maxHolder = left.findMax();
				this.data = maxHolder.data;
				left.removeNode(data);
				return true;
			}

			if (left != null) {
				if (parent.left.equals(this)) {
					parent.left = right;
					right.parent = parent;
					return true;
				}

				else {
					parent.right = right;
					right.parent = parent;
					return true;
				}
			}

			else {
				if (parent.left.equals(this)) {
					parent.left = left;
					left.parent = parent;
					return true;
				}

				else {
					parent.right = left;
					left.parent = parent;
					return true;
				}
			}

		}
		return false;
	}

	public BST_Node findMin() {

		if (left != null) {
			return left.findMin();
		}

		return this;
	}

	public BST_Node findMax() {

		if (right != null) {
			return right.findMax();
		}

		return this;
	}

	public int getHeight() {

		if (left == null && right == null) {
			return 0;
		}

		else if (left == null) {
			return right.getHeight() + 1;
		}

		else if (right == null) {
			return left.getHeight() + 1;
		}

		else {
			if (left.getHeight() >= right.getHeight()) {
				return left.getHeight() + 1;
			}

			else {
				return right.getHeight() + 1;
			}
		}

	}

	// --- end fill in these methods --------------------------------------

	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------

	public String toString() {
		return "Data: " + this.data + ", Left: " + ((this.left != null) ? left.data : "null") + ",Right: "
				+ ((this.right != null) ? right.data : "null");
	}
}