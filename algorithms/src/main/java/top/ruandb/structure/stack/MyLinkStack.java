package top.ruandb.structure.stack;


public class MyLinkStack<T> {

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

	// ����ջ��Ԫ��
	private Node top;
	// ����ջԪ�ظ���
	private int size = 0;

	// ��ʼ����ջ
	public MyLinkStack() {
		top = null;
	}

	// ��ָ��Ԫ�ع���ջ
	public MyLinkStack(T element) {
		top = new Node(element);
		size++;
	}

	// ����ջ�ĳ���
	public int length() {
		return size;
	}

	// ��ջ
	public void push(T element) {
		Node newNode = new Node(element);
		newNode.next = top;
		top = newNode;
		size++;
	}

	//��ջ
	public T pop() {
		Node oldNode = top;
		top = top.next;
		oldNode.setNext(null);
		size-- ;
		return oldNode.getValue();
	}
	
	//��ѯջ��Ԫ��
	public T peek(){
		return top.getValue();
	}
	//�ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty(){
		return size == 0 ;
	}
	//���ջ
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
