package java_base.genericity;

import java.util.ArrayList;

/**
 * @author mengfh
 *
 * @version 2020-6-1����8:11:50
 *
 * @description ����
 */
public class Genericity {

	/**
	 * ���Ͳ���
	 */
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		//System.out.println(a == b); ���뼴����
		Class c1 = a.getClass();
		Class c2 = b.getClass();
		System.out.println(c1 == c2); 
	}

}
