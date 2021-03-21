package FindAlgrithm;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 19, 2021 6:23:24 PM
*/
public class BSExist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static boolean exist(int[] sortedArr, int num) {
		if(sortedArr == null || sortedArr.length == 0) {
			return false;
		}
		int left = 0;
		int right = sortedArr.length - 1;
		int mid = 0;
		
		while(left < right) {
			mid = left + ((right - left)>>1);
			if(sortedArr[mid] == num) {
				return true;
			}else if(sortedArr[mid] > num) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		return sortedArr[left] == num;
	}

}
