package concurrency.artofconcurrency.expand;

public class AB_Print implements Runnable {

	/**需要线程间共享，所以要定义全局的*/
	int i;

	@Override
	public void run() {
		while (i < 100) {
			printNum();
		}
	}

	/** 要把printNum()抽出来，并用synchronized修饰，否则会报错获取锁监视器异常*/
	private synchronized void printNum() {
		System.out.println(Thread.currentThread().getName() + " is running " + i++);
		this.notify();
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		AB_Print numCounter = new AB_Print();/**必须是同一个类才有意义*/
		Thread t1 = new Thread(numCounter);
		Thread t2 = new Thread(numCounter);
		t1.start();
		t2.start();
	}

}