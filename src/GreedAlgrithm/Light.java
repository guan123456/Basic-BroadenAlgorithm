package GreedAlgrithm;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 23, 2021 6:24:01 PM
*/
public class Light {

	public static void main(String[] args) {
		
	}
	
	public static int minLight2(String road) {
		char[] str = road.toCharArray();
		int index = 0;
		int light = 0;
		while(index < str.length) {
			if(str[index] == 'X') {
				index++;
			}else {
				light++;
				if(index + 1 == str.length) {
					break;
				}else {
					if(str[index + 1] == 'X') {
						index = index + 2;
					}else {
						index = index + 3;
					}
				}
			}
		}
		return light;
	}
}
