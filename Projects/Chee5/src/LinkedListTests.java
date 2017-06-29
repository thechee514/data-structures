/**
 * LinkedList Tests which tests my linkedlist methods based on javadocs.
 * @author Vincent Chee
 * @version 23/02/15
 *
 */
public class LinkedListTests {

	public static void main(String[] args) {
		
		Testing.setVerbose(true);
		System.out.println("Starting Tests");
		testCreate();
		testSize();
		testGet();
		testSet();
		testAdd();
		testRemove();
	}
	
	private static void testCreate() {
		Testing.testSection("Creation tests");
		LinkedList aLinkedList = new LinkedList();
		Testing.assertEquals("Default constructor", "{}",
				aLinkedList.toString());
	}
	
	private static void testSize() {
		Testing.testSection("Size tests");
		LinkedList aLinkedList = new LinkedList();
		Testing.assertEquals("Size", 0,
				aLinkedList.size());
		aLinkedList.add("YAY",0);
		Testing.assertEquals("Size after adding one", 1,
				aLinkedList.size());
		aLinkedList.add("YAY",1);
		Testing.assertEquals("Size after adding two", 2,
				aLinkedList.size());
	}
	
	private static void testGet() {
		Testing.testSection("Get tests");
		LinkedList aLinkedList = new LinkedList();
		aLinkedList.add("YAY",0);
		aLinkedList.add("Woohoo",1);
		Testing.assertEquals("Get first element", "YAY",
				aLinkedList.get(0));
		Testing.assertEquals("Get next element", "Woohoo",
				aLinkedList.get(1));
		Testing.assertEquals("Get element that doesn't exist", "Please select an acceptable value.",
				aLinkedList.get(3));
	}
	
	private static void testSet() {
		Testing.testSection("Set tests");
		LinkedList aLinkedList = new LinkedList();
		aLinkedList.add("YAY",0);
		aLinkedList.add("Woohoo",1);
		Testing.assertEquals("Get first element", "YAY",
				aLinkedList.get(0));
		aLinkedList.set("HAH",0);
		Testing.assertEquals("Set first element to HAH", "HAH",
				aLinkedList.get(0));
	}
	
	private static void testAdd() {
		Testing.testSection("Add tests");
		LinkedList aLinkedList = new LinkedList();
		aLinkedList.add("Yay",0);
		aLinkedList.add("Earlier",0);
		aLinkedList.add("Woohoo",1);
		Testing.assertEquals("Adding", "{Earlier, Woohoo, Yay}",
				aLinkedList.toString());
		Testing.assertEquals("Size after adding three", 3,
				aLinkedList.size());
	}
	
	private static void testRemove() {
		Testing.testSection("Remove tests");
		LinkedList aLinkedList = new LinkedList();
		aLinkedList.add("YAY",0);
		aLinkedList.remove(0);
		aLinkedList.add("Woohoo",0);
		Testing.assertEquals("Removed Yay", "{Woohoo}",
				aLinkedList.toString());
		aLinkedList.remove(0);
		Testing.assertEquals("Removed all elements", "{}",
				aLinkedList.toString());
	}
}