/**
 * Sequence Class which uses LinkedList implementation instead of array
 * Invariants 1. Capacity of sequence is stored in the instance variable
 * capacity. 2. For an empty sequence, we do not care what is stored in any of
 * data, for a non empty sequence, the size of the LinkedList is the same as the
 * number of elements in the sequence. 3. If there is a current element it is
 * indicated by the instance variable currentIndex, if there is no currentIndex,
 * then currentIndex = numberOfElements.
 * 
 * @author Vincent Chee
 * @version 23/02/15
 *
 */

public class Sequence {
	private LinkedList data;
	private int currentIndex;
	private int capacity;
	private final int INITIAL_CAPACITY = 10;

	/**
	 * Creates a new sequence with initial capacity 10.
	 * 
	 * Postcondition: sequence is empty and has initial capacity of 10
	 */
	public Sequence() {
		data = new LinkedList();
		capacity = INITIAL_CAPACITY;
	}

	/**
	 * Creates a new sequence.
	 * 
	 * Precondition: non negative Postcondition: sequence is empty and has given
	 * initial capacity Throws: IllegalArgumentException indicates
	 * initialCapacity is negative
	 * 
	 * @param initialCapacity
	 *            the initial capacity of the bag.
	 */
	public Sequence(int initialCapacity) {
		data = new LinkedList();
		capacity = initialCapacity;
	}

	/**
	 * Adds a string to the sequence in the location before the current element.
	 * If the sequence has no current element, the string is added to the
	 * beginning of the sequence.
	 * 
	 * The added element becomes the current element.
	 * 
	 * If the sequences's capacity has been reached, the sequence will expand to
	 * twice its current capacity plus 1.
	 * 
	 * Postcondition: new copy of element added to sequence, if there's a
	 * current element, it places new element before current element. If there
	 * was no current element, then addBefore places new element at the
	 * beginning of sequence. In all cases, new element becomes new current
	 * element of sequence. Throws: OutOfMemoryError - indicates insufficient
	 * memory to increase the size of this sequence
	 * 
	 * @param value
	 *            the string to add.
	 */
	public void addBefore(String value) {
		if (data.size() == getCapacity()) {
			ensureCapacity(getCapacity() * 2 + 1);
		}
		if (!isCurrent()) {
			currentIndex = 0;
			data.add(value, currentIndex);
		} else {
			data.add(value, currentIndex);
		}
	}

	/**
	 * Adds a string to the sequence in the location after the current element.
	 * If the sequence has no current element, the string is added to the end of
	 * the sequence.
	 * 
	 * The added element becomes the current element.
	 * 
	 * If the sequences's capacity has been reached, the sequence will expand to
	 * twice its current capacity plus 1.
	 * 
	 * Postcondition: new copy of element added to sequence, if there's a
	 * current element, it places new element after current element. If there
	 * was no current element, then addAfter places new element at the end of
	 * sequence. In all cases, new element becomes new current element of
	 * sequence. Throws: OutOfMemoryError - indicates insufficient memory to
	 * increase the size of this sequence
	 * 
	 * @param value
	 *            the string to add.
	 */
	public void addAfter(String value) {
		if (data.size() == getCapacity()) {
			ensureCapacity(getCapacity() * 2 + 1);
		}
		if (!isCurrent()) {
			currentIndex = size();
			data.add(value, currentIndex);
		} else {
			advance();
			data.add(value, currentIndex);
		}
	}

	/**
	 * Places the contents of another sequence at the end of this sequence.
	 * 
	 * If adding all elements of the other sequence would exceed the capacity of
	 * this sequence, the capacity is changed to make room for all of the
	 * elements to be added.
	 * 
	 * Precondition: parameter addend is not null Postcondition: elements from
	 * addend have been placed at end of sequence. Current element of this
	 * sequence remains where it was and addend is also unchanged Throws:
	 * OutOfMemoryError - indicates insufficient memory to increase the capacity
	 * of this sequence Throws: NullPointerException - indicates addend is null
	 * 
	 * @param addend
	 *            the sequence whose contents should be added.
	 */
	public void addAll(Sequence addend) {
		if (addend.size() + this.size() > this.getCapacity()) {
			ensureCapacity(addend.size() + this.size());
		}
		int thisTempIndex = this.getCurrentIndex();
		int addendTempIndex = addend.getCurrentIndex();
		this.moveToEnd();
		addend.start();
		int limit = addend.size();
		for (int i = 0; i < limit; i++) {
			String element = addend.getCurrent();
			this.addAfter(element);
			addend.advance();
		}
		this.setCurrentIndex(thisTempIndex);
		addend.setCurrentIndex(addendTempIndex);
	}

	/**
	 * Move forward in the sequence so that the current element is now the next
	 * element in the sequence.
	 * 
	 * If the current element was already the end of the sequence, then
	 * advancing causes there to be no current element.
	 * 
	 * Precondition: should only be called when there is a current element.
	 * isCurrent() returns true Postcondition: If current element was the end
	 * element of sequence (with nothing after) then there is no longer any
	 * current element. Otherwise, new element is element immediately after
	 * original current element. Throws: IllegalStateException - indicates there
	 * is no current element so advance may not be called
	 */
	public void advance() {
		if (!isCurrent()) {
			String str = "There is no current element.";
			throw new IllegalStateException(str);
		} else {
			currentIndex += 1;
		}
	}

	/**
	 * Make a copy of this sequence. Subsequence changes to the copy do not
	 * affect the current sequence, and vice versa.
	 * 
	 * @return the copy of this sequence.
	 */
	public Sequence clone() {
		int cloneCapacity = this.getCapacity();
		Sequence cloneSequence = new Sequence(cloneCapacity);
		int tempCurrentIndex = this.getCurrentIndex();
		cloneSequence.addAll(this);
		this.setCurrentIndex(tempCurrentIndex);
		cloneSequence.setCurrentIndex(tempCurrentIndex);
		return cloneSequence;
	}

	/**
	 * Create a new sequence that contains all of the elements of one sequence
	 * followed by all of the elements of another sequence.
	 * 
	 * The new sequence does not have a current element. The new sequence has
	 * capacity equal to the sum of the capacities of the sequences being
	 * concatenated.
	 * 
	 * @param s1
	 *            the sequence whose elements should come first in the
	 *            concatenation
	 * @param s2
	 *            the sequence whose elements should come second Precondition:
	 *            Neither s1 or n2 is null. Throws: NullPointerException -
	 *            indicates that one of the arguments is null.
	 */
	public static Sequence concatenation(Sequence s1, Sequence s2) {
		int correctSize = s1.getCapacity() + s2.getCapacity();
		Sequence combinedData = new Sequence(correctSize);
		combinedData.addAll(s1);
		combinedData.addAll(s2);
		combinedData.setCurrentIndex(combinedData.size());
		return combinedData;
	}

	/**
	 * Change the current capacity of this sequence. The sequence's capacity
	 * will be changed to be at least a minimum capacity.
	 * 
	 * @param minCapacity
	 *            the minimum capacity that the sequence should now have.
	 *            Postcondition: This sequence's capacity has been changed to at
	 *            least minimumCapacity.
	 */
	public void ensureCapacity(int minCapacity) {
		if (getCapacity() < minCapacity) {
			capacity = minCapacity;
		}
	}

	/**
	 * @return the capacity of the sequence.
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @return the element at the current location in the sequence, or null if
	 *         there is no current element. Precondition: isCurrent() is true.
	 *         Throws: IllegalStateException - indicates that there is no
	 *         current element.
	 */
	public String getCurrent() {
		if (!isCurrent()) {
			return "There is no current element.";
		}
		return data.get(currentIndex);
	}

	/**
	 * @return true if and only if the sequence has a current element.
	 */
	public boolean isCurrent() {
		return data.size() != 0 && currentIndex < data.size();
	}

	/**
	 * Remove the current element from this sequence. The following element, if
	 * there was one, becomes the current element. If there was no following
	 * element (current was at the end of the sequence), the sequence now has no
	 * current element.
	 * 
	 * If there is no current element, does nothing. Precondition: isCurrent()
	 * returns true. Postcondition: current element removed from this sequence
	 * and following element (if there is one) is now new current element. If
	 * there was no following element, then there is now no current element.
	 * Throws: IllegalStateException - indicates that there is no current
	 * element, so removeCurrent may not be called
	 */
	public void removeCurrent() {
		if (!isCurrent()) {
			String str = "There is no current element.";
			throw new IllegalStateException(str);
		}
		data.remove(currentIndex);
	}

	/**
	 * @return the number of elements stored in the sequence.
	 */
	public int size() {
		return data.size();
	}

	/**
	 * Sets the current element to the start of the sequence. If the sequence is
	 * empty, the sequence has no current element. Postcondition: front element
	 * of this sequence is now the current element (but if this sequence has no
	 * elements at all, then there is no current element).
	 */
	public void start() {
		currentIndex = 0;
	}

	/**
	 * Reduce the current capacity to its actual size, so that it has capacity
	 * to store only the elements currently stored. Postcondition: This
	 * sequence's capacity has been changed to its current size.
	 */
	public void trimToSize() {
		int trimmedCapacity = size();
		capacity = trimmedCapacity;
	}

	/**
	 * Produce a string representation of this sequence. The current location is
	 * indicated by a >. For example, a sequence with "A" followed by "B", where
	 * "B" is the current element, and the capacity is 5, would print as:
	 * 
	 * {A, >B} (capacity = 5)
	 * 
	 * An empty sequence with a capacity of 10 would print as:
	 * 
	 * {} (capacity = 10)
	 * 
	 * @return a string representation of this sequence.
	 */
	public String toString() {
		String stringSequence = "{";
		for (int i = 0; i < size(); i++) {
			if (i == getCurrentIndex()) {
				stringSequence += ">";
			}
			stringSequence += data.get(i);
			if (i != size() - 1) {
				stringSequence += ", ";
			}
		}
		stringSequence += "} (capacity = " + getCapacity() + ")";
		return stringSequence;
	}

	/**
	 * Checks whether another sequence is equal to this one. To be considered
	 * equal, the other sequence must have the same elements, in the same order,
	 * and with the same element marked current. The capacity can differ.
	 * 
	 * @param other
	 *            the other Sequence with which to compare
	 * @return true iff the other sequence is equal to this one.
	 */
	public boolean equals(Sequence other) {
		int mismatch = 0;
		String tempOriginalCurrent = this.getCurrent();
		String tempOtherCurrent = other.getCurrent();
		this.start();
		other.start();

		for (int i = 0; i < this.size(); i++) {
			if (this.getCurrent().equals(other.getCurrent())) {
				this.advance();
				other.advance();
			} else {
				mismatch++;
			}
		}
		return equalsChecker(other, mismatch, tempOriginalCurrent,
				tempOtherCurrent);
	}

	/**
	 * Getter Method of current index
	 * 
	 * @return currentIndex
	 */
	private int getCurrentIndex() {
		return currentIndex;
	}

	/**
	 * Sets currentIndex to specified index
	 * 
	 * @param newCurrentIndex
	 *            - specified index
	 */
	private void setCurrentIndex(int newCurrentIndex) {
		currentIndex = newCurrentIndex;
	}

	/**
	 * Moves currentIndex to end of sequence
	 */
	private void moveToEnd() {
		currentIndex = size() - 1;
	}

	/**
	 * Helper method that returns whether the two sequences are equal
	 * 
	 * @param other
	 *            - other sequence
	 * @param mismatch
	 *            - instance variable to check if there are differences
	 * @param originalCurrent
	 *            - original current string
	 * @param otherCurrent
	 *            - other current string
	 * @return - whether sequences are equal
	 */
	private boolean equalsChecker(Sequence other, int mismatch,
			String originalCurrent, String otherCurrent) {
		return originalCurrent.equals(otherCurrent)
				&& this.size() == other.size() && mismatch == 0;
	}
}