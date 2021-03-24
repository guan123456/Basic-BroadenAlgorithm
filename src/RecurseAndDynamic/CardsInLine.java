package RecurseAndDynamic;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 24, 2021 8:15:12 PM
*/
public class CardsInLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int win1(int[] arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		return Math.max(first(arr, 0, arr.length-1), last(arr, 0, arr.length-1));
	}
	
	public static int first(int[] arr, int left ,int right) {
		if(left == right) {
			return arr[left];
		}
		return Math.max(arr[left]+last(arr, left+1, right), arr[right] + last(arr, left, right-1));
	}
	
	public static int last(int[] arr, int left, int right) {
		if(left == right) {
			return 0;
		}
		return Math.min(first(arr, left+1, right), first(arr, left, right-1));
	}
}
