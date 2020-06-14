package algorithm.weilong;

import java.util.Stack;

/**
 * @author mengfh
 * 
 * @version 2020-6-10����3:43:41
 * 
 * @description �������ұߵ�һ��������Ԫ��
 */
public class FirstMaxNumOnRight {

	/**
	 * Ҫ��O��n��
	 * 
	 * ������A=[1,5,3,6,4,8,9,10] ���[5, 6, 6, 8, 8, 9, 10, -1]
	 * 
	 * ������A=[8, 2, 5, 4, 3, 9, 7, 2, 5] ���[9, 5, 9, 9, 9, -1, -1, 5, -1]
	 */
	public static void main(String[] args) {

		findMaxRightWithStack(new int[] { 8, 5, 3, 3, 5, 8, 2 });
	}

	/**
	 * ����˼�����ڣ�ջ�д�ŵ��������±� 
	 * 
	 * �÷���result[stack.pop()],array[stack.peek()],stack.push(index);
	 */
	public static int[] findMaxRightWithStack(int[] array) {
		if (array == null) {
			return array;
		}
		int size = array.length;
		int[] result = new int[size];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int index = 1;
		while (index < size) {
			if (!stack.isEmpty() && array[index] > array[stack.peek()]) {
				result[stack.pop()] = array[index];
			} else {
				stack.push(index);
				index++;
			}
		}
		while (!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}
		return result;
	}

}
