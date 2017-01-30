/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	Node root;// this will be the entry point to your linked list (the head)
	private int listSize = 0;

	public LinkedListImpl() {// this constructor is needed for testing purposes.
								// Please don't modify!
		root = new Node(0); // Note that the root's data is not a true part of
							// your data set!
	}

	// implement all methods in interface, and include the getRoot method we
	// made for testing purposes. Feel free to implement private helper methods!

	public Node getRoot() { // leave this method as is, used by the grader to
							// grab your linkedList easily.
		return root;
	}

	@Override
	public boolean insert(Node n, int index) {

		if (index > listSize || index < 0) { // returns false for faulty
													// index values
			return false;
		}

		else {
			Node temp = root;
			if (index < listSize) { // if body for insertions
													// within the list but not
													// on ends
				for (int count = 0; count != index; count++) {
					temp = temp.next;
				}

				n.prev = temp;
				n.next = temp.next;
				temp.next = n;
				if(index!=0){
				n.next.prev = n;
				}
				listSize++;

				return true;
			}

			else {
				for (int count = 0; count != index; count++) { // if body for insertions at the beginning
																// or end of
																// list
					temp = temp.next;
				}

				n.prev = temp;
				n.next = null;
				temp.next = n;

				listSize++;

				return true;

			}

		}

	}

	@Override
	public boolean remove(int index) {
		// TODO Auto-generated method stub
		if (index >= listSize || index < 0) {
			return false;
		}

		else {
			
			Node temp=root.next;
			
			for( int count=0; count!=index; count++){
				temp=temp.next;
			}
			
			try{
				temp.next.prev=temp.prev;}
				
			catch(NullPointerException e){}
				 temp.prev.next=temp.next;
				    listSize--; 
				    return true;
			
		}
	}

	@Override
	public Node get(int index) {
		// TODO Auto-generated method stub
		
		if(index<0 || index>= listSize || listSize==0){
		return null;
		}
		
		else{
			
			Node temp=root.next;
			
			for (int count=0; count!=index; count ++){
				temp=temp.next;
			}
			
			return temp;
			
		}
	}

	@Override
	public int size() {
		
		return listSize;
	}

	@Override
	public boolean isEmpty() {
		
		return listSize==0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
		if (listSize>0){
			root.next=null;
			listSize=0;
		}

	}
}