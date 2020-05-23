package concurrency.artofconcurrency.chapter_four;

import java.util.concurrent.TimeUnit;

/**
 * 可以看看join()的源码，涉及了等待/通知机制
 * 
 * 代码含义： 创建了10个线程，编号0~9，每个线程调用前一个线程的
 * join()方法，也就是线程0结束了，线程1才能从join()方法中返回，而线程0需要等待main线程结 束。
 * 
 * 很考察看代码的功底
 * */
public class Join {

	public static void main(String[] args) throws Exception {
		Thread previous = Thread.currentThread();
		for (int i = 0; i < 10; i++) {
			// 每个线程拥有前一个线程的引用，需要等待前一个线程终止，才能从等待中返回
			Thread thread = new Thread(new Domino(previous), String.valueOf(i));
			thread.start();            /** 重点 ： 你以为第一遍for循环断点就会去run()，其实不是，因为要等main()线程跑完后，也就是十遍for循环跑完直到输出mian terminate,才会去到run()**/
			previous = thread;
		}
		System.out.println(Thread.currentThread().getName() + " terminate.");  //这里上个断点，第一个输出
	}

	static class Domino implements Runnable {
		
		private Thread thread;

		public Domino(Thread thread) {
			this.thread = thread;
		}

		public void run() {
			try {
				thread.join();  //等待上一个线程执行结束
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName() + " terminate.");   //这里上个断点，陆续输出十次
		}
	}
}