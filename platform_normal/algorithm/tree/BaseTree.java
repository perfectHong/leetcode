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
 * @version 2020-4-23ÏÂÎç8:33:55
 * 
 * @description
 */

public class BaseTree {
	
	public static void main(String[] args) {
		String ss = "www.baidu.com";
		String[] str = ss.split("\\.");
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}
	
	public static List<Integer> DFSByStack(TreeNode root) {
		if (root == null) 
			return null;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		List<Integer> result = new ArrayList<>();

		while (!stack.isEmpty()) {
			TreeNode treeNode = stack.pop();
			result.add(treeNode.val);
			if (treeNode.right != null) 
				stack.push(treeNode.right);
			if (treeNode.left != null) 
				stack.push(treeNode.left);
		}
		return result;
	}

	public static List<Integer> BFSByQueue(TreeNode root) {
		if (root == null) 
			return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		List<Integer> result = new ArrayList<>();

		while (!queue.isEmpty()) {
			TreeNode treeNode = queue.poll();
			result.add(treeNode.val);
			if (treeNode.left != null) 
				queue.add(treeNode.left);
			if (treeNode.right != null) 
				queue.add(treeNode.right);
			}
		return result;
	}

}
