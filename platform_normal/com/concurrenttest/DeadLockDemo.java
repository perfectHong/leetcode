package com.concurrenttest;

/**
 * @author mengfh
 *
 * @version 2020-5-22上午9:15:16
 *
 * @description 死锁
 */
/**
 * 避免死锁的几个常见方法:
 * 1.避免一个线程同时获取多个锁。 
 * 2.避免一个线程在锁内同时占用多个资源，尽量保证每个锁只占用一个资源。
 * 3.尝试使用定时锁，使用lock.tryLock（timeout）来替代使用内部锁机制。
 * 4.对于数据库锁，加锁和解锁必须在一个数据库连接里，否则会出现解锁失败的情况。
 */
public class DeadLockDemo {
	
	private static String A = "A";
	private static String B = "B";

	public static void main(String[] args) {
		new DeadLockDemo().deadLock();
		new DeadLockDemo().deadLock2();
	}

	private void deadLock() {  //书上的
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (A) {         // 注意这两个同步块是内嵌的，满足了第二条：一个锁内同时占用多个资源
					try {
						Thread.currentThread();
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (B) {     // 获取到了A的锁后，想要获取B的锁，一直等待t2释放B的锁
						System.out.println("1");
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (B) {
					synchronized (A) {    // 获取到了B的锁后，想要获取A的锁，一直等待t1释放A的锁
						System.out.println("2");
					}
				}
			}
		});
		t1.start();
		t2.start();
	}
	
	private void deadLock2() {   //自己写的
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				synchronized (A) {
					System.out.println("t1拿到了A的锁");
					try {
						Thread.currentThread();
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(B){
						System.out.println("t1拿到了B的锁");
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				synchronized (B) {
					System.out.println("t2拿到了B的锁");
					synchronized(A){
						System.out.println("t2拿到了A的锁");
					}
				}
			}
		});
		t1.start();
		t2.start();
	}
}
