package com.sotest;

import vo.ListNode;

/**
 * @author mengfh
 *
 * @description ����һ����������������е�����k����㡣
 *
 * @date 2020-10-15����9:11:52
 */
public class Test14 {

	/**
	 * @param 
	 */
	public static void main(String[] args) {
		testname(ListNode.builder(), 10);
	}
	
	private static ListNode testname(ListNode node, int k) {
		int len = 0;          //����������node����
		ListNode head = node; //head��nodeָ��ͬһ���ڴ�
		while(node != null){
			len++;
			node = node.next;
		}
		if(k > len || k <= 0 )
            return null;
		for (int i = 1; i <= len-k+1; i++) {
			if(i == len-k+1){
				System.out.println(head.val);
				break;
			}
			head = head.next;
		}
		return head;
	}

}
