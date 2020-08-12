package design_patterns.singleton;

/**
 * @author mengfh
 *
 * @version 2020-6-14����1:30:11
 *
 * @description ��̬�ڲ���
 */
public class SingletonFour {

	/**
	 * ��̬�ڲ���ʵ�ֵ���Ϊʲô�߳��ǰ�ȫ�ģ�
	 * 
	 * (1)�߲�������£��������ǻ�Ӱ�����ִ�е�Ч�ʵģ���ʱ���þ�̬�ڲ���ķ�ʽ�������˫��У�����ķ�ʽ��ʵ�ֵ���
	 * 
	 * (2)�ⲿ�����ʱ������Ҫ���������ڲ��࣬�ڲ��಻��������ȥ��ʼ��INSTANCE���ʶ���ռ�ڴ�
	 * 
	 * (3)ͬһ���������£�һ������ֻ���ʼ��һ�Σ�ȥ���������ʱ��
	 * 
	 * (4)������ᱣ֤һ�����<clinit>()�����ڶ��̻߳����б���ȷ�ؼ�����ͬ����һ���߳�ִ��<clinit>()�����������̶߳�����
	 * */
	public static void main(String[] args) {
		SingletonFour s1 = SingletonFour.getSingleton();
		SingletonFour s2 = SingletonFour.getSingleton();
		System.out.println(s1 == s2);
	}
	
	private SingletonFour(){}
	
	private static class SubClass{
		private static SingletonFour singleton = new SingletonFour();//�����singletonֻ��ʼ��һ�Σ����Ը����뿴
	}
	
	public static SingletonFour getSingleton(){
		return SubClass.singleton;
	}
}
