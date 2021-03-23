package Tree;

import java.util.ArrayList;
import java.util.List;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 22, 2021 8:13:05 PM
*/
public class MaxHappy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class Employee{
		public int happy;
		public List<Employee> nexts;
		public Employee(int h) {
			happy = h;
			nexts = new ArrayList<>();
		}
	}
	
	public static class Info{
		public int yes;
		public int no;
		public Info(int y, int n) {
			yes = y;
			no = n;
		}
	}
	
	public static Info process(Employee x) {
		if(x.nexts.isEmpty()) {
			return new Info(x.happy,0);
		}
		int yes = x.happy;
		int no = 0;
		for(Employee next : x.nexts) {
			Info nextInfo = process(next);
			yes += nextInfo.no;
			no += Math.max(nextInfo.yes, nextInfo.no);
		}
		return new Info(yes, no);
	}
}
