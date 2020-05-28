package concurrency.artofconcurrency.chapter_ten;

/**
 * @author mengfh
 *
 * @version 2020-5-27����12:46:59
 *
 * @description ���۶����϶࣬ûʲô���룬�࿴�����ʮ��
 */

/**
 * �ص��У���Executor��ܵ���������ģ��VM��OS��������
 * 
 * Executor�ṹ������ThreadPoolExecutor�ȵ�
 * */
public class ExecutorTest {

	/**
	 * Executor��ܵ���������ģ�͸���
	 * 
	 * ��HotSpot VM���߳�ģ���У�Java�̱߳�һ��һӳ��Ϊ���ز���ϵͳ��
	 * �̡�Java�߳�����ʱ�ᴴ��һ�����ز���ϵͳ�̣߳�����Java�߳���ֹʱ���������ϵͳ�߳�
	 * Ҳ�ᱻ���ա�����ϵͳ����������̲߳������Ƿ�������õ�CPU��
	 * 
	 * ���ϲ㣬Java���̳߳���ͨ����Ӧ�÷ֽ�Ϊ���ɸ�����Ȼ��ʹ���û����ĵ�����
	 * ��Executor��ܣ�����Щ����ӳ��Ϊ�̶��������̣߳��ڵײ㣬����ϵͳ�ں˽���Щ�߳�ӳ�䵽 Ӳ���������ϡ�
	 * 
	 * Ӧ�ó���ͨ��Executor��ܿ����ϲ�ĵ��ȣ����²�ĵ����ɲ���ϵͳ �ں˿��ƣ��²�ĵ��Ȳ���Ӧ�ó���Ŀ��ơ�
	 * */

	/**
	 * Executor�����Ҫ��3�󲿷����
	 * 
	 * ���񡣰�����ִ��������Ҫʵ�ֵĽӿڣ�Runnable�ӿڻ�Callable�ӿڡ�
	 * 
	 * �����ִ�С���������ִ�л��Ƶĺ��Ľӿ�Executor���Լ��̳���Executor��
	 * ExecutorService�ӿڡ�Executor����������ؼ���ʵ����ExecutorService�ӿ�
	 * ��ThreadPoolExecutor��ScheduledThreadPoolExecutor����
	 * 
	 * �첽����Ľ���������ӿ�Future��ʵ��Future�ӿڵ�FutureTask�ࡣ
	 * */
	public static void main(String[] args) {

	}

}
