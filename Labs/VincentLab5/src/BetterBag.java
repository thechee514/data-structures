/**
 * Improved bag of integers.  A bag is an unordered collection of elements.
 * Duplicates are allowed.
 * 
 * @author <em>Vincent Chee</em> and Chris Fernandes
 * @version <em>05/02/15</em>
 *
 */
import mainbook.IntBag;

public class BetterBag
{
	private IntBag int_bag;

	/**
	 * Initialize an empty bag with an initial capacity of 10.
	 */
	public BetterBag()
	{
		int_bag = new IntBag();
	}

	/**
	 * Initialize an empty bag with a specified initial capacity.
	 * @param initialCapacity  the initial capacity of this bag
	 */
	public BetterBag(int initialCapacity)
	{
		int_bag = new IntBag(initialCapacity);
	}

	/**
	 * Add a new element to this bag. If the new element would take this
	 * bag beyond its current capacity, then the capacity is increased
	 * before adding the new element.
	 * @param element the new element that is being inserted
	 */
	public void add(int element)
	{
		int_bag.add(element);
	}

	/**
	 * Add the contents of another bag to this bag
	 * @param addend a bag whose contents will be added to this bag
	 */
	public void addAll(BetterBag addend)
	{
		int_bag.addAll(addend.int_bag);
	}

	/**
	 * Generate a copy of this bag.
	 * @return returns a copy of this bag. Subsequent changes to the
	 *   copy will not affect the original, nor vice versa.
	 */
	public BetterBag clone()
	{
		IntBag newInnerBag = int_bag.clone();
		BetterBag toReturn = new BetterBag();
		toReturn.int_bag = newInnerBag;
		return toReturn;
	}

	/**
	 * Counts the number of occurrences of a particular element
	 * in this bag.
	 * @param target
	 *   the element that needs to be counted
	 * @return
	 *   the number of times that target occurs in this bag
	 */
	public int countOccurrences(int target)
	{
		return int_bag.countOccurrences(target);
	}

	/**
	 * Change the capacity of this bag to at least minimumCapacity.
	 *   If the capacity was already at or greater than minimumCapacity,
	 *   then the capacity is left unchanged.
	 *   
	 * @param minimumCapacity
	 *   the new capacity for this bag
	 */
	public void ensureCapacity(int minimumCapacity)
	{
		int_bag.ensureCapacity(minimumCapacity);
	}

	/**
	 * Getter for this bag's capacity
	 * @return the number of elements this bag has the ability to hold
	 */
	public int getCapacity()
	{
		return int_bag.getCapacity();
	}

	/**
	 * Remove one copy of a specified element from this bag.
	 * @param target the element to remove from the bag
	 * @return true if removal was successful; false if target doesn't exist
	 *  (which means the bag will be left unchanged)
	 */
	public boolean remove(int target)
	{
		return int_bag.remove(target);
	}

	/**
	 * Determine the number of elements in this bag
	 * @return the number of elements currently in this bag
	 */
	public int size()
	{
		return int_bag.size();
	}

	/**
	 * Reduce the current capacity of this bag to its actual size (i.e., the
	 * number of elements it contains).
	 */
	public void trimToSize()
	{
		int_bag.trimToSize();
	}

	/**
	 * Accesses a random element in this bag
	 * 
	 * @return a random element from this bag.  The bag is left unchanged
	 *  (i.e. the element is not removed).  If the bag is empty,
	 *  the smallest possible integer is returned (i.e. the static
	 *  constant <code>Integer.MIN_VALUE</code> is returned)
	 */
	public int getRandom()
	{
		return int_bag.getRandom();
	}

	/**
	 * Return status of this bag as a String.  For example, if a bag of 
	 * capacity 10 contained the elements 1, 2, and 3, the returned
	 * string would be "{1, 2, 3} (capacity = 10)".  The order in which
	 * the elements are listed is not guaranteed.
	 * 
	 * @return bag's contents and capacity as a String 
	 */
	public String toString()
	{
		return int_bag.toString();
	}

	/**
	 * Tells if bag is empty or not
	 * @return true if bag contains no elements; false otherwise
	 */
	public boolean isEmpty()
	{
		return size() == 0;
	}

	/**
	 * remove a random element from this bag and return it
	 * 
	 * @return the random element that has been removed from
	 *  this bag.  If the bag is empty, it is left unchanged and
	 *  the smallest possible integer is returned (i.e. the static
	 *  constant <code>Integer.MIN_VALUE</code> is returned)
	 */
	public int removeRandom()
	{
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		} else {
			int removedRandom = getRandom();
			remove(removedRandom);
			return removedRandom;
		}
	}

	/**
	 * See if the bag contains a particular element
	 * @param target the element to be searched for
	 * @return true if bag contains the target element; false otherwise
	 */
	public boolean contains(int target)
	{
		return countOccurrences(target) != 0;
	}

	/**
	 * Tests to see if this bag and another bag are equal. Two bags
	 * are equal if they contain the exact same elements, regardless of order
	 * or capacity.  For example, the bags {1,4,9} and {9,4,1} are equal,
	 * even if they had different capacities.  The number of duplicate
	 * elements must also be the same, so
	 * {1,4,4,9} and {1,4,9,9} are not equal. 
	 * 
	 * @param otherBag bag to be tested for equality with this bag
	 * @return true if bags are equal; false otherwise
	 */
	public boolean equals(BetterBag otherBag)
	{
		BetterBag checkBag = clone();
		BetterBag otherBagCheck = otherBag.clone();
		int differences = 0;
		for (int i = 0; i < size(); i++) {
			clone();
			int randomNum = checkBag.getRandom();
			if (!otherBagCheck.contains(randomNum)) {
				differences +=1;
			} 
			checkBag.remove(randomNum);
			otherBagCheck.remove(randomNum);
		}
		return size() == otherBag.size() && differences == 0;
	}
}
