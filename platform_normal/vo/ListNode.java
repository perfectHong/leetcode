package vo;

/**
 * @author mengfh
 * 
 * @version 2019-12-28下午3:06:04
 * 
 * @description
 */
public class ListNode {
	
	public int val;
	
	public ListNode next = null;
	
	public ListNode() {}
	
	public ListNode(int val) {
		this.val = val;
	}
	
	public static ListNode builder() {
		ListNode node = new ListNode(1); // 创建首节点
		ListNode nextNode = node; // 声明一个变量用来在移动过程中指向当前节点,重点是node，我一直没想到 
		for (int i = 2; i <= 6; i++) {
			ListNode newNode = new ListNode(i); // 生成新的节点
			nextNode.next = newNode; 
			nextNode = nextNode.next; // 当前节点往后移动
		} 
		return nextNode = node; 
	}
	
	public static ListNode builder2() {
		ListNode node = new ListNode(2); // 创建首节点
		ListNode nextNode = node; // 声明一个变量用来在移动过程中指向当前节点,重点是node，我一直没想到 
		for (int i = 3; i <= 8; i++) {
			ListNode newNode = new ListNode(i); // 生成新的节点
			nextNode.next = newNode; 
			nextNode = nextNode.next; // 当前节点往后移动
		} 
		return nextNode = node; 
	}
	
}
