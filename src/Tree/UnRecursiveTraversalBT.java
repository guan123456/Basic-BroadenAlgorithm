package Tree;

import java.util.Stack;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 22, 2021 1:08:16 PM
*/
public class UnRecursiveTraversalBT {

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
	
	//栈后进先出，则先压入右子树再压入左子树，最后出来就可是左子树先出，后子树再出
	//根左右
	public static void pre(Node head) {
		System.out.print("pre-order: ");
		if(head != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.add(head);
			while(!stack.isEmpty()) {
				head = stack.pop();
				System.out.print(head.value + " ");
				if(head.right != null) {
					stack.push(head.right);
				}
				if(head.left != null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}
	
	//左根右
	public static void in(Node head) {
		System.out.print("in-order: ");
		if(head != null) {
			Stack<Node> stack = new Stack<Node>();
			while(!stack.isEmpty() || head != null) {
				//先把整条左边界依次入栈
				//压入顺序根左，那么输出就是左根
				if(head != null) {
					stack.push(head);
					head = head.left;
				//然后出栈并打印，然后来到弹出结点的右子树
			    //先弹出左，然后弹出根，然后再压入右，这样就形成左根右的顺序了
				//一定是输出完了左子树结点然后输出根节点才处理右子树！！！
				}else {
					head = stack.pop();
					System.out.print(head.value + " ");
					head = head.right;
				}
			}
		}
		System.out.println();
	}
	
	//先根右左，然后倒序输出，用一个辅助栈倒序输出就是左右根
	public static void pos(Node head) {
		System.out.print("pos-order: ");
		if(head != null) {
			Stack<Node> stack = new Stack<Node>();
			Stack<Node> stack2 = new Stack<Node>();
			stack.add(head);
			while(!stack.isEmpty()) {
				head = stack.pop();
				stack2.push(head);
				if(head.right != null) {
					stack.push(head.right);
				}
				if(head.left != null) {
					stack.push(head.left);
				}
			}
			while(!stack2.isEmpty()) {
				System.out.print(stack2.pop().value + " ");
			}
		}
		System.out.println();
	}
	// h的意义在于，没有打印之前，它不会干扰c去压左边界
	// 打印完之后，可以用h来标记c的左右子树有没有处理完
	public static void pos_1(Node h) {
		System.out.print("pos-order: ");
		if(h != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(h);
			Node c = null;
			while(!stack.isEmpty()) {
				// c指向当前判断结点，也就是栈顶结点
				c = stack.peek();
				// 如果当前结点左孩子未空且其左右孩子都未处理，那就先处理左孩子
				if(c.left != null && h != c.left && h != c.right) {
					stack.push(c.left);
				// 否则，如果当前结点右孩子未空，且右孩子未处理，那就先处理右孩子
				}else if(c.right != null && h != c.right) {
					stack.push(c.right);
				// 否则，也就是当前结点左右孩子都处理了，那就处理当前结点
				}else {
					System.out.print(stack.pop().value + " ");
					// h指向上一个输出结点，以辅助判断
					// h只有在有结点打印的时候才有了其指向的意义
					h = c;
				}
			}
		}
		System.out.println();
	}
	
	
}
