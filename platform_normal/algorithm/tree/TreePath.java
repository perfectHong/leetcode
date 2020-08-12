package algorithm.tree;

import java.util.ArrayList;
import java.util.Stack;

import vo.TreeNode;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * 
 * 用树的先序遍历来记录路径
 * */
public class TreePath {

	ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();

	ArrayList<Integer> path = new ArrayList<Integer>();// 存储当前的路径

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		if (target < 0) {
			return paths;
		}
		if (root == null) {
			return paths;
		}
		path.add(root.val);
		if (root.left == null && root.right == null && target == root.val) {
			paths.add(new ArrayList<Integer>(path));
		}
		if (root.val < target && root.left != null) {
			FindPath(root.left, target - root.val);
		}
		if (root.val < target && root.right != null) {
			FindPath(root.right, target - root.val);
		} // 遍历完一条路径之后需要回溯
		path.remove(path.size() - 1);
		return paths;
	}
	
	public TreeNode mirrorTree1(TreeNode root) {
        if(root == null) 
        	return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree1(root.right);
        root.right = mirrorTree1(tmp);
        return root;
    }

	public TreeNode mirrorTree2(TreeNode root) {
        if(root == null) 
        	return null;
        Stack<TreeNode> stack = new Stack<>(); 
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
