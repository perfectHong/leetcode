package concurrency.artofconcurrency.expand;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABC_Lock {
	
    private static Lock lock = new ReentrantLock();
    
    private static int state = 0;
 
    static class MyThread extends Thread{
        int num;
        String letter;
 
        public MyThread(String letter, int num) {
            this.num = num;
            this.letter = letter;
        }
 
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (state % 3 == num){
                        System.out.print(letter);
                        state++;
                        i++;//变量自增必须写在这
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }
 
    public static void main(String[] args) {
        new MyThread("A",0).start();
        new MyThread("B",1).start();
        new MyThread("C",2).start();
    }
}