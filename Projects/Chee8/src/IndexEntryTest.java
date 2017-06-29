/**
 * Testing BinarySearchTree Class using JUnit
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IndexEntryTest {

	private IndexEntry indexEntry;

	@Before
	public void setUp() throws Exception {
		indexEntry = new IndexEntry("First");
	}

	@After
	public void tearDown() throws Exception {
		indexEntry = null;
	}
	
	@Test
	public void testConstructor() {
		assertEquals("A new index entry should contain one word.", "First: {}", indexEntry.toString());
	}

	@Test 
	public void testSecondConstructor() {
		indexEntry = new IndexEntry("Second", 3);
		assertEquals("A new index entry should contain a word and page number.", "Second: {3}", indexEntry.toString());
	}
	
	@Test 
	public void testIsFull_newEntry() {
		indexEntry = new IndexEntry("Second", 3);
		assertEquals("A new index entry of a word containing one page number should not be full.", false, indexEntry.isFull());
	}
	
	@Test 
	public void testIsFull_fullEntry() {
		indexEntry = new IndexEntry("Second");
		indexEntry.addPage(4);
		indexEntry.addPage(1);
		indexEntry.addPage(5);
		indexEntry.addPage(6);
		assertEquals("A new index entry of a word containing four different page numbers is full.", true, indexEntry.isFull());
	}
	
	@Test
	public void testGetWord() {
		indexEntry = new IndexEntry("Second", 3);
		assertEquals("A new index entry of a word containing five different page numbers is full.", "Second", indexEntry.getWord());
	}
	
	@Test 
	public void testToString() {
		indexEntry = new IndexEntry("Second", 3);
		indexEntry.addPage(4);
		indexEntry.addPage(1);
		indexEntry.addPage(5);
		assertEquals("toString should return nice representation of indexEntry.", "Second: {3, 4, 1, 5}", indexEntry.toString());
	}
	@Test 
	public void testCompareToSameWord() {
		IndexEntry anotherEntry = new IndexEntry("First");
		assertEquals("CompareTo should return 0 if word is same, 1 if first word is greater, and -1 if second word is less.", true, indexEntry.compareTo(anotherEntry) == 0);
	}
	
	@Test 
	public void testCompareToEarlierWord() {
		IndexEntry anotherEntry = new IndexEntry("Blab");
		assertEquals("CompareTo should return 0 if word is same, 1 if first word is greater, and -1 if second word is less.", true, indexEntry.compareTo(anotherEntry) > 0);
	}
	
	@Test 
	public void testCompareToLaterWord() {
		IndexEntry anotherEntry = new IndexEntry("Zappos");
		assertEquals("CompareTo should return 0 if word is same, 1 if first word is greater, and -1 if second word is less.", true, indexEntry.compareTo(anotherEntry) < 0);
	}
}