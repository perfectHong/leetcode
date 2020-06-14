package java_base.classload;

public class A extends B {
	// 静态变量
	static int i = 1;
	// 静态语句块
	static {
		System.out.println("Class A1:static blocks" + i);  //3
	}
	// 非静态变量
	int j = 1;
	// 静态语句块
	static {
		i++;
		System.out.println("Class A2:static blocks" + i);  //4
	}

	// 构造函数
	public A() {
		super();
		i++;
		j++;
		System.out.println("constructor A: " + "i=" + i + ",j=" + j);  //8
	}

	// 非静态语句块
	{
		i++;
		j++;
		System.out.println("Class A:common blocks" + "i=" + i + ",j=" + j);  //7
	}

	// 非静态方法
	public void aDisplay() {
		i++;
		System.out.println("Class A:static void aDisplay():	" + "i=" + i     //9
				+ ",j=" + j);
		return;
	}

	// 静态方法
	public static void aTest() {
		i++;
		System.out.println("Class A:static void aTest():	" + "i=" + i);
		return;
	}
}