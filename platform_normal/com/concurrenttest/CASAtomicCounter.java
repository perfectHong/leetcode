package com.concurrenttest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mengfh
 * 
 * @version 2020-5-22下午12:58:48
 * 
 * @description CAS实现线程安全
 */
public class CASAtomicCounter {

	private AtomicInteger atomicI = new AtomicInteger(0);
	
	private int i = 0;

	public static void main(String[] args) {
		final CASAtomicCounter cas = new CASAtomicCounter();
		List<Thread> ts = new ArrayList<Thread>(600);  //注意这里借助到了arraylist装载thread
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
		// 等待所有线程执行完成
		for (Thread t : ts) {
			try {
				t.join();  //因为t是个若干个小线程所以要循环join
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(cas.i);
		System.out.println(cas.atomicI.get());
		System.out.println(System.currentTimeMillis() - start);
	}

	/** 使用CAS实现线程安全计数器 */
	private void safeCount() {
		for (;;) {
			int i = atomicI.get();
			boolean suc = atomicI.compareAndSet(i, ++i);
			if (suc) {
				break;
			}
		}
	}

	/** 非线程安全计数器*/
	private void count() {
		i++;
	}
}
