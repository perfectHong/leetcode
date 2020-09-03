package algorithm.thinking.stack_heap_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author mengfh
 *
 * @description 有效的括号
 * 1.明确是什么类型的算法2.明确用什么数据结构
 *
 * @date 2020-8-18下午2:02:53
 */
public class ValidKuoHao {

	public static Map<Character,Character> map = new HashMap<>();
	
	static{
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length()/2; i++) {
			stack.push(s.charAt(i));
		}
		for (int i = s.length()/2; i < s.length(); i++) {
			if(map.get(s.charAt(i)) != stack.pop()){
				return false;
			}
		}
		return true;
	}

}
