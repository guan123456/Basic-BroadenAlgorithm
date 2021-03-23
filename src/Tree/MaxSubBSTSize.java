package Tree;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 22, 2021 7:40:15 PM
*/
public class MaxSubBSTSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class Node{
		public int value;
		public Node left;
		public Node right;
		public Node(int data) {
			this.value = data;
		}
	}
	
	public static class Info{
		public boolean isAllBST;
		public int maxSubBSTSize;
		public int min;
		public int max;
		public Info(boolean is, int size, int MIN, int MAX) {
			isAllBST = is;
			maxSubBSTSize = size;
			min = MIN;
			max = MAX;
		}
	}
	
	public static Info process(Node X) {
		if(X == null) {
			return null;
		}
		Info leftInfo = process(X.left);
		Info rightInfo = process(X.right);
		
		
		int min = X.value;
		int max = X.value;
		// min与max加工
		if(leftInfo != null) {
			min = Math.min(min, leftInfo.min);
			max = Math.max(max, leftInfo.max);
		}
		if(rightInfo != null) {
			min = Math.min(min, rightInfo.min);
			max = Math.max(max, rightInfo.max);
		}
		
		// maxSubBSTSize粗加工
		int maxSubBSTSize = 0;
		if(leftInfo != null) {
			maxSubBSTSize = leftInfo.maxSubBSTSize;
		}
		if(rightInfo != null) {
			maxSubBSTSize = Math.max(maxSubBSTSize, rightInfo.maxSubBSTSize);
		}
		//maxSubBSTSize精加工和isAllBST加工
		boolean isAllBST = false;
		if((leftInfo == null ? true : leftInfo.isAllBST)
		&&(rightInfo == null ? true : rightInfo.isAllBST)
		&&( leftInfo == null ? true : leftInfo.max < X.value)
		&&(rightInfo == null ? true : rightInfo.min > X.value)) {
			maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize)
					+(rightInfo == null ? 0 : rightInfo.maxSubBSTSize)
					+ 1;
			isAllBST = true;
		}
		return new Info(isAllBST, maxSubBSTSize, min, max);
	}
}
