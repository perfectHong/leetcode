package concurrency.artofconcurrency.chapter_nine;
/**
 * @author mengfh
 *
 * @version 2020-5-27����9:33:17
 *
 * @description
 */
public class ThreadPool {

	public static void main(String[] args) {
		
		/**�̳߳ص�ʵ��ԭ��execute()ԭ��*/
		/*�˴�����˵��Ҫ��ͼ��⣬���鿴��ھ���*/
		
		/**���̳߳��ύ����*/
		/*execute()���������ύ����Ҫ����ֵ�����������޷��ж������Ƿ��̳߳�ִ�гɹ���*/
		/*submit()���������ύ��Ҫ����ֵ�������̳߳ػ᷵��һ��future���͵Ķ���ͨ�����
		future��������ж������Ƿ�ִ�гɹ������ҿ���ͨ��future��get()��������ȡ����ֵ��get()��
		����������ǰ�߳�ֱ��������ɣ���ʹ��get��long timeout��TimeUnit unit���������������ǰ��
		��һ��ʱ����������أ���ʱ���п�������û��ִ���ꡣ*/
		
		/**�ر��̳߳�*/
		/*����ͨ�������̳߳ص�shutdown��shutdownNow�������ر��̳߳ء����ǵ�ԭ���Ǳ�����
		�̳��еĹ����̣߳�Ȼ����������̵߳�interrupt�������ж��̣߳������޷���Ӧ�жϵ�����
		������Զ�޷���ֹ��
		ͨ������shutdown�������ر��̳߳أ��������һ��Ҫִ���꣬����Ե���shutdownNow������*/
		
		/**�̳߳صĴ���*/
		/*�˽�ÿ�������ĺ���
		ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
				milliseconds,runnableTaskQueue, handler);*/
	}
	
}
