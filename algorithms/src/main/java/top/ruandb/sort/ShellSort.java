package top.ruandb.sort;

import top.ruandb.utils.ArrayUtil;

/**
 * ϣ������
 * @author rdb
 *
 */
public class ShellSort {

	
	public int[] shellSort(int[] array) {
		
		int increment = array.length;
		while(increment != 1) {
			increment = increment /3 +1 ;
			for(int i=increment;i<array.length;i++) {
				if(array[i] < array[i-increment]) {//0��i-increment���������
					int temp = array[i];
					int j = i-increment;
					for(; j>=0 && array[j] > temp; j=j-increment ) {
						array[j+increment] = array[j] ; //�Ѵ���temp��Ԫ������ƶ�һλ
					}
					array[j+increment] = temp;//��������
				}
			}
		}
		
		return array;
	}
	
	public static void main(String[] args) {		
		
		int[] array =ArrayUtil.generateRandomArray(1000000, 0, 1000000);
		ShellSort ss = new ShellSort();
		
//		ArrayUtil.printArray(array);
//		ArrayUtil.printArray(ss.shellSort(array));
		
		long startTime = System.currentTimeMillis();
		ss.shellSort(array);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + "ms");
	}
	
}
