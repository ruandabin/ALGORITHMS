package top.ruandb.sort;

import top.ruandb.utils.ArrayUtil;

/**
 * 选择排序
 * @author rdb
 *
 */
public class SelectionSort {

	/**
	 * 循环实现选择排序
	 * @param array
	 * @return
	 */
	public int[] selectionSort(int[] array) {
		if (array == null) {
			return null;
		}
		for(int i=0;i<array.length;i++) {
			int k =i;
			for(int j =k+1;j<array.length;j++) {
				if(array[k] > array[j]) {
					k = j;
				}
			}	
			if(k != i) {
				int temp = array[i];
				array[i] = array[k];
				array[k] = temp;
			}
		}
		return array;
	}
	
	
	public static void main(String[] args) {
		int[] array = ArrayUtil.generateRandomArray(1000, 0, 1000000);
		SelectionSort ss = new SelectionSort();
		
//		ArrayUtil.printArray(array);
//		ArrayUtil.printArray(ss.selectionSort(array));
		
		long startTime = System.currentTimeMillis();
		ss.selectionSort(array);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + "ms");

	}
}
