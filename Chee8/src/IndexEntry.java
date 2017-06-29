/**
 * IndexEntry Class allows contains information for each node of the index binary search tree, contains the word and a generic linked list of the pages
 * the word appears on
 * @author Vincent Chee
 * @version 19/03/15
 *
 */

public class IndexEntry implements Comparable<IndexEntry>{
	String word;
	GenericLinkedList<Integer> pages;
	private final int MAX_NUM_PAGES = 4;
	
	/**
	 * Constructor with word parameter
	 * @param aWord
	 */
	public IndexEntry(String aWord) {
		word = aWord;
		pages = new GenericLinkedList<Integer>();
	}
	
	/**
	 * Constructor with word parameter and pageNumbers
	 * @param aWord
	 * @param pageNumber
	 */
	public IndexEntry(String aWord, int pageNumber) {
		word = aWord;
		pages = new GenericLinkedList<Integer>(pageNumber);
	}
	
	/**
	 * Checks if the pagelist is full
	 * @return
	 */
	public boolean isFull() {
		return pages.size() >= MAX_NUM_PAGES;
	}
	
	/**
	 * Returns the word
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * Adds the page number into the page list
	 * @param page
	 */
	public void addPage(int page) {
		if (pages.find(page) == null) {
			pages.addAtTail(page);
		}
	}
	
	/**
	 * toString representation of the index
	 */
	public String toString() {
		return word + ": " + pages.toString();
	}
	
	/**
	 * compareTo method which compares entries to one another
	 */
	public int compareTo(IndexEntry otherEntry) {
		return word.compareToIgnoreCase(otherEntry.getWord());
	}
}
