package com.concurrenttest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mengfh
 *
 * @version 2020-5-25上午11:15:16
 *
 * @description ConditionTest
 */
/**
 * 何这wait()、notify()和notifyAll()不是Thread类声明中的方法，而是Object类中声明的方法其实这个问题很简单，
 * 由于每个对象都拥有monitor（即锁），所以让当前线程等待某个对象的锁
 * 
 * object和condition的wait区别 
 * 1.object wait() 不能单独使用，必须是在synchronized 下才能使用，
 * 2.object wait()必须要通过Nodify()方法进行唤醒 
 * 3.condition await() 必须是当前线程被排斥锁 lock后,获取到condition 后才能使用 
 * 4.condition await() 必须通过 sign()方法进行唤醒
 * 总结：一个是基于对象监听器的同步方式，一个是基于 ASQ同步机制的同步方式
 * */
public class ConditionQueue<T> {
	private Object[] items;
	// 添加的下标，删除的下标和数组当前数量
	private int addIndex, removeIndex, count;
	private Lock lock = new ReentrantLock();
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();

	public ConditionQueue(int size) {
		items = new Object[size];
	}

	// 添加一个元素，如果数组满，则添加线程进入等待状态，直到有"空位"
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

	// 由头部删除一个元素，如果数组空，则删除线程进入等待状态，直到有新添加元素
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