package Stack;

import java.util.Stack;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 27, 2021 11:37:12 PM
*/
public class AllTimesMinToMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int max(int[] arr) {
		int size = arr.length;
		int[] sums = new int[size];
		sums[0] = arr[0];
		// 数据的预处理，前缀和
		for(int i = 1; i < size; i++) {
			sums[i] = sums[i - 1] + arr[i];
		}
		int max = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < size; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				int j = stack.pop();
				// sums[i-1] - sums[stack.peek()] 代表arr[arr[stack.peek()] 到 arr[i-1]之间所有数的累加和
				max = Math.max(max, (stack.isEmpty() ? sums[i-1] : (sums[i-1] - sums[stack.peek()])) * arr[j]);
			}
			stack.push(i);
		}
		// 当栈中还有元素，则需要继续出栈计算
		while(!stack.isEmpty()) {
			int j = stack.pop();
			max = Math.max(max, (stack.isEmpty() ? sums[size-1] : (sums[size-1] - sums[stack.peek()])) * arr[j]);
		}
		return max;
	}
}
