package algorithm.sort;

import java.util.Stack;

import vo.TreeNode;

/**
 * BubbleSort
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] list = { 27, 76, 47, 23, 7, 32, 19, 86 };
		System.out.println("************************");
		System.out.println("前：");
		display(list);
		System.out.println("后：");
		bubbleSort(list);
		display(list);
		System.out.println("************************");
		quickSort(list);
	}

	public static void display(int[] list) {
		if (list != null && list.length > 0) {
			for (int num : list) {
				System.out.print(num + " ");
			}
			System.out.println("");
		}
	}

	public static void dfs(TreeNode node) {
		if (node == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(node);
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
			if(node.right!=null)
				stack.push(node.right);
			if(node.left!=null)
				stack.push(node.left);
		}
	}
	
	public static void quickSort(int[] arr) {

		quickSort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	private static void quickSort(int[] arr, int left, int right) {

		if (left >= right)
			return;
		int i = left;
		int j = right;
		int temp = arr[left];
		while (i < j) {
			while (i < j && arr[j] > temp) {
				j--;
			}
			if (i < j)
				arr[i++] = arr[j];
			while (i < j && arr[i] < temp) {
				i++;
			}
			if (i > j)
				arr[j--] = arr[i];
		}
		arr[i] = temp;
		quickSort(arr, left, i - 1);
		quickSort(arr, i + 1, right);
	}

	public static void bubbleSort(int[] list) {
		int len = list.length;
		for (int i = 0; i < len - 1; i++) { // 做多少轮排序（最多length-1轮）
			for (int j = 0; j < len - 1 - i; j++) { // 每一轮比较多少个
				if (list[j] < list[j + 1]) {
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
			}
		}
	}
}