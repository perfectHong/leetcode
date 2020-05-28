package concurrency.artofconcurrency.chapter_ten;

/**
 * @author mengfh
 *
 * @version 2020-5-27下午12:46:59
 *
 * @description 理论东西较多，没什么代码，多看看书第十章
 */

/**
 * 重点有：　Executor框架的两级调度模型VM和OS层面的理解
 * 
 * Executor结构，各种ThreadPoolExecutor等等
 * */
public class ExecutorTest {

	/**
	 * Executor框架的两级调度模型概念
	 * 
	 * 在HotSpot VM的线程模型中，Java线程被一对一映射为本地操作系统线
	 * 程。Java线程启动时会创建一个本地操作系统线程；当该Java线程终止时，这个操作系统线程
	 * 也会被回收。操作系统会调度所有线程并将它们分配给可用的CPU。
	 * 
	 * 在上层，Java多线程程序通常把应用分解为若干个任务，然后使用用户级的调度器
	 * （Executor框架）将这些任务映射为固定数量的线程；在底层，操作系统内核将这些线程映射到 硬件处理器上。
	 * 
	 * 应用程序通过Executor框架控制上层的调度；而下层的调度由操作系统 内核控制，下层的调度不受应用程序的控制。
	 * */

	/**
	 * Executor框架主要由3大部分组成
	 * 
	 * 任务。包括被执行任务需要实现的接口：Runnable接口或Callable接口。
	 * 
	 * 任务的执行。包括任务执行机制的核心接口Executor，以及继承自Executor的
	 * ExecutorService接口。Executor框架有两个关键类实现了ExecutorService接口
	 * （ThreadPoolExecutor和ScheduledThreadPoolExecutor）。
	 * 
	 * 异步计算的结果。包括接口Future和实现Future接口的FutureTask类。
	 * */
	public static void main(String[] args) {

	}

}
