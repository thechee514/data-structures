/**
 * ListNode class creates a node using one of three constructors. Several helper
 * methods, getter and setter methods are also included.
 * 
 * @author Vincent Chee
 * @version 23/02/15
 */

public class ListNode {
	public String data;
	public ListNode next;

	/**
	 * Non-default Node Constructor
	 * 
	 * @param initialData
	 *            - initial data of this new node
	 * @param initialNext
	 *            - a reference to the node after this new node, reference may
	 *            be null Postcondition: This new node contains the specified
	 *            data and a link to the next node
	 */
	public ListNode(String initialData, ListNode initialNext) {
		data = initialData;
		next = initialNext;
	}

	/**
	 * Non-default Node Constructor
	 * 
	 * @param initialData
	 *            - initial data of this new node
	 */
	public ListNode(String initialData) {
		data = initialData;
		next = null;
	}

	/**
	 * Default Constructor sets data and next to null
	 */
	public ListNode() {
		data = null;
		next = null;
	}
	
	/**
	 * toString method that returns data of the node in a string
	 */
	public String toString() {
		return data;
	}
}