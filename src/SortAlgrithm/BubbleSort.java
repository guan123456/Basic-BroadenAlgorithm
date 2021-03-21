package SortAlgrithm;

import java.util.Arrays;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 19, 2021 5:57:56 PM
*/
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//时间复杂度O(N^2)
	public static void bubbleSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		for(int i = arr.length - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr,i,i+1);
				}
			}
		}
	}
	public static void swap(int[] arr,int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];//arr[j] = arr[i]^arr[j]^arr[j]
		arr[i] = arr[i] ^ arr[j];//arr[i] = arr[i]^arr[j]^arr[i]^arr[j]^arr[j]
	}
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}
}
