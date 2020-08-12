package concurrency.artofconcurrency.chapter_four;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import concurrency.support.SleepUtils;

/**
 * @author mengfh
 *
 * @version 2020-5-23上午9:15:16
 *
 * @description 等待通知机制
 */
/**
 * 1）使用wait()、notify()和notifyAll()时需要先对调用对象加锁。
 * 
 * 2）调用wait()方法后，线程状态由RUNNING变为WAITING，并将当前线程放置到对象的 等待队列。
 * 
 * 3）notify()或notifyAll()方法调用后，等待线程依旧不会从wait()返回，
 * 需要调用notify()或notifAll()的线程释放锁之后，等待线程才有机会从wait()返回。
 * 
 * 4）notify()方法将等待队列中的一个等待线程从等待队列中移到同步队列中，而notifyAll()，
 * 方法则是将等待队列中所有的线程全部移到同步队列，被移动的线程状态由WAITING变为 BLOCKED。
 * 
 * 5）从wait()方法返回的前提是获得了调用对象的锁。
 * 
 * 等待通知机制可以用于代替suspend(),stop()
 * suspend()在调用后，线程不会释放已经占有的资源（比如锁），容易引发死锁问题。
 * stop()方法在终结一个线程时不会保证线程的资源正常释放
 * */
public class WaitNotify {

	static boolean flag = true;

	static Object lock = new Object();

	public static void main(String[] args) throws Exception {
		Thread waitThread = new Thread(new Wait(), "WaitThread");
		waitThread.start();
		TimeUnit.SECONDS.sleep(1);
		Thread notifyThread = new Thread(new Notify(), "NotifyThread");
		notifyThread.start();
	}

	static class Wait implements Runnable {
		public void run() {
			// 加锁，拥有lock的Monitor
			synchronized (lock) {     //断点打在synchronized上面就知道怎么跑的了                              
				// 当条件不满足时，继续wait，同时释放了lock的锁
				while (flag) {
					try {
						System.out.println(Thread.currentThread()
								+ " flag is true. wa@ "                  //1  3
								+ new SimpleDateFormat("HH:mm:ss")
										.format(new Date()));
						lock.wait();
					} catch (InterruptedException e) {
					}
				}
				// 条件满足时，完成工作
				System.out.println(Thread.currentThread()
						+ " flag is false. running@ "                   //4
						+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
			}
		}
	}

	static class Notify implements Runnable {
		public void run() {
			// 加锁，拥有lock的Monitor
			synchronized (lock) {
				// 获取lock的锁，然后进行通知，通知时不会释放lock的锁，
				// 直到当前线程释放了lock后，WaitThread才能从wait方法中返回
				System.out.println(Thread.currentThread()
						+ " hold lock. notify @ "                  //2
						+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
				lock.notifyAll();
				flag = false;
				SleepUtils.second(2);  //这里睡五秒不会释放锁，要等方法块执行完毕
			}
			// 再次加锁
			synchronized (lock) {
				System.out.println(Thread.currentThread()
						+ " hold lock again. sleep@ "                 //5
						+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
				SleepUtils.second(2);
			}
		}
	}
	
	// 超时等待
	public synchronized Object get(long mills) throws InterruptedException {
        long future = System.currentTimeMillis() + mills;  //超时时间
        long remaining = mills;
        Object result = "";
        // 当超时大于0并且result返回值不满足要求
        while ((result == null) && remaining > 0) {
               wait(remaining);              
               remaining = future - System.currentTimeMillis();  //超时时间 - 当前时间  < 0 则超时
        }
               return result;
	}

}