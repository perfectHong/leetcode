package jvm.classload;

public class B {
	// 静态变量
	static int i = 1;
	// 静态语句块
	static {
		System.out.println("Class B1:static blocks" + i);   //1
	}
	// 非静态变量
	int j = 1;
	// 静态语句块
	static {
		i++;
		System.out.println("Class B2:static blocks" + i);  //2
	}

	// 构造函数
	public B() {
		i++;
		j++;
		System.out.println("constructor B: " + "i=" + i + ",j=" + j);  //6
	}

	// 非静态语句块
	{
		i++;
		j++;
		System.out.println("Class B:common blocks" + "i=" + i + ",j=" + j);  //5，调用其父类B的构造函数前,依次先调用父类B中的非静态变量及非静态语句块,因为要做初始化
	}

	// 非静态方法
	public void bDisplay() {
		i++;
		System.out.println("Class B:static void bDisplay():	" + "i=" + i
				+ ",j=" + j);
		return;
	}

	// 静态方法
	public static void bTest() {
		i++;
		System.out.println("Class B:static void bTest():	" + "i=" + i);
		return;
	}
}