package com.sotest;

import vo.ListNode;

/**
 * @author mengfh
 * 
 * @description ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 * 
 * @date 2020-10-17����1:20:15
 */
public class Test16 {

	private static ListNode testname(ListNode node1, ListNode node2) {
		ListNode cur = new ListNode();  //�����ƶ��ڵ�
		ListNode res = cur;				//���ؽ�����ƶ��ڵ�ָ��ͬһ�ڴ�
		while (node1 != null && node2 != null) {
			if (node1.val < node2.val) {
				cur.next = node1;
				cur = cur.next;
				node1 = node1.next;
			} else {
				cur.next = node2;
				cur = cur.next;
				node2 = node2.next;
			}
		}
		if (node1 == null)
			cur.next = node2;
		else
			cur.next = node1;
		return res.next;  				//����һ���ڵ㷵�أ���Ϊû�ж���ͷ���
	}

	public static void main(String[] args) throws Exception {
		testname(ListNode.builder(), ListNode.builder2());
	}

}
