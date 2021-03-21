package List;


/**
* @author 作者:guan
* @createDate 创建时间：Mar 21, 2021 9:23:27 PM
*/
public class SmallEqualBigger {

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
	public static Node listPartition(Node head, int pivot) {
		if(head == null) {
			return head;
		}
		Node cur = head;
		int i = 0;
		while(cur != null) {
			i++;
			cur = cur.next;
		}
		Node[] nodeArr = new Node[i];
		i = 0;
		cur = head;
		for(i = 0; i != nodeArr.length; i++) {
			nodeArr[i] = cur;
			cur = cur.next;
		}
		arrPartition(nodeArr,pivot);
		for(i = 1; i != nodeArr.length; i++) {
			nodeArr[i - 1].next = nodeArr[i];
		}
		nodeArr[i - 1].next = null;
		return nodeArr[0];
	}
	
	public static void arrPartition(Node[] nodeArr, int pivot) {
		int small = -1;
		int big = nodeArr.length;
		int index = 0;
		while(index != big) {
			if(nodeArr[index].value < pivot) {
				swap(nodeArr,++small,index++);
			}else if(nodeArr[index].value == pivot) {
				index++;
			}else {
				swap(nodeArr, --big, index);
			}
		}
	}
	
	public static void swap(Node[] nodeArr, int a, int b) {
		Node temp = nodeArr[a];
		nodeArr[a] = nodeArr[b];
		nodeArr[b] = temp;
	}
	
	public static Node listPartition2(Node head, int pivot) {
		Node sH = null; // small head
		Node sT = null; // small tail
		Node eH = null; // equal head
		Node eT = null; // equal tail
		Node mH = null; // big head
		Node mT = null; // big tail
		Node next = null; // save next node
		//every node distributed to three lists
		while(head != null) {
			next = head.next; // save next node
			head.next = null;
			if(head.value < pivot) {
				if(sH == null) {
					sH = head;
					sT = head;
				}else {
					sT.next = head;
					sT = head;
				}
			}else if(head.value == pivot) {
				if(eH == null) {
					eH = head;
					eT = head;
				}else {
					eT.next = head;
					eT = head;
				}
			}else {
				if(mH == null) {
					mH = head;
					mT = head;
				}else {
					mT.next = head;
					mT = head;
				}
			}
			head = next;
		}
		// small and equal reconnect
		if(sT != null) { // if small region exits
			sT.next = eH;
			eT = eT == null ? sT : eT; // refresh the eT
		}
		//all reconnect
		if(eT != null) {
			eT.next = mH;
		}
		return sH != null ? sH : (eH != null ? eH : mH); // refresh head 
	}
}
