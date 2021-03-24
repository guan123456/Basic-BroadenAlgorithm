package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 22, 2021 2:35:07 PM
*/
public class SerializeAndReconstructTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		public Node(int v) {
			value = v;
		}
	}
	
	public static Queue<String> preSerial(Node head){
		Queue<String> ans = new LinkedList<String>();
		pres(head,ans);
		return ans;
	}
	/*
	 * 二叉树可以通过先序、后续或者按层次遍历的方式序列化和反序列化
	 * 但是，二叉树无法通过中序遍历的方式实现序列化和反序列化
	 * 因为不同的两棵树，可能得到同样的中序序列，即便补了空位置也可能一样
	 */
	public static void pres(Node head, Queue<String> ans) {
		if(head == null) {
			ans.add(null);
		}else {
			ans.add(String.valueOf(head.value));
			pres(head.left, ans);
			// 中序序列化 	ans.add(String.valueOf(head.value));
			pres(head.right, ans);
			// 后序序列化   	ans.add(String.valueOf(head.value));
		}
	}
	
	public static Node buildByPreQueue(Queue<String> prelist) {
		if(prelist == null || prelist.size() == 0) {
			return null;
		}
		return preb(prelist);
	}
	
	public static Node preb(Queue<String> prelist) {
		String value = prelist.poll();
		if(value == null) {
			return null;
		}
		Node head = new Node(Integer.valueOf(value));
		head.left = preb(prelist);
		// 中序反序列化       Node head = new Node(Integer.valueOf(value));
		head.right = preb(prelist);
		// 后序反序列化       Node head = new Node(Integer.valueOf(value));
		return head;
	}
	
	public static Queue<String> levelSerial(Node head){
		Queue<String> ans = new LinkedList<>();
		if(head == null) {
			ans.add(null);
		}else {
			ans.add(String.valueOf(head.value));
			Queue<Node> queue = new LinkedList<>();
			queue.add(head);
			while(!queue.isEmpty()) {
				head = queue.poll();
				if(head.left != null) {
					ans.add(String.valueOf(head.left.value));
					queue.add(head.left);
				}else {
					ans.add(null);
				}
				if(head.right != null) {
					ans.add(String.valueOf(head.right.value));
					queue.add(head.right);
				}else {
					ans.add(null);
				}
			}
		}
		return ans;
	}
	
	public static Node buildByLevelQueue(Queue<String> levelList) {
		if(levelList == null || levelList.size() == 0) {
			return null;
		}
		Node head = generateNode(levelList.poll());
		Queue<Node> queue = new LinkedList<>();
		if(head != null) {
			queue.add(head);
		}
		Node node = null;
		while(!queue.isEmpty()) {
			node = queue.poll();
			node.left = generateNode(levelList.poll());
			node.right = generateNode(levelList.poll());
			if(node.left != null) {
				queue.add(node.left);
			}
			if(node.right != null) {
				queue.add(node.right);
			}
		}
		return head;
	}
	public static Node generateNode(String val) {
		if(val == null) {
			return null;
		}
		return new Node(Integer.valueOf(val));
	}
}
