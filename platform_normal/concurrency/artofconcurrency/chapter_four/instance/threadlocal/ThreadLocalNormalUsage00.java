package concurrency.artofconcurrency.chapter_four.instance.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * �����̴߳�ӡ����
 */
public class ThreadLocalNormalUsage00 {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalNormalUsage00().date(10);
                System.out.println(date);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalNormalUsage00().date(104707);
                System.out.println(date);
            }
        }).start();

    }

    public String date(int seconds) {

        //�����ĵ�λ�Ǻ��룬��1970.1.1 00:00:00 GMT ��ʼ��ʱ
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }
}