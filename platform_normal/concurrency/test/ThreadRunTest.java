package concurrency.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author mengfh
 * 
 * @version 2020-5-21����10:03:07
 * 
 * @description
 */
public class ThreadRunTest {

	private static ThreadPoolExecutor executor  = new ThreadPoolExecutor(0, 0, 1, null, null);
	
	public static void main(String[] args) {

	}

	public void startKafkaQueue(long seckillId) {
		for (int i = 0; i < 1000; i++) {
			Runnable task1 = new Runnable() {  /**ע��������д�������ԣ���ʵ����Runnable*/
				@Override
				public void run() {
					System.out.println("task1");
				}
			};
			Thread task2 = new Thread() {
				@Override
				public void run() {
					System.out.println("task2");
				}
			};
			Thread task3 = new Thread(new Runnable(){
				@Override
				public void run() {
					System.out.println("task3");
				}
			});
			executor.execute(task1);
			executor.execute(task2);
			task3.start();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
	}

}
