package jvm.u8c.single;

public class Signle {

	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		System.out.println("Singleton1 value1:" + singleton.value1);
		System.out.println("Singleton1 value2:" + singleton.value2);
		
		Singleton2 singleton2 = Singleton2.getInstance2();
		System.out.println("Singleton2 value1:" + singleton2.value1);
		System.out.println("Singleton2 value2:" + singleton2.value2);

	}

}
