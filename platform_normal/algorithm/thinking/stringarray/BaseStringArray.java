package algorithm.thinking.stringarray;
/**
 * @author mengfh
 *
 * @version 2020-4-24����9:28:45
 *
 * @description
 */
public class BaseStringArray {

	public static void main(String[] args) {
		reverse2();
	}
	
	/**
	 * split()
	 * ת���ַ���������
	 * */
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
	
	/**ת��"www.baidu.com"->"com.baidu.www"*/
	/**��Ȼsplit�õ�\\.����append�õ�.*/
	public static void reverse2(){
		String str = "www.baidu.com";
		String[] arr = str.split("\\.");
		str = new StringBuilder().append(arr[2]).append(".").append(arr[1]).append(".").append(arr[0]).toString();
		System.out.println(str);
	}

}
