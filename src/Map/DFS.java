package Map;

import java.util.HashSet;
import java.util.Stack;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 24, 2021 4:43:58 PM
*/
public class DFS {

	// 遍历结果不唯一！！！
	public static void dfs(Node node) {
		if(node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();
		stack.add(node);
		set.add(node);
		System.out.println(node.value);
		while(!stack.isEmpty()) {
			Node cur = stack.pop();
			// 每一条路都是走到死然后再往上返回继续走
			// 代码里就是，栈中不断弹出栈顶元素然后判断
			for(Node next : cur.nexts) {
				if(!set.contains(next)) {
					stack.push(cur);
					stack.push(next);
					set.add(next);
					System.out.println(next.value);
					break;
				}
			}
		}
	}
}
