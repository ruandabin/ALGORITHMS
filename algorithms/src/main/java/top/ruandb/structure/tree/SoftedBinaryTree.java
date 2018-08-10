package top.ruandb.structure.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 排序二叉树
 * 
 * @author rdb
 *
 * @param <T>
 */
public class SoftedBinaryTree<T extends Comparable> {
	// 保存根节点
	private TreeNode root;

	// 创建空的排序二叉树
	public SoftedBinaryTree() {
		root = null;
	}

	// 以指定根元素创建排序二叉树
	public SoftedBinaryTree(T element) {
		root = new TreeNode<T>(element);
	}

	// 添加节点
	@SuppressWarnings("unchecked")
	public void add(T element) {
		if (root == null) {
			root = new TreeNode<T>(element);
		} else {
			TreeNode<T> current = root;
			TreeNode<T> parent = null;
			int cmp = 0;
			// 寻找合适的节点，以该节点做为父节点添加新节点
			while (current != null) {
				parent = current;
				cmp = element.compareTo(current.getValue());
				if (cmp > 0) {
					current = current.getRight();
				} else {
					current = current.getLeft();
				}
			}
			TreeNode<T> newNode = new TreeNode<T>(element);
			newNode.setParent(parent);
			if (cmp > 0) {
				parent.setRight(newNode);
			} else {
				parent.setLeft(newNode);
			}
		}
	}

	// 获取根节点
	public TreeNode root() {
		return root;
	}

	// 根据值搜索节点
	@SuppressWarnings("unchecked")
	public TreeNode<T> getNode(T element) {
		TreeNode<T> current = root;
		int cmp = 0;
		while (current != null) {
			cmp = element.compareTo(current.getValue());
			if (cmp > 0) {
				current = current.getRight();
			} else if (cmp < 0) {
				current = current.getLeft();
			} else {
				return current;
			}
		}
		return null;
	}

	// 删除节点
	@SuppressWarnings("unchecked")
	public void remove(T element) {
		TreeNode<T> node = getNode(element);
		if (node == null) {
			return;
		}
		// 删除的节点是叶子节点
		if (node.getLeft() == null && node.getRight() == null) {
			if(node == root){
				return ;
			}
			//判断node是左子节点还是右子节点
			if (node.getParent().getLeft() == node) {
				node.getParent().setLeft(null);
			} else {
				node.getParent().setRight(null);
			}
			node.setParent(null);
			;
		}
		// 删除的节点只有左子树
		if (node.getLeft() != null && node.getRight() == null) {
			if(node == root ){
				root = node.getLeft() ;
				root.setParent(null);
				node.setLeft(null);
				return ;
			}
			// node在左子树
		    if (node.getParent().getLeft() == node) {
				node.getParent().setLeft(node.getLeft());
			}
			// node在右子树
			else {
				node.getParent().setRight(node.getLeft());
			}
			node.getLeft().setParent(node.getParent());
			node.setParent(null);
		}
		// 删除的节点只有右子树
		if (node.getLeft() == null && node.getRight() != null) {
			if(node == root ){
				root = node.getRight() ;
				root.setParent(null);
				node.setRight(null);
				return ;
			}
			// node在左子树
		    if (node.getParent().getLeft() == node) {
				node.getParent().setLeft(node.getRight());
			}
			// node在右子树
			else {
				node.getParent().setRight(node.getRight());
			}
			node.getRight().setParent(node.getParent());
			node.setParent(null);
		}
		// 删除的节点既有左子树又有右子树
		if (node.getLeft() != null && node.getRight() != null) {
			// 找到节点右子树中的最小值节点
			TreeNode<T> rightMinNode = node.getRight();
			while (rightMinNode.getLeft() != null) {
				rightMinNode = rightMinNode.getLeft();
			}
			
			//断开rightMinNode
			//上面循环后rightMinNode可能是叶子节点或者只有右子节点
			if(rightMinNode.getParent().getLeft() == rightMinNode){
				rightMinNode.getParent().setLeft(rightMinNode.getRight());
			}else{
				rightMinNode.getParent().setRight(rightMinNode.getRight());
			}
			//rightMinNode连接到node位置
			rightMinNode.setParent(node.getParent());
			rightMinNode.setLeft(node.getLeft());
			rightMinNode.setRight(node.getRight());
			//根
			if(node == root){
				root = rightMinNode ;
				node.setLeft(null);
				node.setRight(null);
				return;
			}
			
			// node是左子树
			if (node.getParent().getLeft() == node) {
				node.getParent().setLeft(rightMinNode);
			} 
			//node是右子树
			else {
				node.getParent().setRight(rightMinNode);
			}
			node.setParent(null);
			node.setLeft(null);
			node.setRight(null);
		}
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

		if (node.getLeft() != null) {
			List<TreeNode<T>> lList = inIterator(node.getLeft());
			list.addAll(lList);
		}
		list.add(node);
		if (node.getRight() != null) {
			List<TreeNode<T>> rList = inIterator(node.getRight());
			list.addAll(rList);
		}
		return list;
	}

	/**
	 * 广度优先遍历，即按层遍历 利用队列实现 算法：1、新建一个队列，存入根节点 2、取出根节点，判断根节点的左右子节点，有就存入队列
	 * 3、重复2步，知道队列为空
	 * 
	 * @return
	 */
	public List<TreeNode> breadthFirst() {
		// 初始化一个队列
		Queue<TreeNode> queue = new ArrayDeque<>();
		// 存放遍历好的节点
		List<TreeNode> list = new ArrayList<>();
		if (root != null) {
			queue.offer(root);
		}
		while (!queue.isEmpty()) {
			// 队头元素放入list
			list.add(queue.peek());
			// 出队
			TreeNode parent = queue.poll();
			// 按层将数据遍历存放到队列
			if (parent.getLeft() != null) {
				queue.offer(parent.getLeft());
			}
			if (parent.getRight() != null) {
				queue.offer(parent.getRight());
			}
		}
		return list;
	}

	public static void main(String[] args) {
		SoftedBinaryTree<Integer> sbt = new SoftedBinaryTree<Integer>();
		sbt.add(10);
		sbt.add(3);
		sbt.add(2);
		sbt.add(4);
		sbt.add(9);
		sbt.add(8);
		sbt.add(9);
		sbt.add(18);
		sbt.add(13);
		sbt.add(21);
		System.out.println(sbt.root.getValue());
		System.out.println(sbt.getNode(18).getValue());
		// 中序遍历
		sbt.inIterator().stream()
				.forEach(e -> System.out.print(e.getValue() + "  "));
		System.out.println();
		// 广度遍历
		sbt.breadthFirst().stream()
				.forEach(e -> System.out.print(e.getValue() + "  "));
		System.out.println();

		sbt.remove(3);
		// 中序遍历
		sbt.inIterator().stream()
				.forEach(e -> System.out.print(e.getValue() + "  "));
		System.out.println();
		// 广度遍历
		sbt.breadthFirst().stream()
				.forEach(e -> System.out.print(e.getValue() + "  "));
		System.out.println();

	}
}
