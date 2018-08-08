package top.ruandb.structure.queue;

import java.util.Arrays;

/**
 * ˳��ṹ���У��ײ�������ʵ��
 * @author rdb
 *
 */
public class MyQueue<T> {

	//��ʼ�����鳤��
	private int DEFAULT_SIZE = 10 ;
	//�������鳤��
	private int capacity ;
	//����Ԫ�ص�����
	private Object[] elementData ;
	//�����������Ԫ��λ��
	private int rear = 0;
	//����������Ԫ�ص�λ��
	private int front = 0;
	
	//��ʼ��һ���ն���
	public MyQueue() {
		capacity = DEFAULT_SIZE ;
		elementData = new Object[capacity];
	}
	
	//��һ��Ԫ�س�ʼ������
	public MyQueue(T element) {
		this();
		elementData[0] = element ;
		rear++ ;
	}
	//���ض��д�С
	public int length(){
		if(isEmpty()){
			return 0 ;
		}
		return rear>front?rear-front : capacity-front+rear;
	}
	
	//���
	public void add(T element){
		if(rear == front && elementData[front] != null){
			throw new IndexOutOfBoundsException("��������");
		}else{
			elementData[rear++] = element ;
			//rear��ͷ����ͷ
			rear = rear == capacity ? 0 : rear ; 
		}
	}
	
	//����
	public T remove(){
		if(isEmpty()){
			throw new IndexOutOfBoundsException("�ն���");
		}else{
			@SuppressWarnings("unchecked")
			T oldValue = (T) elementData[front];
			//�ͷŶ�ͷԪ��
			elementData[front++] = null ;
			front = front == capacity ? 0 : front ;
			return  oldValue ;
		}
	}
	
	//��ѯ��ͷԪ�أ�����ɾ����ͷԪ��
	@SuppressWarnings("unchecked")
	public T elemet(){
		if(isEmpty()){
			throw new IndexOutOfBoundsException("�ն���");
		}
		return (T) elementData[front] ;
	}

	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty(){
		return rear == front && elementData[front] == null ;
	}
	//��ն���
	public void clear(){
		Arrays.fill(elementData, null);
		front = 0 ;
		rear = 0 ;
	}
	
	public String toString(){
		if(isEmpty()){
			return "[]" ;
		}else{
			//δ��ͷ���
			if(front < rear){
				StringBuilder sb = new StringBuilder("[ ");
				for(int i = front; i<rear ;i++){
					sb.append(elementData[i] + " ");
				}
				return sb.append("]").toString();
			}else{//��ͷ���
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
