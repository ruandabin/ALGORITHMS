package top.ruandb.sort;

import top.ruandb.utils.ArrayUtil;

/**
 * �鲢����
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
	 * �ݹ���
	 * @param array
	 * @param left
	 * @param right
	 * @param temp
	 * @return
	 */
	private int[] sort(int[] array,int left,int right,int[] temp) {
		
		if(left < right) {
			int mid = (left + right)/2 ;
			sort(array,left,mid,temp);//��߹鲢����ʹ��������������
			sort(array,mid+1,right,temp);//�ұ߹鲢����ʹ��������������
			merge(array,left,mid,right,temp);//����������������ϲ�����
		}
		return array;
	}
	
	/**
	 * �ϲ�������������
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
		
		//��temp�е�Ԫ��ȫ��������ԭ������
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
