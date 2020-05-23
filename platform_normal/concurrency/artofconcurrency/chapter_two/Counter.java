package concurrency.artofconcurrency.chapter_two;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mengfh
 * 
 * @version 2020-5-22����12:58:48
 * 
 * @description CASʵ���̰߳�ȫ
 */
public class Counter {

	private AtomicInteger atomicI = new AtomicInteger(0);
	
	private int i = 0;

	public static void main(String[] args) {
		final Counter cas = new Counter();
		List<Thread> ts = new ArrayList<Thread>(600);  //ע�������������arraylistװ��thread
		long start = System.currentTimeMillis();
		for (int j = 0; j < 100; j++) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10000; i++) {
						cas.count();
						cas.safeCount();
					}
				}
			});
			ts.add(t);
		}
		for (Thread t : ts) {
			t.start();
		}
		// �ȴ������߳�ִ�����
		for (Thread t : ts) {
			try {
				t.join();  //��Ϊt�Ǹ����ɸ�С�߳�����Ҫѭ��join
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(cas.i);
		System.out.println(cas.atomicI.get());
		System.out.println(System.currentTimeMillis() - start);
	}

	/** ʹ��CASʵ���̰߳�ȫ������ */
	private void safeCount() {
		for (;;) {
			int i = atomicI.get();
			boolean suc = atomicI.compareAndSet(i, ++i);
			if (suc) {
				break;
			}
		}
	}

	/** ���̰߳�ȫ������*/
	private void count() {
		i++;
	}
}
