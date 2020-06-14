package design_patterns.singleton;
/**
 * @author mengfh
 *
 * @version 2020-6-14下午1:15:49
 *
 * @description 双重检查锁
 */
public class SingletonThree {

	public static void main(String[] args) {
		System.out.println(SingletonThree.getSingleton() == SingletonThree.getSingleton());
	}
	
	private static volatile SingletonThree singleton = null;

	private SingletonThree(){}
	
	public static SingletonThree getSingleton(){
		if(singleton == null){
			synchronized(SingletonThree.class){  // 注意这里锁的是类.class，而不是this
				if (singleton == null) {         // this关键字必须放在非静态方法里面,因为this代表当前对象的引用，是对象级别的，static是类级别的
					singleton = new SingletonThree();				
					}
			}
		}
		return singleton;
	}
}
