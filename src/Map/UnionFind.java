package Map;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 23, 2021 7:55:37 PM
*/
public class UnionFind {

	public static class Node<V> {
		V value;

		public Node(V v) {
			value = v;
		}
	}

	//shift + ctrl + F 可以实现快速对齐
	public static class UnionSet<V> {
		public HashMap<V, Node<V>> nodes;
		public HashMap<Node<V>, Node<V>> parents;
		public HashMap<Node<V>, Integer> sizeMap;

		public UnionSet(List<V> values) {
			for (V value : values) {
				Node<V> node = new Node<>(value);
				nodes.put(value, node);
				parents.put(node, node);
				sizeMap.put(node, 1);
			}
		}

		public Node<V> findFather(Node<V> cur) {
			Stack<Node<V>> path = new Stack<>();
			while (cur != parents.get(cur)) {
				path.push(cur);
				cur = parents.get(cur);
			}
			// cur头节点
			while (!path.isEmpty()) {
				parents.put(path.pop(), cur);
			}
			return cur;
		}

		public boolean isSameSet(V a, V b) {
			if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
				return false;
			}
			return findFather(nodes.get(a)) == findFather(nodes.get(b));
		}

		public void union(V a, V b) {
			if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
				return;
			}
			Node<V> aHead = findFather(nodes.get(a));
			Node<V> bHead = findFather(nodes.get(b));
			if (aHead != bHead) {
				int aSetSize = sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);
//				Node<V> big = aSetSize >= bSetSize ? aHead : bHead;
//				Node<V> small = big == aHead ? bHead : aHead;
//				parents.put(small, big);
//				sizeMap.put(big, aSetSize + bSetSize);
//				sizeMap.remove(small);
				if (aSetSize >= bSetSize) {
					parents.put(bHead, aHead);
					sizeMap.put(aHead, aSetSize + bSetSize);
					sizeMap.remove(bHead);
				} else {
					parents.put(aHead, bHead);
					sizeMap.put(bHead, aSetSize + bSetSize);
					sizeMap.remove(aHead);
				}
			}
		}
	}
}
