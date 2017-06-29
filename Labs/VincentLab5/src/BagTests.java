/**
 * Testing suite for BetterBag
 * 
 * @author Vincent Chee and Kristina Striegnitz and Chris Fernandes
 * 
 */
import mainbook.IntBag;

public class BagTests {
	public static void main(String[] args) {
		Testing.setVerbose(true);
		System.out.println("Starting Tests");

		testClone();
		testisEmpty();
		testRemoveRandom();
		testContains();
		testEquals();
		System.out.println("Tests Complete");
	}

	private static void testClone() {
		Testing.testSection("Testing clone()");

		BetterBag bag1 = new BetterBag(3);

		BetterBag bag2 = bag1.clone();
		Testing.assertEquals("cloning an empty sequence", "{} (capacity = 3)",
				bag2.toString());

		bag1 = new BetterBag(3);
		bag1.add(4);
		bag1.add(8);
		bag1.add(12);
		bag2 = bag1.clone();
		Testing.assertEquals("cloning {4, 8, 12}", "{4, 8, 12} (capacity = 3)",
				bag2.toString());
		Testing.assertEquals(
				"cloning {4, 8, 12} should produce a different object.  Does (bag2 != bag1)",
				true, (bag2 != bag1));

		bag1 = new BetterBag(7);
		bag1.add(-1);
		bag1.add(-2);
		bag1.add(-3);
		bag2 = bag1.clone();
		bag1.add(-4);
		Testing.assertEquals("clone shouldn't change after adding to original",
				"{-1, -2, -3} (capacity = 7)", bag2.toString());
		Testing.assertEquals(
				"original should change after cloning & adding to original",
				"{-1, -2, -3, -4} (capacity = 7)", bag1.toString());

		bag1 = new BetterBag(5);
		bag1.add(1);
		bag1.add(2);
		bag1.add(3);
		bag1.add(4);
		bag2 = bag1.clone();
		bag2.add(5);
		Testing.assertEquals("original shouldn't change after adding to clone",
				"{1, 2, 3, 4} (capacity = 5)", bag1.toString());
		Testing.assertEquals(
				"clone should change after cloning & adding to clone",
				"{1, 2, 3, 4, 5} (capacity = 5)", bag2.toString());
	}

	private static void testisEmpty() {

		Testing.testSection("Testing isEmpty()");

		BetterBag bag1 = new BetterBag();
		Testing.assertEquals(
				"Bag should return true if it's empty (capacity = 10)", true,
				bag1.isEmpty());

		bag1.add(1);
		Testing.assertEquals(
				"Bag should return false if it's not empty (capacity = 10)",
				false, bag1.isEmpty());
	}

	private static void testRemoveRandom() {

		Testing.testSection("Testing removeRandom()");

		BetterBag bag1 = new BetterBag();
		Testing.assertEquals(
				"If bag is empty, should return Integer.MIN_VALUE (capacity = 10)",
				Integer.MIN_VALUE, bag1.removeRandom());

		bag1.add(1);
		Testing.assertEquals(
				"If bag has one item, it should return that item (capacity = 10)",
				1, bag1.removeRandom());

		bag1.add(2);
		int randomNumber = bag1.removeRandom();
		boolean oneOrTwo = randomNumber == 1 || randomNumber == 2;
		Testing.assertEquals(
				"Random element has been removed from bag (capacity = 10)",
				true, oneOrTwo);

	}

	private static void testContains() {

		Testing.testSection("Testing contains()");

		BetterBag bag1 = new BetterBag();
		Testing.assertEquals("Contains test on an empty bag (capacity = 10)",
				false, bag1.contains(3));

		bag1.add(6);
		Testing.assertEquals(
				"Contains test on a bag without target (capacity = 10)", false,
				bag1.contains(3));

		bag1.add(5);
		bag1.add(3);
		Testing.assertEquals(
				"Contains test on a bag with target (capacity = 10)", true,
				bag1.contains(3));
	}

	private static void testEquals() {

		Testing.testSection("Testing equals()");

		BetterBag bag1 = new BetterBag();
		BetterBag bag2 = new BetterBag();
		Testing.assertEquals("Equals test on empty bags (capacity = 10)", true,
				bag1.equals(bag2));
		
		bag1.add(1);
		bag1.add(2);
		Testing.assertEquals("Equals test on different bags (capacity = 10)",
				false, bag1.equals(bag2));

		bag2.add(1);
		bag2.add(2);
		Testing.assertEquals("Equals test on same bags (capacity = 10)", true,
				bag1.equals(bag2));

		bag1 = new BetterBag(5);
		bag2 = new BetterBag();
		Testing.assertEquals(
				"Equals test on empty bags of different capacity (capacity = 5 and 10)",
				true, bag1.equals(bag2));
		bag1.add(1);
		bag1.add(2);
		bag1.add(3);

		Testing.assertEquals(
				"Equals test on different bags of different capacity (capacity = 5 and 10)",
				false, bag1.equals(bag2));
		
		bag2.add(3);
		bag2.add(2);
		bag2.add(1);
		Testing.assertEquals(
				"Equals test on same bags of different capacity (capacity = 5 and 10)",
				true, bag1.equals(bag2));

		bag1 = new BetterBag(5);
		bag2 = new BetterBag();
		bag1.add(1);
		bag1.add(2);
		bag1.add(3);

		bag2.add(3);
		bag2.add(3);
		bag2.add(1);
		Testing.assertEquals(
				"Equals test on different number of duplicates with different capacity (capacity = 5 and 10)",
				false, bag1.equals(bag2));

		bag1 = new BetterBag();
		bag2 = new BetterBag();
		bag1.add(1);
		bag1.add(2);
		bag1.add(3);

		bag2.add(3);
		bag2.add(3);
		bag2.add(1);
		Testing.assertEquals(
				"Equals test on different number of duplicates with same capacity (capacity = 10)",
				false, bag1.equals(bag2));
		
		bag1 = new BetterBag(5);
		bag2 = new BetterBag();
		bag1.add(1);
		bag1.add(2);

		bag2.add(1);
		bag2.add(2);
		bag2.add(3);
		Testing.assertEquals(
				"Equals test if ALL elements are the same with different capacity (capacity = 5 and 10)",
				false, bag1.equals(bag2));
		
		bag1 = new BetterBag();
		bag2 = new BetterBag();
		bag1.add(1);
		bag1.add(2);

		bag2.add(1);
		bag2.add(2);
		bag2.add(3);
		Testing.assertEquals(
				"Equals test if ALL elements are the same with same capacity (capacity = 10)",
				false, bag1.equals(bag2));
	}
}
