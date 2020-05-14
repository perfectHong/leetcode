package algorithm.normalstruct;

import vo.ListNode;

/**
 * @author mengfh
 *
 * @version 2020-4-30обнГ1:55:49
 *
 * @description
 */
public class BaseStruct {

	public static void main(String[] args) {

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
    
}
