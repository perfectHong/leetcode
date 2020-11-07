package com.sotest;

/**
 * 公共类
 *
 * @author mengfh
 * @date 2020/07/01
 */
public class Common {
	
	public static class TreeNode {
		
		public String data;
		public TreeNode left = null;
		public TreeNode right = null;
		public boolean flag;
	 
		TreeNode(String data) {
			this.data = data;
		}
	 
		TreeNode() {}
	 
		@Override
		public String toString() {
			return this.data;
		}
	 
	}
	 
	public static class BinaryTree{
	 
		private static TreeNode root = new TreeNode();
	 
		public static TreeNode getRoot() {
			return root;
		}
	 
		/** 先序递归构建二叉树 */
		private static int createTreeByRecursion(TreeNode node, String[] treeNodes, int n) {
	 
			if ("#".equals(treeNodes[n]))
				return n + 1;
	 
			node.data = treeNodes[n];
	 
			node.left = new TreeNode();
			int left = createTreeByRecursion(node.left, treeNodes, n + 1);
	 
			node.right = new TreeNode();
			int right = createTreeByRecursion(node.right, treeNodes, left);
	 
			return right;
		}
	 
		public static void createTreeByRecursion(String[] treeNodes) {
			createTreeByRecursion(root, treeNodes, 0);
		}
		
		public static TreeNode createTreeByRecursion2(String[] treeNodes) {
			TreeNode tree = new TreeNode();
			createTreeByRecursion(tree, treeNodes, 0);
			return tree;
		}
		
		public static void main(String[] args) throws Exception {
			/** 每个节点必须以 # 结尾，否则在构建二叉树时会数组越界 */
			Common.BinaryTree.createTreeByRecursion(new String[]{"A","B","D","#","#","#","C","#","E","#","#"});
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
