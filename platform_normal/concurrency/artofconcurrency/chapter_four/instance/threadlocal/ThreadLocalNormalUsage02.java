package concurrency.artofconcurrency.chapter_four.instance.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1000���̴߳�ӡ���ڣ����̳߳���ִ��
 */
public class ThreadLocalNormalUsage02 {

	public static ExecutorService threadPool = Executors.newFixedThreadPool(10);

	public static void main(String[] args) throws InterruptedException {
		// �ύ����
		threadPool.submit(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					int finalI = i;
					String date = new ThreadLocalNormalUsage02().date(finalI);
					System.out.println(date);
				}
			}
		});
		threadPool.shutdown();
	}

	public String date(int seconds) {
		// �����ĵ�λ�Ǻ��룬��1970.1.1 00:00:00 GMT ��ʼ��ʱ
		Date date = new Date(1000 * seconds);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return dateFormat.format(date);
	}
}