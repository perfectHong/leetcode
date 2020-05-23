package concurrency.artofconcurrency.chapter_four.instance.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * д�úã��ܿ����𣬶Ա���ConnectionPool,��������ʵ����ģ�ConnectionPool��û��ʵ�����
 * 
 * ��̬�����AOP
 * AOPּ��ͨ��һ������ϵķ�ʽ��Ϊ���������ǿ������̬��������AOPʵ�ַ�ʽ�е�һ��
 * */
public class JavaProxyTest {
	
	public static void main(String[] args) throws Exception {
		
		JavaProxyInterface javaProxyInterface = new ConcreteClass();  //�����ǽӿں�ʵ����

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
