package design_patterns.singleton;

import java.lang.reflect.Constructor;

/**
 * @author mengfh
 *
 * @version 2020-6-14下午1:30:11
 *
 * @description 防反射攻击
 */
public class SingletonResolveOne {

	public static void main(String[] args) {
        Class<SingletonResolveOne> clazz = SingletonResolveOne.class;
        try {
            Constructor<SingletonResolveOne> c = clazz.getDeclaredConstructor();
            c.setAccessible(true);
            Object s1 = c.newInstance();
            Object s2 = c.newInstance();
            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
//		System.out.println(SingletonResolveOne.getSingleton() == SingletonResolveOne.getSingleton());
    }
	
	
	/**防反射攻击在这呢*/
	private SingletonResolveOne(){
        if(SubClass.singleton != null){
            throw new RuntimeException("只能创建一次。");
        }
    }
	
	public static class SubClass{
		private static SingletonResolveOne singleton = new SingletonResolveOne();
	}
	
	public static SingletonResolveOne getSingleton(){
		return SubClass.singleton;
	}
}
