package top.ruandb.structure.stack;

import java.util.Arrays;

/**
 * 顺序存储结构 栈，底层以数组实现
 * 
 * @author rdb
 *
 */
public class MyStack<T> {

	// 初始化数组长度
	private int DEFAULT_SIZE = 16;
	// 保存数组长度
	private int capacity;
	// 定于数组，用户保存栈中元素
	private Object[] elementData;
	// 保存栈的长度（栈中元素的个数）
	private int size = 0;

	// 初始化一个空栈（以默认数组长度）
	public MyStack() {
		elementData = new Object[DEFAULT_SIZE];
		capacity = DEFAULT_SIZE;
	}

	// 以某个元素初始化一个元素栈
	public MyStack(T element) {
		this();
		elementData[0] = element;
		size++;
	}

	// 获取栈的大小
	public int length() {
		return size;
	}

	// 入栈
	public void push(T element) {
		// 保障数组长度够用
		ensureCapacity(size + 1);
		// 添加数据并自增size
		elementData[size++] = element;
	}

	// 扩展数组(性能比较差)
	private void ensureCapacity(int minCapactity) {
		if (minCapactity > capacity) {
			// 以2倍扩展数组
			while (minCapactity > capacity) {
				capacity <<= 1;
			}
			elementData = Arrays.copyOf(elementData, capacity);
		}
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		T oldValue = (T) elementData[--size];
		elementData[size] = null;
		return oldValue;
	}

	// 返回栈顶元素，但不删除元素
	@SuppressWarnings("unchecked")
	public T peek() {
		return (T) elementData[size - 1];
	}

	// 判断是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	//清空栈
	public void clear() {
		Arrays.fill(elementData, null);
		size = 0;
	}
	
	public String toString(){
		if(size == 0){
			return "[]" ;
		}else{
			StringBuilder sb = new StringBuilder("[ ");
			for(int i=0 ;i<size;i++){
				sb.append(elementData[i]+ " ");
			}
			sb.append("]");
			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		MyStack<String> my = new MyStack<String>();
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
