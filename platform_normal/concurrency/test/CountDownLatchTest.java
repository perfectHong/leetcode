package concurrency.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author mengfh
 * 
 * @version 2020-5-16下午1:49:13
 * 
 * @description 待优化
 */
public class CountDownLatchTest {

	private static int count = 0;

	// private static ThreadPoolExecutor executor = new ThreadPoolExecutor(0, 0,
	// 1, null, null);

	public static void main(String[] args) throws Exception {
		test1();
	}

	/** 按顺序执行，但这时有个问题sleep等待的时间还是有效率问题，可以用公平锁代替 */
	public static void test1() throws Exception {

	}

	/**
	 * 实现多个线程开始执行任务的最大并行性。 注意是并行性，不是并发，强调的是多个线程在某一时刻同时开始执行。 做法是初始化一个共享的
	 * CountDownLatch 对象，将其计数器初始化为 1 ：new CountDownLatch(1)， 多个线程在开始执行任务前首先
	 * coundownlatch.await()， 当主线程调用 countDown() 时，计数器变为0，多个线程同时被唤醒。
	 * */
	public static void test2() {
		final CountDownLatch latch = new CountDownLatch(1);
		for (int i = 0; i < 80; i++) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						latch.await();
						System.out.println(Thread.currentThread());
					} catch (InterruptedException e) {
					}
				}
			});
			t.start();
		}
		latch.countDown();
		System.out.println(count);
	}

}
