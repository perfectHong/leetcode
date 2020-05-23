package concurrency.artofconcurrency.chapter_one;

/**
 * @author mengfh
 *
 * @version 2020-5-22上午9:15:16
 *
 * @description 线程切换,书上有实践
 */
/**
 * 每一次从WAITTING到RUNNABLE都会进行一次上下文的切换
 * 
 * 减少上下文切换实战 
 * 第一步：用jstack命令dump线程信息 
 * 第二步：统计所有线程分别处于什么状态，发现300多个线程处于WAITING状态。
 * 第三步：打开dump文件查看处于WAITING基本全是JBOSS的工作线程，在await。说明JBOSS线程池里线程接收到的任务太少，大量线程都闲着。
 * 第四步：减少JBOSS的工作线程数，找到JBOSS的线程池配置信息，将maxThreads降到100。
 * 第五步：重启JBOSS，再dump线程信息，然后统计WAITING（onobjectmonitor）的线程，发现减少了175个。
 * 
 * 下面代码不一定对，虽然是书上的，但测试好像不对劲
 * */
public class ConcurrencyTest {

	private static final long count = 10000000l;

	public static void main(String[] args) throws InterruptedException {
		concurrency();
		serial();
	}

	private static void concurrency() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread thread = new Thread(new Runnable() {  //对比书本，觉得不对，因为这里就一个线程啊
			@Override
			public void run() {
				int a = 0;
				for (long i = 0; i < count; i++) {
					a += 5;
				}
			}
		});
		thread.start();
		int b = 0;
		for (long i = 0; i < count; i++) {
			b--;
		}
		long time = System.currentTimeMillis() - start;
		thread.join();      //想一下，这里为什么要join(),因为要等a执行完毕
		System.out.println("concurrency :" + time + "ms,b=" + b);
	}

	private static void serial() {
		long start = System.currentTimeMillis();
		int a = 0;
		for (long i = 0; i < count; i++) {
			a += 5;
		}
		int b = 0;
		for (long i = 0; i < count; i++) {
			b--;
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
	}
}