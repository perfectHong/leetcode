package concurrency.expand;

/**
 * @author mengfh
 * 
 * @version 2020-6-24下午4:09:58
 * 
 * @description
 */
public class AB_Print_Test {

	/**
	 * 这里的new了两个MyThread，导致线程自己wait自己
	 */
	public static void main(String[] args) {
//		Thread t1 = new Thread(new MyThread(), "A");
//		Thread t2 = new Thread(new MyThread(), "B");
		MyThread t = new MyThread();
		Thread t1 = new Thread(t, "A");
		Thread t2 = new Thread(t, "B");
		t1.start();
		t2.start();
	}

	private static class MyThread implements Runnable {

		private int i = 0;

		@Override
		public void run() {
			while(i < 100){
				func();
			}
		}

		private synchronized void func() {
			System.out.println(Thread.currentThread().getName() + " : " + i++);
			this.notify();
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
