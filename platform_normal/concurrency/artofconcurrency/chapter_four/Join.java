package concurrency.artofconcurrency.chapter_four;

/**
 * ���Կ���join()��Դ�룬�漰�˵ȴ�/֪ͨ����
 * 
 * ���뺬�壺 ������10���̣߳����0~9��ÿ���̵߳���ǰһ���̵߳�
 * join()������Ҳ�����߳�0�����ˣ��߳�1���ܴ�join()�����з��أ����߳�0��Ҫ�ȴ�main�߳̽� ����
 * 
 * �ܿ��쿴����Ĺ���
 * */
public class Join {

	public static void main(String[] args) throws Exception {
		Thread previous = Thread.currentThread();
		for (int i = 0; i < 10; i++) {
			// ÿ���߳�ӵ��ǰһ���̵߳����ã���Ҫ�ȴ�ǰһ���߳���ֹ�����ܴӵȴ��з���
			Thread thread = new Thread(new Domino(previous), String.valueOf(i));
			thread.start();            /** �ص� �� ����Ϊ��һ��forѭ���ϵ�ͻ�ȥrun()����ʵ���ǣ���ΪҪ��main()�߳������Ҳ����ʮ��forѭ������ֱ�����mian terminate,�Ż�ȥ��run()**/
			previous = thread;
		}
		System.out.println(Thread.currentThread().getName() + " terminate.");  //�����ϸ��ϵ㣬��һ�����
	}

	static class Domino implements Runnable {
		
		private Thread thread;

		public Domino(Thread thread) {
			this.thread = thread;
		}

		public void run() {
			try {
				thread.join();  //�ȴ���һ���߳�ִ�н���
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName() + " terminate.");   //�����ϸ��ϵ㣬½�����ʮ��
		}
	}
}