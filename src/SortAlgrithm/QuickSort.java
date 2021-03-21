package SortAlgrithm;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 20, 2021 3:40:22 PM
*/
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void quickSort(int[] array,int start, int end) {
		if(start < end) {
			int pivotpos = partition_1(array, start, end);
			quickSort(array, start, pivotpos - 1);
			quickSort(array, pivotpos + 1, end);
		}
	}
	private static int partition_1(int[] arr, int start, int end) {
		int pivot = arr[start];
		while(start < end) {
			while(start < end && arr[end] >= pivot) {
				end--;
			}
			arr[start] = arr[end];
			while(start < end && arr[start] <= pivot) {
				start++;
			}
			arr[end] = arr[start];
		}
		arr[start] = pivot;
		return start;
	}
	private static int partition(int[] arr, int start, int end) {
		int pivotKey = arr[start];
		while(start < end) {
			while(start < end && arr[end] >= pivotKey) {
				end--;
			}
			swap(arr,start,end);
			while(start < end && arr[start] <= pivotKey) {
				start++;
			}
			swap(arr,start,end);
		}
		return start;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
