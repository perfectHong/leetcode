package com.sotest;

/**
 * @author mengfh
 * 
 * @description  
 * ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�����
 * 
 * @date 2020-9-27����10:34:20
 */
public class Test1 {

	/**
	 * ˼·�������ǵ����ģ������Ͻǿ�ʼ�� ��һ�����������Ͻǣ����½ǣ����½ǿ�ʼ����
	 */
	public static void main(String[] args) {
		isHave1(null, 0);
		isHave2(null, 0);
	}

	private static boolean isHave1(int[][] arr, int target) {
		// ��ȡ�����������
		int row = arr.length;
		int col = arr[0].length;
		// ��ʼ��(i.j)Ϊ���Ͻ�λ��
		int i = 0;
		int j = col - 1;
		// �ж��Ƿ��������Сֵ֮��
		if (target >= arr[0][0] && target <= arr[row - 1][col - 1]) {
			// �����Ͻǿ�ʼ�ж�
			while (i >= 0 && i <= row - 1 && j >= 0 && j <= col - 1) {
				// ���������������
				if (target == arr[i][j])
					return true;
				// ���Ŀ������Ͻǵ�ֵС�����ų���һ��
				else if (target < arr[i][j])
					j--;
				// ���Ŀ������Ͻǵ�ֵ�����ų���һ��
				else
					i++;
			}
			return false;
		} else
			return false;
	}

	// �����ⷨ��ԭ����ά���������ôд
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
