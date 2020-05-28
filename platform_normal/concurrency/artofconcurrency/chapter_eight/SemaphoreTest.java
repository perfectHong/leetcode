package concurrency.artofconcurrency.chapter_eight;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore（int permits）接受一个整型的数字，表示可用的许可证数量。Semaphore（10）表示允
 * 许10个线程获取许可证，也就是最大并发数是10。Semaphore的用法也很简单，首先线程使用
 * Semaphore的acquire()方法获取一个许可证，使用完之后调用release()方法归还许可证
 * */
public class SemaphoreTest {

	private static final int THREAD_COUNT = 30;

	private static ExecutorService threadPool = Executors
			.newFixedThreadPool(THREAD_COUNT);

	private static Semaphore s = new Semaphore(10);

	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i++) {
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						s.acquire();
						System.out.println("save data");
						s.release();
					} catch (InterruptedException e) {
					}
				}
			});
		}
		threadPool.shutdown();
	}
}