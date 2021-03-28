package RecurseAndDynamic;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 28, 2021 1:50:42 PM
*/
public class HorseKStepsToLocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 6;
		int y = 6;
		int k = 10;
		System.out.println(ways(x, y, k));
		System.out.println(ways1(x, y, k));
	}

	public static int ways(int x, int y, int k) {
		return function(x, y, k);
	}
	
	public static int function(int x, int y, int k) {
		if(k == 0) {
			return x == 0 && y == 0 ? 1 : 0;
		}
		if(x < 0 || x > 9 || y < 0 || y > 8) {
			return 0;
		}
		return   function(x + 2, y - 1, k - 1)
				+function(x + 2, y + 1, k - 1)
				+function(x + 1, y + 2, k - 1)
				+function(x - 1, y + 2, k - 1)
				+function(x - 2, y + 1, k - 1)
				+function(x - 2, y - 1, k - 1)
				+function(x - 1, y - 2, k - 1)
				+function(x + 1, y - 2, k - 1);
	}
	
	public static int ways1(int x, int y, int k) {
		int[][][] dp = new int[10][9][k+1]; // 0 ~ k
		dp[0][0][0] = 1; // dp[...][...][0] = 0
		// level层，x y
		for(int level = 1; level <= k; level++) { // x可能性
			for(int i = 0; i < 10; i++) { // y可能性
				for(int j = 0; j < 9; j++) {
					dp[i][j][level] =getValue(dp, i + 2, j - 1, level - 1)
									+getValue(dp, i + 2, j + 1, level - 1)
									+getValue(dp, i + 1, j + 2, level - 1)
									+getValue(dp, i - 1, j + 2, level - 1)
									+getValue(dp, i - 2, j + 1, level - 1)
									+getValue(dp, i - 2, j - 1, level - 1)
									+getValue(dp, i - 1, j - 2, level - 1)
									+getValue(dp, i + 1, j - 2, level - 1);
				}
			}
		}
		return dp[x][y][k];
	}
	public static int getValue(int[][][] dp, int x, int y, int k) {
		if(x < 0 || x > 9 || y < 0 || y > 8) {
			return 0;
		}
		return dp[x][y][k];
	}
}
