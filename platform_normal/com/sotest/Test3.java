package com.sotest;

import java.util.ArrayList;
import java.util.Stack;

import vo.ListNode;

/**
 * @author mengfh
 * 
 * @description ����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList��
 * 
 * @date 2020-9-30����9:10:14
 */
public class Test3 {

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
		test(ListNode.builder());
	}

}
