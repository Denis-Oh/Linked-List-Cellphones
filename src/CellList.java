import java.util.NoSuchElementException;
/**
 * Implementaion of the CellList class with inner class CellNode
 * @author Denis Oh
 */
public class CellList {

	//Inner Class
	/**
	 * Implementation of the CellNode Class which is an inner class of CellList
	 * @author Denis Oh
	 */
	protected class CellNode{
		private CellPhone object;
		private CellNode pointer;
		
		//constructors
		/**
		 * Default Constructor for CellNode Class
		 */
		public CellNode() {
			this.object = null;
			this.pointer = null;
		}
		/**
		 * Parameterized Constructor for CellNode Class
		 * @param object CellPhone Object held in CellNode
		 * @param pointer Pointer to the next CellNode in the linked list
		 */
		public CellNode(CellPhone object, CellList.CellNode pointer) {
			this.object = object;
			this.pointer = pointer;
		}
		/**
		 * Copy Constructor for CellNode Class
		 * @param c CellNode Object to be copied from
		 */
		public CellNode(CellNode c) { //TODO copy constuctor UNSURE...
			this.object = c.object; //or: c.clone().object
			this.pointer = c.pointer;
		}
		
		//clone
		/**
		 * Clone Method for CellNode Class
		 * @return New CellNode Object with the same object and pointer attributed
		 */
		public CellNode clone() {
			return new CellNode(this.object, this.pointer);
		}
		
		//accessors and mutators
		/**
		 * Accessor for object attribute
		 * @return object
		 */
		public CellPhone getObject() {
			return object;
		}
		/**
		 * Mutator for object attribute
		 * @param object
		 */
		public void setObject(CellPhone object) {
			this.object = object;
		}
		/**
		 * Accessor for pointer attribute
		 * @return pointer
		 */
		public CellNode getPointer() {
			return pointer;
		}
		/**
		 * Mutator for pointer attribute
		 * @param pointer
		 */
		public void setPointer(CellNode pointer) {
			this.pointer = pointer;
		}	
	}
	
	//attributes
	private CellNode head;
	private int size;
	
	//accessors and mutators
	/**
	 * Accessor for head attribute
	 * @return head
	 */
	public CellNode getHead() {
		return head;
	}
	/**
	 * Mutator for head attribute
	 * @param head
	 */
	public void setHead(CellNode head) {
		this.head = head;
	}
	/**
	 * Accessor for size attribute
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * Mutator for size attribute
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	//default constructors
	/**
	 * Default Constructor for CellList Class
	 */
	public CellList() {
		this.head = null;
		this.size = 0;
	}
	
	//copy constructor
	/**
	 * Copy Constructor for CellList Class
	 * @param c CellList Object to be copied from
	 */
	public CellList(CellList c) {
		if(c==null) {
			throw new NullPointerException();
		} else if(c.head==null) { //empty list
			this.head = null;
			this.size = 0;
		} else { //make new copy of all list nodes
			CellNode listHead = c.head;
			CellNode newHead = new CellNode(listHead.object, null); //create new list's head
			CellNode newEnd = newHead;			
			CellNode listNextNode = listHead.pointer;
			
			int size = 1;
			while(listNextNode != null) {
				newEnd.pointer = new CellNode(listNextNode.object, null);
				newEnd = newEnd.pointer;
				listNextNode = listNextNode.pointer;
				size++;
			}	
			this.head = newHead;
			this.size = size;
		}
	}
	
	//add to start
	/**
	 * Add a CellPhone Object to start of CellList
	 * @param cell CellPhone Object to be added
	 */
	public void addToStart(CellPhone cell) {
		this.head = new CellNode(cell, this.head);
		this.size++;
	}
	//insert at index
	/**
	 * Add a CellPhone Object to specific index of CellList
	 * @param cell CellPhone Object to be added
	 * @param index index that object will be added to
	 */
	public void insertAtIndex(CellPhone cell, int index) {
		if(index<0 || index>this.size) {
			throw new NoSuchElementException();
		} else if(index==0) {
			addToStart(cell);
		} else {
			CellNode temp = this.head;
			
			for(int i=1; i<index; i++) {
				temp = temp.pointer;
			}
			temp.pointer = new CellNode(cell, temp.pointer);
			this.size++;
		}
	}
	//delete from index
	/**
	 * Delete a CellPhone Object from a specific index of CellList
	 * @param index index that object will be deleted from
	 */
	public void deleteFromIndex(int index) {
		if(index<0 || index>this.size) {
			throw new NoSuchElementException();
		} else if(index==0) {
			this.head = this.head.pointer;
			this.size--;
		} else {
			CellNode temp = this.head;
			
			for(int i=1; i<index; i++) {
				temp = temp.pointer;
			}
			temp.pointer = temp.pointer.pointer;
			this.size--;
		}
	}
	//delete from start
	/**
	 * Delete a CellPhone Object from start of CellList
	 */
	public void deleteFromStart() {
		this.deleteFromIndex(0);
	}
	//replace at index
	/**
	 * Replace a CellPhone Object from a specific index of CellList
	 * @param cell CellPhone Object to be added
	 * @param index index that object will be replaced from
	 */
	public void replaceAtIndex(CellPhone cell, int index) {
		if(index<0 ||index>this.size) {
			return;
		} else if(index==0) {
			this.head = new CellNode(cell, this.head.pointer);
		} else {
			CellNode temp = this.head;
			for(int i=1; i<index; i++) {
				temp = temp.pointer;
			}
			temp.pointer = new CellNode(cell, temp.pointer.pointer);
		}
	}
	//find
	/**
	 * Find a specific CellNode in the CellList
	 * @param serial Serial Number of desired CellPhone
	 * @return CellNode Object which contains CellPhone with specific serialNumber attribute value
	 */
	public CellNode find(long serial) {
		CellNode temp = this.head;
		CellNode match = null;
		for(int i=0; i<this.size; i++) {
			if(temp.object.getSerialNum() == serial) {
				match = temp;
				System.out.println("Number of Iterations: "+(i+1));
			}
			temp = temp.pointer;
		}
		return match;	
	}
	//contains (serialNumber)
	/**
	 * Lets user know whether or not CellList contains CellPhone object with specific serialNumber
	 * @param serial serialNumber in question
	 * @return boolean: true if list contains desired CellPhone object
	 */
	public boolean contains(long serial) {
		CellNode temp = this.head;
		for(int i=0; i<this.size; i++) {
			if(temp.getObject().getSerialNum()==serial) {
				return true;
			} else {
				temp = temp.pointer;
			}
		}
		return false;
	}
	//show contents
	/**
	 * Displays size and All contents of CellList to the console
	 */
	public void showContents() {
		System.out.println("The current size of the list is "+this.size+". Here are the contents:\n"
				+ "=========================================================");
		CellNode temp = this.head;
		int n = 1;
		for(int i=0; i<this.size; i++) {
			System.out.print(temp.getObject()+" ---> ");
			temp = temp.pointer;
			if(n%3 == 0)
				System.out.println();
			n++;
		}
		System.out.println("x");
	}
	//contains (CellPhone)
	/**
	 * Lets user know whether or not CellList contains specific CellPhone object
	 * @param cell CellPhone object in question
	 * @return boolean: true if list contains desired CellPhone object
	 */
	public boolean contains(CellPhone cell) {
		CellNode temp = this.head;
		for(int i=0; i<this.size; i++) {
			if(temp.getObject() == cell) {
				return true;
			} else {
				temp = temp.pointer;
			}
		}
		return false;
	}
	//equals
	/**
	 * Checks if one CellList contains similar CellPhone Objects as another
	 * @param list CellList in question
	 * @return boolean: true if both lists contain similar objects
	 */
	public boolean equals(CellList list) {
		//check if 1st list contains all objects of 2nd
		CellNode temp = this.head;
		for(int i=0; i<this.size; i++) {	
			if(!(list.contains(temp.getObject()))) {
				return false;
			}
			temp = temp.pointer;
		}
		//check if 2st list contains all objects of 1nd
		CellNode temp2 = list.head;
		for(int j=0; j<list.size; j++) {
			if(!(this.contains(temp2.getObject()))) {
				return false;
			}
			temp2 = temp2.pointer;
		}
		return true;
	}
	
	
}
