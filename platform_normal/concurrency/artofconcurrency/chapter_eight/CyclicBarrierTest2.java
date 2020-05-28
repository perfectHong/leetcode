package concurrency.artofconcurrency.chapter_eight;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier（int parties，Runnable
 * barrier-Action），用于在线程到达屏障时，优先执行barrierAction，方便处理更复杂的业务场景
 * 
 * 因为CyclicBarrier设置了拦截线程的数量是2，所以必须等代码中的第一个线程和线程A都执行完之后，才会继续执行主线程
 * */
public class CyclicBarrierTest2 {

	static CyclicBarrier c = new CyclicBarrier(2, new A());

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					c.await();
				} catch (Exception e) {
				}
				System.out.println(1);
			}
		}).start();
		try {
			c.await();
		} catch (Exception e) {
		}
		System.out.println(2);
	}

	static class A implements Runnable {
		@Override
		public void run() {
			System.out.println(3);
		}
	}
}