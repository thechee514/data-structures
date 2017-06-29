/**
 * LinkedList class creates a LinkedList object which is made up of ListNodes.
 * Invariants
 * 1. LinkedListClass keeps track of the number of Elements
 * 2. LinkedList can only be accessed through the head
 * 3. LinkedList is empty if numberOfElements = 0.
 * @author Vincent Chee
 * @version 23/02/15
 *
 */
public class LinkedList {
	
	private int numberOfElements;
	private ListNode head;

	/**
	 * Default Constructor
	 */
	public LinkedList() {
		head = new ListNode();
	}

	/**
	 * Non-default constructor
	 * 
	 * @param data
	 *            with a string
	 */
	public LinkedList(String data) {
		head = new ListNode(data);
	}

	/**
	 * Tells us number Of Elements of LinkedListObject
	 * 
	 * @return numberOfElements
	 */
	public int size() {
		return numberOfElements;
	}

	/**
	 * Getter method to get the string of a node at specified index
	 * 
	 * @param index
	 *            - index of node to get data
	 * @return the data of the node at the specified at index
	 */
	public String get(int index) {
		ListNode currentNode = head;
		if (index > this.size() || index < 0) {
			return "Please select an acceptable value.";
		}
		currentNode = getNode(index);
		return currentNode.data;
	}

	/**
	 * Setter method which sets the value of a node at specified index
	 * 
	 * @param value
	 *            - string to be added
	 * @param index
	 *            - index of node which value needs to be added
	 */
	public void set(String value, int index) {
		ListNode currentNode = head;
		currentNode = getNode(index);
		currentNode.data = value;
	}

	/**
	 * Helper getter method that gets and returns node
	 * 
	 * @param index
	 *            - index of specified node
	 * @return - node at specified index returned
	 */
	private ListNode getNode(int index) {
		ListNode currentNode = head;
		for (int count = 0; count < index; count++) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}

	/**
	 * Add method that adds a node at specified index with specified value
	 * 
	 * @param value
	 *            - string of new node to be added
	 * @param index
	 *            - index node will be added at
	 */
	public void add(String value, int index) {
		if (index == 0) {
			head = new ListNode(value, head);
			numberOfElements++;
		} else if (index > this.size() || index < 0) {
			throw new NullPointerException("Please select an acceptable value.");
		} else {
			ListNode previousNode = this.getNode(index-1);
			ListNode newNode = new ListNode(value, previousNode.next);
			previousNode.next = newNode;
			numberOfElements++;
		}
	}

	/**
	 * Remove method removes node at specified index
	 * 
	 * @param index
	 *            - index node will be removed from
	 * @return removed node
	 */
	public String remove(int index) {
		String tempRemovedNode = getNode(index).data;
		if (index == 0) {
			head = head.next;
		} else if (index == size()) {
			getNode(index - 1).next = null;
		} else if (index > this.size() || index < 0) {
			throw new NullPointerException("Please select an acceptable value.");
		} else {
			getNode(index - 1).next = getNode(index).next;
		}
		numberOfElements--;
		return tempRemovedNode;
	}

	/**
	 * toString method represents LinkedList as a string
	 */
	public String toString() {
		String stringSequence = "{";
		ListNode currentNode = head;
		for (int i = 0; i < numberOfElements; i++) {
			stringSequence += currentNode.toString();
			currentNode = currentNode.next;
			if (i != numberOfElements - 1) {
				stringSequence += ", ";
			}
		}
		stringSequence += "}";
		return stringSequence;
	}
}