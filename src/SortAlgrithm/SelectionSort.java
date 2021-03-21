package SortAlgrithm;

import java.util.Arrays;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 19, 2021 5:52:23 PM
*/
public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//时间复杂度O(N^2)
	public static void selectionSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		for(int i = 0; i < arr.length - 1; i++) {
			//最小值在哪个位置上 i~n-1
			int minIndex = i;
			for(int j = i + 1; j < arr.length; j++) {
				//i~N-1上找最小值的下标
				minIndex = arr[j] < arr[minIndex] ? j : minIndex;
			}
			swap(arr,i,minIndex);
		}
	}
	public static void swap(int[] arr,int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}
}
