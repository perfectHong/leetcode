package concurrency.artofconcurrency.chapter_six;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author mengfh
 *
 * @version 2020-5-26����12:20:02
 *
 * @description
 */
public class ConcurrentHashmapTest {

	public static void main(String[] args) {

	}
	
	/**�ڶ��̻߳����£�ʹ��HashMap����put������������ѭ��������CPU�����ʽӽ�100%,���ʼ�ͷ�巨β�巨*/
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
//    t.start();  //��ע�ͻᱨ����֪��Ϊɶ
//    t.join();

}
