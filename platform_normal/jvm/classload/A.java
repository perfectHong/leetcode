package jvm.classload;

public class A extends B {
	// ��̬����
	static int i = 1;
	// ��̬����
	static {
		System.out.println("Class A1:static blocks" + i);  //3
	}
	// �Ǿ�̬����
	int j = 1;
	// ��̬����
	static {
		i++;
		System.out.println("Class A2:static blocks" + i);  //4
	}

	// ���캯��
	public A() {
		super();
		i++;
		j++;
		System.out.println("constructor A: " + "i=" + i + ",j=" + j);  //8
	}

	// �Ǿ�̬����
	{
		i++;
		j++;
		System.out.println("Class A:common blocks" + "i=" + i + ",j=" + j);  //7
	}

	// �Ǿ�̬����
	public void aDisplay() {
		i++;
		System.out.println("Class A:static void aDisplay():	" + "i=" + i     //9
				+ ",j=" + j);
		return;
	}

	// ��̬����
	public static void aTest() {
		i++;
		System.out.println("Class A:static void aTest():	" + "i=" + i);
		return;
	}
}