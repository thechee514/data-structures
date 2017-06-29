/**
 * The main method you use to run your experiments is here. You should study
 * this code to see what's going on and modify it in MANY WAYS to thoroughly
 * test each sort routine. See the assignment for suggestions of ways to modify
 * this code.
 * 
 * @author Aaron Cass and Kristina Striegnitz based on a version by Chris Fernandes and Vincent Chee
 * @version 26/02/2015
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Client {
	public static void main(String[] args) {
		writer();
	}

	public static String sandbox(int size) {
		int[] random, identical, reverse, sorted, largestStart, largestEnd, smallestStart, smallestEnd = null;
		int n;
		n = size;

		// create a random array of n integers
		random = randomArray(n);

		// create an identical array of n integers
		identical = identicalArray(n);

		// create a reverse sorted array of n integers
		reverse = reverseSortedArray(n);

		// create a sorted array of n integers
		sorted = sortedArray(n);

		// create an array with largest int at start of n integers
		largestStart = largestStartArray(n);

		// create an array with largest int at end of n integers
		largestEnd = largestEndArray(n);

		// create an array with smallest int at start of n integers
		smallestStart = smallestStartArray(n);

		// create an array with smallest int at end of n integers
		smallestEnd = smallestEndArray(n);

		Sorter[] sortMethods = initializeSortMethods();

		return 
		  appendInfo(sortMethods, 1, random, n)
		+ appendInfo(sortMethods, 2, random, n)
		+ appendInfo(sortMethods, 3, random, n)
		+ appendInfo(sortMethods, 4, random, n)
		+ appendInfo(sortMethods, 5, random, n)
		+ appendInfo(sortMethods, 6, random, n)

		+ appendInfo(sortMethods, 1, identical, n)
		+ appendInfo(sortMethods, 2, identical, n)
		+ appendInfo(sortMethods, 3, identical, n)
		+ appendInfo(sortMethods, 4, identical, n)
		+ appendInfo(sortMethods, 5, identical, n)
		+ appendInfo(sortMethods, 6, identical, n) 

		+ appendInfo(sortMethods, 1, reverse, n)
		+ appendInfo(sortMethods, 2, reverse, n)
		+ appendInfo(sortMethods, 3, reverse, n)
		+ appendInfo(sortMethods, 4, reverse, n)
		+ appendInfo(sortMethods, 5, reverse, n)
		+ appendInfo(sortMethods, 6, reverse, n) 

		+ appendInfo(sortMethods, 1, sorted, n)
		+ appendInfo(sortMethods, 2, sorted, n)
		+ appendInfo(sortMethods, 3, sorted, n)
		+ appendInfo(sortMethods, 4, sorted, n)
		+ appendInfo(sortMethods, 5, sorted, n)
		+ appendInfo(sortMethods, 6, sorted, n) 

		+ appendInfo(sortMethods, 1, largestStart, n)
		+ appendInfo(sortMethods, 2, largestStart, n)
		+ appendInfo(sortMethods, 3, largestStart, n)
		+ appendInfo(sortMethods, 4, largestStart, n)
		+ appendInfo(sortMethods, 5, largestStart, n)
		+ appendInfo(sortMethods, 6, largestStart, n) 

		+ appendInfo(sortMethods, 1, largestEnd, n)
		+ appendInfo(sortMethods, 2, largestEnd, n)
		+ appendInfo(sortMethods, 3, largestEnd, n)
		+ appendInfo(sortMethods, 4, largestEnd, n)
		+ appendInfo(sortMethods, 5, largestEnd, n)
		+ appendInfo(sortMethods, 6, largestEnd, n) 

		+ appendInfo(sortMethods, 1, smallestStart, n)
		+ appendInfo(sortMethods, 2, smallestStart, n)
		+ appendInfo(sortMethods, 3, smallestStart, n)
		+ appendInfo(sortMethods, 4, smallestStart, n)
		+ appendInfo(sortMethods, 5, smallestStart, n)
		+ appendInfo(sortMethods, 6, smallestStart, n) 

		+ appendInfo(sortMethods, 1, smallestEnd, n)
		+ appendInfo(sortMethods, 2, smallestEnd, n)
		+ appendInfo(sortMethods, 3, smallestEnd, n)
		+ appendInfo(sortMethods, 4, smallestEnd, n)
		+ appendInfo(sortMethods, 5, smallestEnd, n)
		+ appendInfo(sortMethods, 6, smallestEnd, n);
	}

	// Several Array Creation methods
	private static int[] randomArray(int n) {
		int[] random = new int[n];
		for (int i = 0; i < n; i++) {
			random[i] = (int) (-1000 * Math.random());
		}
		return random;
	}

	private static int[] identicalArray(int n) {
		int[] identical = new int[n];
		for (int i = 0; i < n; i++) {
			identical[i] = 1;
		}
		return identical;
	}

	private static int[] reverseSortedArray(int n) {
		int z = 1000000;
		int[] reverseSorted = new int[n];
		for (int i = 0; i < n; i++) {
			reverseSorted[i] = z--;
		}
		return reverseSorted;
	}

	private static int[] sortedArray(int n) {
		int[] sorted = new int[n];
		for (int i = 0; i < n; i++) {
			sorted[i] = i;
		}
		return sorted;
	}

	private static int[] largestStartArray(int n) {
		int[] largestStart = new int[n];
		for (int i = 0; i < n; i++) {
			largestStart[i] = (int) (-1000 * Math.random());
		}
		largestStart[0] = 1324;
		return largestStart;
	}

	private static int[] largestEndArray(int n) {
		int[] largestEnd = new int[n];
		for (int i = 0; i < n; i++) {
			largestEnd[i] = (int) (-1000 * Math.random());
		}
		largestEnd[n - 1] = 1;
		return largestEnd;
	}

	private static int[] smallestStartArray(int n) {
		int[] smallestStart = new int[n];
		for (int i = 0; i < n; i++) {
			smallestStart[i] = (int) (-1000 * Math.random());
		}
		smallestStart[0] = Integer.MIN_VALUE;
		return smallestStart;
	}

	private static int[] smallestEndArray(int n) {
		int[] smallestEnd = new int[n];
		for (int i = 0; i < n; i++) {
			smallestEnd[i] = (int) (-1000 * Math.random());
		}
		smallestEnd[n - 1] = Integer.MIN_VALUE;
		return smallestEnd;
	}

	/**
	 * testing method helps create arrays of different sizes
	 * 
	 * @return
	 */
	public static String testing() {
		String toString = "";
		// tests array length 1000-10000
		for (int i = 1000; i < 10000; i += 1000) {
			toString += sandbox(i);
		}
		// tests array length 10000-100000
		for (int i = 10000; i < 100000; i += 10000) {
			toString += sandbox(i);
		}
		for (int i = 100000; i <= 250000; i+= 50000) {
			toString += sandbox(i);
		}
		return toString;
	}

	// Method which writes data into .csv file
	private static void writer() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter("data.csv", true));
		} catch (IOException e) {
			
		}
		writer.println(testing());
		writer.close();
	}

	// Private helper method that creates a correct string for the .csv file
	private static String appendInfo(Sorter[] sorters, int sortMethodNum,
			int[] toSort, int size) {
		long startTime = System.currentTimeMillis();
		int[] B;
		B = sorters[sortMethodNum].sort(toSort);
		return sortMethodNum + "," + (System.currentTimeMillis() - startTime)
				+ "," + sorters[sortMethodNum].getOperationCount() + "," + size
				+ "\n";
	}

	private static Sorter[] initializeSortMethods() {
		Sorter[] sorts = new Sorter[7];

		sorts[1] = new Method1();
		sorts[2] = new Method2();
		sorts[3] = new Method3();
		sorts[4] = new Method4();
		sorts[5] = new Method5();
		sorts[6] = new Method6();

		return sorts;
	}

	/**
	 * Times a sort method. Prints the time the sort method took as well as the
	 * number of operations it took. Also prints a message if the resulting
	 * array is not actually sorted.
	 * 
	 * @param sorters
	 *            an array of sorters containing a Sorter to use.
	 * @param sortMethodNum
	 *            the index of the Sorter to use (from the sorters array)
	 * @param toSort
	 *            an array of ints to sort.
	 */
	private static void timeSorting(Sorter[] sorters, int sortMethodNum,
			int[] toSort) {
		long startTime = System.currentTimeMillis();
		int[] B;

		B = sorters[sortMethodNum].sort(toSort);
		System.out.print("Method" + sortMethodNum + " time: ");
		System.out.print(System.currentTimeMillis() - startTime);
		System.out.println(", \tmethod" + sortMethodNum + " count: "
				+ sorters[sortMethodNum].getOperationCount());
		// to make sure it is sorted
		if (!isSorted(B)) {
			System.out.println("  The array is not sorted.");
		}
	}

	/**
	 * printArray: prints the elements of array A to System.out. It prints 10
	 * values per line
	 * 
	 * @param A
	 *            the array to print
	 */
	private static void printArray(int[] A) {
		System.out.println();
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + ",  ");
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
	}

	/**
	 * tests if an array is sorted. If the array is not sorted, prints out the
	 * two unsorted elements that it found.
	 * 
	 * @param A
	 *            the array to test
	 * @return true iff A is sorted from smallest to largest.
	 */
	private static boolean isSorted(int[] A) {
		if (A == null)
			return true;
		for (int i = 0; i < A.length - 1; i++)
			if (A[i] > A[i + 1]) {
				System.out.print("A[" + i + "] = " + A[i] + " and A[" + (i + 1)
						+ "] = " + A[i + 1]);
				return false;
			}
		return true;
	}
}