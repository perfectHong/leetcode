package concurrency.artofconcurrency.chapter_four;

import java.util.concurrent.TimeUnit;

/**
 * �ȴ�֪֪ͨ�����ˣ���ô������ŵ���ֹ�߳���
 * 
 * ���£� main�߳�ͨ���жϲ�����cancel()��������ʹCountThread������ֹ������ͨ����ʶλ�����жϲ����ķ�ʽ
 * �ܹ�ʹ�߳�����ֹʱ�л���ȥ������Դ����������ϵؽ��߳�ֹͣ�����������ֹ�̵߳������Եø��Ӱ�ȫ�����š�
 * */
public class Shutdown {
	
	public static void main(String[] args) throws Exception {
		Runner one = new Runner();
		Thread countThread = new Thread(one, "CountThread");
		countThread.start();
		// ˯��1�룬main�̶߳�CountThread�����жϣ�ʹCountThread�ܹ���֪�ж϶�����
		TimeUnit.SECONDS.sleep(1);
		countThread.interrupt();
		Runner two = new Runner();
		countThread = new Thread(two, "CountThread");
		countThread.start();
		// ˯��1�룬main�̶߳�Runner two����ȡ����ʹCountThread�ܹ���֪onΪfalse������
		TimeUnit.SECONDS.sleep(1);
		two.cancel();
	}

	private static class Runner implements Runnable {
		private long i;
		private volatile boolean on = true;   //on������䵱��ʶλ�ĸ���

		@Override
		public void run() {
			while (on && !Thread.currentThread().isInterrupted()) {
				i++;
			}
			System.out.println("Count i = " + i);
		}

		public void cancel() {
			on = false;
		}
	}
}