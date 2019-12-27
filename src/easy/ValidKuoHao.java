package easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author mengfh
 * 
 * @version 2019-12-27上午10:31:23
 * 
 * @description
 */
public class ValidKuoHao {

	public static void main(String[] args) {

		new ValidKuoHao().isValid("([])");
	}
	/** 意识到要用charAt(),Map中可以存放包装类Character*/
	private HashMap<Character, Character> mappings;

	public ValidKuoHao() {
		this.mappings = new HashMap<Character, Character>();
		this.mappings.put(')', '(');
		this.mappings.put('}', '{');
		this.mappings.put(']', '[');
	}

	public boolean isValid(String s) {
		/** str.length&1==1等价于str.length%2==1*/
		if((s.length()&1) == 1)
			return false;
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (this.mappings.containsKey(c)) {

				char topElement = stack.empty() ? '#' : stack.pop();

				if (topElement != this.mappings.get(c)) {
					return false;
				}
			} else {
				stack.push(c);
			}
		}
		Queue<Integer> queue = new LinkedList<>();

		return stack.isEmpty();
	}
	
	
	/**
	 * map
	 * 包装类
	 * 栈
	 * 按位运算
	 * */
	
	/**
	 *  stack.push("g");
	 *  System.out.println(stack.search("o"));//返回一个对象，从栈顶向下数第一个位置
     *  System.out.println(stack.peek());//查看此堆栈顶部的对象，而不从堆栈中删除它
     *  System.out.println(stack.empty());//查看栈是否为空，flase不是空，true是空
     *  System.out.println(stack.pop());//删除栈顶部的对象，并将该对象作为此函数的值返回
     *  
     *  
     *  当LinkedList被当做栈来使用时，常用api及对应关系如下：
　　	 *	栈方法                    等效方法
　	 *	push(e)      addFirst(e)
　	 *	pop()        removeFirst()
　	 *	peek()       peekFirst()     
	 *  isempty()    isempty()
	 * */
	
    /**
	＆按位与操作符，当且仅当两个操作数的某一位都非0时候结果的该位才为1。（A＆B），得到12，即0000 1100
	|按位或操作符，只要两个操作数的某一位有一个非0时候结果的该位就为1。（A | B）得到61，即 0011 1101
	^按位异或操作符，两个操作数的某一位不相同时候结果的该位就为1。（A ^ B）得到49，即 0011 0001
	〜按位补运算符翻转操作数的每一位。（〜A）得到-61，即1100 0011
	<<按位左移运算符。左操作数按位左移右操作数指定的位数。A << 2得到240，即 1111 0000
	>>按位右移运算符。左操作数按位右移右操作数指定的位数。A >> 2得到15即 1111
	>>>按位右移补零操作符。左操作数的值按右操作数指定的位数右移，移动得到的空位以零填充。A>>>2得到15即0000 1111
	*/
}
