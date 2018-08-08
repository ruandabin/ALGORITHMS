package top.ruandb.structure.tree;
/**
 * ��������ʵ�ֶ�����
 * @author rdb
 *
 */
public class MyLinkBinaryTree<T> {
	
	//������ڵ�
	private TreeNode<T> root ;

	//��ָ����Ԫ�س�ʼ��������
	public MyLinkBinaryTree(T element) {
		root = new TreeNode<T>(element) ;
	}
	
	//public Tree
	/**
	 * ���ָ���ڵ�
	 * @param parent ��ӽڵ�ĸ��ڵ�
	 * @param element ��ӽڵ������
	 * @param isLeft �Ƿ������ӽڵ�
	 * @return ��ӵĽڵ�
	 */
	public TreeNode<T> addNode(TreeNode<T> parent,T element ,boolean isLeft){
		if(parent == null){
			throw new RuntimeException("�ڵ�Ϊnull,�޷�����ӽڵ�");
		}
		if(isLeft && parent.getLeft() != null){
			throw new RuntimeException("��ڵ��Ѿ�����,�޷�������ӽڵ�");
		}
		if(!isLeft && parent.getRight() != null){
			throw new RuntimeException("�ҽڵ��Ѿ�����,�޷�������ӽڵ�");
		}
		TreeNode<T> newNode = new TreeNode<>(element);
		if(isLeft){
			parent.setLeft(newNode);
		}else{
			parent.setRight(newNode);
		}
		return newNode;
	}
	//�ж϶������Ƿ�Ϊ��
	public boolean isEmpty(){
		return root == null ;
	}
	//���ظ����ڵ�
	public T root(){
		if(isEmpty()){
			throw new RuntimeException("�������޸��ڵ�");
		}
		return root.getValue() ;
	}
	
	//����ָ���ڵ�����ӽڵ�
	public T leftChild(TreeNode<T> parent){
		return null ;
	}
	
	
	
	
	public static void main(String[] args) {
		MyLinkBinaryTree<String> my = new MyLinkBinaryTree<String>("���ڵ�");
	}
	
}
