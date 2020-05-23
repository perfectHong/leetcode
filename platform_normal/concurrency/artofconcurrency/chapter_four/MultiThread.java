package concurrency.artofconcurrency.chapter_four;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author mengfh
 *
 * @version 2020-5-22����9:15:16
 *
 * @description ���̸߳���
 */
/**
 * һ��Java��������в�������main()���������У�����main�̺߳Ͷ�������̵߳�ͬʱ���С�
 * */
public class MultiThread{
    public static void main(String[] args) {
        // ��ȡJava�̹߳���MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // ����Ҫ��ȡͬ����monitor��synchronizer��Ϣ������ȡ�̺߳��̶߳�ջ��Ϣ
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // �����߳���Ϣ������ӡ�߳�ID���߳�������Ϣ
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.
            getThreadName());
        }
    }
}