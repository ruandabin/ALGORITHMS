package top.ruandb.structure.queue;
/**
 * 链式队列
 * @author rdb
 *
 */
public class MyLinkQueue<T> {

	//node节点
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

	//保存队头节点
	private Node front ;
	//保存队尾节点
	private Node rear ;
	//记录节点个数
	private int size = 0 ;
	//初始化一个空队列
	public MyLinkQueue() {
		front = null ;
		rear = null;
	}
	//以一个元素初始化队列
	public MyLinkQueue(T element) {
		front = new Node(element);
		rear = front;
		size++ ;
	}
	//返回队列长度
	public int length(){
		return size ;
	}
	//入队
	public void add(T element){
		//空队的时候
		if(front == null){
			front = new Node(element);
			rear = front ;
		}else{
			rear.setNext(new Node(element));
			rear = rear.getNext() ;
		}	
		size++ ;
	}
	
	//出队
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
	//返回队头元素，但不删除
	public T element(){
		return front.getValue();
	}
	//是否为空队列
	public boolean isEmpty(){
		return size == 0 ;
	}
	//清空队列
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
