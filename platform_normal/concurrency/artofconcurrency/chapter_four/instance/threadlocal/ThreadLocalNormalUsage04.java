package concurrency.artofconcurrency.chapter_four.instance.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1000个线程打印日期，用线程池来执行，出现线程安全问题
 */
public class ThreadLocalNormalUsage04 {

	public static ExecutorService threadPool = Executors.newFixedThreadPool(10);
	// 只创建一次 SimpleDateFormat 对象，避免不必要的资源消耗
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public static void main(String[] args) throws InterruptedException {
		// 提交任务
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
	 * 格式化代码是在最后一句return dateFormat.format(date);,所以可以为最后一句代码添加synchronized锁
	 * 
	 * 因为添加了synchronized，所以会保证同一时间只有一条线程可以执行，这在高并发场景下肯定不是一个好的选择
	 * */
	public String date(int seconds) {
		// 参数的单位是毫秒，从1970.1.1 00:00:00 GMT 开始计时
		Date date = new Date(1000 * seconds);
		String s;
		synchronized (ThreadLocalNormalUsage04.class) {
			s = dateFormat.format(date);
		}
		return s;
	}
}