package Queue;

import java.util.LinkedList;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 27, 2021 10:20:34 PM
*/
public class SlidingWindowMaxArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int[] getMaxWindow(int[] arr, int w) {
		if(arr == null || w < 1 || arr.length < w) {
			return null;
		}
		// 其中放的是位置，arr[位置]，头代表（大->小)尾
		LinkedList<Integer> qmax = new LinkedList<>();
		int[] res = new int[arr.length - w + 1];
		int index = 0;
		// L...R
		//     right
		for(int right = 0; right < arr.length; right++) { // 当前让 right -> [right] 进窗口
			// right-> 值可以放在比他大的数后，或者空
			while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[right]) {
				qmax.pollLast();
			}
			qmax.addLast(right);
			// 数进来了
			// 如果窗口没有形成W的长度之前，不弹出数字
			if(qmax.peekFirst() == right - w) {
				qmax.pollFirst();
			}
			// 以上窗口更新做完了
			// 窗口形成W之后才开始收集答案
			if(right >= w - 1) {
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}
}
