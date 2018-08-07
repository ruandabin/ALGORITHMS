package top.ruandb.structure.linearlist;

/**
 * 线性表链式链式存储结构（链表）
 * @author rdb
 *
 * @param <T>
 */
public class MyLinkList<T> {

	//Node,表示链表的节点
	private class Node{
		//Node实例化时后value就不能变了
		private final T value;
		private Node next;
		public Node(T value) {
			this.value = value;
			this.next  = null ;
		}
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		public T getValue() {
			return value;
		}
	}

	//保存头节点
	private Node head;
	//保存尾部节点
	private Node tail;
	//链表节点数
	private int size=0;
	
	//初始化空链表
	public MyLinkList() {
		head = null;
		tail = null ;
	}
	
	//以指定元素创建链表
	public MyLinkList(T element) {
		head = new Node(element);
		tail = head ;
		size++;
	}
	//返回链表的长度
	public int length(){
		return size ;
	}
	
	//根据索引返回值
	public T get(int i){
		return getNodeByIndex(i).getValue();
	}
	//查找索引出的Node
	private Node getNodeByIndex(int i){
		if(i<0 || i> size -1){
			throw new IndexOutOfBoundsException("索引越界");
		}
		Node current = head ;
		for(int k=0 ; k<size && current!= null; k++){
			if(i == k){
				return current ;
			}
			current = current.getNext();
		}
		return null;
	}
	
	//查找指定元素的索引
	public int localte(T element){
		Node current = head ;
		for(int i=0;i<size && current != null ; i++){
			if(current.getValue().equals(element)){
				return i;
			}
		}
		return -1 ;
	}
	
	//尾部添加的新的节点
	public void add(T element){
		if(head == null){
			head = new Node(element);
			tail = head ;
		}else{
			tail.setNext(new Node(element));
			tail = tail.getNext();
		}
		size++ ;	
	}
	
	//头部插入新的节点
	public void addHead(T element){
		if(head == null){
			head = new Node(element);
			tail = head ;
		}else{
			Node newNode = new Node(element);
			newNode.next = head ;
			head = newNode ;
		}
		size++ ;
	}
	
	//向指定位置插入元素
	public void insert(T element , int index ){
		if(index<0 || index> size ){
			throw new IndexOutOfBoundsException("索引越界");
		}
		//空链表
		if(head == null){
			add(element);
		}else{
			if(index == 0){
				addHead(element);
			}else{
				//获取前一个节点
				Node pre = getNodeByIndex(index -1);
				Node newNode = new Node(element);
				newNode.setNext(pre.next);
				pre.next = newNode;
				size++ ;		
			}
		}
	}
	
	public void delete(int index){
		if(index<0 || index> size-1 ){
			throw new IndexOutOfBoundsException("索引越界");
		}
		Node tempNode ;
		//删除头结点
		if(index == 0){
			head = head.getNext();
		}else{
			tempNode = getNodeByIndex(index-1);
			tempNode.next = tempNode.next.next ;
			if(index == size -1){
				tail = tempNode;
			}
		}
		size-- ;
	}
	
	//删除最后一个节点
	public void remove(){
		delete(size -1);
	}
	
	//判断是否为空
	public boolean isEmpty(){
		return size == 0 ;
	}
	
	public void clear(){
		head = null ;
		tail = null ;
		size = 0;
	}
	
	public String toString(){
		if(size == 0){
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder("[ ");
			Node current = head ;
			for(int i =0;i <size && current!=null ;i++){
				sb.append(current.getValue() + " " );
				current = current.getNext();
			}
			sb.append("]");
			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		MyLinkList<String> my = new MyLinkList<String>();
		my.add("11");
		my.add("22");
		my.add("33");
		my.add("44");
		my.add("55");
		my.add("66");
		my.add("77");
		my.add("88");
		System.out.println(my.toString() + " | " + my.head.getValue() + " "+ my.tail.getValue() );
		my.addHead("00");
		System.out.println(my.toString() + " | " + my.head.getValue() + " "+ my.tail.getValue() );
		my.insert("xx", 8);
		System.out.println(my.toString() + " | " + my.head.getValue() + " "+ my.tail.getValue() );
		my.delete(9);
		System.out.println(my.toString() + " | " + my.head.getValue() + " "+ my.tail.getValue() );
		my.delete(0);
		System.out.println(my.toString() + " | " + my.head.getValue() + " "+ my.tail.getValue() );
		System.out.println(my.get(0) + " "+my.get(7));
		my.remove();
		System.out.println(my.toString() + " | " + my.head.getValue() + " "+ my.tail.getValue() );
		System.out.println(my.isEmpty());
		System.out.println(my.length());
		my.clear();
		System.out.println(my.toString() );
	}
}
