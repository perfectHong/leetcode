package concurrency.artofconcurrency.chapter_four;

import java.util.concurrent.TimeUnit;

/**
 * ���Կ���join()��Դ�룬�漰�˵ȴ�/֪ͨ����
 * 
 * ���뺬�壺
 * ��������10���̣߳����0~9��ÿ���̵߳���ǰһ���̵߳�
join()������Ҳ�����߳�0�����ˣ��߳�1���ܴ�join()�����з��أ����߳�0��Ҫ�ȴ�main�߳̽�
����
 * */
public class Join {
    public static void main(String[] args) throws Exception {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            // ÿ���߳�ӵ��ǰһ���̵߳����ã���Ҫ�ȴ�ǰһ���߳���ֹ�����ܴӵȴ��з���
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }
    static class Domino implements Runnable {
        private Thread thread;
        public Domino(Thread thread) {
            this.thread = thread;
        }
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}