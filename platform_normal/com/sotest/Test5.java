package com.sotest;

import java.util.Stack;

/**
 * @author mengfh
 *
 * @description ����ջʵ�ֶ���
 *
 * @date 2020-10-10����5:30:49
 */
public class Test5 {

	public static void main(String[] args) {

	}
	
	Stack<Integer> stackA = new Stack<>();
	Stack<Integer> stackB = new Stack<>();

	// Aջ�룬Ҫ��ʱ�����Bջ�ǿգ��ʹ�Bջ����
	// ���Bջ�գ�Aջȫ����Bջ�ٳ�
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
