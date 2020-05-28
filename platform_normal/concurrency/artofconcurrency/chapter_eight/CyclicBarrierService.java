package concurrency.artofconcurrency.chapter_eight;

import java.util.Map.Entry;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author mengfh
 * 
 * @version 2020-5-27����8:57:28
 * 
 * @description ������ˮ���������
 */
/**
 * Ӧ�ó����� CyclicBarrier�������ڶ��̼߳������ݣ����ϲ��������ĳ�����
 * 
 * ʹ���̳߳ش���4���̣߳��ֱ����ÿ��sheet������ݣ�ÿ��sheet��������1������
 * BankWaterService�̻߳���4��sheet������Ľ��
 * 
 * ���� ��һ��Excel�� �����û�����������ˮ��ÿ��Sheet����һ���˻���һ���ÿ��������ˮ��������Ҫͳ���û�
 * ���վ�������ˮ�����ö��̴߳���ÿ��sheet���������ˮ����ִ����֮�󣬵õ�ÿ��sheet����
 * ��������ˮ���������barrierAction����Щ�̵߳ļ����������������Excel���վ������� ˮ
 * */
public class CyclicBarrierService implements Runnable {
	/**
	 * ����4�����ϣ�������֮��ִ�е�ǰ���run����
	 */
	private CyclicBarrier c = new CyclicBarrier(4, this);
	/**
	 * ����ֻ��4��sheet������ֻ����4���߳�
	 */
	private Executor executor = Executors.newFixedThreadPool(4);
	/**
	 * ����ÿ��sheet��������������
	 */
	private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<String, Integer>();

	private void count() {
		for (int i = 0; i < 4; i++) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					// ���㵱ǰsheet���������ݣ��������ʡ��
					sheetBankWaterCount
							.put(Thread.currentThread().getName(), 1);
					// ����������ɣ�����һ������
					try {
						c.await();
					} catch (InterruptedException | BrokenBarrierException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	@Override
	public void run() {
		int result = 0;
		// ����ÿ��sheet������Ľ��
		for (Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
			result += sheet.getValue();
		}
		// ��������
		sheetBankWaterCount.put("result", result);
		System.out.println(result);
	}

	public static void main(String[] args) {
		CyclicBarrierService bankWaterCount = new CyclicBarrierService();
		bankWaterCount.count();
	}
}
