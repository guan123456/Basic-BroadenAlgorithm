package Map;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 24, 2021 3:55:04 PM
*/
public class Edge {
	public int weight;
	public Node from;
	public Node to;
	
	public Edge(int weight, Node from, Node to) {
		this.weight = weight;
		this.from = from;
		this.to = to;
	}
	
}
