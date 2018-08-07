package top.ruandb.structure.stack;

import java.util.Arrays;

/**
 * ˳��洢�ṹ ջ���ײ�������ʵ��
 * 
 * @author rdb
 *
 */
public class MyStack<T> {

	// ��ʼ�����鳤��
	private int DEFAULT_SIZE = 16;
	// �������鳤��
	private int capacity;
	// �������飬�û�����ջ��Ԫ��
	private Object[] elementData;
	// ����ջ�ĳ��ȣ�ջ��Ԫ�صĸ�����
	private int size = 0;

	// ��ʼ��һ����ջ����Ĭ�����鳤�ȣ�
	public MyStack() {
		elementData = new Object[DEFAULT_SIZE];
		capacity = DEFAULT_SIZE;
	}

	// ��ĳ��Ԫ�س�ʼ��һ��Ԫ��ջ
	public MyStack(T element) {
		this();
		elementData[0] = element;
		size++;
	}

	// ��ȡջ�Ĵ�С
	public int length() {
		return size;
	}

	// ��ջ
	public void push(T element) {
		// �������鳤�ȹ���
		ensureCapacity(size + 1);
		// ������ݲ�����size
		elementData[size++] = element;
	}

	// ��չ����(���ܱȽϲ�)
	private void ensureCapacity(int minCapactity) {
		if (minCapactity > capacity) {
			// ��2����չ����
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

	// ����ջ��Ԫ�أ�����ɾ��Ԫ��
	@SuppressWarnings("unchecked")
	public T peek() {
		return (T) elementData[size - 1];
	}

	// �ж��Ƿ�Ϊ��
	public boolean isEmpty() {
		return size == 0;
	}
	//���ջ
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
