package algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import vo.TreeNode;

/**
 * @author mengfh
 * 
 * @version 2020-4-23����8:33:55
 * 
 * @description
 */

public class BaseTree {

	/** �������������� */
	private int[] nums;

	public static void main(String[] args) {
		String ss = "www.baidu.com";
		String[] str = ss.split("\\.");
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}
	
	public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

	private int recur(TreeNode root) {
		if (root == null)
			return 0;
		int left = recur(root.left);
		if (left == -1)
			return -1;
		int right = recur(root.right);
		if (right == -1)
			return -1;
		return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
	}

	private TreeNode helper(int left, int right) {
		if (left > right)
			return null;
		int p = (left + right) / 2;     // ���򣬶����������ȣ��ö��ַ�(left,right˫��ݹ�)
		TreeNode root = new TreeNode(nums[p]);
		root.left = helper(left, p - 1);
		root.right = helper(p + 1, right);
		return root;
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		this.nums = nums;               // ֮���Էֳ���������������Ϊleft,right�ݹ鲻�ð���    
		return helper(0, nums.length - 1);
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val == q.val)
			return true;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	/** �ԳƵ��� */
	public boolean isSymmetric(TreeNode root) {
		if (root.left == null && root.right == null)
			return true;
		if (root.right == null || root.left == null)
			return false;
		if (root.left.val != root.right.val)
			return false;
		return isSymmetric(root);
	}

	public static void DFSByStack(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode treeNode = stack.pop();
			System.out.println(treeNode.val);
			if (treeNode.right != null) // DFSʹ��Stack���Ƚ����������Ƚ����ԭ��
				stack.push(treeNode.right);
			if (treeNode.left != null)
				stack.push(treeNode.left);
		}
	}

	public static void BFSByQueue(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode treeNode = queue.poll();
			System.out.println(treeNode.val);
			if (treeNode.left != null) // BFSʹ��Queue,�Ƚ����������Ƚ��ȳ�ԭ��
				queue.add(treeNode.left);
			if (treeNode.right != null)
				queue.add(treeNode.right);
		}
	}

}
