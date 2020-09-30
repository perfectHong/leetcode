package com.sotest;

/**
 * @author mengfh
 * 
 * @description  
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * 
 * @date 2020-9-27上午10:34:20
 */
public class Test1 {

	/**
	 * 思路：数组是递增的，从右上角开始找 举一反三：从左上角，左下角，右下角开始找呢
	 */
	public static void main(String[] args) {
		isHave1(null, 0);
		isHave2(null, 0);
	}

	private static boolean isHave1(int[][] arr, int target) {
		// 获取数组的行列数
		int row = arr.length;
		int col = arr[0].length;
		// 初始化(i.j)为右上角位置
		int i = 0;
		int j = col - 1;
		// 判断是否在最大最小值之间
		if (target >= arr[0][0] && target <= arr[row - 1][col - 1]) {
			// 从右上角开始判断
			while (i >= 0 && i <= row - 1 && j >= 0 && j <= col - 1) {
				// 如果相等则结束查找
				if (target == arr[i][j])
					return true;
				// 如果目标比右上角的值小，则排除这一列
				else if (target < arr[i][j])
					j--;
				// 如果目标比右上角的值大，则排除这一行
				else
					i++;
			}
			return false;
		} else
			return false;
	}

	// 暴力解法，原来二维数组可以这么写
	private static boolean isHave2(int[][] arr, int target) {
		for (int[] arr1 : arr) {
			for (int i : arr1) {
				if (target == i)
					return true;
			}
		}
		return false;
	}
}
