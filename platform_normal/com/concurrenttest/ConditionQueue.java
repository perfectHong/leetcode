package com.concurrenttest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mengfh
 *
 * @version 2020-5-25����11:15:16
 *
 * @description ConditionTest
 */
/**
 * ����wait()��notify()��notifyAll()����Thread�������еķ���������Object���������ķ�����ʵ�������ܼ򵥣�
 * ����ÿ������ӵ��monitor���������������õ�ǰ�̵߳ȴ�ĳ���������
 * 
 * object��condition��wait���� 
 * 1.object wait() ���ܵ���ʹ�ã���������synchronized �²���ʹ�ã�
 * 2.object wait()����Ҫͨ��Nodify()�������л��� 
 * 3.condition await() �����ǵ�ǰ�̱߳��ų��� lock��,��ȡ��condition �����ʹ�� 
 * 4.condition await() ����ͨ�� sign()�������л���
 * �ܽ᣺һ���ǻ��ڶ����������ͬ����ʽ��һ���ǻ��� ASQͬ�����Ƶ�ͬ����ʽ
 * */
public class ConditionQueue<T> {
	private Object[] items;
	// ��ӵ��±꣬ɾ�����±�����鵱ǰ����
	private int addIndex, removeIndex, count;
	private Lock lock = new ReentrantLock();
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();

	public ConditionQueue(int size) {
		items = new Object[size];
	}

	// ���һ��Ԫ�أ������������������߳̽���ȴ�״̬��ֱ����"��λ"
	public void add(T t) throws InterruptedException {
		lock.lock();
		try {
			while (count == items.length)
				notFull.await();
			items[addIndex] = t;
			if (++addIndex == items.length)
				addIndex = 0;
			++count;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	// ��ͷ��ɾ��һ��Ԫ�أ��������գ���ɾ���߳̽���ȴ�״̬��ֱ���������Ԫ��
	@SuppressWarnings("unchecked")
	public T remove() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0)
				notEmpty.await();
			Object x = items[removeIndex];
			if (++removeIndex == items.length)
				removeIndex = 0;
			--count;
			notFull.signal();
			return (T) x;
		} finally {
			lock.unlock();
		}
	}
}