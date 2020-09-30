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

	public ListNode(int val) {
		this.val = val;
	}
	
	public static ListNode builder() {
		ListNode node = new ListNode(0); // �����׽ڵ�
		ListNode nextNode; // ����һ�������������ƶ�������ָ��ǰ�ڵ�
		nextNode = node; /** �ص���node����һֱû�뵽 */
		for (int i = 1; i < 10; i++) {
			ListNode newNode = new ListNode(i); // �����µĽڵ�
			nextNode.next = newNode; 
			nextNode = nextNode.next; // ��ǰ�ڵ������ƶ�
		} 
		return nextNode = node; 
	}
	
}
