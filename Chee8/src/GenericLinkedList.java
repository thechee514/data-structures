/**
 * GenericLinkedList ADT creates a generic linked list which can be
 * manipulated with methods
 * 1. Takes Element T and stores it in linked List
 * 2. Generic Linked List will be organized lexicographically if insertSorted is used to add objects
 * 3. Generic Linked List keeps track of number of elements 
 * 4. Generic Linked List can only be accessed through head
 * @author Vincent Chee
 * @version 19/03/15
 *
 * @param <T>
 *            holds element T
 */
public class GenericLinkedList<T extends Comparable<T>> {

	private int numberOfElements;
	private GenericListNode<T> head;

	/**
	 * GenericLinkedList constructor
	 */
	public GenericLinkedList() {
		head = null;
		numberOfElements = 0;
	}

	public GenericLinkedList(T data) {
		head = new GenericListNode<T>(data);
		numberOfElements = 1;

	}

	/**
	 * Inserts a new node containing data toAdd at the given index
	 * 
	 * @param index
	 *            toAdd will be added to
	 * @param toAdd
	 *            data that will be added at index
	 */
	public void add(int index, T toAdd) {
		if (index == 0) {
			head = new GenericListNode<T>(toAdd, head);
			numberOfElements++;
		} else if (index > this.size() || index < 0) {
			throw new NullPointerException("Please select an acceptable value.");
		} else {
			GenericListNode<T> newNode = new GenericListNode<T>(toAdd);
			newNode.next = getNode(index);
			getNode(index - 1).next = newNode;
			numberOfElements++;
		}
	}

	/**
	 * Adds element toAdd at the tail of the linked list
	 * @param toAdd
	 */
	public void addAtTail(T toAdd) {
		this.add(numberOfElements,toAdd);
	}

	/**
	 * Tells us size of Generic Linked List
	 * 
	 * @return number of elements in Generic Linked List
	 */
	public int size() {
		return numberOfElements;
	}

	/**
	 * Inserts a new node in the correct spot such that all elements before
	 * toAdd are "smaller or equal" according to compareTo method. This method
	 * is defined for type T and all elements after toAdd are "greater or equal"
	 * according to the compareTo method defined for type T.
	 * 
	 * @param toAdd
	 *            data to be added
	 */
	public void insertSorted(T toAdd) {
		GenericListNode<T> currentNode = head;
		int indexCounter = 0;
		if (currentNode == null) {
			add(indexCounter, toAdd);
		} else {
			while (currentNode.data != null && currentNode.data.compareTo(toAdd) <= 0) {
				currentNode = currentNode.next;
				indexCounter++;
			}
			add(indexCounter, toAdd);
		}
	}

	/**
	 * Finds the first node whose data matches toRemove (according to the
	 * compareTo method) and removes it.
	 * 
	 * @param toRemove
	 *            data to be removed in a node
	 * @return the data of the node which is removed
	 */
	public T remove(T toRemove) {
		GenericListNode<T> currentNode = head;
		GenericListNode<T> lagNode = currentNode;
		if (currentNode.data.compareTo(toRemove) == 0) {
			head = currentNode.next;
			numberOfElements--;
			return currentNode.data;
		} else {
			while (currentNode.data != null && currentNode.data.compareTo(toRemove) != 0) {
				lagNode = currentNode;
				currentNode = currentNode.next;
			}
			if (currentNode.data != null) {
				currentNode = lagNode.next;
				lagNode.next = lagNode.next.next;
				numberOfElements--;
			}
			return currentNode.data;
		}
	}

	/**
	 * Finds the first node whose data matches toFind (according to the
	 * compareTo method), and returns the data.
	 * 
	 * @param toFind
	 *            data to be found in a node
	 * @return the data of the node which is found
	 */
	public T find(T toFind) {
		GenericListNode<T> currentNode = head;
		if (currentNode == null) {
			return null;
		} else {
			while (currentNode != null && currentNode.data.compareTo(toFind) != 0) {
				currentNode = currentNode.next;
			}
			if (currentNode != null){
				return currentNode.data;
			}
			else{
				return null;
			}
		}
	}

	/**
	 * toString method produces string representation of our generic linked
	 * list.
	 * 
	 * @return string representation
	 */
	public String toString() {
		String stringSequence = "{";
		GenericListNode<T> currentNode = head;
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

	/**
	 * Private helper method which gets a node specified by the index in the
	 * parameter.
	 * 
	 * @param index
	 * @return node at index
	 */
	private GenericListNode<T> getNode(int index) {
		GenericListNode<T> currentNode = head;
		for (int count = 0; count < index; count++) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}
}