package Tree;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 23, 2021 11:51:19 AM
*/
public class MaxSubBSTHead {

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
		//这里不需要一个boolean类型的判断是否是二叉搜索树了
		public Node maxSubBSTHead;
		public int maxSubBSTSize;
		public int min;
		public int max;
		public Info(Node h, int size, int mi, int ma) {
			maxSubBSTHead = h;
			maxSubBSTSize = size;
			min = mi;
			max = ma;
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
		Node maxSubBSTHead = null;
		int maxSubBSTSize = 0;
		if(leftInfo != null) {
			min = Math.min(min, leftInfo.min);
			max = Math.max(max, leftInfo.max);
			maxSubBSTHead = leftInfo.maxSubBSTHead;
			maxSubBSTSize = leftInfo.maxSubBSTSize;
		}
		if(rightInfo != null) {
			min = Math.min(min, rightInfo.min);
			max = Math.max(max, rightInfo.max);
			if(rightInfo.maxSubBSTSize > maxSubBSTSize) {
				maxSubBSTHead = rightInfo.maxSubBSTHead;
				maxSubBSTSize = rightInfo.maxSubBSTSize;
			}
		}
		//这里肯定有问题，有时间或者需要到的时候再搞一搞
		if((leftInfo == null ? true : (leftInfo.maxSubBSTHead == X.left && leftInfo.max < X.value))
		&&(rightInfo == null ? true : (rightInfo.maxSubBSTHead == X.right && rightInfo.max < X.value))){
			maxSubBSTHead = X;
			maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize)
					+(rightInfo == null ? 0 : rightInfo.maxSubBSTSize)
					+ 1;
		}
		return new Info(maxSubBSTHead, maxSubBSTSize, min, max);
	}
}
