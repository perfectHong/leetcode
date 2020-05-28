package concurrency.artofconcurrency.chapter_eight;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier��int parties�����������ʾ�������ص��߳���
 * ����ÿ���̵߳���await��������CyclicBarrier���Ѿ����������ϣ�Ȼ��ǰ�̱߳�����
 * 
 * ��Ϊ���̺߳����̵߳ĵ�������CPU�����ģ������̶߳��п�����ִ��
 * 
 * �����new CyclicBarrier(2)�޸ĳ�new CyclicBarrier(3)�������̺߳����̻߳���Զ�ȴ���
 * ��Ϊû�е������߳�ִ��await��������û�е������̵߳������ϣ�����֮ǰ�������ϵ����� �̶߳��������ִ��
 * */
public class CyclicBarrierTest1 {

	static CyclicBarrier c = new CyclicBarrier(2);

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					c.await();
				} catch (Exception e) {
				}
				System.out.println(1);
			}
		}).start();
		try {
			c.await();
		} catch (Exception e) {
		}
		System.out.println(2);
	}
}