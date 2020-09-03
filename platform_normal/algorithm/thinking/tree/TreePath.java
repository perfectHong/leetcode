package algorithm.thinking.tree;

import java.util.ArrayList;
import java.util.Stack;

import vo.TreeNode;

/**
 * ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * (ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
 * 
 * �����������������¼·��
 * */
public class TreePath {

	ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();

	ArrayList<Integer> path = new ArrayList<Integer>();// �洢��ǰ��·��

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
		} // ������һ��·��֮����Ҫ����
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
