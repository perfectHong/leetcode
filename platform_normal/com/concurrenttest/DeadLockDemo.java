package com.concurrenttest;

/**
 * @author mengfh
 *
 * @version 2020-5-22����9:15:16
 *
 * @description ����
 */
/**
 * ���������ļ�����������:
 * 1.����һ���߳�ͬʱ��ȡ������� 
 * 2.����һ���߳�������ͬʱռ�ö����Դ��������֤ÿ����ֻռ��һ����Դ��
 * 3.����ʹ�ö�ʱ����ʹ��lock.tryLock��timeout�������ʹ���ڲ������ơ�
 * 4.�������ݿ����������ͽ���������һ�����ݿ�������������ֽ���ʧ�ܵ������
 */
public class DeadLockDemo {
	
	private static String A = "A";
	private static String B = "B";

	public static void main(String[] args) {
		new DeadLockDemo().deadLock();
		new DeadLockDemo().deadLock2();
	}

	private void deadLock() {  //���ϵ�
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (A) {         // ע��������ͬ��������Ƕ�ģ������˵ڶ�����һ������ͬʱռ�ö����Դ
					try {
						Thread.currentThread();
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (B) {     // ��ȡ����A��������Ҫ��ȡB������һֱ�ȴ�t2�ͷ�B����
						System.out.println("1");
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (B) {
					synchronized (A) {    // ��ȡ����B��������Ҫ��ȡA������һֱ�ȴ�t1�ͷ�A����
						System.out.println("2");
					}
				}
			}
		});
		t1.start();
		t2.start();
	}
	
	private void deadLock2() {   //�Լ�д��
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				synchronized (A) {
					System.out.println("t1�õ���A����");
					try {
						Thread.currentThread();
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(B){
						System.out.println("t1�õ���B����");
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				synchronized (B) {
					System.out.println("t2�õ���B����");
					synchronized(A){
						System.out.println("t2�õ���A����");
					}
				}
			}
		});
		t1.start();
		t2.start();
	}
}
