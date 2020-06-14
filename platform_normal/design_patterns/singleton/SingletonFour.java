package design_patterns.singleton;

/**
 * @author mengfh
 *
 * @version 2020-6-14下午1:30:11
 *
 * @description 静态内部类
 */
public class SingletonFour {

	/**
	 * 静态内部类实现单例为什么线程是安全的：
	 * 
	 * (1)高并发情况下，加锁总是会影响程序执行的效率的，这时采用静态内部类的方式可以替代双重校验锁的方式来实现单例
	 * 
	 * (2)外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存
	 * 
	 * (3)同一个加载器下，一个类型只会初始化一次，去看看类加载时机
	 * 
	 * (4)虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确地加锁、同步，一个线程执行<clinit>()方法，其他线程都阻塞
	 * */
	public static void main(String[] args) {
		System.out.println(SingletonFour.getSingleton() == SingletonFour.getSingleton());
	}
	
	private SingletonFour(){
        if(SubClass.singleton != null){
            throw new RuntimeException("只能创建一次。");
        }
    }
	
	public static class SubClass{
		private static SingletonFour singleton = new SingletonFour();
	}
	
	public static SingletonFour getSingleton(){
		return SubClass.singleton;
	}
}
