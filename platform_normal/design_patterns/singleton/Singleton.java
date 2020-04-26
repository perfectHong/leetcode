package design_patterns.singleton;

/**
 * @author mengfh
 * 
 * @version 2020-4-21����8:48:22
 * 
 * @description
 */
public class Singleton {

	public static void main(String[] args) {
		Singleton s = new Singleton();
		System.out.println();
	}

	/** volatile,��ָֹ�������� */
	private volatile static Singleton instance;

	/** ˽�й������������� */
	private Singleton() {
	}

	private static class SingletonHolder {
		private static Singleton instance = new Singleton();
	}

	/** ��̬�ڲ���ʵ�ֵ��� */
	public static Singleton getInstance4() {
		return SingletonHolder.instance;
	}

	/**
	 * ���û�н�ָֹ�������򣬵�A�߳�ִ�е�����ʱ��
	 * 
	 * ʵ���Ͽ���ֻ��1.�������ڴ棬3.����instanceָ�����ڴ�ռ䣬ȴû��2.��ʼ������
	 * 
	 * B�̷߳��ʵ���һ�У������˲�Ϊnull��instance,�ӵ�8�з���һ��û�г�ʼ����instance
	 * */
	/**
	 * ���乥�����⣬�����л�����https://www.cnblogs.com/happy4java/p/11206105.html
	 * 
	 * Singleton���ʵ����Serializable�ӿڣ���ô��ÿ�����л�ʱ���ᴴ��һ���¶�����Ҫ��֤������
	 * �������������ֶζ���transient��
	 * 
	 * ���乥������ͨ��setAccessible()������˽�еĹ��췽��������������ʵ������
	 * */
	// �������ڵ��������������ӳٳ�ʼ��
	public static Singleton getInstance3() {
		if (instance == null) { // 1
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton(); // 4
				}
			}
		}
		return instance; // 8
	}

	/**
	 * ö��ʵ�ֵĵ�������� ���ӵ����л������乥��ʱ����Ȼ�ܹ������Լ��ĵ���״̬�����Ա���Ϊ�ǵ��������ʵ����
	 * 
	 * ö�����ԣ���JVM����ʵ�֣��������Ǳ�֤�̰߳�ȫ�͵���
	 * 
	 * ���磬mybatis�ڶ���SQL��������ʱ��ʹ�õ���ö�١�
	 * 
	 * https://blog.csdn.net/javazejian/article/details/71333103?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-7&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-7
	 * 
	 * */
	public enum SqlCommandType {
		
		UNKNOWN, INSERT, UPDATE, DELETE, SELECT, FLUSH;
		
		public void doSomething() {
			System.out.println("doSomething");
		}

		public static void main(String[] args) {
			SqlCommandType.UNKNOWN.doSomething();
		}
	}
}
