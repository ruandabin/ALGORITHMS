package top.ruandb.sort;

import top.ruandb.utils.ArrayUtil;

/**
 * 归并排序
 * @author rdb
 *
 */
public class MergeSort {

	public int[] mergeSort(int[] array) {
		
		int[] temp = new int[array.length];
		sort(array,0,array.length-1,temp);
		return array;
	}
	
	/**
	 * 递归拆分
	 * @param array
	 * @param left
	 * @param right
	 * @param temp
	 * @return
	 */
	private int[] sort(int[] array,int left,int right,int[] temp) {
		
		if(left < right) {
			int mid = (left + right)/2 ;
			sort(array,left,mid,temp);//左边归并排序，使得左子序列有序
			sort(array,mid+1,right,temp);//右边归并排序，使得右子序列有序
			merge(array,left,mid,right,temp);//将两个有序子数组合并操作
		}
		return array;
	}
	
	/**
	 * 合并两个有序序列
	 * @param array
	 * @param left
	 * @param mid
	 * @param right
	 * @param temp
	 */
	private void merge(int array[],int left,int mid,int right,int[] temp) {
		int i = left;
		int j = mid + 1;
		int t = 0 ;
		while(i <= mid && j <=right) {
			if(array[i] < array[j]) {
				temp[t++] = array[i++];
			}else {
				temp[t++] = array[j++];
			}
		}
		
		while(i <= mid) {
			temp[t++] = array[i++];
		}
		
		while(j <= right) {
			temp[t++] = array[j++];
		}
		
		t=0;
		
		//将temp中的元素全部拷贝到原数组中
		while(left <= right) {
			array[left++] = temp[t++] ;
		}
	}
	
	public static void main(String[] args) {
		int[] array = ArrayUtil.generateRandomArray(1000000, 0, 1000000);
		MergeSort ms = new MergeSort();
		
//		ArrayUtil.printArray(array);
//		ArrayUtil.printArray(ms.mergeSort(array));
		
		long startTime = System.currentTimeMillis();
		ms.mergeSort(array);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime + "ms");
	}
}
