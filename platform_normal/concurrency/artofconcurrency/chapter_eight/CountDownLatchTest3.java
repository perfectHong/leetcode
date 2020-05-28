package concurrency.artofconcurrency.chapter_eight;

/**
 * ˳��ִ��
 * 
 * joinԭ���ǲ�ͣ���join�߳��Ƿ�����join�̴߳�����õ�ǰ�߳���Զ�ȴ������У�wait��0����ʾ��Զ�ȴ���ȥ
 * 
 * ֱ��join�߳���ֹ���̵߳�this.notifyAll()�����ᱻ���ã�����notifyAll()��������JVM��ʵ�ֵģ�������JDK�￴����
 * */
public class CountDownLatchTest3 {

	public static void main(String[] args) throws InterruptedException {
		Thread parser1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("parser1 finish");
			}
		});
		Thread parser2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("parser2 finish");
			}
		});
		parser1.start();
		parser2.start();
		parser1.join();
		parser2.join();
		System.out.println("all parser finish");
	}
}