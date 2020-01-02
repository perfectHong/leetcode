package besttest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import vo.ListNode;

/**
 * @author mengfh
 *
 * @version 2019-12-28下午3:07:14
 *
 * @description
 */
public class ListFromTailToHead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		printListFromTailToHead(node);
	}
	/** 反向打印链表，Stack.FIFO*/
    public static List<Integer> printListFromTailToHead(ListNode listNode) {
		List<Integer> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		do{
			stack.push(listNode.val);
			listNode = listNode.next;
		}while(listNode != null);
		while(!stack.isEmpty()){
			list.add(stack.pop());
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		return list;
    }
}
