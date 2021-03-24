package Map;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 24, 2021 3:56:11 PM
*/

import java.util.ArrayList;

public class Node {

	public int value;
	public int in;
	public int out;
	public ArrayList<Node> nexts;
	public ArrayList<Edge> edges;
	
	public Node(int value) {
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}
