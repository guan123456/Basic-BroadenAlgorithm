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
		return Math.max(arr[left]+last(arr, left+1, right), arr[right] + last(arr,  left, right-1));
	}
	
	public static int last(int[] arr, int left, int right) {
		if(left == right) {
			return 0;
		}
		return Math.min(first(arr, left+1, right), first(arr, left, right-1));
	}
	
	public static int win2(int[] arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		int N = arr.length;
		int[][] f = new int[N][N];
		int[][] s = new int[N][N];
		for(int i = 0; i < N; i++) {
			f[i][i] = arr[i];
		}
		for(int i = 1; i < N; i++) {
			int L = 0;
			int R = i;
			while(L < N && R < N) {
				f[L][R] = Math.max(arr[L]+s[L+1][R], arr[R] + s[L][R-1]);
				s[L][R] = Math.min(f[L+1][R], f[L][R-1]);
				L++;
				R++;
			}
		}
		return Math.max(f[0][N-1], s[0][N-1]);
	}
	
	public static int win3(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int[][] f = new int[arr.length][arr.length];
		int[][] s = new int[arr.length][arr.length];
		for (int j = 0; j < arr.length; j++) {
			f[j][j] = arr[j];
			for (int i = j - 1; i >= 0; i--) {
				f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
				s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
			}
		}
		return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
	}
}
