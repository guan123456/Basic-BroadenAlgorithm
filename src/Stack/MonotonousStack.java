package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 27, 2021 11:25:12 PM
*/
public class MonotonousStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[][] getNearLessNoRepeat(int[] arr){
		int[][] res = new int[arr.length][2];
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < arr.length; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
				int popIndex = stack.pop();
				int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
				res[popIndex][0] = leftLessIndex;
				res[popIndex][1] = i;
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			int popIndex = stack.pop();
			int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
			res[popIndex][0] = leftLessIndex;
			res[popIndex][1] = -1;
		}
		return res;
	}
	
	// arr[3, 2, 1, 4, 5]
	//     0  1  2  3  4
	//   [
	//      0 : [-1, 1]
	//      1 : [-1, 2]
	//
	//   ]
	public static int[][] getNearLess(int[] arr){
		int[][] res = new int[arr.length][2];
		// List<Integer> -> 放的是位置，同样值的东西，位置压在一起
		Stack<List<Integer>> stack = new Stack<>();
		for(int i = 0; i < arr.length; i++) { // i -> arr[i] 进栈
			// 底 -> 顶， 小 -> 大
			while(!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
				List<Integer> popIs = stack.pop(); // 整个list弹出
				// 取位于下面位置的列表中，最晚加入的那个
				int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
				for(Integer popi : popIs) {
					res[popi][0] = leftLessIndex;
					res[popi][1] = i;
				}
			}
			// 相等的、比你小的
			if(!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
				stack.peek().add(Integer.valueOf(i));
			}else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				stack.push(list);
			}
		}
		while(!stack.isEmpty()) {
			List<Integer> popIs = stack.pop();
			// 取位于下面位置的列表中，最晚加入的那个
			int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
			for(Integer popi : popIs) {
				res[popi][0] = leftLessIndex;
				res[popi][1] = -1;
			}
		}
		return res;
	}
}
