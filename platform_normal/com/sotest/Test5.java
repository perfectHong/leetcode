package com.sotest;

import java.util.Stack;

/**
 * @author mengfh
 *
 * @description 两个栈实现队列
 *
 * @date 2020-10-10下午5:30:49
 */
public class Test5 {

	public static void main(String[] args) {

	}
	
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
