package SortAlgrithm;

import java.util.Arrays;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 19, 2021 6:03:53 PM
*/
public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//时间复杂度O(N^2)
	public static void insertionSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		for(int i = 1; i < arr.length; i++) {
			for(int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--) {
				swap(arr,j,j+1);
			}
		}
	}
	public static void swap(int[] arr,int i, int j) {
		//这么做行得通是要两个数地址是不一样的，如果i和j都是0，那么返回的是0，而不是a[i]
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];//arr[j] = arr[i]^arr[j]^arr[j]
		arr[i] = arr[i] ^ arr[j];//arr[i] = arr[i]^arr[j]^arr[i]^arr[j]^arr[j]
	}
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		//Math.random() [0,1)
		//Math.random() * N [0,N)
		//(int)(Math.random() * N) [0,N-1]
		int[] arr = new int[(int)((maxSize+1)*Math.random())];
		for(int i = 0; i < arr.length; i++) {
			//相减是为了有负数产生[-? , +?]
			arr[i] = (int)((maxValue + 1) * Math.random()) -(int)(maxValue*Math.random());
		}
		return arr;
	}
	public static int[] copyArray(int[] arr) {
		if(arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
}
