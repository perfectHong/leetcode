package besttest;

import java.util.ArrayList;
import java.util.List;

import vo.ListNode;

/**
 * @author mengfh
 *
 * @version 2020-1-1����10:08:12
 *
 * @description
 */
public class FindKthToTail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		FindKthToTail(node,5);
	}
	//������������K��Ԫ��
	/** ����Խ�磬��չ���ز�����*/
	public static Integer FindKthToTail(ListNode list,int k) {
		int count = 0;
		if (list == null)   
			return null;
		List<Integer> arraylist = new ArrayList<>();
		while(list != null){
			count++;
			list = list.next;
		}
		if (count < k)  
			return null;
        for (int i = 0; i < count - k; i++) {
        	arraylist.add(list.val);
        }
		return arraylist.get(count-k);
    }

}
