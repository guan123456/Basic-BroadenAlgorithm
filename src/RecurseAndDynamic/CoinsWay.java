package RecurseAndDynamic;


/**
* @author 作者:guan
* @createDate 创建时间：Mar 25, 2021 3:43:56 PM
*/
public class CoinsWay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 10, 50, 100};
		int sum = 1000;
		System.out.println(ways1(arr,sum));
		System.out.println(ways2(arr,sum));
		System.out.println(ways3(arr,sum));
		System.out.println(ways4(arr,sum));
	}

	// arr中都是正数且无重复值，返回组成aim的方法数
	public static int ways1(int[] arr, int aim) {
		if(arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		return process1(arr,0,aim);
	}
	// 可以自由使用arr[index...]所有的面值，每一种面值都可以使用任意张
	// 组成rest，有多少种方法
	public static int process1(int[] arr, int index, int rest) {
		if(rest < 0) {
			return 0;
		}
		
		// rest >= 0
		if(index == arr.length) {
			// 没有货币可以选择了
			return rest == 0 ? 1 : 0;
		}
		// 当前有货币，arr[index]
		int ways = 0;
		for(int zhang = 0; zhang * arr[index] <= rest; zhang++) {
			ways += process1(arr, index+1, rest-(zhang * arr[index]));
		}
		return ways;
	}
	
	public static int ways2(int[] arr, int aim) {
		if(arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		// HashMap<String, Integer> map = new HashMap<>();
		// index = 3 rest = 900 map key "3_900" int 
	    int[][] dp = new int[arr.length+1][aim+1];
	    // 一开始所有的过程，都没有计算
	    // dp[...][...] = -1
	    for(int i = 0; i < dp.length; i++) {
	    	for(int j = 0; j < dp[0].length; j++) {
	    		dp[i][j] = -1;
	    	}
	    }
		return process2(arr,0,aim,dp);
	}
	
	// 如果index和rest的参数组合，是没有算过的，即dp[index][rest] == -1
	// 如果index和rest的参数组合，是有算过的，即dp[index][rest] > -1
	public static int process2(int[] arr, int index, int rest,int[][] dp) {
		if(dp[index][rest] != -1) {
			return dp[index][rest];
		}
		
		// rest >= 0
		if(index == arr.length) {
			// 没有货币可以选择了
			dp[index][rest] = rest == 0 ? 1 : 0;
			return dp[index][rest];
		}
		// 当前有货币，arr[index]
		int ways = 0;
		for(int zhang = 0; zhang * arr[index] <= rest; zhang++) {
			ways += process2(arr, index+1, rest-(zhang * arr[index]),dp);
		}
		dp[index][rest] = ways;
		return ways;
	}
	
	public static int ways3(int[] arr, int aim) {
		if(arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int N = arr.length;
		int[][] dp = new int[N+1][aim + 1];
		dp[N][0] = 1; // dp[N][1...aim] = 0
		for(int index = N - 1; index >= 0; index--) {
			for(int rest = 0; rest <= aim; rest++) {
				int ways = 0;
				// 这里有枚举行为，所以可以继续优化
				for(int zhang = 0; zhang * arr[index] <= rest; zhang++) {
					ways += dp[index+1][rest-(zhang*arr[index])];
				}
				dp[index][rest] = ways;
			}
		}
		return dp[0][aim];
	}
	
	public static int ways4(int[] arr, int aim) {
		if(arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int N = arr.length;
		int[][] dp = new int[N+1][aim + 1];
		dp[N][0] = 1; // dp[N][1...aim] = 0
		for(int index = N - 1; index >= 0; index--) {
			for(int rest = 0; rest <= aim; rest++) {
				dp[index][rest] = dp[index+1][rest];
				if(rest - arr[index] >= 0) {
					dp[index][rest] += dp[index][rest - arr[index]];
				}
			}
		}
		return dp[0][aim];
	}
}
