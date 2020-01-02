package besttest;

import java.util.Stack;

import vo.ListNode;

/**
 * @author mengfh
 *
 * @version 2020-1-1����10:37:09
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
	//��ת����
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
	 * ����������ⵥ������ܺ�
	 * */
	// ������ѽ�𣬿ɻ�ͼ������
	private static ListNode bestFunc(ListNode head) {
		if(head==null)
            return null;
        ListNode pre = null;
        ListNode next = null;
        while(head!=null){    //�����Ͽ�����
            next = head.next; //nextָ��head.next,��Ҫ��Ϊֻ����headͷ��㣬��ͬ
            head.next = pre;  //������˭ָ��գ���Ϊ��
            pre = head;
            head = next;
        }
        return pre;
	}

}
