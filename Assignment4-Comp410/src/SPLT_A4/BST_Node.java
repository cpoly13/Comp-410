package SPLT_A4;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	BST_Node parent;
	boolean justMade; // could be helpful if you change some of the return types
						// on your BST_Node insert.
	// I personally use it to indicate to my SPLT insert whether or not we
	// increment size.

	BST_Node(String data, BST_Node parent) {
		this.data = data;
		this.parent = parent;
		justMade=true;
	}

	BST_Node(String data) { // new for SPLT
		this.data = data;
		this.justMade = true;
	}

	BST_Node(String data, BST_Node left, BST_Node right, BST_Node par) { // feel
																			// free
																			// to
																			// modify
																			// this
																			// constructor
																			// to
																			// suit
																			// your
																			// needs
		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = par;
		this.justMade = true;
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

	public BST_Node containsNode(String s) {

		if (data.equals(s)) {
			
			return splay();
			
		}
		if (data.compareTo(s) > 0) {// s lexiconically less than data
			if (left == null) {
				
				return splay();
			}
			return left.containsNode(s);
		}
		if (data.compareTo(s) < 0) {
			if (right == null) {
				
				return splay();
			}
			return right.containsNode(s);
		}
		return this; // shouldn't hit
	}

	public BST_Node insertNode(BST_Node n) {

		if (data.equals(n.data)) {
			justMade=false;
			return splay();
		}

		else if (left == null && right == null) {

			if (n.getData().compareTo(data) < 0) {
				n.parent = this;
				left = n;
				
				return left.splay();
			} else {
				n.parent = this;
				right = n;
				
				return right.splay();
			}
		}

		else if (left == null) {
			if (n.getData().compareTo(data) < 0) {
				n.parent = this;
				left = n;
				
				return left.splay();
			}

			else {

				return right.insertNode(n);

			}
		}

		else if (right == null) {
			if (n.getData().compareTo(data) > 0) {
				n.parent = this;
				right = n;
				
				return right.splay();
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

		if (!this.data.equals(s)) { // this block is for when the node in not
									// what needs to be removed

			if (right == null && left == null) {
				return false;
			}

			else if (s.compareTo(data) > 0) {

				if (right == null) {
					return false;
				}
				return right.removeNode(s);

			}

			else {

				if (left == null) {
					return false;
				}

				return left.removeNode(s);

			}

		}

		else { // this block if for a node that does need to be removed

			if (right == null && left == null) {
				if (parent.left != null && parent.left.equals(this)) {
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
				if (parent.left != null && parent.left.equals(this)) {
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

			else {
				if (parent.left != null && parent.left.equals(this)) {
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

		}

	}

	public BST_Node findMin() {

		if (left != null) {
			return left.findMin();
		}

		else {
			splay();
			return this;
		}
	}

	public BST_Node findMax() {

		if (right != null) {
			return right.findMax();
		} else {
			splay();
			return this;
		}
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

	private BST_Node splay() {
		while (parent != null) {

			if (this.parent.parent == null) {// only one node away from root
				if (parent.left != null && this.parent.left.equals(this)) {

					rotateLeft(parent);
					

				}

				else if (parent.right != null && this.parent.right.equals(this)) {
					rotateRight(parent);
					
				}

				else {
					System.out.println("Error with splay method rotation with root parent");
					throw new RuntimeException("This is the spot");
				}

			}

			else { // all other general cases

				if (parent.right != null && this.parent.right.equals(this) && parent.parent.left != null
						&& this.parent.parent.left.equals(parent)) { // zig zag
																		// Left
																		// Right
																		// (downwards)

					doubleRotateLeft(parent.parent);

				}

				else if (parent.left != null && this.parent.left.equals(this) && parent.parent.left != null
						&& this.parent.parent.left.equals(parent)) {// zig zig
																	// left left
																	// (downwards)

					rotateLeft(parent.parent);
					rotateLeft(parent);

				}

				else if (parent.left != null && this.parent.left.equals(this) && parent.parent.right != null
						&& this.parent.parent.right.equals(parent)) { // zig
					// zag
					// right
					// left
					// downwards

					doubleRotateRight(parent.parent);
				}

				else if (this.parent.right.equals(this) && this.parent.parent.right.equals(parent)) {// zig
																										// zig
																										// right
																										// right
																										// (downwards)

					rotateRight(parent.parent);
					rotateRight(parent);
				}

				else {
					System.out.println("Something wrong detecting wether to zig or zag");
					throw new RuntimeException("This is the spot");
				}
			}
		}
		return this;
	}

	// you could have this return or take
	// in whatever you want..so long as it will do the job internally. As a
	// caller of SPLT functions,
	// I should really have no idea if you are "splaying or not"
	// I of course, will be checking with tests and by eye to make sure you are
	// indeed splaying
	// Pro tip: Making individual methods for rotateLeft and rotateRight might
	// be a good idea!

	// --- end fill in these methods --------------------------------------

	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------
	private BST_Node rotateLeft(BST_Node par) {
		BST_Node origChild = par.left;
		par.left = origChild.right;
		origChild.right = par;
		origChild.parent = par.parent;

		if (origChild.parent != null && origChild.parent.right!= null && origChild.parent.right.equals(par)) {
			origChild.parent.right = origChild;
		} else if (origChild.parent != null) {
			origChild.parent.left = origChild;
		}

		par.parent = origChild;
		if (par.left != null) {
			par.left.parent = par;
		}

		return origChild;
	}

	private BST_Node rotateRight(BST_Node par) {
		BST_Node origChild = par.right;
		par.right = origChild.left;
		origChild.left = par;
		origChild.parent = par.parent;
		

			if (origChild.parent != null && origChild.parent.right!= null && origChild.parent.right.equals(par)) {
				origChild.parent.right = origChild;
			} else if (origChild.parent != null) {
				origChild.parent.left = origChild;
			}
		
		par.parent = origChild;
		if (par.right != null) {
			par.right.parent = par;
		}

		return origChild;
	}

	private BST_Node doubleRotateLeft(BST_Node par) {
		par.left = rotateRight(par.left);
		return rotateLeft(par);
	}

	private BST_Node doubleRotateRight(BST_Node par) {
		par.right = rotateLeft(par.right);
		return rotateRight(par);
	}

	public String toString() {
		return "Data: " + this.data + ", Left: " + ((this.left != null) ? left.data : "null") + ",Right: "
				+ ((this.right != null) ? right.data : "null");
	}
}