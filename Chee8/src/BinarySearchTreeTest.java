/**
 * Testing BinarySearchTree Class using JUnit
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

	private BinarySearchTree<String> tree;

	@Before
	public void setUp() throws Exception {
		tree = new BinarySearchTree<String>();
	}

	@After
	public void tearDown() throws Exception {
		tree = null;
	}

	@Test
	public void testConstructor() {
		assertEquals("A new tree should be empty", "", tree.toString());
	}

	@Test
	public void testAdd_toEmptyTree() {
		tree.add("K");
		assertEquals("empty tree + K", "K", tree.toString());
	}

	@Test
	public void testAdd_depthZeroTreeLeftChild() {
		tree.add("K");
		tree.add("D");
		assertEquals("K + D", "D\nK", tree.toString());
	}

	@Test
	public void testAddShowTree_depthZeroTreeLeftChild() {
		tree.add("K");
		tree.add("D");
		assertEquals("K + D", "K\n D", tree.showTree());
	}

	@Test
	public void testAdd_depthZeroTreeRightChild() {
		tree.add("K");
		tree.add("L");
		assertEquals("K + L", "K\nL", tree.toString());
	}

	@Test
	public void testAddShowTree_depthZeroTreeRightChild() {
		tree.add("K");
		tree.add("L");
		assertEquals("K + L", "K\n L", tree.showTree());
	}

	@Test
	public void testAdd_depthZeroTwoChildren() {
		tree.add("K");
		tree.add("L");
		tree.add("D");

		assertEquals("K + L + D", "D\nK\nL", tree.toString());
	}

	@Test
	public void testAddShowTree_depthZeroTreeTwoChildren() {
		tree.add("K");
		tree.add("L");
		tree.add("D");
		assertEquals("K + L + D", "K\n D\n L", tree.showTree());
	}

	@Test
	public void testAdd_depthOneTreeLeftChild() {
		tree.add("K");
		tree.add("D");
		tree.add("C");
		assertEquals("K + D + C", "C\nD\nK", tree.toString());
	}

	@Test
	public void testAddShowTree_depthOneTreeLeftChild() {
		tree.add("K");
		tree.add("D");
		tree.add("C");
		assertEquals("K + D + C", "K\n D\n  C", tree.showTree());
	}

	@Test
	public void testAdd_depthOneTreeRightChild() {
		tree.add("K");
		tree.add("L");
		tree.add("M");
		assertEquals("K + L + M", "K\nL\nM", tree.toString());
	}

	@Test
	public void testAddShowTree_depthOneTreeRightChild() {
		tree.add("K");
		tree.add("L");
		tree.add("M");
		assertEquals("K + L + M", "K\n L\n  M", tree.showTree());
	}

	@Test
	public void testAdd_depthOneTwoChildren() {
		tree.add("F");
		tree.add("B");
		tree.add("A");
		tree.add("D");
		tree.add("H");
		tree.add("G");
		tree.add("I");

		assertEquals("F + B + A + D + H + G + I", "A\nB\nD\nF\nG\nH\nI",
				tree.toString());
	}

	@Test
	public void testAddShowTree_depthOneTreeTwoChildren() {
		tree.add("F");
		tree.add("B");
		tree.add("A");
		tree.add("D");
		tree.add("H");
		tree.add("G");
		tree.add("I");
		assertEquals("F + B + A + D + H + G + I",
				"F\n B\n  A\n  D\n H\n  G\n  I", tree.showTree());
	}

	@Test
	public void testAdd_depthTwoTwoChildren() {
		tree.add("P");
		tree.add("L");
		tree.add("H");
		tree.add("A");
		tree.add("J");
		tree.add("N");
		tree.add("M");
		tree.add("O");
		tree.add("T");
		tree.add("R");
		tree.add("Q");
		tree.add("S");
		tree.add("Y");
		tree.add("X");
		tree.add("Z");
		assertEquals(
				"P + L + H + A + J + N + M + O + T + R + Q + S + Y + X + Z",
				"A\nH\nJ\nL\nM\nN\nO\nP\nQ\nR\nS\nT\nX\nY\nZ", tree.toString());
	}

	@Test
	public void testAddShowTree_depthTwoTreeTwoChildren() {
		tree.add("P");
		tree.add("L");
		tree.add("H");
		tree.add("A");
		tree.add("J");
		tree.add("N");
		tree.add("M");
		tree.add("O");
		tree.add("T");
		tree.add("R");
		tree.add("Q");
		tree.add("S");
		tree.add("Y");
		tree.add("X");
		tree.add("Z");
		assertEquals(
				"P + L + H + A + J + N + M + O + T + R + Q + S + Y + X + Z",
				"P\n L\n  H\n   A\n   J\n  N\n   M\n   O\n T\n  R\n   Q\n   S\n  Y\n   X\n   Z",
				tree.showTree());
	}

	@Test
	public void testAdd_depthTwoIncomplete() {
		tree.add("F");
		tree.add("B");
		tree.add("A");
		tree.add("D");
		tree.add("C");
		tree.add("E");
		tree.add("G");
		tree.add("I");
		tree.add("H");
		assertEquals("F + B + A + D + C + E + G + I + H",
				"A\nB\nC\nD\nE\nF\nG\nH\nI", tree.toString());
	}

	@Test
	public void testAddShowTree_depthTwoTreeIncomplete() {
		tree.add("F");
		tree.add("B");
		tree.add("A");
		tree.add("D");
		tree.add("C");
		tree.add("E");
		tree.add("G");
		tree.add("I");
		tree.add("H");
		assertEquals("F + B + A + D + C + E + G + I + H",
				"F\n B\n  A\n  D\n   C\n   E\n G\n  I\n   H", tree.showTree());
	}

	@Test
	public void testFind_onEmptyTree() {
		assertEquals("Find A in empty tree", null, tree.find("A"));
	}

	@Test
	public void testFind_onZeroDepthTreeContaining() {
		tree.add("A");
		assertEquals("Find A in tree with depth zero containing A", "A",
				tree.find("A"));
	}

	@Test
	public void testFind_onZeroDepthTreeNotContaining() {
		tree.add("B");
		assertEquals("Find A in tree with depth zero not containing A", null,
				tree.find("A"));
	}

	@Test
	public void testFind_onOneDepthTreeContaining() {
		tree.add("D");
		tree.add("A");
		tree.add("E");
		assertEquals("Find A in tree with depth one containing A", "A",
				tree.find("A"));
	}

	@Test
	public void testFind_onOneDepthTreeNotContaining() {
		tree.add("D");
		tree.add("B");
		tree.add("E");
		assertEquals("Find A in tree with depth one not containing A", null,
				tree.find("A"));
	}

	@Test
	public void testFind_onTwoDepthTreeContaining() {
		tree.add("F");
		tree.add("B");
		tree.add("A");
		tree.add("D");
		tree.add("H");
		tree.add("G");
		tree.add("I");
		assertEquals("Find A in tree with depth two containing A", "A",
				tree.find("A"));
	}

	@Test
	public void testFind_onTwoDepthTreeNotContaining() {
		tree.add("F");
		tree.add("C");
		tree.add("B");
		tree.add("D");
		tree.add("H");
		tree.add("G");
		tree.add("I");
		assertEquals("Find A in tree with depth two not containing A", null,
				tree.find("A"));
	}

	@Test
	public void testRemove_onEmptyTree() {
		assertEquals("Remove A from empty tree", null, tree.remove("A"));
	}

	@Test
	public void testRemove_onZeroDepthTreeContaining() {
		tree.add("A");
		assertEquals("Remove A from zero depth tree containing A", "A",
				tree.remove("A"));
	}

	@Test
	public void testRemove_showTree() {
		tree.add("A");
		tree.remove("A");
		assertEquals("A - A", "", tree.showTree());
	}

	@Test
	public void testRemove_onZeroDepthTreeNotContaining() {
		tree.add("B");
		assertEquals("Remove A from zero depth tree not containing A", null,
				tree.remove("A"));
	}

	@Test
	public void testRemove_onOneDepthTreeContaining() {
		tree.add("C");
		tree.add("D");
		tree.add("E");
		tree.remove("E");
		assertEquals("Remove E from one depth tree containing E", "C\n D",
				tree.showTree());
	}

	@Test
	public void testRemove_onOneDepthTreeNotContaining() {
		tree.add("C");
		tree.add("D");
		tree.add("A");
		assertEquals("Remove B from one depth tree containing B", null,
				tree.remove("B"));
	}

	@Test
	public void testRemove_onOneDepthTreeNotContaining_showTree() {
		tree.add("C");
		tree.add("D");
		tree.add("F");
		tree.remove("E");
		assertEquals("Remove E from one depth tree containing E", "C\n D\n  F",
				tree.showTree());
	}

	@Test
	public void testRemove_onNodeContainingAChild_showTree() {
		tree.add("C");
		tree.add("D");
		tree.add("E");
		tree.remove("D");
		assertEquals("Remove D from tree", "C\n E", tree.showTree());
	}

	@Test
	public void testRemove_onNodeWithTwoChildren_showTree() {
		tree.add("D");
		tree.add("B");
		tree.add("A");
		tree.add("C");
		tree.remove("B");
		assertEquals("Remove B from tree", "D\n A\n  C", tree.showTree());
	}

	@Test
	public void testRemove_onTwoDepthTreeContaining_showTree() {
		tree.add("F");
		tree.add("B");
		tree.add("A");
		tree.add("D");
		tree.add("H");
		tree.add("G");
		tree.add("I");
		tree.remove("B");
		assertEquals("Remove B from tree", "F\n A\n  D\n H\n  G\n  I",
				tree.showTree());
	}

	@Test
	public void testRemove_onTwoDepthTreeContainingOneChild_showTree() {
		tree.add("G");
		tree.add("J");
		tree.add("L");
		tree.add("K");
		tree.remove("J");
		assertEquals("Remove J from tree", "G\n L\n  K", tree.showTree());
	}

	@Test
	public void testRemove_Root_showTree() {
		tree.add("F");
		tree.add("C");
		tree.add("B");
		tree.add("D");
		tree.add("H");
		tree.add("G");
		tree.add("I");
		tree.remove("F");
		assertEquals("Remove root F from tree", "D\n C\n  B\n H\n  G\n  I",
				tree.showTree());

	}
	
	@Test
	public void testRemove_onTwoDepthTreeContainingTwoChildren() {
		tree.add("P");
		tree.add("L");
		tree.add("H");
		tree.add("A");
		tree.add("J");
		tree.add("N");
		tree.add("M");
		tree.add("O");
		tree.add("T");
		tree.add("R");
		tree.add("Q");
		tree.add("S");
		tree.add("Y");
		tree.add("X");
		tree.add("Z");
		tree.remove("L");
		assertEquals("Removing L", "P\n J\n  H\n   A\n  N\n   M\n   O\n T\n  R\n   Q\n   S\n  Y\n   X\n   Z", tree.showTree());
	}
	
	@Test
	public void testRemove_rootOneNodeTreeRemainingTree() {
		tree.add("Z");
		tree.remove("Z");
		assertEquals("Remove only node, root from tree", "", tree.showTree());
	}
}
