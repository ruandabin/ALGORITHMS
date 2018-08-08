package top.ruandb.structure.tree;
/**
 * 树节点（二叉链表）
 * @author rdb
 *
 */
public class TreeNode<T> {
	private final T value ;
	private TreeNode left ;
	private TreeNode right ;
	public TreeNode(T value) {
		this.value = value ;
		this.left = null ;
		this.right = null ;
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
	
}
