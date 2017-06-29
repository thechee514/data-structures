/**
 * ExpressionTree is a binary expression tree supporting the operators +, -, *,
 * and /. Only 1-digit operands are allowed.
 * 
 * @author Vincent Chee
 * @version 26/02/15
 */
public class ExpressionTree {
	private TreeNode root;

	/**
	 * Creates an expression tree for the given expression. The expression must
	 * be in valid prefix notation.
	 * 
	 * @param expression
	 *            the expression to represent in the tree.
	 */
	public ExpressionTree(String expression) {
		root = buildSubtree(new CharacterIterator(expression));
	}

	/**
	 * Builds an expression tree starting with the first character in the input.
	 * Precondition: the prefix expression in input must be valid
	 * 
	 * @param input
	 *            the input as a CharacterIterator that can be
	 * @return a pointer to the root of the subtree it builds.
	 */
	private TreeNode buildSubtree(CharacterIterator input) {
		if (input.hasNext()) {
			char nextChar = input.getNext().charValue();
			TreeNode newNode = new TreeNode(nextChar);
			if (isOperator(nextChar)) {
				newNode.llink = buildSubtree(input);
				newNode.rlink = buildSubtree(input);
			}
			return newNode;
		} else {
			return null;
		}
	}

	/**
	 * Determines if a given character represents an operator.
	 * 
	 * @param c
	 *            the given character
	 * @return true iff c is an operator.
	 */
	private boolean isOperator(Character c) {
		return c.equals('+') || c.equals('-') || c.equals('*') || c.equals('/');
	}

	/**
	 * Performs a preorder traversal, creating a string version of the
	 * expression.
	 * 
	 * @return a String with the mathematical expression in prefix notation
	 */
	public String prefixString() {
		return preOrderToString(root, 0);
	}

	/**
	 * Helper method which constructs a prefix string to be returned
	 * @param root
	 * @param level
	 * @return toString
	 */
	private String preOrderToString(TreeNode root, int level) {
		String toString = "";
		toString += root.toString();
		if (root.llink != null) {
			toString += preOrderToString(root.llink, level + 1);
		}
		if (root.rlink != null) {
			toString += preOrderToString(root.rlink, level + 1);
		}
		return toString;
	}

	/**
	 * Performs an inorder traversal, creating a string version of the
	 * expression.
	 * 
	 * @return a String with the mathematical expression in infix notation
	 *         (fully parenthesized)
	 */
	public String infixString() {
		return inOrderToString(root, 0);
	}

	/**
	 * Helper method which constructs an in order string to be returned
	 * @param root
	 * @param level
	 * @return toString
	 */
	private String inOrderToString(TreeNode root, int level) {
		String toString = "";
		if (root.llink != null) {
			toString += "(" + inOrderToString(root.llink, level + 1);
		}
		toString += root.toString();
		if (root.rlink != null) {
			toString += inOrderToString(root.rlink, level + 1) + ")";
		}
		return toString;
	}
}
