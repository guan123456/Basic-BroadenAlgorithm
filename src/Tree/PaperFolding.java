package Tree;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 22, 2021 6:18:18 PM
*/
public class PaperFolding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 4;
		printAllFolds(N);
	}

	public static void printAllFolds(int N) {
		printProcess(1,N,true);
	}
	
	// 递归过程，来到了某一个节点
	// i是节点的层数，N一共的层数，down == true  凹     down == false  凸
	public static void printProcess(int i, int N, boolean down) {
		if(i > N) {
			return;
		}
		printProcess(i+1, N, true);
		System.out.println(down ? "凹" : "凸");
		printProcess(i+1, N, false);
	}

}
