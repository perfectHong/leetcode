package concurrency.expand;

/**
 * @author mengfh
 * 
 * @version 2020-6-24����4:09:58
 * 
 * @description �����ӡ�̲߳���һ
 */
public class AB_Print_Test {

	static AB_Print_Test test = new AB_Print_Test();
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			@Override
			public void run() {
				test.print();
			}
		};
		Thread t2 = new Thread(){
			@Override
			public void run() {
				test.print();
			}
		};
		t1.start();
		t2.start();
	}
	
	int value = 100;
	
	/**
	 * ͬ����ӡ
	 */
	public synchronized void print() {
		for (int i = 0; i < value;) {
			System.out.println(value--);
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
	}
	

}
