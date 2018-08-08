package top.ruandb.structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������ʵ�ֶ�����
 * 
 * @author rdb
 *
 */
public class MyLinkBinaryTree<T> {

	// ������ڵ�
	private TreeNode<T> root;

	// ��ָ����Ԫ�س�ʼ��������
	public MyLinkBinaryTree() {
		root = null;
	}

	// ��ָ����Ԫ�س�ʼ��������
	public MyLinkBinaryTree(T element) {
		root = new TreeNode<T>(element);
	}

	public TreeNode addRoot(T element) {
		if (root != null) {
			throw new RuntimeException("�Ѿ���root�ڵ㣬�޷����root�ڵ�");
		} else {
			root = new TreeNode<T>(element);
		}
		return root;
	}

	// public Tree
	/**
	 * ���ָ���ڵ�
	 * 
	 * @param parent
	 *            ��ӽڵ�ĸ��ڵ�
	 * @param element
	 *            ��ӽڵ������
	 * @param isLeft
	 *            �Ƿ������ӽڵ�
	 * @return ��ӵĽڵ�
	 */
	public TreeNode<T> addNode(TreeNode<T> parent, T element, boolean isLeft) {
		if (parent == null) {
			throw new RuntimeException("�ڵ�Ϊnull,�޷�����ӽڵ�");
		}
		if (isLeft && parent.getLeft() != null) {
			throw new RuntimeException("��ڵ��Ѿ�����,�޷�������ӽڵ�");
		}
		if (!isLeft && parent.getRight() != null) {
			throw new RuntimeException("�ҽڵ��Ѿ�����,�޷�������ӽڵ�");
		}
		TreeNode<T> newNode = new TreeNode<>(element);
		if (isLeft) {
			parent.setLeft(newNode);
		} else {
			parent.setRight(newNode);
		}
		return newNode;
	}

	// �ж϶������Ƿ�Ϊ��
	public boolean isEmpty() {
		return root == null;
	}

	// ���ظ����ڵ�
	public TreeNode<T> root() {
		if (isEmpty()) {
			throw new RuntimeException("�������޸��ڵ�");
		}
		return root;
	}

	// ���ظ��ڵ�
	public T parent(TreeNode<T> child) {
		return null;
	}

	// ����ָ���ڵ�����ӽڵ�
	@SuppressWarnings("unchecked")
	public T leftChild(TreeNode<T> parent) {
		if (parent == null) {
			throw new RuntimeException("���ڵ�Ϊ��");
		}

		return parent == null ? null : (T) parent.getLeft().getValue();
	}

	// �����ҽڵ�
	@SuppressWarnings("unchecked")
	public T rightChild(TreeNode<T> parent) {
		if (parent == null) {
			throw new RuntimeException("���ڵ�Ϊ��");
		}
		return parent == null ? null : (T) parent.getRight().getValue();
	}

	// ���ض����������
	public int deep() {
		return deep(root);
	}

	// �ݹ��ȡ��ÿ�����������Ϊ������������������+1
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
	 * ǰ�����
	 *�ȸ����㣬�ݹ����������ݹ�������
	 * @param node
	 * @return
	 */
	public List<TreeNode<T>> preIterator() {
		return preIterator(root);
	}

	private List<TreeNode<T>> preIterator(TreeNode<T> node){
		
		List<TreeNode<T>> list = new ArrayList<TreeNode<T>>();
		
		list.add(node);
		//�ݹ�������
		if(node.getLeft() != null ){
			List<TreeNode<T>> lLift = preIterator(node.getLeft());
			list.addAll(lLift);
		}
		//�ݹ�������
		if(node.getRight() != null){
			List<TreeNode<T>> lRight = preIterator(node.getRight());
			list.addAll(lRight);
		}
		return list;
	}
	
	/**
	 * �������
	 *
	 * @param node
	 * @return
	 */
	public List<TreeNode<T>> inIterator(TreeNode<T> node) {
		return null;
	}
	
	/**
	 * �������
	 *
	 * @param node
	 * @return
	 */
	public List<TreeNode<T>> postIterator(TreeNode<T> node) {
		return null;
	}

	public static void main(String[] args) {
		// ��ʼ������
		MyLinkBinaryTree<String> my = new MyLinkBinaryTree<String>();
		// ��Ӹ��ڵ�
		my.addRoot("��");
		TreeNode n21 = my.addNode(my.root, "�ڶ�����ڵ�", true);
		TreeNode n22 = my.addNode(my.root, "�ڶ����ҽڵ�", false);
		TreeNode n31 = my.addNode(n21, "��������ڵ�", true);
		TreeNode n32 = my.addNode(n21, "�������ҽڵ�", false);
		TreeNode n41 = my.addNode(n31, "���Ĳ���ڵ�", true);

		System.out.println(my.root().getValue());
		System.out.println(my.root().getLeft().getValue());
		System.out.println(my.parent(n21));
		System.out.println(my.leftChild(n21));
		System.out.println(my.rightChild(n21));
		System.out.println(my.deep());
	}

}
