package concurrency.artofconcurrency.chapter_four.instance.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * 写得好，能看懂吗，对比于ConnectionPool,这里是有实现类的，ConnectionPool是没有实现类的
 * 
 * 动态代理和AOP
 * AOP旨在通过一种无耦合的方式来为程序带来增强。而动态代理，就是AOP实现方式中的一种
 * */
public class JavaProxyTest {
	
	public static void main(String[] args) throws Exception {
		
		JavaProxyInterface javaProxyInterface = new ConcreteClass();  //这里是接口和实现类

		JavaProxyInterface newJavaProxyInterface = (JavaProxyInterface) Proxy
				.newProxyInstance(JavaProxyTest.class.getClassLoader(),
						new Class[] { JavaProxyInterface.class },
						new MyInvocationHandler(javaProxyInterface));
		
		newJavaProxyInterface.gotoSchool();
		newJavaProxyInterface.gotoWork();
		newJavaProxyInterface.oneDayFinal();
		newJavaProxyInterface.oneDay();
	}
}
