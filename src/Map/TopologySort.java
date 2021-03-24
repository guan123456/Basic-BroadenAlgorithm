package Map;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 24, 2021 5:08:27 PM
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologySort {

	// directed graph and no loop
	public static List<Node> sortedTopology(Graph graph){
		// key : 某一个node
		// value : 生于的入度
		HashMap<Node, Integer> inMap = new HashMap<>();
		// 入度为0的点，才能进这个队列
		Queue<Node> zeroInQueue = new LinkedList<Node>();
		for(Node node : graph.nodes.values()) {
			inMap.put(node, node.in);
			if(node.in == 0) {
				zeroInQueue.add(node);
			}
		}
		// 拓扑排序的结果，依次加入result
		List<Node> result = new ArrayList<Node>();
		while(!zeroInQueue.isEmpty()) {
			Node cur = zeroInQueue.poll();
			result.add(cur);
			for(Node next : cur.nexts) {
				inMap.put(next, inMap.get(next) - 1);
				if(inMap.get(next) == 0) {
					zeroInQueue.add(next);
				}
			}
		}
		return result;
	}

}
