package top.ruandb.sort;

import top.ruandb.utils.ArrayUtil;

/**
 * ��������
 * @author rdb
 *
 */
public class QuickSort {

	//��������
	public int[] quickSort(int[] array) {
		sort(array,0,array.length-1);
		return array;
	}
	
	private void sort(int[] array,int left,int right) {
		if(left < right) {
			int partition = divide( array, left, right);//��ͷ������
//			int partition = divide1( array, left, right);//��׼��
			sort(array, left, partition-1);
			sort(array, partition+1, right);
		}
	}
	
	//��ͷ������
	private int  divide(int[] array,int left,int right) {
		int base = array[left]; //��׼��,�Ե�һ��Ԫ��Ϊ��׼��
		int i = left;
		int j = right;
		int temp;
		while(i < j ) {
			while(i < j && base <= array[j]) {
				j--;
			}
			if(i == j){
				temp = array[j];
				array[j] = base;
				array[left] = temp;
				break;
			}
			while(i < j && base >= array[i]) {
				i++;
			}
			if(i == j){
				temp = array[j];
				array[j] = base;
				array[left] = temp;
				break;
			}
			
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;					
		}
		return i;
	}
	
	//��׼д��
	private int  divide1(int[] array,int left,int right) {
		int base = array[left]; //��׼��,�Ե�һ��Ԫ��Ϊ��׼��
		int i = left;
		int j = right;
		int temp;
		while(i < j ) {
			while(i < j && base <= array[j]) {
				j--;
			}
			if(i < j) {
				temp = array[j] ;
				array[j] = base;
				array[i] = temp;
			}
			
			
			while(i < j && base >= array[i]) {
				i++;
			}
			if(i < j) {
				temp = array[i];
				array[i] = base;
				array[j] = temp;
			}
		}
		return i;
	}
	
	public static void main(String[] args) {
		int[] array = ArrayUtil.generateRandomArray(1000000, 0, 1000000);
		QuickSort qs = new QuickSort();
		
//		ArrayUtil.printArray(array);
//		ArrayUtil.printArray(qs.quickSort(array));
				
		long startTime = System.currentTimeMillis();
		qs.quickSort(array);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + "ms");
		
	}
}
