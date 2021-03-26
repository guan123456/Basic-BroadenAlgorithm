package RecurseAndDynamic;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 26, 2021 1:11:17 PM
*/
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "fkakjhkfa";
		String str2 = "fhajkfdaj";
		System.out.println(lcse(str1.toCharArray(), str2.toCharArray()));
	}
	public static int lcse(char[] str1, char[] str2) {
		int[][] dp = new int[str1.length][str2.length];
		dp[0][0] = str1[0] == str2[0] ? 1 : 0;
		for(int i = 1; i < str1.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
		}
		for(int j = 1; j < str2.length; j++) {
			dp[0][j] = Math.max(dp[0][j - 1], str1[0] == str2[j] ? 1 : 0);
		}
		for(int i = 1; i < str1.length; i++) {
			for(int j = 1; j < str2.length; j++) {
				// 先可能性2与可能性3决策出大小，其实这里也跟可能性1一起决策了
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j-1]);
				// 可能性4存在
				if(str1[i] == str2[j]) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
				}
			}
		}
		return dp[str1.length - 1][str2.length-1];
	}
}
