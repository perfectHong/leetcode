package com.sotest;
 
/**
 * 构建二叉树：https://blog.csdn.net/qq_34120430/article/details/80043472
 * 
 * 为了方便展示,并没有将Node属性私有
 */
 
class Node {
 
	public String data;
	public Node left = null;
	public Node right = null;
	public boolean flag;
 
	Node(String data) {
		this.data = data;
	}
 
	Node() {}
 
	@Override
	public String toString() {
		return this.data;
	}
 
}
 
public class BinaryTree{
 
	private static Node root = new Node();
 
	public static Node getRoot() {
		return root;
	}
 
	private static int createTreeByRecursion(Node node, String[] treeNodes, int n) {
 
		if ("#".equals(treeNodes[n]))
			return n + 1;
 
		node.data = treeNodes[n];
 
		node.left = new Node();
		int left = createTreeByRecursion(node.left, treeNodes, n + 1);
 
		node.right = new Node();
		int right = createTreeByRecursion(node.right, treeNodes, left);
 
		return right;
	}
 
	public static void createTreeByRecursion(String[] treeNodes) {
		createTreeByRecursion(root, treeNodes, 0);
	}
	
	public static void main(String[] args) {
		//String[] treeStr = new String[]{"A","B","D","#","#","#","C","#","E","#","#"};
		String[] treeStr = new String[]{"1","2","3","4","5","6","7","8","9","10","11"};
		createTreeByRecursion(treeStr);
	}
 
}