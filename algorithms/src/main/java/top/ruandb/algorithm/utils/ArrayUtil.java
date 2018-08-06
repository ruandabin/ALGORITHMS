package top.ruandb.algorithm.utils;

import java.util.Random;
import java.util.stream.IntStream;

public class ArrayUtil {

	/**
	 * 生产长度为n的随机数�?,数组值的边界是[rangeL,angeR]
	 *@param n 数组长度
	 *@param rangeL 数组值边界[rangeL,angeR]
	 *@param rangeR 数组值边界[rangeL,angeR]
	 *@return
	 */
	public static int[] generateRandomArray(int n,int rangeL,int rangeR){
		
		if(rangeL > rangeR){
			return null;
		}
		Random random = new Random();
		int[] randomArray = new int[n];
		for(int i=0;i<n;i++){
			randomArray[i] = (random.nextInt(rangeR)%(rangeR-rangeL+1) + rangeL);
		}
		return randomArray;
	}
	
	/**
	 * 打印数组
	 * @param array
	 */
	public static void printArray(int[] array) {
		IntStream.of(array).forEach(i -> System.out.print(i+ " "));
		System.out.print("\n");
	}
}
