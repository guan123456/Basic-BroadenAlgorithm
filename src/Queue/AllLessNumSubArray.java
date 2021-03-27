package Queue;

import java.util.LinkedList;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 27, 2021 10:40:11 PM
*/
public class AllLessNumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int getNum(int[] arr, int num) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		LinkedList<Integer> qmin = new LinkedList<>();
		LinkedList<Integer> qmax = new LinkedList<>();
		int L = 0;
		int R = 0;
		int res = 0;
		// [L...R) [0,0)  窗口内无数
		while(L < arr.length) { // L是开头位置，尝试每一个开头
			// 如果此时窗口的开头是L,下面的while工作:R向右扩到违规为止
			while(R < arr.length) { // R是最后一个达标位置的再下一个
				while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[R]) {
					qmin.pollLast();
				}
				qmin.addLast(R);
				while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
					qmax.pollLast();
				}
				qmax.addLast(R);
				
				if(arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
					break;
				}
				R++;
			}
			// R是最后一个达标位置的再下一个，第一个违规的位置
			res += R - L;
			if(qmin.peekFirst() == L) {
				qmin.pollFirst();
			}
			if(qmax.peekFirst() == L) {
				qmax.pollFirst();
			}
			L++;
		}
		return res;
	}
}
