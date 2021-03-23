package Tree;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 23, 2021 11:41:59 AM
*/
public class IsFull {

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
		public int height;
		public int numberOfNodes;
		public Info(int h, int n) {
			height = h;
			numberOfNodes = n;
		}
	}
	
	public static boolean isFull(Node head) {
		if(head == null) {
			return true;
		}
		Info all = process(head);
		return (1 << all.height) - 1 == all.numberOfNodes;
	}
	
	public static Info process(Node head) {
		if(head == null) {
			return new Info(0, 0);
		}
		Info leftInfo = process(head.right);
		Info rightInfo = process(head.right);
		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
		int numberOfNodes = leftInfo.numberOfNodes + rightInfo.numberOfNodes + 1;
		return new Info(height, numberOfNodes);
	}
}
