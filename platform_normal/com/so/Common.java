package com.so;

import java.util.ArrayList;

import com.so.Common.TreeNode;

import vo.ListNode;

/**
 * 公共类
 *
 * @author mengfh
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

		public static TreeNode builder() {

			
			
			return null;
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
    		ListNode node = new ListNode();  			//这里产生了对象，并分配了引用
    		ListNode head = node;            			//这里只分配引用，代表node和head指向同一块内存空间
    		for (int i = 1; i < 10; i++) {
    			ListNode temp = new ListNode(i);		//temp作为新节点，head作为移动节点，node始终指向原始对象，返回node即可
    			head.next = temp;
    			head = head.next;						//节点后移
    		}
    		return node;								//整个算法用到了node，head和temp，常复习，了解他们的关系
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

