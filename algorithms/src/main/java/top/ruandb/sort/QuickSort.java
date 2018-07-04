package top.ruandb.sort;

import top.ruandb.utils.ArrayUtil;

/**
 * 快速排序
 * @author rdb
 *
 */
public class QuickSort {

	public int[] quickSort(int[] array) {
		sort(array,0,array.length-1);
		return array;
	}
	
	private void sort(int[] array,int left,int right) {
		if(left < right) {
			int partition = divide( array, left, right);
			sort(array, left, partition-1);
			sort(array, partition+1, right);
		}
	}
	
	private int  divide(int[] array,int left,int right) {
		int base = array[left]; //基准点
		int i = left;
		int j = right;
		int temp;
		while(i < j ) {
			while(i < j && base <= array[j]) {
				j--;
			}
			//System.out.println(j);
			if(i == j){
				temp = array[j];
				array[j] = base;
				array[left] = temp;
				break;
			}
			while(i < j && base >= array[i]) {
				i++;
			}
			//System.out.println(i);
			//ArrayUtil.printArray(array);
			//System.out.println(array[i]+"****"+array[j]);
			
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
	
	public static void main(String[] args) {
		int[] array = ArrayUtil.generateRandomArray(1000000, 0, 1000000);
		//int[] array = {5, 9 ,10 ,17 ,7, 10, 14 ,9 ,9 ,10};
		//int[] array = {7 ,1, 0 ,10};
		
		
		QuickSort qs = new QuickSort();
//		ArrayUtil.printArray(array);
//		ArrayUtil.printArray(qs.quickSort(array));
		
		
		//qs.divide(array, 0, array.length-1);
		//qs.sort(array, 0, array.length-1);
		//ArrayUtil.printArray(array);
		
		
		long startTime = System.currentTimeMillis();
		qs.quickSort(array);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + "ms");
		
	}
}
