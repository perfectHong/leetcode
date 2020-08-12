package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author mengfh
 *
 * @version 2020-6-8下午6:36:32
 *
 * @description
 */
public class Test {

	public static void main(String[] args) {
		func1();
	}
	
	private static void func1() {
		
		String[] str = {"111","222"};
		List<String> list = Arrays.asList(str);
		String[] ss = list.toArray(new String[0]);

		int i = 1;
		double d = 1.5; //隐式的去掉了d,不用强转
		i = (int)d;//由上向下，要强转
		d = i; //由下向上，不用强转
		System.out.println(d); //输出1.0，数据丢失
		System.out.println(i);
		
		short s1 = (short) i; //i明确为int，需要强转
		short s2 = 1;//隐式的去掉了short,不用强转
		//s1 = s1 + 1; //编译不通过，s1+1为int型
		s1 += 1;
	}

}
