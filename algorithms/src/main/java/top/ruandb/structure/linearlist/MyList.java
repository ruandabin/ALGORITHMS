package top.ruandb.structure.linearlist;

import java.util.Arrays;

/**
 * 顺序存储结构的线性表，底层以数组实现
 * @author rdb
 *
 */
public class MyList<T> {
	//初始化数组长度
	private int DEFAULT_SIZE = 16 ;
	
	//保存数组长度
	private int capacity ;
	//定义数组，保存线性表元素
	private Object[] elementData ;
	//保存线性表的长度
	private int size=0 ;
	
	//以默认数组长度初始化线性表
	public MyList() {
		this.capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	//以一个元素初始化线性表
	public MyList(T element) {
		this();
		elementData[0] = element ;
		size++ ;
	}
	//获取线性表的大小
	public int length(){
		return size;
	}
	//获取指定索引位置的元素
	@SuppressWarnings("unchecked")
	public T get(int i){
		//越界异常
		if(i<0 || i>size-1){
			throw new IndexOutOfBoundsException("索引越界");
		}
		return (T)elementData[i];
	}
	
	//根据元素返回位置,多个元素，返回第一个元素的位置
	public int locate(T element){
		for(int i =0 ;i< size;i++){
			if(element.equals(elementData[i])){
				return i; 
			}
		}
		return -1 ;
	}
	
	//向线性表指定位置插入元素
	public void insert(T element, int i){
		//越界异常
		if(i<0 || i>size){
			throw new IndexOutOfBoundsException("索引越界");
		}
		//确保数组长度够存储
		ensureCapacity(size+1);
		//将数组向后移动一位
		System.arraycopy(elementData, i, elementData, i+1, size-i);
		elementData[i] = element ;
		size++ ;
	}
	
	//在头出添加一个元素
	public void add(T element){
		insert(element, 0);
	}
	
	//扩展数组
	private void ensureCapacity(int minCapacity){
		//如果需要的最小长度超出数组长度
		if(minCapacity > capacity){
			//循环不断将capacity*2，直到capacity>minCapacity
			while(minCapacity > capacity){
				capacity <<= 1 ;
			}
			elementData = Arrays.copyOf(elementData, capacity);
		}
	}
	//删除指定位置的元素
	public void delete(int i){
		//越界异常
		if(i<0 || i>size){
			throw new IndexOutOfBoundsException("索引越界");
		}
		int numMoved = size - i + 1 ;
		if(numMoved > 0){
			System.arraycopy(elementData, i+1, elementData, i, numMoved);
		}
		elementData[size] = null ;
		size-- ;
	}
	//删除线性表最后一个元素
	public void remove(){
		delete(size-1);
	}
	//判断是否为空
	public boolean isEmpty(){
		return size == 0 ;
	}
	//清空线性表
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
