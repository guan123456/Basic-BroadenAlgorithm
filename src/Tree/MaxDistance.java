package Tree;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 22, 2021 7:09:19 PM
*/
public class MaxDistance {

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
		public int maxDistance;
		public int height;
		public Info(int dis, int h) {
			maxDistance = dis;
			height = h;
		}
	}
	
	public static Info process(Node X) {
		if(X == null) {
			return new Info(0, 0);
		}
		Info leftInfo = process(X.left);
		Info rightInfo = process(X.right);
		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
		// 与X有关和与X无关
		int maxDistance = Math.max(Math.max(leftInfo.maxDistance, rightInfo.maxDistance),
				leftInfo.height + rightInfo.height + 1);
		
		return new Info(maxDistance, height);
	}
	public static int maxDistance(Node head) {
		return process(head).maxDistance;
	}
}
