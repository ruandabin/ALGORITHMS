package top.ruandb.structure.queue;
/**
 * ��ʽ����
 * @author rdb
 *
 */
public class MyLinkQueue<T> {

	//node�ڵ�
	private class Node{
		private final T value ;
		private Node next ;
		public Node(T value) {
			this.value = value ;
			this.next = null ;
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

	//�����ͷ�ڵ�
	private Node front ;
	//�����β�ڵ�
	private Node rear ;
	//��¼�ڵ����
	private int size = 0 ;
	//��ʼ��һ���ն���
	public MyLinkQueue() {
		front = null ;
		rear = null;
	}
	//��һ��Ԫ�س�ʼ������
	public MyLinkQueue(T element) {
		front = new Node(element);
		rear = front;
		size++ ;
	}
	//���ض��г���
	public int length(){
		return size ;
	}
	//���
	public void add(T element){
		//�նӵ�ʱ��
		if(front == null){
			front = new Node(element);
			rear = front ;
		}else{
			rear.setNext(new Node(element));
			rear = rear.getNext() ;
		}	
		size++ ;
	}
	
	//����
	public T remove(){
		if(front == null){
			return null;
		}
		
		Node oldNode = front ;
		front = front.getNext();
		oldNode.setNext(null); 
		size-- ;
		return oldNode.getValue();
	}
	//���ض�ͷԪ�أ�����ɾ��
	public T element(){
		return front.getValue();
	}
	//�Ƿ�Ϊ�ն���
	public boolean isEmpty(){
		return size == 0 ;
	}
	//��ն���
	public void clear(){
		front = null ;
		rear = front ;
		size = 0;
	}
	
	public String toString(){
		if(isEmpty()){
			return "[]" ;
		}else{
			StringBuilder sb = new StringBuilder("[ ");
			Node current = front ;
			for(int i=0;i<size && current != null;i++){
				sb.append(current.getValue() + " ");
				current = current.getNext();
			}
			sb.append("]");
			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		MyLinkQueue<String> my = new MyLinkQueue<String>();
		my.add("00");
		my.add("11");
		my.add("22");
		my.add("33");
		my.add("44");
		my.add("55");
		my.add("66");
		my.add("77");
		my.add("88");
		my.add("99");
		System.out.println(my.toString());
		my.remove();
		System.out.println(my.toString());
		my.add("xx");
		System.out.println(my.toString());
		System.out.println(my.length());
		System.out.println(my.element());
		System.out.println(my.isEmpty());
		my.clear();
		System.out.println(my.toString());	
	}
}
