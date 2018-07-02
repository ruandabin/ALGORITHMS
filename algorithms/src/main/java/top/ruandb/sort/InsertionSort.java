package top.ruandb.sort;

import top.ruandb.utils.ArrayUtil;

/**
 * 插入排序
 * @author rdb
 *
 */
public class InsertionSort {

	/**
	 * 插入排序
	 * @param array
	 * @return
	 */
	public int[] insertionSort(int[] array) {
		
		if(array == null) {
			return null;
		}
		for(int i=1;i<array.length;i++) {
			if(array[i] < array[i-1]) {//0到i-1都是有序的
				int temp = array[i];
				int j = i-1;
				for(; j>=0 && array[j] > temp; j-- ) {
					array[j+1] = array[j] ; //把大于temp的元素向后移动一位
				}
				array[j+1] = temp;//插入数据
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[] array =ArrayUtil.generateRandomArray(1000, 0, 1000000);
		InsertionSort is = new InsertionSort();
		
//		ArrayUtil.printArray(array);
//		ArrayUtil.printArray(is.insertionSort(array));
		
		long startTime = System.currentTimeMillis();
		is.insertionSort(array);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + "ms");
	}
}
