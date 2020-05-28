package concurrency.artofconcurrency.chapter_eight;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore��int permits������һ�����͵����֣���ʾ���õ����֤������Semaphore��10����ʾ��
 * ��10���̻߳�ȡ���֤��Ҳ������󲢷�����10��Semaphore���÷�Ҳ�ܼ򵥣������߳�ʹ��
 * Semaphore��acquire()������ȡһ�����֤��ʹ����֮�����release()�����黹���֤
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