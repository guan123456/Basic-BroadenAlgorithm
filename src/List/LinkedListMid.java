package List;

import java.util.ArrayList;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 21, 2021 8:40:46 PM
*/
public class LinkedListMid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class Node{
		public int value;
		public Node next;
		public Node(int x) {
			this.value = x;
		}	
	}
	public static Node midOrUpMidNode(Node head) {
		//这里判断复杂是为了下面可以head.next.next
		if(head == null || head.next == null || head.next.next == null) {
			return head;
		}
		//链表有3个点或3个点以上
		Node slow = head.next;
		Node fast = head.next.next;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public static Node midOrDownMidNode(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node slow = head.next;
		Node fast = head.next;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	public static Node midOrUpMidPreNode(Node head) {
		if(head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node slow = head;
		Node fast = head.next.next;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public static Node midOrDownMidPreNode(Node head) {
		if(head == null || head.next == null) {
			return null;
		}
		if(head.next.next == null) {
			return head;
		}
		Node slow = head;
		Node fast = head.next;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	public static Node right1(Node head) {
		if(head == null) {
			return null;
		}
		Node cur = head;
		ArrayList<Node> arrayList = new ArrayList<>();
		while(cur != null) {
			arrayList.add(cur);
			cur = cur.next;
		}
		return arrayList.get((arrayList.size() - 1) / 2);
	}
	public static Node right2(Node head) {
		if(head == null) {
			return null;
		}
		Node cur = head;
		ArrayList<Node> arrayList = new ArrayList<>();
		while(cur != null) {
			arrayList.add(cur);
			cur = cur.next;
		}
		return arrayList.get((arrayList.size()) / 2);
	}
	public static Node right3(Node head) {
		if(head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node cur = head;
		ArrayList<Node> arrayList = new ArrayList<>();
		while(cur != null) {
			arrayList.add(cur);
			cur = cur.next;
		}
		return arrayList.get((arrayList.size() - 3) / 2);
	}
	public static Node right4(Node head) {
		if(head == null || head.next == null) {
			return null;
		}
		Node cur = head;
		ArrayList<Node> arrayList = new ArrayList<>();
		while(cur != null) {
			arrayList.add(cur);
			cur = cur.next;
		}
		return arrayList.get((arrayList.size() - 2) / 2);
	}
}
