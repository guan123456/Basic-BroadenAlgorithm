package SortAlgrithm;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 20, 2021 12:36:03 PM
*/
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//时间复杂度O(NlogN)，相比于O(N^2)的排序，它没有浪费比较行为
	//比如选择排序，每一次比较只确定了一个数的，而归并排序比较可以确定两个数或更多数
	public static void mergeSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		process(arr, 0, arr.length-1);
	}
	//T(N)=2*T(N/2)+O(N) ==>log2^2==1(d) ==>O(N^d *logN) ==>O(NlogN)
	public static void process(int[] arr,int left, int right) {
		if(left == right) {
			return;
		}
		int mid = left + ((right - left) >> 1);
		process(arr, left, mid);
		process(arr, mid+1, right);
		merge(arr,left,mid,right);
	}
	
	//归并的非递归实现O(NlogN)
	public static void process_1(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		int N = arr.length;
		int mergeSize = 1;//当前有序的，左组长度的
		while(mergeSize < N) {
			int left = 0;
			while(left < N) {
				//left...mid  左组(mergeSize)
				//获取左组的终点mid的下标
				int mid = left + mergeSize - 1;
				if(mid >= N) {
					break;
				}
				//mid+1...right(mergeSize)
				//获取右组的终点right的下标
				int right = Math.min(mid+mergeSize, N-1);
				merge(arr, left, mid, right);
				left = right + 1;
			}
			//这样的好处就是防止数值*2刚好越界了出现溢出错误
			if(mergeSize > N / 2) {
				break;
			}
			//每次乘2
			mergeSize <<= 1;
		}
	}
	//O(N)
	public static void merge(int[] arr, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		int i = 0;
		int p1 = left;
		int p2 = mid + 1;
		while(p1 <= mid && p2 <= right) {
			//这一步可以保证稳定性
			//先赋值，然后i++，和p1++或p2++
			temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
		}
		//p2越界，拷贝p1剩余的
		while(p1 <= mid) {
			temp[i++] = arr[p1++];
		}
		//p1越界，拷贝p2剩余的
		while(p2 <= right) {
			temp[i++] = arr[p2++];
		}
		for(int j = 0; j < temp.length; j++) {
			arr[left+j] = temp[j];
		}
	}
	
	//小和问题，数组中的顺序对
	public static int smallSum(int[] arr) {
		if(arr == null || arr.length < 2) {
			return 0;
		}
		return process_2(arr,0,arr.length - 1);
	}
	public static int process_2(int[] arr, int left ,int right) {
		if(left == right) {
			return 0;
		}
		int mid = left + ((right - left) >> 1);
		//左边+右边+整体的
		return process_2(arr,left,mid)+process_2(arr, mid+1, right)+mergeCount(arr, left, mid, right);
	}
	//求小和数和
	public static int mergeCount(int[] arr, int left, int mid ,int right) {
		int[] temp = new int[right-left+1];
		int i = 0;
		int p1 = left;
		int p2 = mid + 1;
		int res = 0;
		while(p1 <= mid && p2 <= right) {
			//每一个数左边比当前数小的数累加起来，叫做这个数组的小和
			//这里arr[p1]比右边的数小的个数总数(right-pp2+1)
			res += arr[p1] > arr[p2] ? (mid-p1+1): 0;
			//只有左边的数小于右边的才拷贝左边的，除此之外都拷贝右边的
			temp[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
		}
		while(p1 <= mid) {
			temp[i++] = arr[p1++];
		}
		while(p2 <= right) {
			temp[i++] = arr[p2++];
		}
		for(int j = 0; j < temp.length; j++) {
			arr[left+j] = temp[j];
		}
		return res;
	}
	
	//求逆序对!!!
	public static int mergeCount_1(int[] arr, int left, int mid ,int right) {
		int[] temp = new int[right-left+1];
		int i = 0;
		int p1 = left;
		int p2 = mid + 1;
		int res = 0;
		while(p1 <= mid && p2 <= right) {
			//每一个数左边比当前数小的数累加起来，叫做这个数组的小和
			//这里arr[p1]比右边的数小的个数总数(right-pp2+1)
			res += arr[p1] < arr[p2] ? (right-p2+1) * arr[p1] : 0;
			//只有左边的数小于右边的才拷贝左边的，除此之外都拷贝右边的
			temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while(p1 <= mid) {
			temp[i++] = arr[p1++];
		}
		while(p2 <= right) {
			temp[i++] = arr[p2++];
		}
		for(int j = 0; j < temp.length; j++) {
			arr[left+j] = temp[j];
		}
		return res;
	}
}
