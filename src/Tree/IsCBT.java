   package Tree;

import java.util.LinkedList;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 23, 2021 12:33:17 PM
*/
public class IsCBT {

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
	
	public static boolean isCBT1(Node head) {
		if(head == null) {
			return true;
		}
		LinkedList<Node> queue = new LinkedList<>();
		// 是否遇到过左右两个孩子不双全的结点
		boolean leaf = false;
		Node left = null;
		Node right = null;
		queue.add(head);
		while(!queue.isEmpty()) {
			head = queue.poll();
			left = head.left;
			right = head.right;
			// 如果遇到了不双全的结点之后，又发现当前结点不是叶结点
			if((leaf && (left != null || right != null)) || (left == null && right != null)) {
				//有右孩子无左孩子直接false
				return false;
			}
			if(left != null) {
				queue.add(left);
			}
			if(right != null) {
				queue.add(right);
			}
			if(left == null || right == null) {
				leaf = true;
			}
		}
		return true;
	}
	
	//对每一颗子树，是否是满二叉树、是否是完全二叉树、以及它的高度
	public static class Info{
		public boolean isFull;
		public boolean isCBT;
		public int height;
		public Info(boolean full, boolean cbt, int h) {
			isFull = full;
			isCBT = cbt;
			height = h;
		}
	}
	
	public static Info process(Node X) {
		if(X == null) {
			return new Info(true, true, 0);
		}
		Info leftInfo = process(X.left);
		Info rightInfo = process(X.right);
		
		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
		boolean isFull = leftInfo.isFull && rightInfo.isFull
				&& leftInfo.height == rightInfo.height;
		boolean isCBT = false;
		if(isFull) {
			isCBT = true;
		}else { // 以X为头整棵树，不满
			if(leftInfo.isCBT && rightInfo.isCBT) {
				if(leftInfo.isCBT && rightInfo.isFull
				&& leftInfo.height == rightInfo.height + 1) {
					isCBT = true;
				}
				if(leftInfo.isFull && rightInfo.isFull 
				&& leftInfo.height == rightInfo.height + 1) {
					isCBT = true;
				}
				if(leftInfo.isFull && rightInfo.isCBT
				&& leftInfo.height == rightInfo.height) {
					isCBT = true;
				}
			}

		}
		return new Info(isFull, isCBT, height);
	}
}
