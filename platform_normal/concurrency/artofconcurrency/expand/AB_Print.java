package concurrency.artofconcurrency.expand;

public class AB_Print implements Runnable {

	/**��Ҫ�̼߳乲������Ҫ����ȫ�ֵ�*/
	int i;

	@Override
	public void run() {
		while (i < 100) {
			printNum();
		}
	}

	/** Ҫ��printNum()�����������synchronized���Σ�����ᱨ���ȡ���������쳣*/
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
		AB_Print numCounter = new AB_Print();/**������ͬһ�����������*/
		Thread t1 = new Thread(numCounter);
		Thread t2 = new Thread(numCounter);
		t1.start();
		t2.start();
	}

}