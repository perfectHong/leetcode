package concurrency.artofconcurrency.chapter_four.instance.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * 这是书上的
 * 
 * 记得之前还看过其他案例，也写下来
 * */
public class ThreadLocalProfiler {
    // 第一次get()方法调用时会进行初始化（如果set方法没有调用），每个线程会调用一次
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
        // 当超时大于0并且result返回值不满足要求
        while ((result == null) && remaining > 0) {
               wait(remaining);              
               remaining = future - System.currentTimeMillis();
        }
               return result;
 }
}