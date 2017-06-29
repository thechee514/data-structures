/**
 * The Heap ADT. This is a max heap.
 * 
 * @author Vincent Chee
 * @version 05/03/15
 */
public class Heap {
	private int[] itemArray; // binary tree of ints in array form
								// (index 0 has the root)
	private int nodes; // number of nodes in the tree

	/**
	 * Builds a heap from an array of ints.
	 * 
	 * @param items
	 *            an array of ints(starting at index 0), which will be
	 *            interpreted as a binary tree.
	 */
	public Heap(int[] items) {
		itemArray = new int[items.length];
		nodes = items.length;

		for (int i = 0; i < nodes; i++) {
			itemArray[i] = items[i];
		}

		buildAHeap();
	}

	/**
	 * @return number of nodes in the heap.
	 */
	public int size() {
		return nodes;
	}

	/**
	 * Constructs a heap from the given binary tree (given as an array).
	 * Heapifies each internal node in reverse level-by-level order.
	 */
	public void buildAHeap() {
		for (int i = (nodes - 1) / 2; i >= 0; i--) {
			heapify(i);
		}
	}

	/**
	 * @return string representation of the heap (in level-by-level order)
	 */
	public String toString() {
		String result = "";
		int lastNodeOnLevel = 0;

		for (int i = 0; i < nodes; i++) {
			result += itemArray[i];
			if (i == lastNodeOnLevel) {
				result += "\n";
				lastNodeOnLevel = lastNodeOnLevel * 2 + 2;
			} else {
				result += " ";
			}
		}

		return result;
	}

	/**
	 * Turns a subtree into a heap, assuming that only the root of that subtree
	 * violates the heap property (i.e. the left and right subtrees are already
	 * heaps).
	 * 
	 * @param startingNodeIndex
	 *            the index of the node to start with. This node is the root of
	 *            a subtree which must be turned into a heap.
	 */
	public void heapify(int startingNodeIndex) {
		if (isLeaf(startingNodeIndex)) {
			return;
		} else if (getLargestChild(startingNodeIndex) > itemArray[startingNodeIndex]) {
			int temp = getLargestChildIndex(startingNodeIndex);
			swap(startingNodeIndex, getLargestChildIndex(startingNodeIndex));
			heapify(temp);
		} 
	}

	private int getLargestChild(int parentNode) {
		if (hasRightChild(parentNode)) {
			if (getLeftValue(parentNode) > getRightValue(parentNode)) {
				return getLeftValue(parentNode);
			} else {
				return getLeftValue(parentNode);
			}
		} else {
			return getLeftValue(parentNode);
		}
	}


	private int getLargestChildIndex(int parentNode) {
		if (hasRightChild(parentNode)) {
			if (getLeftValue(parentNode) > getRightValue(parentNode)) {
				return parentNode*2 + 1;
			} else {
				return parentNode*2 + 2;
			}
		} else {
			return parentNode*2 + 1;
		}
	}
	
	private void swap(int parentNode, int largestChild) {
		int temp = itemArray[parentNode];
		itemArray[parentNode] = itemArray[largestChild];
		itemArray[largestChild] = temp;
	}

	private boolean hasLeftChild(int parentNode) {
		return parentNode * 2 + 1 < size();
	}

	private boolean hasRightChild(int parentNode) {
		return parentNode * 2 + 2 < size();
	}

	private boolean isLeaf(int parentNode) {
		return !hasLeftChild(parentNode);
	}

	private int getLeftValue(int parentNode) {
		return itemArray[parentNode * 2 + 1];
	}

	private int getRightValue(int parentNode) {
		return itemArray[parentNode * 2 + 2];
	}

	/**
	 * Removes and returns the root from the heap. After the method is finished,
	 * the heap still obeys the heap property.
	 * 
	 * @return the root value.
	 */
	public int deleteRoot() {
		int temp = itemArray[0];
		itemArray[0] = itemArray[size()-1];
		nodes--;
		heapify(0);
		return temp;
	}
}
