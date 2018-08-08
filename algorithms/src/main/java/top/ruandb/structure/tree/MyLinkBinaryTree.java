package top.ruandb.structure.tree;
/**
 * 二叉链表实现二叉树
 * @author rdb
 *
 */
public class MyLinkBinaryTree<T> {
	
	//保存根节点
	private TreeNode<T> root ;

	//以指定根元素初始化二叉树
	public MyLinkBinaryTree(T element) {
		root = new TreeNode<T>(element) ;
	}
	
	//public Tree
	/**
	 * 添加指定节点
	 * @param parent 添加节点的父节点
	 * @param element 添加节点的数据
	 * @param isLeft 是否是左子节点
	 * @return 添加的节点
	 */
	public TreeNode<T> addNode(TreeNode<T> parent,T element ,boolean isLeft){
		if(parent == null){
			throw new RuntimeException("节点为null,无法添加子节点");
		}
		if(isLeft && parent.getLeft() != null){
			throw new RuntimeException("左节点已经存在,无法添加左子节点");
		}
		if(!isLeft && parent.getRight() != null){
			throw new RuntimeException("右节点已经存在,无法添加右子节点");
		}
		TreeNode<T> newNode = new TreeNode<>(element);
		if(isLeft){
			parent.setLeft(newNode);
		}else{
			parent.setRight(newNode);
		}
		return newNode;
	}
	//判断二叉树是否为空
	public boolean isEmpty(){
		return root == null ;
	}
	//返回根根节点
	public T root(){
		if(isEmpty()){
			throw new RuntimeException("空树，无根节点");
		}
		return root.getValue() ;
	}
	
	//返回指定节点的左子节点
	public T leftChild(TreeNode<T> parent){
		return null ;
	}
	
	
	
	
	public static void main(String[] args) {
		MyLinkBinaryTree<String> my = new MyLinkBinaryTree<String>("根节点");
	}
	
}
