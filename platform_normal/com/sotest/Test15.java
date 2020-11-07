package com.sotest;

import vo.ListNode;

/**
 * @author mengfh
 * 
 * @description ����һ��������ת��������������ı�ͷ��
 * 
 * @date 2020-10-15����9:12:21
 */
public class Test15 {

	/**
	 * @param һ��û�������ύ���´�����
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// ��һ�����˺ܾòŹ����ڶ���úý������ͼ�Σ�����ָ�룩
	private static ListNode testname(ListNode node) {
		ListNode current = new ListNode();
		while (node != null) {
			ListNode temp = new ListNode();
			temp = node; // ָ��ͬһ���ڴ棬temp�ı����nodeָ��Ķ���Ҳ���
			node = node.next; // ������һ��Ҫд���⣬д�ں�����ı�ָ��
			temp.next = null;
			temp.next = current;
			current = temp;  //current��tempһ��ָ��ͬһ���ڴ�
		}
		return current;
	}
	
	/**�ص�***��ת��������**/  //�Լ���ͼ
	public static ListNode reverseList1(ListNode head) {  //������3��node��ƽ��д��ʱ��Ҫ�Ӷ�
		ListNode res = null;
		while (head != null) {
			ListNode nextTemp = head.next;
			head.next = res;  // ��ʱ��Ҫ�����ﲻ�����뵽
			res = head;  //headָ������һ��res��res��ָ��head
			head = nextTemp;
		}
		return res;
    }
	
	/**�ص�***��ת�����ݹ飬��leetcode���û��**/ 
	public ListNode reverseList2(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode cur = reverseList2(head.next);
		head.next.next = head;
		head.next = null;
		return cur;
	}
}
