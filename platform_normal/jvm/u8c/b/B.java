package jvm.u8c.b;

public class B {

	public static B t1 = new B();

	public static B t2 = new B();

	public B() {
		System.out.println("构造块");
	}

	static {
		System.out.println("静态块");
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		B t = new B();  //第一遍要进行类初始化，再产生对象
		B t2 = new B(); //第二遍只需要产生对象
	}
}