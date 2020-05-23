package concurrency.artofconcurrency.chapter_four.instance.connectionpool;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 这里的各种await,countDown还不错，待深入理解
 * 
 * 动态代理和AOP
 * AOP旨在通过一种无耦合的方式来为程序带来增强。而动态代理，就是AOP实现方式中的一种
 * */
public class ConnectionPoolTest {
	
	// 创建连接池
	static ConnectionPool pool = new ConnectionPool(10);
	
	// 保证所有ConnectionRunner能够同时开始
	static CountDownLatch start = new CountDownLatch(1);
	
	// main线程将会等待所有ConnectionRunner结束后才能继续执行
	static CountDownLatch end;

	public static void main(String[] args) throws Exception {
		// 线程数量，可以修改线程数量进行观察
		int threadCount = 10;
		end = new CountDownLatch(threadCount);
		int count = 20;
		AtomicInteger got = new AtomicInteger();
		AtomicInteger notGot = new AtomicInteger();
		for (int i = 0; i < threadCount; i++) {
			Thread thread = new Thread(new ConnetionRunner(count, got, notGot),
					"ConnectionRunnerThread");
			thread.start();
		}
		start.countDown();
		end.await();
		System.out.println("total invoke: " + (threadCount * count));
		System.out.println("got connection:  " + got);
		System.out.println("not got connection " + notGot);
	}

	static class ConnetionRunner implements Runnable {
		int count;
		AtomicInteger got;
		AtomicInteger notGot;

		public ConnetionRunner(int count, AtomicInteger got,
				AtomicInteger notGot) {
			this.count = count;
			this.got = got;
			this.notGot = notGot;
		}

		public void run() {
			try {
				start.await();
			} catch (Exception ex) {
			}
			while (count > 0) {
				try {
					// 从线程池中获取连接，如果1000ms内无法获取到，将会返回null
					// 分别统计连接获取的数量got和未获取到的数量notGot
					Connection connection = pool.fetchConnection(1000);
					if (connection != null) {
						try {
							connection.createStatement();
							connection.commit();
						} finally {
							pool.releaseConnection(connection);
							got.incrementAndGet();
						}
					} else {
						notGot.incrementAndGet();
					}
				} catch (Exception ex) {
				} finally {
					count--;
				}
			}
			end.countDown();
		}
	}
}