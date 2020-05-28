package concurrency.artofconcurrency.chapter_eight;

/**
 * 顺序执行
 * 
 * join原理是不停检查join线程是否存活，如果join线程存活则让当前线程永远等待。其中，wait（0）表示永远等待下去
 * 
 * 直到join线程中止后，线程的this.notifyAll()方法会被调用，调用notifyAll()方法是在JVM里实现的，所以在JDK里看不到
 * */
public class CountDownLatchTest3 {

	public static void main(String[] args) throws InterruptedException {
		Thread parser1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("parser1 finish");
			}
		});
		Thread parser2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("parser2 finish");
			}
		});
		parser1.start();
		parser2.start();
		parser1.join();
		parser2.join();
		System.out.println("all parser finish");
	}
}