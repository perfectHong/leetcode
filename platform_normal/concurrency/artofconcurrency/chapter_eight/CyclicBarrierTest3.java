package concurrency.artofconcurrency.chapter_eight;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

/**
 * isBroken()���������˽��������߳��Ƿ��ж�
 * 
 * reset()�������ü��� ���������߳�����ִ��һ��,����ûд��������
 * 
 * getNumberWaiting()���Ի��Cyclic-Barrier �������߳�����,����ûд��������
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