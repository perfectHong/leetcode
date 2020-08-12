package java_base.reflect;

import java.lang.reflect.Constructor;

public class Fanshe {
	
	public static void main(String[] args) {

	}

	@SuppressWarnings("unused")
	private void getClazz() {
		// 第一种方式获取Class对象
		Test test1 = new Test();
		Class<? extends Test> test1Class = test1.getClass();
		System.out.println(test1Class.getName());

		// 第二种方式获取Class对象
		Class<? extends Test> test = Test.class;
		System.out.println(test1Class == test);

		// 第三种方式获取Class对象
		try {
			Class<?> testClass3 = Class.forName("fanshe.test");
			System.out.println(testClass3 == test);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void getInstance() throws Exception {
		//使用Class对象的newInstance()方法来创建Class对象对应类的实例
		Class<?> c = String.class;
		Object str = c.newInstance();
		//先通过Class对象获取指定的Constructor对象，再调用Constructor对象的newInstance()方法来创建对象
		Class<?> clazz = String.class;
		Constructor<?> constructor = c.getConstructor(String.class);
		Object obj = constructor.newInstance("hello reflection");
	}
	
}