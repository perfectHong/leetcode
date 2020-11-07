package com.sotest;

import vo.ListNode;

/**
 * @author mengfh
 * 
 * @description 输入一个链表，反转链表后，输出新链表的表头。
 * 
 * @date 2020-10-15上午9:12:21
 */
public class Test15 {

	/**
	 * @param 一遍没过，别提交，下次再做
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 第一遍做了很久才过，第二遍好好结合想象图形（对象，指针）
	private static ListNode testname(ListNode node) {
		ListNode current = new ListNode();
		while (node != null) {
			ListNode temp = new ListNode();
			temp = node; // 指向同一块内存，temp改变对象，node指向的对象也会变
			node = node.next; // 所以这一行要写在这，写在后面会变改变指针
			temp.next = null;
			temp.next = current;
			current = temp;  //current和temp一样指向同一块内存
		}
		return current;
	}
	
	/**重点***反转链表，迭代**/  //自己画图
	public static ListNode reverseList1(ListNode head) {  //包含了3个node，平常写的时候不要嫌多
		ListNode res = null;
		while (head != null) {
			ListNode nextTemp = head.next;
			head.next = res;  // 当时主要是这里不容易想到
			res = head;  //head指向了上一个res，res再指向head
			head = nextTemp;
		}
		return res;
    }
	
	/**重点***反转链表，递归，看leetcode题解没懂**/ 
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
