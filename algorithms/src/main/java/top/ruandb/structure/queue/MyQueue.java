package top.ruandb.structure.queue;

import java.util.Arrays;

/**
 * 顺序结构队列，底层以数组实现
 * @author rdb
 *
 */
public class MyQueue<T> {

	//初始化数组长度
	private int DEFAULT_SIZE = 10 ;
	//保存数组长度
	private int capacity ;
	//保存元素的数组
	private Object[] elementData ;
	//即将进入队列元素位置
	private int rear = 0;
	//即将出队列元素的位置
	private int front = 0;
	
	//初始化一个空队列
	public MyQueue() {
		capacity = DEFAULT_SIZE ;
		elementData = new Object[capacity];
	}
	
	//以一个元素初始化队列
	public MyQueue(T element) {
		this();
		elementData[0] = element ;
		rear++ ;
	}
	//返回队列大小
	public int length(){
		if(isEmpty()){
			return 0 ;
		}
		return rear>front?rear-front : capacity-front+rear;
	}
	
	//入队
	public void add(T element){
		if(rear == front && elementData[front] != null){
			throw new IndexOutOfBoundsException("队列已满");
		}else{
			elementData[rear++] = element ;
			//rear到头，掉头
			rear = rear == capacity ? 0 : rear ; 
		}
	}
	
	//出队
	public T remove(){
		if(isEmpty()){
			throw new IndexOutOfBoundsException("空队列");
		}else{
			@SuppressWarnings("unchecked")
			T oldValue = (T) elementData[front];
			//释放队头元素
			elementData[front++] = null ;
			front = front == capacity ? 0 : front ;
			return  oldValue ;
		}
	}
	
	//查询队头元素，但不删除队头元素
	@SuppressWarnings("unchecked")
	public T elemet(){
		if(isEmpty()){
			throw new IndexOutOfBoundsException("空队列");
		}
		return (T) elementData[front] ;
	}

	//判断队列是否为空
	public boolean isEmpty(){
		return rear == front && elementData[front] == null ;
	}
	//清空队列
	public void clear(){
		Arrays.fill(elementData, null);
		front = 0 ;
		rear = 0 ;
	}
	
	public String toString(){
		if(isEmpty()){
			return "[]" ;
		}else{
			//未掉头情况
			if(front < rear){
				StringBuilder sb = new StringBuilder("[ ");
				for(int i = front; i<rear ;i++){
					sb.append(elementData[i] + " ");
				}
				return sb.append("]").toString();
			}else{//掉头情况
				StringBuilder sb = new StringBuilder("[ ");
				for(int i = front; i<capacity ;i++){
					sb.append(elementData[i] + " ");
				}
				for(int i = 0;i<rear;i++){
					sb.append(elementData[i] + " ");
				}
				return sb.append("]").toString();
			}
		}
	}
	
	public static void main(String[] args) {
		MyQueue<String> my = new MyQueue<String>();
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
		System.out.println(my.elemet());
		System.out.println(my.isEmpty());
		my.clear();
		System.out.println(my.toString());	
	}
}
