package jvm.classload;

/**
 * @author mengfh
 *
 * @description 
 *
 * @date 2020-10-15下午7:00:40
 */
public class Extends {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test();
	}
	/**
	 * 类A是不加载的，上次听了鑫哥的分享，找找代码实例来理解类加载机制
	 * 
	 * 数组和普通对象不一样，编译后，会多个L前缀
	 */
	private static void test() {
		A[] a = new A[1];
	}

}
