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
			while(i <= j && base <= array[j]) {
				j--;
			}
			while(i < j && base >= array[i]) {
				i++;
			}
			//ArrayUtil.printArray(array);
			System.out.println(array[i]+"****"+array[j]);
			if(i == j) {
				temp = array[j];
				array[j] = base;
				array[left] = temp;
			}else {
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				j--;
				i++;
			}	
			
		}
		
		return i;
	}
	
	public static void main(String[] args) {
		//int[] array = ArrayUtil.generateRandomArray(10, 0, 20);
		int[] array = {10, 10, 0 ,12 ,14 ,13 ,14 ,17, 7 ,1};
		QuickSort qs = new QuickSort();
		ArrayUtil.printArray(array);
		//ArrayUtil.printArray(qs.quickSort(array));
		qs.divide(array, 0, array.length-1);
		//qs.sort(array, 0, array.length-1);
		ArrayUtil.printArray(array);
		
	}
}
