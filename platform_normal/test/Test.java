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
 * @version 2020-6-8����6:36:32
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
		double d = 1.5; //��ʽ��ȥ����d,����ǿת
		i = (int)d;//�������£�Ҫǿת
		d = i; //�������ϣ�����ǿת
		System.out.println(d); //���1.0�����ݶ�ʧ
		System.out.println(i);
		
		short s1 = (short) i; //i��ȷΪint����Ҫǿת
		short s2 = 1;//��ʽ��ȥ����short,����ǿת
		//s1 = s1 + 1; //���벻ͨ����s1+1Ϊint��
		s1 += 1;
	}

}
