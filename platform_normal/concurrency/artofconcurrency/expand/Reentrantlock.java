package concurrency.artofconcurrency.expand;


/**
 * 可重入锁的作用就是为了避免死锁，java中synchronized和ReentrantLock都是可重入锁
 * 
 * 当线程进入funcitonA(),functionB会获得该类的对象锁,当前线程可重入
 * */
public class Reentrantlock {
	
	public synchronized void functionA() {
		System.out.println("iAmFunctionA");
		functionB();
	}

	public synchronized void functionB() {
		System.out.println("iAmFunctionB");
	}
}