package FindAlgrithm;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 19, 2021 6:28:37 PM
*/
public class BSNearLeft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int nearestIndex(int[] arr, int value) {
		int left = 0;
		int right = arr.length - 1;
		int index = -1;
		while(left <= right) {
			int mid = left + ((right-left) >> 1);
			if(arr[mid] >= value) {
				index = mid;
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		return index;
	}
}
