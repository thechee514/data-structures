public class Sorter {
	// no constructor -- using implicit default constructor

	/**
	 * Sorts a copy of an array.
	 * 
	 * @param input
	 *            the array to copy and then sort.
	 * @return the sorted array.
	 */
	public String[] sort(String[] input) {
		String[] inputCopy = arrayCopy(input);
		selectionSort(inputCopy);
		return inputCopy;
	}

	/**
	 * Determines the "smallest" element in a portion of an array. The array
	 * elements in positions i s.t. start <= i <= end are compared. Elements are
	 * compared lexicographically.
	 * 
	 * @param array
	 *            the array.
	 * @param start
	 *            the starting index
	 * @param end
	 *            the ending index (plus one)
	 * @return the index of the minimum element (in lexicographic order).
	 */
	public int getMinIndex(String[] array, int start, int end) {
		int temp = start;
		if (start == end) {
			return start;
		}
		int minIndex = getMinIndex(array, start + 1, end);
		if (comesBefore(array[temp], array[minIndex])) {
			return temp;
		} else {
			return minIndex;
		}
	}

	/**
	 * Sorts an array, lexicographically.
	 * 
	 * @param array
	 * @return the sorted array
	 */
	private void selectionSort(String[] array) {
		selectionSort(array, 0, array.length - 1);
	}

	/**
	 * Sorts a portion of an array. The array elements in positions i s.t. start
	 * <= i <= end are sorted. Elements are compared lexicographically.
	 * 
	 * @param array
	 *            the array to sort
	 * @param start
	 *            the starting index
	 * @param end
	 *            the ending index (plus one)
	 */
	private void selectionSort(String[] array, int start, int end) {
		if (end <= start) {
			return;
		}
		int minIndex = getMinIndex(array, start, end);
		swap(array, start, minIndex);
		selectionSort(array, start + 1, end);
	}

	/**
	 * Swaps two Strings in an array. Swaps the Strings at index i and index j.
	 * 
	 * @param array
	 *            an array.
	 * @param i
	 *            an index.
	 * @param j
	 *            an index.
	 */
	private void swap(String[] array, int i, int j) {
		String tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	/**
	 * Compares two Strings in lexicographic order.
	 * 
	 * @param a
	 *            a string
	 * @param b
	 *            a string
	 * @return true iff a is lexicographically before b.
	 */
	private boolean comesBefore(String a, String b) {
		return (a.compareTo(b) < 0);
	}

	/**
	 * Copies the given array. Does not make copies of the elements themselves,
	 * because Strings are immutable anyway.
	 * 
	 * @param input
	 *            the array to copy
	 * @return a copy of the array.
	 */
	private String[] arrayCopy(String[] input) {
		String[] copy = new String[input.length];
		for (int i = 0; i < input.length; i++) {
			copy[i] = input[i];
		}
		return copy;
	}
}
