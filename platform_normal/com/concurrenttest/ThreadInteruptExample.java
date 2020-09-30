package com.concurrenttest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ����ReentrantLock���ж�����Ч��
 * 
 * �߳�t1ͨ��lockInterruptibly()ȡ��һ��������������ִ��һ����ʱ���������һ���߳�ͨ��interrupt()�������̴��t1�̵߳�ִ�У�����ȡt1���е��Ǹ�����������
 * ��ͨ��ReentrantLock��lock()��������Synchronized���������߳��ǲ�����Ӧ�����̵߳�interrupt()�����ģ�ֱ���÷��������ͷ���֮��Ż���Ӧinterrupt()������
 */
public class ThreadInteruptExample {
    ReentrantLock lock1=new ReentrantLock();
    ReentrantLock lock2=new ReentrantLock();
 
    /**
     * ReentrantLock��Ӧ�ж�
     * @throws Exception
     */
    public void reentrantLockInterupt() throws Exception{
        Thread t1=new Thread(new ReentrantLockTask(lock1,lock2));
        Thread t2=new Thread(new ReentrantLockTask(lock2,lock1));
        t1.start();
        t2.start();
        System.out.println(t1.getName()+"�ж�");
        //���߳�˯��1�룬�����߳�t1ֱ����Ӧrun�����е�˯���ж�
        Thread.sleep(1000);
        t1.interrupt();
        //�������̣߳����������߳�ֱ�ӽ�����Ӱ������Ч��
        Thread.sleep(10000);
    }
 
 
    /**
     * Synchronized��Ӧ�ж�
     * @throws Exception
     */
    public void synchronizedInterupt() throws Exception{
        Object syn1=new Object();
        Object syn2=new Object();
        Thread t1=new Thread(new SynchronizedTask(syn1,syn2));
        Thread t2=new Thread(new SynchronizedTask(syn2,syn1));
        t1.start();
        t2.start();
        System.out.println(t1.getName()+"�ж�");
        //���߳�˯��1�룬�����߳�t1ֱ����Ӧrun�����е�˯���ж�
        Thread.sleep(1000);
        t1.interrupt();
        //�������̣߳����������߳�ֱ�ӽ�����Ӱ������Ч��
        Thread.sleep(1000);
    }
 
    /**
     * ReentrantLockʵ������
     */
    static class ReentrantLockTask implements Runnable{
 
        ReentrantLock lock1;
        ReentrantLock lock2;
 
        public ReentrantLockTask(ReentrantLock lock1, ReentrantLock lock2){
            this.lock1=lock1;
            this.lock2=lock2;
        }
 
        @Override
        public void run() {
            try {
                //���жϵĻ�ȡ��
                lock1.lockInterruptibly();
                //lock1.lock();
                //˯��200���룬��֤�����̷ֱ߳��Ѿ���ȡ����������ʵ���໥�����ȴ�
                TimeUnit.MILLISECONDS.sleep(200);
                //lock2.lock();
                //���жϵĻ�ȡ��
                lock2.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock1.unlock();
                lock2.unlock();
                System.out.println("�߳�"+Thread.currentThread().getName()+"��������");
            }
 
        }
    }
 
    /**
     * Synchronizedʵ������
     */
    static class SynchronizedTask implements Runnable{
 
        Object lock1;
        Object lock2;
 
        public SynchronizedTask(Object lock1, Object lock2){
            this.lock1=lock1;
            this.lock2=lock2;
        }
 
        @Override
        public void run() {
            try {
                synchronized (lock1){
                    //˯��200���룬�ٻ�ȡ��һ������
                    //��֤�����̷ֱ߳��Ѿ���ȡ����������ʵ���໥�����ȴ�
                    Thread.sleep(200);
                    synchronized (lock2){
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("�߳�"+Thread.currentThread().getName()+"��������");
            }
 
        }
    }
 
    public static void main(String[] args) throws Exception {
        ThreadInteruptExample demo=new ThreadInteruptExample();
        ThreadInteruptExample demo1=new ThreadInteruptExample();
        demo.reentrantLockInterupt();
        demo1.synchronizedInterupt();
    }
 
}