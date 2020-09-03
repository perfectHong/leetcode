package utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

public class APILock {

	private static Map<String, APILock> instances = new HashMap<>();

	private String billmark;

	/** 加入锁，保证锁数据和解锁数据时线程安全 */
	private final ReentrantLock lock = new ReentrantLock();

	private MapList<String, String> lockDatas = new MapList<>();

	private APILock(String billmark) {
		this.billmark = billmark;
	}

	public static APILock getInstance(String billmark) {
		synchronized (billmark) {
			APILock instance = instances.get(billmark);
			if (instance == null) {
				instance = new APILock(billmark);
				instances.put(billmark, instance);
			}
			return instance;
		}
	}
	
	/** 获取到的锁ID是： 单据号+时间戳 */
	public String getLockID() {
		return billmark + "," + System.currentTimeMillis();
	}

	/** 举例：对来源单据号加锁 */
	public boolean lock(String lockid, String[] datas) {
		this.lock.lock();
		try {
			if (!lockDatas.isEmpty()) {
				List<String> allDatas = this.lockDatas.values();
				for (String data : datas) {
					if (allDatas.contains(data)) {
						return false;
					}
				}
			}
			this.lockDatas.putAll(lockid, Arrays.asList(datas));
			return true;
		} finally {
			this.lock.unlock();
		}
	}

	public void release(String lockid) {
		this.lock.lock();
		try {
			if (!this.lockDatas.isEmpty() && this.lockDatas.containsKey(lockid)) {
				this.lockDatas.remove(lockid);
			}
		} finally {
			this.lock.unlock();
		}
	}
	
	public static void main(String[] args) {

	}
}
