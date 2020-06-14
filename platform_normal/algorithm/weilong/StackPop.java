package algorithm.weilong;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5
 * 是某栈的压入顺序
 * ，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * 对于这个题目，声明一个栈，对于一个栈而言每次都会有两种方式，要么pop要不就push，判断好对于栈目前而言时pop还是push就好
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