package concurrency.artofconcurrency.chapter_eight;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author mengfh
 * 
 * @version 2020-5-16����1:49:13
 * 
 * @description ����ִ��
 */
public class CountDownLatchTest2 {

	private static int count = 0;

	// private static ThreadPoolExecutor executor = new ThreadPoolExecutor(0, 0,
	// 1, null, null);

	public static void main(String[] args) throws Exception {
		test1();
	}

	/** ��˳��ִ�У�����ʱ�и�����sleep�ȴ���ʱ�仹����Ч�����⣬�����ù�ƽ������ */
	public static void test1() throws Exception {

	}

	/**
	 * ʵ�ֶ���߳̿�ʼִ�������������ԡ� ע���ǲ����ԣ����ǲ�����ǿ�����Ƕ���߳���ĳһʱ��ͬʱ��ʼִ�С� �����ǳ�ʼ��һ�������
	 * CountDownLatch ���󣬽����������ʼ��Ϊ 1 ��new CountDownLatch(1)�� ����߳��ڿ�ʼִ������ǰ����
	 * coundownlatch.await()�� �����̵߳��� countDown() ʱ����������Ϊ0������߳�ͬʱ�����ѡ�
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
