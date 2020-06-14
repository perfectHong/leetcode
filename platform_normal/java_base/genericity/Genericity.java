package java_base.genericity;

import java.util.ArrayList;

/**
 * @author mengfh
 *
 * @version 2020-6-1ÏÂÎç8:11:50
 *
 * @description ·ºĞÍ
 */
public class Genericity {

	/**
	 * ·ºĞÍ²Á³ı
	 */
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		//System.out.println(a == b); ±àÒë¼´±¨´í
		Class c1 = a.getClass();
		Class c2 = b.getClass();
		System.out.println(c1 == c2); 
	}

}
