package com.sotest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import com.sotest.Common.TreeNode;

import utils.MapList;

//https://www.nowcoder.com/ta/coding-interviews
public class Test {

	private static Map<String, Test> instances = new HashMap<>();

	private String billmark;

	private final ReentrantLock lock = new ReentrantLock();

	private MapList<String, String> lockDatas = new MapList<>();

	private Test(String billmark) {
		this.billmark = billmark;
	}

	public static Test getInstance(String billmark) {
		synchronized (billmark) {
			Test instance = instances.get(billmark);
			if (instance == null) {
				instance = new Test(billmark);
				instances.put(billmark, instance);
			}
			return instance;
		}
	}

	public String getLockID() {
		return billmark + "," + System.currentTimeMillis();
	}

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
	
	private static boolean testname2(TreeNode node1, TreeNode node2) {
		return contains(node1, node2);
	}
	
	/** 做出来了，很欣慰，复习递归思想 */
	private static boolean contains(TreeNode node1, TreeNode node2) {
		if(node1.data == null && node2.data != null)
			return false;
		else if(node1.data != null && node2.data == null)
			return true;
		else if(node1.data == null && node2.data == null)
			return true;
		else {
			contains(node1.left, node2.left);
			contains(node1.right, node2.right);
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		Common.TreeNode tree1 = Common.BinaryTree.createTreeByRecursion2(new String[]{"A","B","D","#","#","#","C","#","E","#","#"});
		Common.TreeNode tree2 = Common.BinaryTree.createTreeByRecursion2(new String[]{"A","B","#","#","C","#","#"});
		testname2(tree1, tree2);
	}
	
}
