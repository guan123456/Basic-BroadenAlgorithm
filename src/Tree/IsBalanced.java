package Tree;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 22, 2021 8:23:37 PM
*/
public class IsBalanced {

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
	
	// 左、右要求一样，信息返回的结构体
	public static class Info{
		public boolean isBalanced;
		public int height;
		public Info(boolean b, int h) {
			isBalanced = b;
			height = h;
		}
	}
	
	public static Info process(Node X) {
		if(X == null) {
			return new Info(true, 0);
		}
		Info leftInfo = process(X.left);
		Info rightInfo = process(X.right);
		
		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
		
		boolean isBalanced = true;
		
		if(!leftInfo.isBalanced || !rightInfo.isBalanced || Math.abs(leftInfo.height - rightInfo.height) > 1) {
			isBalanced = false;
		}
		return new Info(isBalanced, height);
	}
	
	public static boolean isBalanced(Node head) {
		return process(head).isBalanced;
	}
	
}
