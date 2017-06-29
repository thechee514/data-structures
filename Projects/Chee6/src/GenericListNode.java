/**
 * GenericListNode class creates a node using one of three constructors. Several
 * helper methods, getter and setter methods are also included. Data can be of
 * different types.
 * 
 * @author Vincent Chee
 * @version 20/02/15
 *
 */
public class GenericListNode<T> {

	public T data;
	public GenericListNode<T> next;

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
	public GenericListNode(T initialData, GenericListNode<T> initialNext) {
		data = initialData;
		next = initialNext;
	}

	/**
	 * Non-default Node Constructor
	 * 
	 * @param initialData
	 *            - initial data of this new node
	 */
	public GenericListNode(T initialData) {
		data = initialData;
		next = null;
	}

	/**
	 * Default Constructor sets data and next to null
	 */
	public GenericListNode() {
		data = null;
		next = null;
	}

	/**
	 * toString method that returns data of the node in a string
	 */
	public String toString() {
		return data.toString();
	}
}