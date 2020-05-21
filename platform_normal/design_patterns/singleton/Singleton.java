package design_patterns.singleton;

/**
 * @author mengfh
 * 
 * @version 2020-4-21上午8:48:22
 * 
 * @description
 */
public class Singleton {

	/**缺点：单例模式没有接口，如果要扩展就必须修改源码，这样就违反了开闭原则。*/
	public static void main(String[] args) {
		Singleton s = new Singleton();
		System.out.println();
	}

	/** volatile,禁止指令重排序 */
	private volatile static Singleton instance;

	/** 私有构造器，不可少 */
//	private Singleton() {
//	}
	

	/**
	 * 反射攻击可以通过setAccessible()方法将私有的构造方法公共化，进而实例化,这样写可以防止反射攻击
	 * */
	private Singleton(){
        if(instance != null){
            throw new RuntimeException("只能创建一次。");
        }
    }

	private static class SingletonHolder {
		private static Singleton instance = new Singleton();
	}

	/** 静态内部类实现单例 */
	public static Singleton getInstance4() {
		return SingletonHolder.instance;
	}

	/**
	 * 如果没有禁止指令重排序，当A线程执行第四行时，
	 * 
	 * 实际上可能只是1.分配了内存，3.设置instance指向了内存空间，却没有2.初始化对象
	 * 
	 * B线程访问到第一行，看到了不为null的instance,从第8行返回一个没有初始化的instance
	 * */
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
	 *反序列化问题https://www.cnblogs.com/happy4java/p/11206105.html
	 * 
	 * Singleton如果实现了Serializable接口，那么在每次序列化时都会创建一个新对象，若要保证单例，
	 * 
	 * 必须声明所有字段都是transient的，或者重写readResolve,直接返回当前instanceZ即可
	 * */
	private Object readResolve() {
        return this.instance;
    }
	
	/**
	 * 枚举实现的单例在面对 复杂的序列化及反射攻击时，依然能够保持自己的单例状态，所以被认为是单例的最佳实践。
	 * 
	 * 枚举特性，在JVM层面实现，来帮我们保证线程安全和单例
	 * 
	 * 比如，mybatis在定义SQL命令类型时就使用到了枚举。
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
