package com.sotest;

/**
 * @author mengfh
 *
 * @description 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @date 2020-10-15上午9:10:58
 */
public class Test13 {

	/**
	 * @param 这道题当时我自己一遍过了，第二遍能轻松的回忆起来吗
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public static void reOrderArray(int[] array) {
		
		int[] temp = new int[array.length];
		int ouindex = 0;
		int jiindex = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] % 2 != 1){
				temp[ouindex++] = array[i];
			}else{
				array[jiindex++] = array[i];
			}
		}
		for (int i = ouindex + 1; i < array.length; i++) {
			array[i] = temp[i-jiindex];
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
