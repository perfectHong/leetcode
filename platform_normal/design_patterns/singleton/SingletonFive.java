package design_patterns.singleton;

import java.lang.reflect.Constructor;

/**
 * @author mengfh
 *
 * @version 2020-6-14下午2:06:43
 *
 * @description 枚举
 */
/**
 * 在《Effective Java》中提到，解决了多线程下的线程安全问题，并且不会被反射和序列化所破坏单例机制
 * 
 * 待续：
 * 
 * 
 * */
public enum SingletonFive {

	singleton;
	
	public static SingletonFive getInstance(){
		
        return singleton;
    }
	public static void main(String[] args) {
		Class clazz = SingletonFive.class;
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
