package top.ruandb.structure.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * ���������
 * 
 * @author rdb
 *
 * @param <T>
 */
public class SoftedBinaryTree<T extends Comparable> {
	// ������ڵ�
	private TreeNode root;

	// �����յ����������
	public SoftedBinaryTree() {
		root = null;
	}

	// ��ָ����Ԫ�ش������������
	public SoftedBinaryTree(T element) {
		root = new TreeNode<T>(element);
	}

	// ��ӽڵ�
	@SuppressWarnings("unchecked")
	public void add(T element) {
		if (root == null) {
			root = new TreeNode<T>(element);
		} else {
			TreeNode<T> current = root;
			TreeNode<T> parent = null;
			int cmp = 0;
			// Ѱ�Һ��ʵĽڵ㣬�Ըýڵ���Ϊ���ڵ�����½ڵ�
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

	// ��ȡ���ڵ�
	public TreeNode root() {
		return root;
	}

	// ����ֵ�����ڵ�
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

	// ɾ���ڵ�
	@SuppressWarnings("unchecked")
	public void remove(T element) {
		TreeNode<T> node = getNode(element);
		if (node == null) {
			return;
		}
		// ɾ���Ľڵ���Ҷ�ӽڵ�
		if (node.getLeft() == null && node.getRight() == null) {
			if(node == root){
				return ;
			}
			//�ж�node�����ӽڵ㻹�����ӽڵ�
			if (node.getParent().getLeft() == node) {
				node.getParent().setLeft(null);
			} else {
				node.getParent().setRight(null);
			}
			node.setParent(null);
			;
		}
		// ɾ���Ľڵ�ֻ��������
		if (node.getLeft() != null && node.getRight() == null) {
			if(node == root ){
				root = node.getLeft() ;
				root.setParent(null);
				node.setLeft(null);
				return ;
			}
			// node��������
		    if (node.getParent().getLeft() == node) {
				node.getParent().setLeft(node.getLeft());
			}
			// node��������
			else {
				node.getParent().setRight(node.getLeft());
			}
			node.getLeft().setParent(node.getParent());
			node.setParent(null);
		}
		// ɾ���Ľڵ�ֻ��������
		if (node.getLeft() == null && node.getRight() != null) {
			if(node == root ){
				root = node.getRight() ;
				root.setParent(null);
				node.setRight(null);
				return ;
			}
			// node��������
		    if (node.getParent().getLeft() == node) {
				node.getParent().setLeft(node.getRight());
			}
			// node��������
			else {
				node.getParent().setRight(node.getRight());
			}
			node.getRight().setParent(node.getParent());
			node.setParent(null);
		}
		// ɾ���Ľڵ��������������������
		if (node.getLeft() != null && node.getRight() != null) {
			// �ҵ��ڵ��������е���Сֵ�ڵ�
			TreeNode<T> rightMinNode = node.getRight();
			while (rightMinNode.getLeft() != null) {
				rightMinNode = rightMinNode.getLeft();
			}
			
			//�Ͽ�rightMinNode
			//����ѭ����rightMinNode������Ҷ�ӽڵ����ֻ�����ӽڵ�
			if(rightMinNode.getParent().getLeft() == rightMinNode){
				rightMinNode.getParent().setLeft(rightMinNode.getRight());
			}else{
				rightMinNode.getParent().setRight(rightMinNode.getRight());
			}
			//rightMinNode���ӵ�nodeλ��
			rightMinNode.setParent(node.getParent());
			rightMinNode.setLeft(node.getLeft());
			rightMinNode.setRight(node.getRight());
			//��
			if(node == root){
				root = rightMinNode ;
				node.setLeft(null);
				node.setRight(null);
				return;
			}
			
			// node��������
			if (node.getParent().getLeft() == node) {
				node.getParent().setLeft(rightMinNode);
			} 
			//node��������
			else {
				node.getParent().setRight(rightMinNode);
			}
			node.setParent(null);
			node.setLeft(null);
			node.setRight(null);
		}
	}

	/**
	 * ������� �ݹ������������ڵ㣬�ݹ�������
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
	 * ������ȱ�������������� ���ö���ʵ�� �㷨��1���½�һ�����У�������ڵ� 2��ȡ�����ڵ㣬�жϸ��ڵ�������ӽڵ㣬�оʹ������
	 * 3���ظ�2����֪������Ϊ��
	 * 
	 * @return
	 */
	public List<TreeNode> breadthFirst() {
		// ��ʼ��һ������
		Queue<TreeNode> queue = new ArrayDeque<>();
		// ��ű����õĽڵ�
		List<TreeNode> list = new ArrayList<>();
		if (root != null) {
			queue.offer(root);
		}
		while (!queue.isEmpty()) {
			// ��ͷԪ�ط���list
			list.add(queue.peek());
			// ����
			TreeNode parent = queue.poll();
			// ���㽫���ݱ�����ŵ�����
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
		// �������
		sbt.inIterator().stream()
				.forEach(e -> System.out.print(e.getValue() + "  "));
		System.out.println();
		// ��ȱ���
		sbt.breadthFirst().stream()
				.forEach(e -> System.out.print(e.getValue() + "  "));
		System.out.println();

		sbt.remove(3);
		// �������
		sbt.inIterator().stream()
				.forEach(e -> System.out.print(e.getValue() + "  "));
		System.out.println();
		// ��ȱ���
		sbt.breadthFirst().stream()
				.forEach(e -> System.out.print(e.getValue() + "  "));
		System.out.println();

	}
}
