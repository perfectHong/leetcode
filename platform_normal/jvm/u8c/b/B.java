package jvm.u8c.b;

public class B {

	public static B t1 = new B();

	public static B t2 = new B();

	public B() {
		System.out.println("�����");
	}

	static {
		System.out.println("��̬��");
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		B t = new B();  //��һ��Ҫ�������ʼ�����ٲ�������
		B t2 = new B(); //�ڶ���ֻ��Ҫ��������
	}
}