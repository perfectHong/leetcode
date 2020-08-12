package design_patterns.singleton;

import java.lang.reflect.Constructor;

/**
 * @author mengfh
 *
 * @version 2020-6-14����2:06:43
 *
 * @description ö��
 */
/**
 * �ڡ�Effective Java�����ᵽ������˶��߳��µ��̰߳�ȫ���⣬���Ҳ��ᱻ��������л����ƻ���������
 * 
 * ������
 * 
 * 
 * */
public enum SingletonFive {

	singleton;
	
	public static void main(String[] args) {
		Class<SingletonFive> clazz = SingletonFive.class;
		 try {
	            Constructor<SingletonFive> c = clazz.getDeclaredConstructor();
	            c.setAccessible(true);
	            Object s1 = c.newInstance();
	            Object s2 = c.newInstance();
	            System.out.println(s1 == s2);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}
