package concurrency.artofconcurrency.chapter_nine;
/**
 * @author mengfh
 *
 * @version 2020-5-27上午9:33:17
 *
 * @description
 */
public class ThreadPool {

	public static void main(String[] args) {
		
		/**线程池的实现原理，execute()原理*/
		/*此处不好说，要配图理解，建议看书第九章*/
		
		/**向线程池提交任务*/
		/*execute()方法用于提交不需要返回值的任务，所以无法判断任务是否被线程池执行成功。*/
		/*submit()方法用于提交需要返回值的任务。线程池会返回一个future类型的对象，通过这个
		future对象可以判断任务是否执行成功，并且可以通过future的get()方法来获取返回值，get()方
		法会阻塞当前线程直到任务完成，而使用get（long timeout，TimeUnit unit）方法则会阻塞当前线
		程一段时间后立即返回，这时候有可能任务没有执行完。*/
		
		/**关闭线程池*/
		/*可以通过调用线程池的shutdown或shutdownNow方法来关闭线程池。它们的原理是遍历线
		程池中的工作线程，然后逐个调用线程的interrupt方法来中断线程，所以无法响应中断的任务
		可能永远无法终止。
		通常调用shutdown方法来关闭线程池，如果任务不一定要执行完，则可以调用shutdownNow方法。*/
		
		/**线程池的创建*/
		/*了解每个参数的含义
		ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
				milliseconds,runnableTaskQueue, handler);*/
	}
	
}
