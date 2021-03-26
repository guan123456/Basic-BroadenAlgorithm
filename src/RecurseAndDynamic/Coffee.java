package RecurseAndDynamic;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 26, 2021 1:50:49 PM
*/
public class Coffee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,5,5,7,10,12,12,12,12,12,12,15};
		int a = 3;
		int b = 10;
		System.out.println(process(arr, a, b, 0, 0));
	}
	// process(drinks, 3, 10, 0 , 0)
	// a  洗一杯的时间  固定变量
	// b  自己挥发干净的时间  固定变量
	// drinks  每一个员工喝完的时间  固定变量
	// drinks[0...index-1]都已经干净了，不用你操心了
	// drinks[index...]都想变干净，这是我操心的，washLine表示洗的机器何时可用
	// drinks[index...]变干净，最少的时间点返回
	public static int process(int[] drinks, int a, int b, int index, int washLine) {
		if(index == drinks.length - 1) {
			return Math.min(Math.max(washLine, drinks[index] + a), drinks[index] + b);
		}
		// 剩下不止一杯咖啡
		// wash是我当前的咖啡杯，洗完的时间
		int wash = Math.max(washLine, drinks[index]) + a; // 洗index一杯结束的时间点
		// index + 1 ... 变干净的最早时间
		int next1 = process(drinks, a, b, index+1, wash);
		// 选择洗的终止时间
		int p1 = Math.max(wash, next1);
		int dry = drinks[index] + b; // 挥发index一杯，结束的时间点
		int next2 = process(drinks, a, b, index+1, washLine);
		// 不选择洗的终止时间
		int p2 = Math.max(dry, next2);
		return Math.min(p1, p2);
	}
}
