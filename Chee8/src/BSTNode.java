/**
 * BSTNode class represents an individual node for the BinarySearchTree. 
 * @author Vincent Chee
 * @version 19/03/15
 *
 * @param <T>
 */
public class BSTNode<T> {

	public T data;
	public BSTNode<T> left;
	public BSTNode<T> right;
	
	public BSTNode(T initialData) {
		data = initialData;
		left = null;
		right = null;
	}
	
	public BSTNode() {
		data = null;
		left = null;
		right = null;
	}
	
	public boolean hasOneChild() {
		return this.left == null || this.right == null;
	}

	public boolean hasTwoChildren() {
		return this.left != null && this.right != null;
	}
	
	public boolean isLeaf() {
		return this.left == null && this.right == null;
	}
}
