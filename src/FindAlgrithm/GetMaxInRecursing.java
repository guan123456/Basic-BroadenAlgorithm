package FindAlgrithm;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 19, 2021 8:47:01 PM
*/
public class GetMaxInRecursing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int getMax(int[] arr) {
		return process(arr,0,arr.length - 1);
	}
	public static int process(int[] arr, int left, int right) {
		if(left == right) {
			return arr[left];
		}
		
		int mid = left +((right - left) >> 1);//中点
		int leftMax = process(arr, left, mid);
		int rightMax = process(arr, mid + 1, right);
		return Math.max(leftMax, rightMax);
	}
	
	//非递归实现

}
