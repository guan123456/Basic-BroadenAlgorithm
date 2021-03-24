package Map;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 24, 2021 4:33:34 PM
*/
public class BFS {

	// 遍历结果不唯一！！！
	public static void bfs(Node node) {
		if(node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		HashSet<Node> set = new HashSet<>();
		queue.add(node);
		set.add(node);
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.println(cur.value);
			// 遍历cur.nexts，一定不包含cur了
			for(Node next : cur.nexts) {
				// set中没有删除过元素，只是queue中有元素弹出而已
				if(!set.contains(next)) {
					set.add(next);
					queue.add(next);
				}
			}
		}
	}
}
