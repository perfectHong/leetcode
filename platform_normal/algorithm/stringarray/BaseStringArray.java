package algorithm.stringarray;
/**
 * @author mengfh
 *
 * @version 2020-4-24����9:28:45
 *
 * @description
 */
public class BaseStringArray {

	public static void main(String[] args) {
//		escape();
		reverse1();
	}
	
	/**
	 * split()
	 * ת���ַ���������*/
	private static void escape() {
		String ss = "www.'baidu.'com";
		String[] str1 = ss.split("\\.");   //.
		String[] str2 = ss.split("\'");	   //'
		for (int i = 0; i < str1.length; i++) {
			System.out.println(str1[i]);
			System.out.println("\r");      //�س�
			System.out.println(str2[i]);
			System.out.println("\n");	   //����
		}
	}
	
	/**
	 * ��ת�ַ�������ʹ�ö���ռ�
	 * 
	 * substring(1,7)��ȡ����2~7λ����engfhm
	 * replace��replaceAll���ú󷵻�������String����Ҫ������ֵ��ֵ��str
	 * char[] ch = str.toCharArray()
	 * reverse()�÷�Ҫ���StringBuilder(str)
	 * 
	 * Դ��۲죺
	 * substring()replace()replaceAll()���ص���new�Ķ�������Ҫֵ��ֵ��str
	 * reverse()���ص���this,�Ƕ�������еĲ���
	 * */
	public static void reverse1(){
		String str = "mengfhm1";
		for (int i = 0; i < str.length() - 1; i++) {
			if(str.substring(i + 1, str.length()).contains(str.substring(i, i + 1))){
				System.out.println("false");
			}
		}
		System.out.println(str.indexOf("e"));
		//str = str.replaceAll( "1" , "2");
		//System.out.println(str.replaceAll( "1" , "2"));
		System.out.println(str.replace( "1" , "2"));
		
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		System.out.println(sb);
		
	}
	
	/**ת��"www.baidu.com"->"com.baidu.www"*/
	public static void reverse2(){
		String str = "www.baidu.com";
		
		
	}

}
