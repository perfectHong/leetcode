package concurrency.artofconcurrency.chapter_four;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import concurrency.support.SleepUtils;

/**
 * @author mengfh
 *
 * @version 2020-5-23����9:15:16
 *
 * @description �ȴ�֪ͨ����
 */
/**
 * 1��ʹ��wait()��notify()��notifyAll()ʱ��Ҫ�ȶԵ��ö��������
 * 
 * 2������wait()�������߳�״̬��RUNNING��ΪWAITING��������ǰ�̷߳��õ������ �ȴ����С�
 * 
 * 3��notify()��notifyAll()�������ú󣬵ȴ��߳����ɲ����wait()���أ�
 * ��Ҫ����notify()��notifAll()���߳��ͷ���֮�󣬵ȴ��̲߳��л����wait()���ء�
 * 
 * 4��notify()�������ȴ������е�һ���ȴ��̴߳ӵȴ��������Ƶ�ͬ�������У���notifyAll()��
 * �������ǽ��ȴ����������е��߳�ȫ���Ƶ�ͬ�����У����ƶ����߳�״̬��WAITING��Ϊ BLOCKED��
 * 
 * 5����wait()�������ص�ǰ���ǻ���˵��ö��������
 * 
 * �ȴ�֪ͨ���ƿ������ڴ���suspend(),stop()
 * suspend()�ڵ��ú��̲߳����ͷ��Ѿ�ռ�е���Դ���������������������������⡣
 * top()�������ս�һ���߳�ʱ���ᱣ֤�̵߳���Դ�����ͷ�
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
			// ������ӵ��lock��Monitor
			synchronized (lock) {
				// ������������ʱ������wait��ͬʱ�ͷ���lock����
				while (flag) {
					try {
						System.out.println(Thread.currentThread()
								+ " flag is true. wa@ "
								+ new SimpleDateFormat("HH:mm:ss")
										.format(new Date()));
						lock.wait();
					} catch (InterruptedException e) {
					}
				}
				// ��������ʱ����ɹ���
				System.out.println(Thread.currentThread()
						+ " flag is false. running@ "
						+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
			}
		}
	}

	static class Notify implements Runnable {
		public void run() {
			// ������ӵ��lock��Monitor
			synchronized (lock) {
				// ��ȡlock������Ȼ�����֪ͨ��֪ͨʱ�����ͷ�lock������
				// ֱ����ǰ�߳��ͷ���lock��WaitThread���ܴ�wait�����з���
				System.out.println(Thread.currentThread()
						+ " hold lock. notify @ "
						+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
				lock.notifyAll();
				flag = false;
				SleepUtils.second(5);
			}
			// �ٴμ���
			synchronized (lock) {
				System.out.println(Thread.currentThread()
						+ " hold lock again. sleep@ "
						+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
				SleepUtils.second(5);
			}
		}
	}
	
	// ��ʱ�ȴ�
	public synchronized Object get(long mills) throws InterruptedException {
        long future = System.currentTimeMillis() + mills;  //��ʱʱ��
        long remaining = mills;
        Object result = "";
        // ����ʱ����0����result����ֵ������Ҫ��
        while ((result == null) && remaining > 0) {
               wait(remaining);              
               remaining = future - System.currentTimeMillis();  //��ʱʱ�� - ��ǰʱ��  < 0 ��ʱ
        }
               return result;
	}

}