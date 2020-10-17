package com.sotest;

import vo.ListNode;

/**
 * @author mengfh
 *
 * @description 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @date 2020-10-15上午9:11:52
 */
public class Test14 {

	/**
	 * @param 
	 */
	public static void main(String[] args) {
		testname(ListNode.builder(), 10);
	}
	
	private static ListNode testname(ListNode node, int k) {
		int len = 0;          //后面用来求node长度
		ListNode head = node; //head和node指向同一块内存
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
