package FindAlgrithm;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 19, 2021 6:38:34 PM
*/
public class LocalLessIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//局部最小数
	//二分法不一定要求是有序数组，这里是求某个数比左右都小
	//先判断头尾，如果头尾不存在，也就是开头两个数是向下，结尾两个数是向上，一定是存在有这样的数的
	public static int localLessIndex(int[] arr) {
		if(arr == null || arr.length == 0) {
			return -1;
		}
		if(arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		if(arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
		int left = 1;
		int right = arr.length - 2;
		int mid = 0;
		while(left < right) {
			mid = left + ((right-left) >> 1);
			if(arr[mid] > arr[mid - 1]){
				right = mid - 1;
			}else if(arr[mid] > arr[mid + 1]) {
				left = mid + 1;
			}else {
				return mid;
			}
		}
		return left;
	}
}
