package vo;

/**
 * @author mengfh
 * 
 * @version 2019-12-28����3:06:04
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
		ListNode node = new ListNode(1); // �����׽ڵ�
		ListNode nextNode = node; // ����һ�������������ƶ�������ָ��ǰ�ڵ�,�ص���node����һֱû�뵽 
		for (int i = 2; i <= 6; i++) {
			ListNode newNode = new ListNode(i); // �����µĽڵ�
			nextNode.next = newNode; 
			nextNode = nextNode.next; // ��ǰ�ڵ������ƶ�
		} 
		return nextNode = node; 
	}
	
	public static ListNode builder2() {
		ListNode node = new ListNode(2); // �����׽ڵ�
		ListNode nextNode = node; // ����һ�������������ƶ�������ָ��ǰ�ڵ�,�ص���node����һֱû�뵽 
		for (int i = 3; i <= 8; i++) {
			ListNode newNode = new ListNode(i); // �����µĽڵ�
			nextNode.next = newNode; 
			nextNode = nextNode.next; // ��ǰ�ڵ������ƶ�
		} 
		return nextNode = node; 
	}
	
}
