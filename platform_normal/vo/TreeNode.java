package vo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author mengfh
 * 
 * @version 2020-1-2����8:59:01
 * 
 * @description
 */
public class TreeNode {

	public int val = 0;
	public TreeNode left = null;
	public TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}

	public static void DFSByStack(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode treeNode = stack.pop();
			System.out.println(treeNode.val);    
			if (treeNode.right != null)			//DFSʹ��Stack���Ƚ����������Ƚ����ԭ��
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
			if (treeNode.left != null)			//BFSʹ��Queue,�Ƚ����������Ƚ��ȳ�ԭ��
				queue.add(treeNode.left);
			if (treeNode.right != null)
				queue.add(treeNode.right);
		}
	}

}
