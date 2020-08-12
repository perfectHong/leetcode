package concurrency.artofconcurrency.chapter_eight;

import java.util.concurrent.CountDownLatch;

/**
 * ˳��ִ��
 * 
 * �����ǵ���CountDownLatch��countDown����ʱ��N�ͻ��1��CountDownLatch��await���� ��������ǰ�̣߳�ֱ��N����㡣
 */
public class CountDownLatchTest1 {

	static CountDownLatch c = new CountDownLatch(3);
	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(1);
				c.countDown();
				try {
					Thread.currentThread();
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(2);
				c.countDown();
			}
		}).start();
		c.countDown();
		c.await();
		System.out.println("3");
	}
}