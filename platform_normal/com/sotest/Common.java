package com.sotest;

/**
 * ������
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
	 
		/** ����ݹ鹹�������� */
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
			/** ÿ���ڵ������ # ��β�������ڹ���������ʱ������Խ�� */
			Common.BinaryTree.createTreeByRecursion(new String[]{"A","B","D","#","#","#","C","#","E","#","#"});
		}
		
	}

    /**
     * ����
     */
    public static class ListNode {
    	
    	public int val;
    	
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
        
        public ListNode(){};
        
        /**
         * ��������
         */
        public static ListNode builder() {
    		ListNode node = new ListNode();  			//��������˶��󣬲�����������
    		ListNode head = node;            			//����ֻ�������ã�����node��headָ��ͬһ���ڴ�ռ�
    		for (int i = 1; i < 10; i++) {
    			ListNode temp = new ListNode(i);		//temp��Ϊ�½ڵ㣬head��Ϊ�ƶ��ڵ㣬nodeʼ��ָ��ԭʼ���󣬷���node����
    			head.next = temp;
    			head = head.next;						//�ڵ����
    		}
    		return node;								//�����㷨�õ���node��head��temp������ϰ���˽����ǵĹ�ϵ
    	}
    }

    /**
     * ��ȡ��������нڵ�
     *
     * @param head
     * @return
     */
    public static String getAllListNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" �� ");
            head = head.next;
        }
        return sb.length() < 1 ? null : sb.substring(0, sb.length() - 2);
    }
}
