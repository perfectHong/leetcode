package besttest;

import vo.ListNode;

/**
 * @author mengfh
 *
 * @version 2020-1-2上午9:00:24
 *
 * @description
 */
public class MergeList {

	//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
	public static void main(String[] args) {
		//递归两个重要思想
		//1.程序停止条件,例如 阶乘得例子中当n为1时就可以直接返回
		//2.子问题需与原问题为同样的事，且规模更小
		
		//如果下面这两点是成立的，我们就知道这个递归对于所有的 n 都是正确的。
		//当 n=0,1 时，结果正确；
		//假设递归对于 n 是正确的，同时对于 n+1 也正确。
	}
	// 递归推荐参考：https://blog.csdn.net/qmdweb/article/details/80537602
	// 递归，最重要的是递归思想，何时以及如何使用递归
    public static ListNode Merge(ListNode list1,ListNode list2) {
    	if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }       
    }
}
