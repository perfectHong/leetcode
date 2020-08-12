package algorithm.select;

/**
 * @author mengfh
 * 
 * @version 2020-6-16下午2:47:47
 * 
 * @description 二分查找
 */
public class BanirySearch {

	public static void main(String[] args) {
		int t = search(new int[] { 13, 23, 45, 55, 68, 98, 555, 2341 }, 98);
		System.out.println(t);
	}
	/**迭代 start*/
	private static int search(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == target)
				return mid;
			if (arr[mid] > target)
				right = mid;
			if (arr[mid] < target)
				left = mid;
		}
		return -1;
	}
	/**迭代 end*/
	
	/**递归 start : 注意要将初始的start,end,arr抽出来*/
	public static void searchByDigui(String[] args) {
		int a[] = { 3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81, 95, 101 };
		int target = 81;
		int start = 0;
		int end = a.length - 1;
		int result = search(start, end, target, a);
		System.out.println(a[result]);
	}
	public static int search(int start, int end, int target, int a[]) {
		if (start <= end) {
			int mid = (start + end) / 2;
			if (a[mid] == target) {
				return mid;
			} else if (target > a[mid]) {
				return search(mid + 1, end, target, a);
			} else if (target < a[mid]) {
				return search(start, mid - 1, target, a);
			}
		}
		return -1;
	}
	/**递归 end*/
}
