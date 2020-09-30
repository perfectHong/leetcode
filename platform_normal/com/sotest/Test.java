package com.sotest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

import com.so.Common.ListNode;

import algorithm.test;

import utils.MapList;

//https://blog.csdn.net/weiwei121451070/article/details/81742418?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.nonecase
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

	// ����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList��
	public static ArrayList<Integer> test(ListNode node) {
		ArrayList<Integer> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		ListNode head = new ListNode();
		head = node;
		while (head != null) {
			stack.push(head.val);
			head = head.next;
		}
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		return list;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(0); // �����׽ڵ�
    	ListNode nextNode; // ����һ�������������ƶ�������ָ��ǰ�ڵ�
    	nextNode = node;   // ָ���׽ڵ�      /** �ص���node����һֱû�뵽 */
    	for (int i = 1; i < 10; i++) {
    		ListNode newNode = new ListNode(i); // �����µĽڵ�
    		nextNode.next = newNode; 
    		nextNode = nextNode.next; // ��ǰ�ڵ������ƶ�
    	} 
    	//nextNode = node; 
	}
}
