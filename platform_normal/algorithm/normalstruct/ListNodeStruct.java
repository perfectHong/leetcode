package algorithm.normalstruct;

import vo.ListNode;

/**
 * @author mengfh
 *
 * @version 2020-4-30����1:55:49
 *
 * @description �����������ĵ��⣬������㹻��
 */
public class ListNodeStruct {

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
//		node.next.next.next.next.next = new ListNode(4);
//		removeElements(node, 4);
		reverseList1(node);
	}
	
	/**�ص�***��ת��������**/  //�Լ���ͼ
	public static ListNode reverseList1(ListNode head) {  //������3��node��ƽ��д��ʱ��Ҫ�Ӷ�
		ListNode res = null;
		while (head != null) {
			ListNode nextTemp = head.next;
			head.next = res;  // ��ʱ��Ҫ�����ﲻ�����뵽
			res = head;  //headָ������һ��res��res��ָ��head
			head = nextTemp;
		}
		return res;
    }
	
	/**�ص�***��ת�����ݹ飬��leetcode���û��**/ 
	public ListNode reverseList2(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode cur = reverseList2(head.next);
		head.next.next = head;
		head.next = null;
		return cur;
	}

	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
    
    /**�ص���������ָ��node,head�͵�ַ�Ĺ�ϵ*/
    public static ListNode removeElements(ListNode head, int val) {
    	ListNode node = head;   //��node������������ַ��ʵ�ʷ��ص���headָ��
    	while(node != null){
    		if(node.next.val == val){
    			node.next = node.next.next;
    		}
    		node = node.next;
    	}
		return head;
    }
    
}
