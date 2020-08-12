package concurrency.artofconcurrency.expand;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *�����������̣߳�ÿ���߳̿ɳ����Լ��ѻ�õ������϶ϵ�printer.print();
 */
public class ReentranLockTest {

    public static void main(String[] args) {

        final Printer printer = new ReentranLockTest().new Printer();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    printer.print("zhangsan33953");
                }

            };
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    printer.print("lisi27965");
                }
            };
        }.start();
    }

    class Printer {

        private Lock lock = new ReentrantLock();//Ĭ���Ƿǹ�ƽ��

        public void print(String name) {
            lock.lock(); // ��ȡ�� �� ��ȡ����������
            try {
                
                int len = name.length();
                for (int i = 0; i < len; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
                
            } finally {
                lock.unlock(); // �ͷ���
            }
        }
    }

}