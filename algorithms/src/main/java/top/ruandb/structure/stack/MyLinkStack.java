package top.ruandb.structure.stack;


public class MyLinkStack<T> {

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

	// 保存栈顶元素
	private Node top;
	// 保存栈元素个数
	private int size = 0;

	// 初始化空栈
	public MyLinkStack() {
		top = null;
	}

	// 以指定元素构建栈
	public MyLinkStack(T element) {
		top = new Node(element);
		size++;
	}

	// 返回栈的长度
	public int length() {
		return size;
	}

	// 入栈
	public void push(T element) {
		Node newNode = new Node(element);
		newNode.next = top;
		top = newNode;
		size++;
	}

	//出栈
	public T pop() {
		Node oldNode = top;
		top = top.next;
		oldNode.setNext(null);
		size-- ;
		return oldNode.getValue();
	}
	
	//查询栈顶元素
	public T peek(){
		return top.getValue();
	}
	//判断栈是否为空
	public boolean isEmpty(){
		return size == 0 ;
	}
	//清空栈
	public void clear(){
		top = null ;
		size = 0 ;
	}
	public String toString(){
		if(size == 0){
			return "[]" ;
		}else{
			StringBuilder sb = new StringBuilder("[ ");
			Node current = top ;
			for(int i=0 ;i<size && current != null;i++){
				sb.append(current.getValue()+ " ");
				current = current.getNext();
			}
			sb.append("]");
			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		MyLinkStack<String> my = new MyLinkStack<String>();
		System.out.println(my.toString());
		my.push("aa");
		my.push("bb");
		my.push("cc");
		System.out.println(my.toString());
		System.out.println(my.pop());
		System.out.println(my.toString());
		System.out.println(my.peek());
		System.out.println(my.toString());
	}
}
