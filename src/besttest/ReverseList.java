package besttest;

import java.util.Stack;

import vo.ListNode;

/**
 * @author mengfh
 *
 * @version 2020-1-1上午10:37:09
 *
 * @description
 */
public class ReverseList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		bestFunc(node);
	}
	//反转链表
	public static ListNode ReverseList(ListNode head) {
		ListNode reHead = null;
		Stack<ListNode> stack = new Stack<>();
		while(head != null){
			stack.push(head);
			head = head.next;
		}
		while(!stack.isEmpty()){
			reHead = stack.pop();
			reHead = reHead.next;
		}
		return reHead;
    }
	/**
	 * 这道题对于理解单向链表很好
	 * */
	// 网上最佳解答，可画图做出来
	private static ListNode bestFunc(ListNode head) {
		if(head==null)
            return null;
        ListNode pre = null;
        ListNode next = null;
        while(head!=null){    //反复断开连接
            next = head.next; //next指向head.next,不要认为只等于head头结点，下同
            head.next = pre;  //不管是谁指向空，都为空
            pre = head;
            head = next;
        }
        return pre;
	}

}
