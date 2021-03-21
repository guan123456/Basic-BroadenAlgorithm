package SortAlgrithm;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 21, 2021 7:05:17 PM
*/
public class radixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void radixSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		radixSort(arr,0,arr.length-1,maxbits(arr));
	}
	public static int maxbits(int[] arr) {
		int max = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int res = 0;
		while(max != 0) {
			res++;
			max /= 10;
		}
		return res;
	}
	//arr[left...right] 排序，digit
	//left...right  3 56 17 100   3       这个3表示最大值(100)有三位
	//时间复杂度O(N*lg(max))
	public static void radixSort(int[] arr, int left, int right, int digit) {
		final int radix = 10;
		int i = 0;
		int j = 0;
		//有多少个数准备多少个辅助空间
		int[] help = new int[right - left + 1];
		for(int d = 1; d <= digit; d++) {//有多少位就进出几次
			//10个空间
			//count[0] 当前位(d位)是0的数字有多少个
			//count[1] 当前位(d位)是(0和1)的数字有多少个
			//count[2] 当前位(d位)是(0和1和2)的数字有多少个
			//count[i] 当前位(d位)是(0~i)的数字有多少个
			int[] count = new int[radix];
			for(i = left; i <= right; i++) {
				//103    1    3
				//209    1    9
				j = getDigit(arr[i],d);
				count[j]++;
			}
			for(i = 1; i < radix; i++) {
				count[i] = count[i] + count[i - 1];
			}
			for(i = right; i >= left; i--) {
				j = getDigit(arr[i],d);
				help[count[j] - 1] = arr[i];
				count[j]--;
			}
			for(i = left, j = 0; i <= right; i++,j++) {
				arr[i] = help[j];
			}
		}
	}
	public static int getDigit(int x, int d) {
		return ((x / ((int)Math.pow(10, d-1))) % 10);
	}
}
