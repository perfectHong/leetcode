package com.sotest;

/**
 * @author mengfh
 * 
 * @description 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * 
 * @date 2020-10-15上午9:10:05
 */
public class Test11 {

	/**
	 * @param 自己看看反码补码原码
	 */
	public static void main(String[] args) {

	}

	// n ≥ 0 的时候很好理解，就是实际1的个数，如果是负数首先需要考虑是否溢出，因为反码到补码的时候我们 + 1，在开始的时候需要给他减去
	// 1，这样反过来原码中 0 的个数 正好就是补码中 1 的个数【与或异或运算】

	public static int NumberOf1(int n) {
		if (n >= 0) {
			String num = Integer.toBinaryString(n);
			return num.length() - num.replaceAll("1", "").length();
		} else {
			String num = Integer.toBinaryString(0 - n - 1);
			if (num.length() >= 32) {
				return 1;
			}
			return (32 - num.length()) + num.length()
					- num.replaceAll("0", "").length();
		}
	}

}
