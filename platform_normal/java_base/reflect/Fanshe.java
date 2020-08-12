package java_base.reflect;

import java.lang.reflect.Constructor;

public class Fanshe {
	
	public static void main(String[] args) {

	}

	@SuppressWarnings("unused")
	private void getClazz() {
		// ��һ�ַ�ʽ��ȡClass����
		Test test1 = new Test();
		Class<? extends Test> test1Class = test1.getClass();
		System.out.println(test1Class.getName());

		// �ڶ��ַ�ʽ��ȡClass����
		Class<? extends Test> test = Test.class;
		System.out.println(test1Class == test);

		// �����ַ�ʽ��ȡClass����
		try {
			Class<?> testClass3 = Class.forName("fanshe.test");
			System.out.println(testClass3 == test);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void getInstance() throws Exception {
		//ʹ��Class�����newInstance()����������Class�����Ӧ���ʵ��
		Class<?> c = String.class;
		Object str = c.newInstance();
		//��ͨ��Class�����ȡָ����Constructor�����ٵ���Constructor�����newInstance()��������������
		Class<?> clazz = String.class;
		Constructor<?> constructor = c.getConstructor(String.class);
		Object obj = constructor.newInstance("hello reflection");
	}
	
}