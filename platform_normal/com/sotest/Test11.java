package com.sotest;

/**
 * @author mengfh
 * 
 * @description ����һ���������������32λ�����Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 * 
 * @date 2020-10-15����9:10:05
 */
public class Test11 {

	/**
	 * @param �Լ��������벹��ԭ��
	 */
	public static void main(String[] args) {

	}

	// n �� 0 ��ʱ��ܺ���⣬����ʵ��1�ĸ���������Ǹ���������Ҫ�����Ƿ��������Ϊ���뵽�����ʱ������ + 1���ڿ�ʼ��ʱ����Ҫ������ȥ
	// 1������������ԭ���� 0 �ĸ��� ���þ��ǲ����� 1 �ĸ��������������㡿

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
