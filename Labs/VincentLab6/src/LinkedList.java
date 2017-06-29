/**
 * Linked List is a collection of data nodes.  All methods here relate to
 * how one can manipulate those nodes.
 * 
 * @author Vincent Chee
 * @version 13/02/15
 */
public class LinkedList
{
    private int length;         // number of nodes
    private ListNode firstNode; // pointer to first node
    
    public LinkedList()
    {
        length=0;
        firstNode=null;
    }
    
    /** getter
     * 
     * @return number of nodes in the list
     */
    public int getLength() {return length;}
    
    
    /** insert new Event at linked list's head
     * 
     * @param newData the Event to be inserted
     */
    public void insertAtHead(Event newData)
    {
    	ListNode newnode = new ListNode(newData);
        if (getLength() == 0)
        {
            firstNode=newnode;
        } else {
            newnode.next=firstNode;
            firstNode=newnode;
        }
        length++;
    }
  
    /**
     * @return a string representation of the list and its contents.
     */
    public String toString() 
    {
    	String toReturn="(";
    	ListNode runner;
    	runner = firstNode;
    	while (runner != null) {
            toReturn = toReturn + runner;
            runner = runner.next;
            if (runner != null) {
                toReturn = toReturn + ",\n";
            }
    	}
    	toReturn = toReturn + ")";
    	return toReturn;
    }
    
    /**
     * insert new Event into sorted position in LL
     *
     * @param newData the Event to insert
     */
    public void insertSorted(Event newData)
    {
        ListNode nodeBefore = this.findNodeBefore(newData);
        if (nodeBefore == null) {  // if there isn't a node that should go before newNode
            insertAtHead(newData);
        } else {
            insertAfter(nodeBefore, newData);
        }
    }

    /**
     * Given a new event to be inserted in the list, finds the correct position for it.
     *
     * @param newData an event to be inserted in the list
     *
     * @return a pointer to the node in the linked list that will
     * immediately precede newData once newData gets inserted.
     * Returns null if no such node exists (which means newData goes first).
     */
	private ListNode findNodeBefore(Event newData) {
		ListNode runner;
		runner = firstNode;
		if (runner == null) {
			return null;
		} else if (newData.compareTo(runner.data) == 0
				|| (newData.compareTo(runner.data) == -1)) {
			return null;
		} else {
			while (newData.compareTo(runner.data) != -1) {
				if (runner.next == null) {
					return runner;
				} else if (newData.compareTo(runner.next.data) == 0
						|| (newData.compareTo(runner.next.data) == -1)) {
					return runner;
				} else {
					runner = runner.next;
				}
			}
		}
		return null;
	}
    /**
     * Given an event to insert and a pointer to the node
     * that should come before it, insert the new event after nodeBefore.
     *
     * @param nodeBefore the node (already in the list) that should
     * immediately precede the node with newData in it
     * @param newData the event to be inserted after nodeBefore
     */
    private void insertAfter (ListNode nodeBefore, Event newData)
    {
    	ListNode nodeAfter = new ListNode(newData);
    	if (nodeBefore == null) {
    		firstNode = nodeAfter;
    	} else {
        	nodeAfter.next = nodeBefore.next;
        	nodeBefore.next = nodeAfter;
    	}
    	length++;
    }
 }
