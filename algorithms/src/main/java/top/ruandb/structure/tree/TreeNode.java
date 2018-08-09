package top.ruandb.structure.tree;
/**
 * 树节点（三叉链表，也可当二叉链表用）
 * @author rdb
 *
 */
public class TreeNode<T> {
	private final T value ;
	private TreeNode left ;
	private TreeNode right ;
	private TreeNode parent;
	public TreeNode(T value) {
		this.value = value ;
		this.left = null ;
		this.right = null ;
		this.parent = null ;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	public T getValue() {
		return value;
	}
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	
}
