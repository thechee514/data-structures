/**
 * BinarySearchTree class created to handle tree operations like insertion,
 * deletion, searching, printing, etc.
 * 
 * @author Vincent Chee
 * @version 19/03/15
 * 
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> {
	/**
	 * INVARIANTS 1. Left child of root node is always less than root. 2. Right
	 * child of root node is always greater than root.
	 */
	private BSTNode<T> root;

	public BinarySearchTree() {
		root = new BSTNode<T>();
	}

	/**
	 * Finds node in the tree that stores a value that according to compareTo
	 * matches with toFind
	 * 
	 * @return
	 */
	public T find(T toFind) {
		return findHelper(root, toFind);
	}

	/**
	 * findHelper method recursively searches for the element
	 * 
	 * @param root
	 * @param toFind
	 * @return
	 */
	private T findHelper(BSTNode<T> root, T toFind) {
		if (root == null) {
			return null;
		}
		if (root.data == null) {
			return null;
		} else if (root.data.compareTo(toFind) == 0) {
			return root.data;
		} else if (root.data.compareTo(toFind) <= 0) {
			return findHelper(root.right, toFind);
		} else {
			return findHelper(root.left, toFind);
		}
	}

	/**
	 * Adds new node with value toAdd to the tree
	 * 
	 * @param toAdd
	 */
	public void add(T toAdd) {
		addHelper(root, toAdd);
	}

	/**
	 * addHelper recursively finds the correct place to add the node toAdd
	 * 
	 * @param root
	 * @param toAdd
	 */
	private void addHelper(BSTNode<T> root, T toAdd) {
		BSTNode<T> newNode = new BSTNode<T>(toAdd);
		if (root.data == null) {
			this.root = newNode;
		} else {
			if (root.data.compareTo(toAdd) > 0 && root.left != null) {
				addHelper(root.left, toAdd);
			} else if (root.data.compareTo(toAdd) <= 0 && root.right != null) {
				addHelper(root.right, toAdd);
			} else if (root.data.compareTo(toAdd) > 0) {
				root.left = newNode;
			} else if (root.data.compareTo(toAdd) <= 0) {
				root.right = newNode;
			}
		}
	}

	/**
	 * Finds node in the tree that stores a value that according to compareTo
	 * matches with toFind and removes it
	 * 
	 * @param toRemove
	 * @return
	 */
	public T remove(T toRemove) {
		return removeHelper(root, toRemove);
	}

	/**
	 * Remove Helper which uses recursion to arrive at node to remove Does the
	 * actual removal and restructuring of tree
	 * 
	 * @param target
	 * @param toRemove
	 * @return the node to be returned
	 */
	private T removeHelper(BSTNode<T> target, T toRemove) {
		T temp = find(toRemove);
		if (target != null) {
			if (temp == null) {
				return null;
			} else if (target.data.compareTo(toRemove) == 0) {
				BSTNode<T> parentNode = getParent(toRemove, root);
				if (parentNode == null & root.isLeaf()) {
					temp = root.data;
					root = null;
					return temp;
				} else if (target.isLeaf()) {
					if (parentNode.data.compareTo(toRemove) < 0) {
						parentNode.right = null;
					} else {
						parentNode.left = null;
					}
				} else if (target.hasOneChild()) {
					if (parentNode != null) {
						if (toRemove.compareTo(parentNode.data) > 0) {
							if (target.right != null) {
								parentNode.right = target.right;
							} else {
								parentNode.right = target.left;
							}
						} else {
							if (target.right != null) {
								parentNode.left = target.right;
							} else {
								parentNode.left = target.left;
							}
						}
					}
				} else if (target.hasTwoChildren()) {
					BSTNode<T> rightMostOfLeftSubtree = getRightMostLeftDescendant(target);
					BSTNode<T> rightMostLeftParentNode = getParent(rightMostOfLeftSubtree.data, target);
					T rightMostTemp = rightMostOfLeftSubtree.data;
					target.data = rightMostTemp;
					if (rightMostTemp.compareTo(rightMostLeftParentNode.data) > 0) {
						rightMostLeftParentNode.right = rightMostOfLeftSubtree.left;
					} else {
						rightMostLeftParentNode.left = rightMostOfLeftSubtree.left;
					}
					return temp;
				}
			} else if (target.data.compareTo(toRemove) < 0) {
				return removeHelper(target.right, toRemove);
			} else if (target.data.compareTo(toRemove) >= 0) {
				return removeHelper(target.left, toRemove);
			}
		}
		return null;
	}

	/**
	 * This returns the parent node of the node containing the given data
	 * returns null if there is no parent If data is not in the search tree,
	 * there is no parent
	 * 
	 * @param data
	 * @return
	 */
	private BSTNode<T> getParent(T data, BSTNode<T> target) {
		return getParentRec(data, target);
	}

	/**
	 * Gets parent node by recursion
	 * @param data
	 * @param target
	 * @return
	 */
	private BSTNode<T> getParentRec(T data, BSTNode<T> target) {
		if (target == null) {
			return null;
		}
		if (target.left != null && data.compareTo(target.left.data) == 0) {
			return target;
		}
		if (target.right != null && data.compareTo(target.right.data) == 0) {
			return target;
		}
		if (data.compareTo(target.data) <= 0) {
			return getParentRec(data, target.left);
		} else {
			return getParentRec(data, target.right);
		}
	}

	/**
	 * Gets Largest Value of left subtree
	 * 
	 * @param target
	 * @return
	 */
	private BSTNode<T> getRightMostLeftDescendant(BSTNode<T> target) {
		return getRightMostDescendant(target.left);
	}

	/**
	 * Recursively goes to the rightmost node
	 * 
	 * @param root
	 * @return
	 */
	private BSTNode<T> getRightMostDescendant(BSTNode<T> root) {
		if (root.right != null) {
			return getRightMostDescendant(root.right);
		}
		return root;
	}

	/**
	 * returns a String representing elements of the tree in order determined by
	 * compareTo
	 */
	public String toString() {
		BSTNode<T> cursor = root;
		return inOrderToString(cursor, 0);
	}

	/**
	 * In-order recursion to represent tree as string
	 * 
	 * @param root
	 * @param level
	 * @return
	 */
	private String inOrderToString(BSTNode<T> root, int level) {
		String toString = "";
		if (root.data == null) {
			return toString;
		} else if (root.data != null) {
			if (root.left != null) {
				toString += inOrderToString(root.left, level + 1) + "\n";
			}
			toString += root.data.toString();
			if (root.right != null) {
				toString += "\n" + inOrderToString(root.right, level + 1);
			}
		}
		return toString;
	}

	/**
	 * Prints spaces for each level
	 * @param level
	 * @return
	 */
	private String printSpaces(int level) {
		String spaces = "";
		for (int i = 0; i < level; i++) {
			spaces += " ";
		}
		return spaces;
	}

	/**
	 * returns a String showing elements of tree in pre-order order
	 * 
	 * @return
	 */
	public String showTree() {
		BSTNode<T> cursor = root;
		return preOrderToString(cursor, 0);
	}

	/**
	 * Pre-order traversal through tree for showing tree 
	 * 
	 * @param root
	 * @param level
	 * @return
	 */
	private String preOrderToString(BSTNode<T> root, int level) {
		String toString = "";
		if (root == null || root.data == null) {
			return toString;
		}
		toString += printSpaces(level);
		if (root != null) {
			toString += root.data.toString();
		}
		if (root.left != null) {
			toString += "\n" + preOrderToString(root.left, level + 1);
		}
		if (root.right != null) {
			toString += "\n" + preOrderToString(root.right, level + 1);
		}
		return toString;
	}
}