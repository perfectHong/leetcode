package concurrency.artofconcurrency.chapter_six;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author mengfh
 *
 * @version 2020-5-26下午12:20:02
 *
 * @description
 */
public class ConcurrentHashmapTest {

	public static void main(String[] args) {

	}
	
	/**在多线程环境下，使用HashMap进行put操作会引起死循环，导致CPU利用率接近100%,看笔记头插法尾插法*/
	final HashMap<String, String> map = new HashMap<String, String>(2);
	
    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        map.put(UUID.randomUUID().toString(), "");
                    }
                }, "ftf" + i).start();
            }
        }
    }, "ftf");
//    t.start();  //不注释会报错，不知道为啥
//    t.join();

}
