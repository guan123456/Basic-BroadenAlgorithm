package preSensitiveTree;

import java.util.HashMap;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 21, 2021 6:16:17 PM
*/
public class TrieTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//用数组实现
	public static class TreeNode{
		public int pass;
		public int end;
		public TreeNode[] nexts;
		public TreeNode() {
			pass = 0;
			end = 0;
			//0    a
			//1    b
			//2    c
			//..  ..
			//25   z
			//nexts[i] == null  i方向的路不存在
			//nexts[i] != null  i方向的路存在
			//默认都是小写字母
			//nexts数组表示从当前结点出发有没有路走
			//每一个结点都有这么一个nexts数组
			nexts = new TreeNode[26];
		}
	}
	
	public static class Trie1{
		private TreeNode root;
		public Trie1() {
			root = new TreeNode();
		}
		
		public void insert(String word) {
			if(word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			//从根结点开始加
			TreeNode node = root;
			node.pass++;
			int index = 0;//
			for(int i = 0; i < chs.length; i++) {//从左到右遍历字符
				index = chs[i] - 'a';//上面定义a--0，右字符，对应成走哪条路
				//先判断有没有这个方向的路，没有就创建
				if(node.nexts[index] == null) {
					node.nexts[index] = new TreeNode();
				}
				//node调到这个结点上
				node = node.nexts[index];
				//node对应的pass值++
				node.pass++;
			}
			//最后一步，把node的end值++
			node.end++;
		}
		
		public void delete(String word) {
			if(search(word) != 0) {
				char[] chs = word.toCharArray();
				TreeNode node = root;
				//从根节点往结尾节点依次设置结点的pass值--
				node.pass--;
				int index = 0;
				for(int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
					//这里是如果当前结点的下一个结点pass--为0，那么就不必要继续了
					//后面结点的pass值和end值没必要操作了，jvm会帮忙垃圾回收
					if(--node.nexts[index].pass == 0) {
						node.nexts[index] = null;
						return;
					}
					node = node.nexts[index];
				}
				//最后一个结点记得end值--
				node.end--;
			}
		}
		
		//word这个单词之前加入过几次,pass值和end值不需要操作，只是查询
		public int search(String word) {
			if(word == null) {
				return 0;
			}
			char[] chs = word.toCharArray();
			TreeNode node = root;
			int index = 0;
			for(int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if(node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.end;
		}
		
		//所有加入的字符串中，有几个是以pre这个字符串作为前缀的
		public int prefixNumber(String pre) {
			if(pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			TreeNode node = root;
			int index = 0;
			for(int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				//如果走着走着路没了，那就是没有
				if(node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			//如果能走到最后，则返回这个结点的pass值即可
			return node.pass;
		}
	}

	//用哈希表实现
	public static class Node{
		public int pass;
		public int end;
		public HashMap<Integer, Node> nexts;
		public Node() {
			pass = 0;
			end = 0;
			nexts = new HashMap<>();
		}
	}
	
	public static class Trie2{
		private Node root;
		public Trie2() {
			root = new Node();
		}
		
		public void insert(String word) {
			if(word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			Node node = root;
			node.pass++;
			int index = 0;
			for(int i = 0; i < chs.length; i++) {
				index = (int)chs[i];
				if(!node.nexts.containsKey(index)) {
					node.nexts.put(index, new Node());
				}
				node = node.nexts.get(index);
				node.pass++;
			}
			node.end++;
		}
		
		public void delete(String word) {
			if(search(word) != 0) {
				char[] chs = word.toCharArray();
				Node node = root;
				//从根节点往结尾节点依次设置结点的pass值--
				node.pass--;
				int index = 0;
				for(int i = 0; i < chs.length; i++) {
					index = (int)chs[i];
					//这里是如果当前结点的下一个结点pass--为0，那么就不必要继续了
					//后面结点的pass值和end值没必要操作了，jvm会帮忙垃圾回收
					if(--node.nexts.get(index).pass == 0) {
						node.nexts.remove(index);
						return;
					}
					node = node.nexts.get(index);
				}
				//最后一个结点记得end值--
				node.end--;
			}
		}
		
		//word这个单词之前加入过几次,pass值和end值不需要操作，只是查询
		public int search(String word) {
			if(word == null) {
				return 0;
			}
			char[] chs = word.toCharArray();
			Node node = root;
			int index = 0;
			for(int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if(node.nexts.containsKey(index)) {
					return 0;
				}
				node = node.nexts.get(index);
			}
			return node.end;
		}
		
		//所有加入的字符串中，有几个是以pre这个字符串作为前缀的
		public int prefixNumber(String pre) {
			if(pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			Node node = root;
			int index = 0;
			for(int i = 0; i < chs.length; i++) {
				index = (int)chs[i];
				//如果走着走着路没了，那就是没有
				if(!node.nexts.containsKey(index)) {
					return 0;
				}
				node = node.nexts.get(index);
			}
			//如果能走到最后，则返回这个结点的pass值即可
			return node.pass;
		}
	}
}
