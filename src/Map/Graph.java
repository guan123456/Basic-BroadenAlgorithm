package Map;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 24, 2021 3:59:50 PM
*/

import java.util.HashMap;
import java.util.HashSet;

public class Graph {

	public HashMap<Integer, Node> nodes;
	public HashSet<Edge> edges;
	
	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}
}
