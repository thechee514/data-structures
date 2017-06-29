/**
 * Stack class uses LinkedList to hold hold stack contents and uses LinkedList
 * methods to manipulate the contents of the stack.
 * 
 * @author Vincent Chee
 * @version 19/02/15
 *
 * @param <Element>
 *            Holder for element later on
 */
public class Stack<Element> {

	private LinkedList<Element> stackContents;

	/**
	 * Default Stack constructor which creates a new generic linked list that
	 * holds the stack contents
	 */
	public Stack() {
		stackContents = new LinkedList<Element>();
	}

	/**
	 * Size() method
	 * 
	 * @return the number of stack contents
	 */
	public int size() {
		return stackContents.size();
	}

	/**
	 * isEmpty() method checks if there are any stack contents
	 * 
	 * @return true if there are no stack contents/stack is empty
	 */
	public boolean isEmpty() {
		return stackContents.size() == 0;
	}

	/**
	 * push() method adds stack content at the head
	 * 
	 * @param toAdd
	 *            the element to be added
	 */
	public void push(Element toAdd) {
		stackContents.insertAtHead(toAdd);
	}

	/**
	 * pop() method removes element at the top of the stack
	 * 
	 * @return the element which is popped from the top of the stack
	 */
	public Element pop() {
		return stackContents.removeHead();
	}

	/**
	 * top() method
	 * 
	 * @return element at top of the stack
	 */
	public Element top() {
		return stackContents.elementAtHead();
	}
}
