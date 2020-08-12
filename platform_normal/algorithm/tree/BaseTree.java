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
 * @version 2020-4-23下午8:33:55
 * 
 * @description
 */

public class BaseTree {

	/** 可用于有序数组 */
	private int[] nums;

	public static void main(String[] args) {

	}
	
	/** 重点 */// 翻转二叉树,标准题解
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode tmp = root.right;
		root.right = root.left;
		root.left = tmp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
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

	/** 对称的树 */
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
			if (treeNode.right != null) // DFS使用Stack，先进右子树，先进后出原理
				stack.push(treeNode.right);
			if (treeNode.left != null)
				stack.push(treeNode.left);
		}
	}
	
//	private void depthTraversal(TreeNode tn){
//		if(tn!=null&&!tn.equals(null)){
//			System.out.print(tn.val+"  ");
//			depthTraversal(tn.left);
//			depthTraversal(tn.left);
//		}         
//	 }

	public static void BFSByQueue(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode treeNode = queue.poll();
			System.out.println(treeNode.val);
			if (treeNode.left != null) // BFS使用Queue,先进左子树，先进先出原理
				queue.add(treeNode.left);
			if (treeNode.right != null)
				queue.add(treeNode.right);
		}
	}

	/** 平衡树 start*/
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
	/** 平衡树 end*/
	
	/**有序数组转二叉搜索树 start*/
	private TreeNode helper(int left, int right) {
		if (left > right)
			return null;
		int p = (left + right) / 2; // 有序，二叉搜索树等，用二分法(left,right双向递归)
		TreeNode root = new TreeNode(nums[p]);
		root.left = helper(left, p - 1);
		root.right = helper(p + 1, right);
		return root;
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		this.nums = nums; // 之所以分成两个方法，是因为left,right递归不好安排
		return helper(0, nums.length - 1);
	}
	/**有序数组转二叉搜索树 end*/
}
