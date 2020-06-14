package algorithm.weilong;

import java.util.Stack;

/**
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ���������1,2,3,4,5
 * ��ĳջ��ѹ��˳��
 * ������4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
 * ���������Ŀ������һ��ջ������һ��ջ����ÿ�ζ��������ַ�ʽ��ҪôpopҪ����push���жϺö���ջĿǰ����ʱpop����push�ͺ�
 * */
public class StackPop {

	public boolean IsPopOrder(int[] pushA, int[] popA) {
		Stack<Integer> stack = new Stack<Integer>();
		if (pushA.length <= 0)
			return false;
		int n = pushA.length;
		int index1 = 0;
		int index2 = 0;
		while (index2 < n) {
			if (stack.isEmpty()) {
				stack.push(pushA[index1++]);
			} else {
				if (stack.peek() != popA[index2]) {
					if (index1 < n)
						stack.push(pushA[index1++]);
					else
						return false;
				} else {
					index2++;
					stack.pop();
				}
			}
		}
		return true;

	}
}