/**
 * GenericLinkedListTests Class just tests methods of GenericLinkedList Class
 * 
 * @author Vincent Chee
 * @version 20/02/15
 *
 */
public class GenericLinkedListTests {

	public static void main(String[] args) {
		Testing.setVerbose(true);
		System.out.println("Starting Tests");
		testCreate();
		testSize();
		testAddAndInsertSorted();
		testRemove();
		testFind();

		Testing.finishTests();
	}

	private static void testCreate() {
		Testing.testSection("Creation tests");
		GenericLinkedList<String> aLinkedList = new GenericLinkedList<String>();
		Testing.assertEquals("Default constructor", "", aLinkedList.toString());
	}

	private static void testSize() {
		Testing.testSection("Size tests");
		GenericLinkedList<String> aLinkedList = new GenericLinkedList<String>();
		Testing.assertEquals("Size", 0, aLinkedList.size());
		aLinkedList.add(0, "YAY");
		Testing.assertEquals("Size after adding one", 1, aLinkedList.size());
	}

	private static void testAddAndInsertSorted() {
		Testing.testSection("Get tests");
		GenericLinkedList<String> aLinkedList = new GenericLinkedList<String>();
		aLinkedList.add(0, "B");
		aLinkedList.add(1, "C");
		aLinkedList.add(2, "E");
		Testing.assertEquals("Adding", "B" + "\n" + "C" + "\n" + "E",
				aLinkedList.toString());
		aLinkedList.insertSorted("F");
		aLinkedList.insertSorted("D");
		aLinkedList.insertSorted("A");
		aLinkedList.insertSorted("A");
		aLinkedList.insertSorted("Ap");
		Testing.assertEquals("Should insert elements sorted", "A" + "\n" + "A"
				+ "\n" + "Ap" + "\n" + "B" + "\n" + "C" + "\n" + "D" + "\n"
				+ "E" + "\n" + "F", aLinkedList.toString());
		Testing.assertEquals("Size after adding 8", 8, aLinkedList.size());

	}

	private static void testRemove() {
		Testing.testSection("Remove tests");
		GenericLinkedList<String> aLinkedList = new GenericLinkedList<String>();
		aLinkedList.insertSorted("A");
		aLinkedList.insertSorted("B");
		aLinkedList.insertSorted("C");
		aLinkedList.insertSorted("D");
		aLinkedList.insertSorted("E");
		aLinkedList.insertSorted("F");
		Testing.assertEquals("Adding:", "A" + "\n" + "B" + "\n" + "C" + "\n"
				+ "D" + "\n" + "E" + "\n" + "F", aLinkedList.toString());
		Testing.assertEquals(
				"Removing something not in LinkedList returns null", null,
				aLinkedList.remove("Z"));
		Testing.assertEquals("Size after adding six", 6, aLinkedList.size());

		Testing.assertEquals("Remove should return removed element", "A",
				aLinkedList.remove("A"));
		Testing.assertEquals("Remove should return removed element", "D",
				aLinkedList.remove("D"));
		Testing.assertEquals("Remove should return removed element", "F",
				aLinkedList.remove("F"));
		Testing.assertEquals("Removed Elements should be gone", "B" + "\n"
				+ "C" + "\n" + "E", aLinkedList.toString());
		Testing.assertEquals("Size after removing three", 3, aLinkedList.size());

	}

	private static void testFind() {
		Testing.testSection("Find tests");
		GenericLinkedList<String> aLinkedList = new GenericLinkedList<String>();
		aLinkedList.insertSorted("A");
		aLinkedList.insertSorted("B");
		aLinkedList.insertSorted("C");
		aLinkedList.insertSorted("D");
		aLinkedList.insertSorted("E");
		aLinkedList.insertSorted("F");
		Testing.assertEquals("Adding:", "A" + "\n" + "B" + "\n" + "C" + "\n"
				+ "D" + "\n" + "E" + "\n" + "F", aLinkedList.toString());
		Testing.assertEquals(
				"Finding should return null if element doesn't exist", null,
				aLinkedList.find("Z"));
		Testing.assertEquals("Finding should return found element", "A",
				aLinkedList.find("A"));
		Testing.assertEquals("Finding shouldn't change orginal", "A" + "\n"
				+ "B" + "\n" + "C" + "\n" + "D" + "\n" + "E" + "\n" + "F",
				aLinkedList.toString());
		Testing.assertEquals("Size after finding remains the same", 6,
				aLinkedList.size());

	}
}