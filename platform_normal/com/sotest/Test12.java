package com.sotest;

/**
 * @author mengfh
 *
 * @description 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。保证base和exponent不同时为0
 *
 * @date 2020-10-15上午9:10:23
 */
public class Test12 {

	/**
	 * @param 没别的，就是死要分正，负，零三种情况
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public double Power(double base, int exponent) {
		double r = 1.0;
		double s = 1.0;
		if (exponent > 0) {
			for (int i = 1; i <= exponent; i++) {
				r *= base;
			}
		} else if (exponent < 0) {
			for (int i = 1; i <= exponent; i++) {
				s *= base;
				r = 1.0 / s;
			}
		} else{
			return 1;
		}
		return r;
	}

}
