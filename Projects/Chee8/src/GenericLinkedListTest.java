/**
 * Testing GenericLinkedList Class using JUnit
 * 
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GenericLinkedListTest {

	private GenericLinkedList<String> ll;
	
	@Before
	public void setUp() throws Exception {
		ll = new GenericLinkedList<String> ();
	}

	@After
	public void tearDown() throws Exception {
		ll = null;
	}

	@Test
	public void testConstructor () {
		assertEquals ("New list is empty", "{}", ll.toString());
	}
	
	@Test
	public void testAddAtTail_toEmptyList () {
		ll.addAtTail("A");
		assertEquals ("{} + A", "{A}", ll.toString());
	}
	
	@Test
	public void testAddAtTail_nonEmptyList () {
		ll.addAtTail("A");
		ll.addAtTail("B");
		assertEquals ("{A} + B", "{A, B}", ll.toString());
	}

	@Test
	public void testSize_EmptyList () {
		assertEquals ("Empty List size", 0, ll.size());
	}
	
	@Test
	public void testSize_nonEmptyList () {
		ll.addAtTail("A");
		ll.addAtTail("B");
		assertEquals ("Size after adding two", 2, ll.size());
	}
	
	@Test 
	public void testAdd_toEmptyList () {
		ll.add(0, "A");
		assertEquals ("{} + A", "{A}", ll.toString());

	}
	
	@Test
	public void testAdd_nonEmptyList () {
		ll.add(0, "A");
		ll.add(1, "B");
		assertEquals ("{A} + B", "{A, B}", ll.toString());
	}
	
	@Test
	public void testAdd_atStartTwice () {
		ll.add(0, "A");
		ll.add(0, "B");
		assertEquals ("{A} + B", "{B, A}", ll.toString());
	}
	
	@Test
	public void testAdd_inBetween () {
		ll.add(0, "A");
		ll.add(1, "C");
		ll.add(1, "B");
		assertEquals ("{A, C} + B", "{A, B, C}", ll.toString());
	}
	
	@Test 
	public void testInsertSorted_toEmptyList () {
		ll.insertSorted("A");
		assertEquals ("{} + A", "{A}", ll.toString());

	}
	
	@Test
	public void testInsertSorted_nonEmptyList () {
		ll.insertSorted("B");
		ll.insertSorted("A");
		assertEquals ("{B} + A", "{A, B}", ll.toString());
	}
	
	@Test
	public void testRemove_toEmptyList () {
		ll.insertSorted("B");
		ll.insertSorted("A");
		ll.remove("A");
		ll.remove("B");
		assertEquals ("{A, B} - A - B", "{}", ll.toString());
	}
	
	@Test
	public void testRemove_nonEmptyList () {
		ll.insertSorted("B");
		ll.insertSorted("A");
		ll.remove("A");
		assertEquals ("{A, B} - A", "{B}", ll.toString());
	}
	
	@Test
	public void testFind_toEmptyList () {
		assertEquals ("Find A in {}", null, ll.find("A"));
	}
	
	@Test
	public void testFind_nonEmptyList () {
		ll.insertSorted("Z");
		ll.insertSorted("Q");
		ll.insertSorted("F");
		assertEquals ("Find P in {F, Q, Z}", null, ll.find("P"));
	}
	
	@Test
	public void testFind_nonEmptyListWithElement () {
		ll.insertSorted("Z");
		ll.insertSorted("Q");
		ll.insertSorted("F");
		ll.insertSorted("R");
		assertEquals ("Find F in {F, R, Q, Z}", "F", ll.find("F"));
	}
	
	@Test 
	public void testAddMethods_nonEmptyList() {
		ll.add(0, "B");
		ll.insertSorted("A");
		ll.addAtTail("Z");
		assertEquals ("{B} + A + Z", "{A, B, Z}", ll.toString());

	}
}
