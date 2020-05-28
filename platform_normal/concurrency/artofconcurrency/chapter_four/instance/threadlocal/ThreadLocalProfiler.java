package concurrency.artofconcurrency.chapter_four.instance.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * �������ϵ�
 * 
 * �ǵ�֮ǰ����������������Ҳд����
 * */
public class ThreadLocalProfiler {
    // ��һ��get()��������ʱ����г�ʼ�������set����û�е��ã���ÿ���̻߳����һ��
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){ 
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };
    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }
    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }
    public static void main(String[] args) throws Exception {
    	ThreadLocalProfiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + ThreadLocalProfiler.end() + " mills");
    }
    
    public synchronized Object get(long mills) throws InterruptedException {
        long future = System.currentTimeMillis() + mills;
        long remaining = mills;
        Object result = "";
        // ����ʱ����0����result����ֵ������Ҫ��
        while ((result == null) && remaining > 0) {
               wait(remaining);              
               remaining = future - System.currentTimeMillis();
        }
               return result;
 }
}