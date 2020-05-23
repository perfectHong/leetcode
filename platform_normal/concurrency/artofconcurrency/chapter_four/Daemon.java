package concurrency.artofconcurrency.chapter_four;

import concurrency.support.SleepUtils;

/**
 * @author mengfh
 *
 * @version 2020-5-22����9:15:16
 *
 * @description Daemon�߳�
 */
/**
 * ����Daemon���򣬿��Կ������ն˻���������ʾ����û���κ������
 * main�̣߳���Daemon�̣߳����������߳�DaemonRunner֮������main����ִ����϶���ֹ������ʱJava����
 * �����Ѿ�û�з�Daemon�̣߳��������Ҫ�˳���Java������е�����Daemon�̶߳���Ҫ����
 * ��ֹ�����DaemonRunner������ֹ������DaemonRunner�е�finally�鲢û��ִ�С�
 * ע�⡡�ڹ���Daemon�߳�ʱ����������finally���е�������ȷ��ִ�йرջ�������Դ���߼���
 * */
public class Daemon {

	public static void main(String[] args) {
		Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
		thread.setDaemon(true);
		thread.start();
	}

	static class DaemonRunner implements Runnable {
		@Override
		public void run() {
			try {
				SleepUtils.second(10);
			} finally {
				System.out.println("DaemonThread finally run.");
			}
		}
	}

	
}
