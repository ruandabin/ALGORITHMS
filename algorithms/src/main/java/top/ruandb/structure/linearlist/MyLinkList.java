package top.ruandb.structure.linearlist;

/**
 * ���Ա���ʽ��ʽ�洢�ṹ������
 * @author rdb
 *
 * @param <T>
 */
public class MyLinkList<T> {

	//Node,��ʾ����Ľڵ�
	private class Node{
		//Nodeʵ����ʱ��value�Ͳ��ܱ���
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

	//����ͷ�ڵ�
	private Node head;
	//����β���ڵ�
	private Node tail;
	//����ڵ���
	private int size=0;
	
	//��ʼ��������
	public MyLinkList() {
		head = null;
		tail = null ;
	}
	
	//��ָ��Ԫ�ش�������
	public MyLinkList(T element) {
		head = new Node(element);
		tail = head ;
		size++;
	}
	//��������ĳ���
	public int length(){
		return size ;
	}
	
	//������������ֵ
	public T get(int i){
		return getNodeByIndex(i).getValue();
	}
	//������������Node
	private Node getNodeByIndex(int i){
		if(i<0 || i> size -1){
			throw new IndexOutOfBoundsException("����Խ��");
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
	
	//����ָ��Ԫ�ص�����
	public int localte(T element){
		Node current = head ;
		for(int i=0;i<size && current != null ; i++){
			if(current.getValue().equals(element)){
				return i;
			}
		}
		return -1 ;
	}
	
	//β����ӵ��µĽڵ�
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
	
	//ͷ�������µĽڵ�
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
	
	//��ָ��λ�ò���Ԫ��
	public void insert(T element , int index ){
		if(index<0 || index> size ){
			throw new IndexOutOfBoundsException("����Խ��");
		}
		//������
		if(head == null){
			add(element);
		}else{
			if(index == 0){
				addHead(element);
			}else{
				//��ȡǰһ���ڵ�
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
			throw new IndexOutOfBoundsException("����Խ��");
		}
		Node tempNode ;
		//ɾ��ͷ���
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
	
	//ɾ�����һ���ڵ�
	public void remove(){
		delete(size -1);
	}
	
	//�ж��Ƿ�Ϊ��
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
