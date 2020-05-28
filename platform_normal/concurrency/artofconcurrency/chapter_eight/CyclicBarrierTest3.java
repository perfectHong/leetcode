package concurrency.artofconcurrency.chapter_eight;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

/**
 * isBroken()方法用来了解阻塞的线程是否被中断
 * 
 * reset()可以重置计数 器，并让线程重新执行一次,这里没写，理解就行
 * 
 * getNumberWaiting()可以获得Cyclic-Barrier 阻塞的线程数量,这里没写，理解就行
 * */
public class CyclicBarrierTest3 {

	static CyclicBarrier c = new CyclicBarrier(2);

	public static void main(String[] args) throws InterruptedException,
			BrokenBarrierException {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					c.await();
				} catch (Exception e) {
				}
			}
		});
		thread.start();
		thread.interrupt();
		try {
			c.await();
		} catch (Exception e) {
			System.out.println(c.isBroken());
		}
	}
}