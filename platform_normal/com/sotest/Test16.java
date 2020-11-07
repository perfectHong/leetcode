package com.sotest;

import vo.ListNode;

/**
 * @author mengfh
 * 
 * @description 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * @date 2020-10-17下午1:20:15
 */
public class Test16 {

	private static ListNode testname(ListNode node1, ListNode node2) {
		ListNode cur = new ListNode();  //定义移动节点
		ListNode res = cur;				//返回结果和移动节点指向同一内存
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
		return res.next;  				//从下一个节点返回，因为没有定义头结点
	}

	public static void main(String[] args) throws Exception {
		testname(ListNode.builder(), ListNode.builder2());
	}

}
