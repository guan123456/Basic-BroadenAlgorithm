package GreedAlgrithm;

import java.util.PriorityQueue;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 23, 2021 6:58:48 PM
*/
public class LessMoneySplitGold {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int lessMoney(int[] arr) {
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		for(int i = 0; i < arr.length; i++) {
			pQ.add(arr[i]);
		}
		int sum = 0;
		int cur = 0;
		while(pQ.size() > 1) {
			cur = pQ.poll() + pQ.poll();
			sum += cur;
			pQ.add(cur);
		}
		return sum;
	}
}
