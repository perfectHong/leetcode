package concurrency.artofconcurrency.expand;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ���� ThreadLocal ��ÿ���̷߳����Լ��� dateFormat ����
 * ������֤���̰߳�ȫ������Ч���������ڴ�
 */
public class ThreadLocalNormalUsage {

    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            final int finalI = i;
            //�ύ����
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalNormalUsage().date(finalI);
                    System.out.println(date);
                }
            });
        }
        threadPool.shutdown();
    }

    public String date(int seconds) {

        //�����ĵ�λ�Ǻ��룬��1970.1.1 00:00:00 GMT ��ʼ��ʱ
        Date date = new Date(1000 * seconds);
        //��ȡ SimpleDateFormat ����
        SimpleDateFormat dateFormat = ThreadSafeFormatter.dateFormatThreadLocal.get();
        return dateFormat.format(date);
    }
}