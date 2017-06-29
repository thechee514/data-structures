/**
 * SequenceTests class tests all the sequence methods in the Sequence class It
 * tests all the possibilities that I could think of based on the javadocs
 * 
 * @author Vincent Chee
 * @version 14/03/15
 */

public class SequenceTests {

	public static void main(String[] args) {

		Testing.setVerbose(true);
		System.out.println("Starting Tests");

		testCreate();

		testBasic();

		testAdd();

		testEnsureCapacity();

		testTrim();

		testAddAll();

		testRemove();

		testClone();

		testConcatenation();

		testEquals();

		testConcatenation_modifyingConcatenationDoesntChangeFirstSequence();

		testConcatenation_modifyingConcatenationDoesntChangeSecondSequence();

		System.out.println("Tests Complete");
		Testing.finishTests();

	}

	private static void testCreate() {
		Testing.testSection("Creation tests");

		Sequence s1 = new Sequence();
		Testing.assertEquals("Default constructor", "{} (capacity = 10)",
				s1.toString());
		Testing.assertEquals("Default constructor, initial size", 0, s1.size());

		Sequence s2 = new Sequence(20);
		Testing.assertEquals("Non-default constructor", "{} (capacity = 20)",
				s2.toString());
		Testing.assertEquals("Non-default constructor, initial size", 0,
				s2.size());
	}

	/**
	 * In order, testing size(), isCurrent(), getCurrent(), getCapacity(),
	 * start() and advance() with one element. Then, with 2 elements, then with
	 * no elements. Also shows add methods are working when there's still space.
	 */
	private static void testBasic() {
		Testing.testSection("Basic Method tests");

		// Empty Sequence test
		Sequence s1 = new Sequence(15);
		Testing.assertEquals("Size Test", 0, s1.size());
		Testing.assertEquals("Current Element test should return false", false,
				s1.isCurrent());
		Testing.assertEquals("Current Element test should throw exepction",
				"There is no current element.", s1.getCurrent());
		Testing.assertEquals(
				"Get Capacity test should return chosen capacity (capacity = 15)",
				15, s1.getCapacity());

		// With an item test
		s1.addAfter("^_^");
		Testing.assertEquals("Size Test on Sequence", 1, s1.size());
		Testing.assertEquals("Current Element test should return true", true,
				s1.isCurrent());
		Testing.assertEquals(
				"Current Element test should print correct element", "^_^",
				s1.getCurrent());
		Testing.assertEquals(
				"Get Capacity should return chosen capacity (capacity = 15)",
				15, s1.getCapacity());

		s1.addAfter("^o^");
		Testing.assertEquals("Size Test on Sequence with two items", 2,
				s1.size());

		// Test start
		s1.start();
		Testing.assertEquals("Start test should go back to first element",
				"^_^", s1.getCurrent());

		// Test advance
		s1.advance();
		s1.addAfter("0-0");
		Testing.assertEquals(
				"Advance should result in new element in third position",
				"{^_^, ^o^, >0-0} (capacity = 15)", s1.toString());
	}

	private static void testAdd() {

		Testing.testSection("adding tests");

		// Empty Sequence Add Tests
		Sequence s1 = new Sequence();
		s1.addAfter("^_^");
		s1.addAfter("O.O");
		s1.start();

		Testing.assertEquals(
				"addBefore should create element in first position", "^_^",
				s1.getCurrent());

		s1 = new Sequence();
		Testing.assertEquals("Current Element test should return false", false,
				s1.isCurrent());

		s1.addAfter("^_^");
		s1.advance();
		Testing.assertEquals(
				"Advancing should cause no current Element",
				false, s1.isCurrent());

		// Adding Multiple
		s1 = new Sequence();
		s1.addBefore("^_^");
		s1.addBefore("O.O");
		s1.addBefore("^.^");
		s1.addBefore("*.*");
		Testing.assertEquals(
				"addBefore should add elements one behind the other",
				"{>*.*, ^.^, O.O, ^_^} (capacity = 10)", s1.toString());

		s1 = new Sequence();
		s1.addAfter("^_^");
		s1.addAfter("O.O");
		s1.addAfter("^.^");
		s1.addAfter("*.*");
		Testing.assertEquals("addAfter should add elements one after another",
				"{^_^, O.O, ^.^, >*.*} (capacity = 10)", s1.toString());

		// Adding In Between
		s1 = new Sequence();
		s1.addBefore("^_^");
		s1.addBefore("O.O");
		s1.advance();
		s1.addBefore("^.^");
		s1.addBefore("*.*");
		Testing.assertEquals(
				"addBefore should add elements one behind another",
				"{O.O, >*.*, ^.^, ^_^} (capacity = 10)", s1.toString());

		s1 = new Sequence();
		s1.addAfter("^_^");
		s1.addAfter("O.O");
		s1.start();
		s1.addAfter("^.^");
		s1.addAfter("*.*");
		Testing.assertEquals("addAfter should add elements one after another",
				"{^_^, ^.^, >*.*, O.O} (capacity = 10)", s1.toString());

		// Adding over original capacity
		s1 = new Sequence(2);
		s1.addBefore("^_^");
		s1.addBefore("O.O");
		s1.addBefore("^.^");
		Testing.assertEquals(
				"addBefore orginal capcity creates new array with original length*2+1",
				"{>^.^, O.O, ^_^} (capacity = 5)", s1.toString());

		s1 = new Sequence(2);
		s1.addAfter("^_^");
		s1.addAfter("O.O");
		s1.addAfter("^.^");
		Testing.assertEquals(
				"addAfter orginal capcity creates new array with original length*2+1",
				"{^_^, O.O, >^.^} (capacity = 5)", s1.toString());
	}

	private static void testEnsureCapacity() {

		Testing.testSection("ensureCapacity() Tests");

		Sequence s1 = new Sequence();
		Testing.assertEquals("Capacity", 10, s1.getCapacity());
		s1.ensureCapacity(100);
		Testing.assertEquals("Capacity", 100, s1.getCapacity());
		s1 = new Sequence();
		s1.addAfter("A");
		Testing.assertEquals(
				"ensureCapicity should create new array with same elements",
				"{>A} (capacity = 10)", s1.toString());
		s1.ensureCapacity(15);
		Testing.assertEquals(
				"ensureCapicity should create new array with same elements",
				"{>A} (capacity = 15)", s1.toString());
	}

	private static void testTrim() {

		Testing.testSection("trimToSize() Test");
		Sequence s1 = new Sequence();
		s1.addAfter("ONE");
		s1.addAfter("TWO");
		Testing.assertEquals("Capacity", 10, s1.getCapacity());
		s1.trimToSize();
		Testing.assertEquals("Capacity", 2, s1.getCapacity());
	}

	private static void testAddAll() {

		Testing.testSection("addAll() Test");

		Sequence s1 = new Sequence(5);
		s1.addAfter("^_^");
		s1.addAfter("^_^");
		s1.addAfter("^_^");

		Sequence s2 = new Sequence(2);
		s2.addAfter("O.O");
		s2.addAfter("O.O");

		s1.addAll(s2);
		Testing.assertEquals("addAllTest should not impact original current",
				"{^_^, ^_^, >^_^, O.O, O.O} (capacity = 5)", s1.toString());
		Testing.assertEquals("addAllTest should not impact addend current",
				"{O.O, >O.O} (capacity = 2)", s2.toString());

		s1 = new Sequence(5);
		s1.addAfter("^_^");
		s1.addAfter("^_^");
		s1.addAfter("^_^");
		s1.addAfter("^_^");
		s1.addAfter("^_^");

		s2 = new Sequence(2);
		s2.addAfter("O.O");
		s2.addAfter("O.O");

		s1.addAll(s2);

		Testing.assertEquals(
				"addAll should handle exceed capacity with original current pointer",
				"{^_^, ^_^, ^_^, ^_^, >^_^, O.O, O.O} (capacity = 7)",
				s1.toString());
		Testing.assertEquals("addAll addend should be the same",
				"{O.O, >O.O} (capacity = 2)", s2.toString());

		s1 = new Sequence(5);
		s1.addAfter("^_^");
		s1.addAfter("^_^");
		s1.addAfter("^_^");
		s1.addAfter("^_^");
		s1.addAfter("^_^");

		s2 = new Sequence(2);
		s2.addAfter("O.O");
		s2.addAfter("O.O");

		s2.addAll(s1);

		Testing.assertEquals(
				"addAll should handle exceed capacity with original current pointer",
				"{O.O, >O.O, ^_^, ^_^, ^_^, ^_^, ^_^} (capacity = 7)",
				s2.toString());
		Testing.assertEquals("addAll addend should be the same",
				"{^_^, ^_^, ^_^, ^_^, >^_^} (capacity = 5)", s1.toString());
	}

	private static void testRemove() {

		Testing.testSection("remove() Test");
		Sequence s1 = new Sequence();
		s1.addAfter("^_^");
		s1.addAfter("O.O");
		s1.addAfter("^.^");
		s1.addAfter("*.*");
		Testing.assertEquals("No items removed yet",
				"{^_^, O.O, ^.^, >*.*} (capacity = 10)", s1.toString());

		s1.removeCurrent();
		Testing.assertEquals(
				"Remove Current should remove current item with no current at the end",
				"{^_^, O.O, ^.^} (capacity = 10)", s1.toString());

		s1 = new Sequence();
		s1.addAfter("^_^");
		s1.addAfter("O.O");
		s1.addAfter("^.^");
		s1.addAfter("*.*");
		s1.start();
		s1.removeCurrent();
		Testing.assertEquals("Remove Current should remove current item",
				"{>O.O, ^.^, *.*} (capacity = 10)", s1.toString());

	}

	private static void testConcatenation() {

		Testing.testSection("concatenation() Test");

		Sequence s1 = new Sequence(2);
		s1.addAfter("O.O");
		s1.addAfter("O.O");
		Sequence s2 = new Sequence(2);
		s2.addAfter("^.^");
		s2.addAfter("^.^");
		Sequence s3 = Sequence.concatenation(s1, s2);
		Testing.assertEquals("Concatenation should combine sequences",
				"{O.O, O.O, ^.^, ^.^} (capacity = 4)", s3.toString());
		s3.addAfter("|.|");
		Testing.assertEquals("Adding to concactenated sequence should change new sequence",
				"{O.O, O.O, ^.^, ^.^, >|.|} (capacity = 9)", s3.toString());
		Testing.assertEquals("Adding to concatenated sequence shouldn't change original s1",
				"{O.O, >O.O} (capacity = 2)", s1.toString());
		Testing.assertEquals("Adding to concatenated sequence shouldn't change original s1",
				"{^.^, >^.^} (capacity = 2)", s2.toString());
	}

	private static void testClone() {

		Testing.testSection("clone() Test");

		Sequence s1 = new Sequence();
		Sequence s2 = s1.clone();
		Testing.assertEquals("Clone should be empty", "{} (capacity = 10)",
				s1.toString());

		s1 = new Sequence();
		s1.addBefore("^_^");
		s1.addAfter("O.O");
		s1.addAfter("^.^");
		s2 = new Sequence();
		Testing.assertEquals(
				"cloning should produce a different object.  Does (s1 != s2)",
				true, (s2 != s1));

		s1 = new Sequence();
		s1.addBefore("^_^");
		s1.addAfter("O.O");
		s1.addAfter("^.^");
		s1.addAfter("*.*");
		s2 = s1.clone();

		s1.addAfter("&.&");
		Testing.assertEquals(
				"Original changes after adding to original sequence",
				"{^_^, O.O, ^.^, *.*, >&.&} (capacity = 10)", s1.toString());

		Testing.assertEquals(
				"Clone shouldn't change after adding to original sequence",
				"{^_^, O.O, ^.^, >*.*} (capacity = 10)", s2.toString());

		s1 = new Sequence();
		s1.addBefore("^_^");
		s1.addAfter("O.O");
		s1.addAfter("^.^");
		s1.addAfter("*.*");
		s2 = s1.clone();

		s2.addAfter("&.&");
		Testing.assertEquals(
				"Original doesn't change after adding to clone sequence",
				"{^_^, O.O, ^.^, >*.*} (capacity = 10)", s1.toString());

		Testing.assertEquals(
				"Clone shouldn't change after adding to original sequence",
				"{^_^, O.O, ^.^, *.*, >&.&} (capacity = 10)", s2.toString());
	}

	private static void testEquals() {

		Testing.testSection("equals() Test");

		Sequence s1 = new Sequence();
		Sequence s2 = new Sequence();

		Testing.assertEquals("Empty sequence should be same (capacity = 10)",
				true, s1.equals(s2));

		s1 = new Sequence(2);
		s2 = new Sequence(5);

		Testing.assertEquals(
				"Empty sequence with different capcity should be same (capacity = 10)",
				true, s1.equals(s2));

		s1 = new Sequence();
		s2 = new Sequence();
		s1.addBefore("^_^");
		s2.addBefore("O.O");

		Testing.assertEquals(
				"Equals test on different sequences (capacity = 10)", false,
				s1.equals(s2));

		s1 = new Sequence();
		s2 = new Sequence();
		s1.addBefore("^_^");
		s1.addAfter("O.O");
		s2.addBefore("O.O");
		s2.addAfter("^_^");

		Testing.assertEquals(
				"Equals test on same elements in different order (capacity = 10)",
				false, s1.equals(s2));

		s1 = new Sequence();
		s2 = new Sequence();
		s1.addBefore("^_^");
		s1.addAfter("O.O");
		s2.addBefore("^_^");
		s2.addAfter("O.O");

		Testing.assertEquals("Equals test on same sequences (capacity = 10)",
				true, s1.equals(s2));

		s1 = new Sequence(2);
		s2 = new Sequence(5);

		s1.addBefore("^_^");
		s1.addAfter("O.O");
		s2.addBefore("^_^");
		s2.addAfter("O.O");

		Testing.assertEquals(
				"Equals test on same elements with different capacity (capacity = 2 and 5)",
				true, s1.equals(s2));

		s1 = new Sequence(2);
		s2 = new Sequence(5);

		s1.addBefore("^_^");
		s1.addAfter("*.*");
		s2.addBefore("^_^");
		s2.addAfter("O.O");

		Testing.assertEquals(
				"Equals test on different elements with different capacity (capacity = 2 and 5)",
				false, s1.equals(s2));

	}

	private static void testConcatenation_modifyingConcatenationDoesntChangeFirstSequence() {
		Sequence s1 = new Sequence(5);
		s1.addAfter("A");
		s1.addAfter("B");
		s1.addAfter("C");
		Sequence s2 = new Sequence();
		s2.addAfter("X");
		s2.addAfter("Y");
		s2.addAfter("Z");
		Sequence conc = Sequence.concatenation (s1, s2);
		conc.addAfter("D");
		Testing.assertEquals("{A, B, >C} + {X, Y, >Z}; add D to concatenation.", "{A, B, >C} (capacity = 5)", s1.toString());
	}

	private static void testConcatenation_modifyingConcatenationDoesntChangeSecondSequence ()
	{
		Sequence s1 = new Sequence(5);
		s1.addAfter("A");
		s1.addAfter("B");
		s1.addAfter("C");
		Sequence s2 = new Sequence();
		s2.addAfter("X");
		s2.addAfter("Y");
		s2.addAfter("Z");
		Sequence conc = Sequence.concatenation (s1, s2);
		conc.addAfter("D");
		Testing.assertEquals("{A, B, >C} + {X, Y, >Z};  add D to concatenation.", "{X, Y, >Z} (capacity = 10)", s2.toString());
	}
}
