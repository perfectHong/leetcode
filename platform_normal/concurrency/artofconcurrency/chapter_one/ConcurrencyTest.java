package concurrency.artofconcurrency.chapter_one;

/**
 * @author mengfh
 *
 * @version 2020-5-22����9:15:16
 *
 * @description �߳��л�,������ʵ��
 */
/**
 * ÿһ�δ�WAITTING��RUNNABLE�������һ�������ĵ��л�
 * 
 * �����������л�ʵս 
 * ��һ������jstack����dump�߳���Ϣ 
 * �ڶ�����ͳ�������̷ֱ߳���ʲô״̬������300����̴߳���WAITING״̬��
 * ����������dump�ļ��鿴����WAITING����ȫ��JBOSS�Ĺ����̣߳���await��˵��JBOSS�̳߳����߳̽��յ�������̫�٣������̶߳����š�
 * ���Ĳ�������JBOSS�Ĺ����߳������ҵ�JBOSS���̳߳�������Ϣ����maxThreads����100��
 * ���岽������JBOSS����dump�߳���Ϣ��Ȼ��ͳ��WAITING��onobjectmonitor�����̣߳����ּ�����175����
 * 
 * ������벻һ���ԣ���Ȼ�����ϵģ������Ժ��񲻶Ծ�
 * */
public class ConcurrencyTest {

	private static final long count = 10000000l;

	public static void main(String[] args) throws InterruptedException {
		concurrency();
		serial();
	}

	private static void concurrency() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread thread = new Thread(new Runnable() {
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
		thread.join();      //��һ�£�����ΪʲôҪjoin(),��ΪҪ��aִ�����
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