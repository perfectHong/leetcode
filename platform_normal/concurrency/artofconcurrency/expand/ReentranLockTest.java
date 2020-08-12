package concurrency.artofconcurrency.expand;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *这里有两个线程，每个线程可冲入自己已获得的锁，上断点printer.print();
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

        private Lock lock = new ReentrantLock();//默认是非公平锁

        public void print(String name) {
            lock.lock(); // 获取锁 ， 获取不到会阻塞
            try {
                
                int len = name.length();
                for (int i = 0; i < len; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
                
            } finally {
                lock.unlock(); // 释放锁
            }
        }
    }

}