package RecurseAndDynamic;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 24, 2021 7:47:46 PM
*/
public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int getMaxValue(int[] w, int[] v, int bag) {
		return process(w,v,0,0,bag);
	}
	
	// index... 最大价值
	// 不变： w[] v[] bag
	// 0...index-1 上做了货物的选择，使得你已经达到的重量是多少alreadyW
	// 如果返回-1，认为没有方案
	// 如果不返回-1，认为返回的值是真实价值
	public static int process(int[] w, int[] v, int index, int alreadyW, int bag) {
		if(alreadyW > bag) {
			return -1;
		}
		// 重量没超
		if(index == w.length) {
			return 0;
		}
		
		int p1 = process(w, v, index+1, alreadyW, bag);
		int p2next = process(w, v, index+1, alreadyW+w[index], bag);
		int p2 = -1;
		if(p2next != -1) {
			p2 = v[index] + p2next;
		}
		return Math.max(p1,p2);
	}
	
	// 只剩下rest的空间了，
	// index...货物自由选择，但是剩余空间不要小于0
	// 返回index...货物能够获得的最大价值
	public static int process_1(int[] w, int[] v, int index, int rest) {
		if(rest <= 0) {// base case 1
			return 0;
		}
		if(index == w.length) { // base case 2
			return 0;
		}
		int p1 = process_1(w, v, index+1, rest);
		int p2 = Integer.MIN_VALUE;
		if(rest >= w[index]) {
			p2 = v[index] + process_1(w, v, index+1, rest-w[index]);
		}
		return Math.max(p1, p2);
	}
	
	// 只剩下rest的空间了，
	// index...货物自由选择，但是剩余空间不要小于0
	// 返回index...货物能够获得的最大价值
	public static int process(int[] w, int[] v, int index, int rest) {
		if(rest < 0){
			return -1;
		}
		// rest >=0
		if (index == w.length) { // base case 2
			return 0;
		}
		// 有货也有空间
		int p1 = process(w, v, index + 1, rest);
	    int p2 = -1;
		int p2Next = process(w,v,index+1,rest-w[index]);
		if(p2Next != -1){
		 	p2 = v[index] + p2Next;
		}
		return Math.max(p1,p2);

	}
	public static int dpWay(int[] w, int[] v, int bag) {
		int N = w.length;
		int[][] dp = new int[N + 1][bag + 1];
		for (int index = N - 1; index >= 0; index--) {
			for (int rest = 0; rest <= bag; rest++) { // rest < 0
				int p1 = dp[index+1][rest];
				int p2 = -1;
				if(rest >= w[index]){
					p2 = v[index] + dp[index+1][rest-w[index]];
				}
				dp[index][rest] = Math.max(p1, p2);
			}
		}
		return dp[0][bag];
	}
	
	public static int dpWay2(int[] w, int[] v, int bag) {
		int N = w.length;
		int[][] dp = new int[N + 1][bag + 1];
		// dp[N][...] = 0
		for (int index = N - 1; index >= 0; index--) {

			for (int rest = 1; rest <= bag; rest++) {
				
				dp[index][rest] = dp[index + 1][rest];
				if (rest >= w[index]) {
					dp[index][rest] = Math.max(dp[index][rest], v[index] + dp[index + 1][rest - w[index]]);
				}
			}
		}
		return dp[0][bag];
	}
}
