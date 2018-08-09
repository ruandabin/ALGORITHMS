package top.ruandb.structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉链表实现二叉树
 * 
 * @author rdb
 *
 */
public class MyLinkBinaryTree<T> {

	// 保存根节点
	private TreeNode<T> root;

	// 以指定根元素初始化二叉树
	public MyLinkBinaryTree() {
		root = null;
	}

	// 以指定根元素初始化二叉树
	public MyLinkBinaryTree(T element) {
		root = new TreeNode<T>(element);
	}

	public TreeNode addRoot(T element) {
		if (root != null) {
			throw new RuntimeException("已经有root节点，无法添加root节点");
		} else {
			root = new TreeNode<T>(element);
		}
		return root;
	}

	// public Tree
	/**
	 * 添加指定节点
	 * 
	 * @param parent
	 *            添加节点的父节点
	 * @param element
	 *            添加节点的数据
	 * @param isLeft
	 *            是否是左子节点
	 * @return 添加的节点
	 */
	public TreeNode<T> addNode(TreeNode<T> parent, T element, boolean isLeft) {
		if (parent == null) {
			throw new RuntimeException("节点为null,无法添加子节点");
		}
		if (isLeft && parent.getLeft() != null) {
			throw new RuntimeException("左节点已经存在,无法添加左子节点");
		}
		if (!isLeft && parent.getRight() != null) {
			throw new RuntimeException("右节点已经存在,无法添加右子节点");
		}
		TreeNode<T> newNode = new TreeNode<>(element);
		if (isLeft) {
			parent.setLeft(newNode);
		} else {
			parent.setRight(newNode);
		}
		return newNode;
	}

	// 判断二叉树是否为空
	public boolean isEmpty() {
		return root == null;
	}

	// 返回根根节点
	public TreeNode<T> root() {
		if (isEmpty()) {
			throw new RuntimeException("空树，无根节点");
		}
		return root;
	}

	// 返回父节点
	public T parent(TreeNode<T> child) {
		//利用前序遍历
		List<TreeNode<T>> list = preIterator(root);
		for(TreeNode<T> n : list){
			if(n.getLeft() == child || n.getRight() == child){
				return n.getValue() ;
			}
		}
		return null ;
	}


	// 返回指定节点的左子节点
	@SuppressWarnings("unchecked")
	public T leftChild(TreeNode<T> parent) {
		if (parent == null) {
			throw new RuntimeException("父节点为空");
		}

		return parent == null ? null : (T) parent.getLeft().getValue();
	}

	// 返回右节点
	@SuppressWarnings("unchecked")
	public T rightChild(TreeNode<T> parent) {
		if (parent == null) {
			throw new RuntimeException("父节点为空");
		}
		return parent == null ? null : (T) parent.getRight().getValue();
	}

	// 返回二叉树的深度
	public int deep() {
		return deep(root);
	}

	// 递归获取：每棵子树的深度为其所有子树的最大深度+1
	@SuppressWarnings("unused")
	private int deep(TreeNode<T> node) {

		if (node == null) {
			return 0;
		}
		int leftDeep = deep(node.getLeft());
		int rightDeep = deep(node.getRight());
		return leftDeep > rightDeep ? leftDeep + 1 : rightDeep + 1;
	}

	/**
	 * 前序遍历 先根节点，递归左子树，递归右子树
	 * 
	 * @param node
	 * @return
	 */
	public List<TreeNode<T>> preIterator() {
		return preIterator(root);
	}

	private List<TreeNode<T>> preIterator(TreeNode<T> node) {

		List<TreeNode<T>> list = new ArrayList<TreeNode<T>>();

		list.add(node);
		// 递归左子树
		if (node.getLeft() != null) {
			List<TreeNode<T>> lLift = preIterator(node.getLeft());
			list.addAll(lLift);
		}
		// 递归右子树
		if (node.getRight() != null) {
			List<TreeNode<T>> lRight = preIterator(node.getRight());
			list.addAll(lRight);
		}
		return list;
	}

	/**
	 * 中序遍历 递归左子树，根节点，递归右子树
	 * 
	 * @param node
	 * @return
	 */
	public List<TreeNode<T>> inIterator() {
		return inIterator(root);
	}

	private List<TreeNode<T>> inIterator(TreeNode<T> node) {
		List<TreeNode<T>> list = new ArrayList<TreeNode<T>>();

		// 左子树
		if (node.getLeft() != null) {
			List lList = inIterator(node.getLeft());
			list.addAll(lList);
		}
		// 根
		list.add(node);
		// 右子树
		if (node.getRight() != null) {
			List rList = inIterator(node.getRight());
			list.addAll(rList);
		}

		return list;
	}

	/**
	 * 后序遍历 递归左子树，递归右子树，根节点
	 * 
	 * @param node
	 * @return
	 */
	public List<TreeNode<T>> postIterator() {
		return postIterator(root);
	}

	private List<TreeNode<T>> postIterator(TreeNode<T> node) {
		List<TreeNode<T>> list = new ArrayList<TreeNode<T>>();

		// 左子树
		if (node.getLeft() != null) {
			List lList = postIterator(node.getLeft());
			list.addAll(lList);
		}
		// 右子树
		if (node.getRight() != null) {
			List rList = postIterator(node.getRight());
			list.addAll(rList);
		}

		// 根
		list.add(node);

		return list;
	}

	public static void main(String[] args) {
		// 初始化空树
		MyLinkBinaryTree<String> my = new MyLinkBinaryTree<String>();
		// 添加根节点
		my.addRoot("根");
		TreeNode n21 = my.addNode(my.root, "第二层左节点", true);
		TreeNode n22 = my.addNode(my.root, "第二层右节点", false);
		TreeNode n31 = my.addNode(n21, "第三层左节点", true);
		TreeNode n32 = my.addNode(n21, "第三层右节点", false);
		TreeNode n41 = my.addNode(n31, "第四层左节点", true);

		System.out.println(my.root().getValue());
		System.out.println(my.root().getLeft().getValue());
		System.out.println(my.parent(n41));
		System.out.println(my.leftChild(n21));
		System.out.println(my.rightChild(n21));
		System.out.println(my.deep());

		List<TreeNode<String>> list = my.preIterator(my.root);
		my.preIterator(my.root).stream()
				.forEach(e -> System.out.print(e.getValue() + "   "));
		System.out.println();
		my.inIterator(my.root).stream()
				.forEach(e -> System.out.print(e.getValue() + "   "));
		System.out.println();
		my.postIterator(my.root).stream()
				.forEach(e -> System.out.print(e.getValue() + "   "));
	}

}
