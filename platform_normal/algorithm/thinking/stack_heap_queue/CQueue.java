package algorithm.thinking.stack_heap_queue;

import java.util.Stack;

/**
 * @author mengfh
 * 
 * @description 用两个栈实现队列
 * 
 * @date 2020-8-19下午3:02:50
 */
class CQueue {

	Stack<Integer> stackA = new Stack<>();
	Stack<Integer> stackB = new Stack<>();

	// A栈入，要出时，如果B栈非空，就从B栈出，
	// 如果B栈空，A栈全部入B栈再出
	public void appendTail(int value) {
		stackA.push(value);
	}

	public int deleteHead() {
		if (!stackB.isEmpty()) {
			return stackB.pop();
		} else {
			while (!stackA.isEmpty()) {
				stackB.push(stackA.pop());
			}
			return stackB.pop();
		}
	}
}
