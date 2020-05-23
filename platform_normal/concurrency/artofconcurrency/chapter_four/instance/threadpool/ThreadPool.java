package concurrency.artofconcurrency.chapter_four.instance.threadpool;

public interface ThreadPool<Job extends Runnable> { // �����ʣ�Ϊʲôjob���õ�����
       // ִ��һ��Job�����Job��Ҫʵ��Runnable
       void execute(Job job);
       // �ر��̳߳�
       void shutdown();
       // ���ӹ������߳�
       void addWorkers(int num);
       // ���ٹ������߳�
       void removeWorker(int num);
       // �õ����ڵȴ�ִ�е���������
       int getJobSize();
}