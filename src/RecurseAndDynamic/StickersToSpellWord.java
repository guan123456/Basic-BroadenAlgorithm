package RecurseAndDynamic;

import java.util.HashMap;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 26, 2021 1:01:58 PM
*/
public class StickersToSpellWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int minSticker1(String[] stickers, String target) {
		int n = stickers.length;
		int[][] map = new int[n][26]; // stickers -> [26] [26] [26]
		for(int i = 0; i < n; i++) {
			char[] str = stickers[i].toCharArray();
			for(char c : str) {
				map[i][c - 'a']++;
			}
		}
		HashMap<String, Integer> dp = new HashMap<>();
		dp.put("", 0);
		return process1(dp,map,target); // 唯一可变参数是target
	}
	
	// dp 傻缓存，如果t已经算过了，直接返回dp中的值
	// rest 剩余的目标
	// 0..N每一个字符串所含字符的词频统计
	// 返回值是-1，map中的贴纸 怎么都无法覆盖rest
	public static int process1(HashMap<String, Integer> dp, int[][] map, String rest) {
		if(dp.containsKey(rest)) {
			return dp.get(rest);
		}
		
		// 以下就是正式的递归调用过程
		int ans = Integer.MAX_VALUE; // ans -> 搞定rest，使用的最少的贴纸数量
		int n = map.length;
		int[] temp = new int[26];
		char[] target = rest.toCharArray();
		for(char c : target) {
			temp[c - 'a']++; // 用于存储rest中各个字母的数量
		}
		for(int i = 0; i < n; i++) {
			// 枚举n张贴纸
            // 先选定搞定a字符的那些字符搞定一遍
            // 所有方案中搞定所有a中，总有一种最优方案
            // 而所有最优方案中，每一种方案都会搞定所有a
            // 所以我可以在满足搞定所有a的所有方案中选出最佳的方案就是最优解！！！
            // 这里可以改为包含target中任意一种字符，不加这if有可能会有栈溢出，也就是没匹配的情况！！！
			if(map[i][target[0] - 'a'] == 0) {
				continue;
			}
			StringBuilder sb = new StringBuilder();
			// i贴纸，j枚举a~z字符
			for(int j = 0; j < 26; j++) {
				if(temp[j] > 0) {
					// 相减后剩余多少个，就在sb中添加多少这个字符
					for(int k = 0; k < Math.max(0, temp[j] - map[i][j]); k++) {
						sb.append((char)('a'+j));
					}
				}
			}
			String s = sb.toString();
			int tmp = process1(dp,map,s);
			if(tmp != -1) {
				ans = Math.min(ans, tmp + 1);
			}
		}
		dp.put(rest, ans == Integer.MAX_VALUE ? -1 : ans);
		return dp.get(rest);
	}
}
