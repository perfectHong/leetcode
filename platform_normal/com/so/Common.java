package com.so;

import java.util.ArrayList;

import vo.ListNode;

/**
 * 公共类
 *
 * @author qgl
 * @date 2019/07/01
 */
public class Common {
	
    /**
     * 二叉树
     */
    public static class TreeNode {
    	public int val;
    	public TreeNode left;
    	public TreeNode right;

    	public TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 链表
     */
    public static class ListNode {
    	
    	public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
        
        public ListNode(){};
        
        /**
         * 构建链表
         */
        public static ListNode builder() {
        	ListNode node = new ListNode(0); // 创建首节点
        	ListNode nextNode; // 声明一个变量用来在移动过程中指向当前节点
        	nextNode = node;   // 指向首节点      /** 重点是node，我一直没想到 */
        	for (int i = 1; i < 10; i++) {
        		ListNode newNode = new ListNode(i); // 生成新的节点
        		nextNode.next = newNode; 
        		nextNode = nextNode.next; // 当前节点往后移动
        	} 
        	return nextNode = node; 
        }
    }
    

    /**
     * 获取链表的所有节点
     *
     * @param head
     * @return
     */
    public static String getAllListNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" → ");
            head = head.next;
        }
        return sb.length() < 1 ? null : sb.substring(0, sb.length() - 2);
    }
}
