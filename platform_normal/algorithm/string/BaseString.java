package algorithm.string;
/**
 * @author mengfh
 *
 * @version 2020-4-24上午9:28:45
 *
 * @description
 */
public class BaseString {

	public static void main(String[] args) {
		escape();
	}
	
	/**转义字符，待补充*/
	private static void escape() {
		String ss = "www.'baidu.'com";
		String[] str1 = ss.split("\\.");   //.
		String[] str2 = ss.split("\'");	   //'
		for (int i = 0; i < str1.length; i++) {
			System.out.println(str1[i]);
			System.out.println("\r");      //回车
			System.out.println(str2[i]);
			System.out.println("\n");	   //换行
		}
	}

}
