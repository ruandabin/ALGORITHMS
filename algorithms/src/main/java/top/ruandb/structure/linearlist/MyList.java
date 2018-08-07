package top.ruandb.structure.linearlist;

import java.util.Arrays;

/**
 * ˳��洢�ṹ�����Ա��ײ�������ʵ��
 * @author rdb
 *
 */
public class MyList<T> {
	//��ʼ�����鳤��
	private int DEFAULT_SIZE = 16 ;
	
	//�������鳤��
	private int capacity ;
	//�������飬�������Ա�Ԫ��
	private Object[] elementData ;
	//�������Ա�ĳ���
	private int size=0 ;
	
	//��Ĭ�����鳤�ȳ�ʼ�����Ա�
	public MyList() {
		this.capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	//��һ��Ԫ�س�ʼ�����Ա�
	public MyList(T element) {
		this();
		elementData[0] = element ;
		size++ ;
	}
	//��ȡ���Ա�Ĵ�С
	public int length(){
		return size;
	}
	//��ȡָ������λ�õ�Ԫ��
	@SuppressWarnings("unchecked")
	public T get(int i){
		//Խ���쳣
		if(i<0 || i>size-1){
			throw new IndexOutOfBoundsException("����Խ��");
		}
		return (T)elementData[i];
	}
	
	//����Ԫ�ط���λ��,���Ԫ�أ����ص�һ��Ԫ�ص�λ��
	public int locate(T element){
		for(int i =0 ;i< size;i++){
			if(element.equals(elementData[i])){
				return i; 
			}
		}
		return -1 ;
	}
	
	//�����Ա�ָ��λ�ò���Ԫ��
	public void insert(T element, int i){
		//Խ���쳣
		if(i<0 || i>size){
			throw new IndexOutOfBoundsException("����Խ��");
		}
		//ȷ�����鳤�ȹ��洢
		ensureCapacity(size+1);
		//����������ƶ�һλ
		System.arraycopy(elementData, i, elementData, i+1, size-i);
		elementData[i] = element ;
		size++ ;
	}
	
	//��ͷ�����һ��Ԫ��
	public void add(T element){
		insert(element, 0);
	}
	
	//��չ����
	private void ensureCapacity(int minCapacity){
		//�����Ҫ����С���ȳ������鳤��
		if(minCapacity > capacity){
			//ѭ�����Ͻ�capacity*2��ֱ��capacity>minCapacity
			while(minCapacity > capacity){
				capacity <<= 1 ;
			}
			elementData = Arrays.copyOf(elementData, capacity);
		}
	}
	//ɾ��ָ��λ�õ�Ԫ��
	public void delete(int i){
		//Խ���쳣
		if(i<0 || i>size){
			throw new IndexOutOfBoundsException("����Խ��");
		}
		int numMoved = size - i + 1 ;
		if(numMoved > 0){
			System.arraycopy(elementData, i+1, elementData, i, numMoved);
		}
		elementData[size] = null ;
		size-- ;
	}
	//ɾ�����Ա����һ��Ԫ��
	public void remove(){
		delete(size-1);
	}
	//�ж��Ƿ�Ϊ��
	public boolean isEmpty(){
		return size == 0 ;
	}
	//������Ա�
	public void clear(){
		Arrays.fill(elementData, null);
		size = 0 ;
	}
	
	public String toString(){
		if(size == 0){
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder("[ ");
			for(int i =0 ;i<size;i++){
				sb.append(elementData[i].toString() + " ");
			}
			sb.append("]");
			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		MyList<String>  myList = new MyList<String>();
		myList.add("aa");
		myList.add("bb");
		myList.add("cc");
		myList.add("dd");
		System.out.println(myList.toString());
		myList.insert("xx", 0);
		System.out.println(myList.toString());
		myList.delete(4);
		System.out.println(myList.toString());
		myList.remove();
		System.out.println(myList.toString());
		System.out.println(myList.get(0));
		System.out.println(myList.locate("dd"));
		myList.clear();
		System.out.println(myList.toString());	
	}
}
