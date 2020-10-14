package com.sotest;

/**
 * @author mengfh
 *
 * @description ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0����
 *
 * @date 2020-10-10����5:33:51
 */
public class Test7 {

	public static int Fibonacci(int n) {
		if (n == 0 || n == 1)
			return n;
		int fn1 = 0;
		int fn2 = 1;
		for (int i = 2; i <= n; i++) {
			fn2 += fn1;
			fn1 = fn2 - fn1;
		}
		return fn2;
	}

	private static int func(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return func(n - 1) + func(n - 2);

	}
	
	// f(n) = f(n-1) + f(n-2)
	public static void main(String[] args) {
		System.out.println(func(7));
		System.out.println(Fibonacci(7));
	}

}
