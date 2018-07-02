package top.ruandb.sort;

import top.ruandb.utils.ArrayUtil;

/**
 * ��������
 * @author rdb
 *
 */
public class InsertionSort {

	/**
	 * ��������
	 * @param array
	 * @return
	 */
	public int[] insertionSort(int[] array) {
		
		if(array == null) {
			return null;
		}
		for(int i=1;i<array.length;i++) {
			if(array[i] < array[i-1]) {//0��i-1���������
				int temp = array[i];
				int j = i-1;
				for(; j>=0 && array[j] > temp; j-- ) {
					array[j+1] = array[j] ; //�Ѵ���temp��Ԫ������ƶ�һλ
				}
				array[j+1] = temp;//��������
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
