package com.sotest;

/**
 * @author mengfh
 *
 * @description ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η�����֤base��exponent��ͬʱΪ0
 *
 * @date 2020-10-15����9:10:23
 */
public class Test12 {

	/**
	 * @param û��ģ�������Ҫ�������������������
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
