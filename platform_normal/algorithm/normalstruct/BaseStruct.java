package algorithm.normalstruct;

import vo.ListNode;

/**
 * @author mengfh
 *
 * @version 2020-4-30下午1:55:49
 *
 * @description 能掌握以下四道题，链表就足够了
 */
public class BaseStruct {

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = new ListNode(4);
		removeElements(node, 4);
	}
	
	/**重点***反转链表，迭代**/  //自己画图
	public ListNode reverseList1(ListNode head) {  //包含了4个node，平常写的时候不要嫌多
		ListNode res = null;
		ListNode node = head;
		while (node != null) {
			ListNode nextTemp = node.next;
			node.next = res;  // 当时主要是这里不容易想到
			res = node;
			node = nextTemp;
		}
		return res;
    }
	
	/**重点***反转链表，递归，看leetcode题解没懂**/ 
	public ListNode reverseList2(ListNode head) {
		return head;
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
    
    /**重点就是理解其指针node,head和地址的关系*/
    public static ListNode removeElements(ListNode head, int val) {
    	ListNode node = head;   //用node代替操作链表地址，实际返回的是head指针
    	while(node != null){
    		if(node.next.val == val){
    			node.next = node.next.next;
    		}
    		node = node.next;
    	}
		return head;
    }
    
}
