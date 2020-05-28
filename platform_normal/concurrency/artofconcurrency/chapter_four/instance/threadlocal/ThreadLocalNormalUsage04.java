package concurrency.artofconcurrency.chapter_four.instance.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1000���̴߳�ӡ���ڣ����̳߳���ִ�У������̰߳�ȫ����
 */
public class ThreadLocalNormalUsage04 {

	public static ExecutorService threadPool = Executors.newFixedThreadPool(10);
	// ֻ����һ�� SimpleDateFormat ���󣬱��ⲻ��Ҫ����Դ����
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public static void main(String[] args) throws InterruptedException {
		// �ύ����
		threadPool.submit(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					int finalI = i;
					String date = new ThreadLocalNormalUsage03().date(finalI);
					System.out.println(date);
				}
			}
		});
		threadPool.shutdown();
	}

	/**
	 * ��ʽ�������������һ��return dateFormat.format(date);,���Կ���Ϊ���һ��������synchronized��
	 * 
	 * ��Ϊ�����synchronized�����Իᱣ֤ͬһʱ��ֻ��һ���߳̿���ִ�У����ڸ߲��������¿϶�����һ���õ�ѡ��
	 * */
	public String date(int seconds) {
		// �����ĵ�λ�Ǻ��룬��1970.1.1 00:00:00 GMT ��ʼ��ʱ
		Date date = new Date(1000 * seconds);
		String s;
		synchronized (ThreadLocalNormalUsage04.class) {
			s = dateFormat.format(date);
		}
		return s;
	}
}