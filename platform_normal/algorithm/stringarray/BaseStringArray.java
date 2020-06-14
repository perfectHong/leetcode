package algorithm.stringarray;
/**
 * @author mengfh
 *
 * @version 2020-4-24上午9:28:45
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
	 * 转义字符，待补充*/
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
	
	/**
	 * 反转字符串，不使用额外空间
	 * 
	 * substring(1,7)截取的是2~7位，即engfhm
	 * replace和replaceAll调用后返回类型是String，需要将返回值赋值给str
	 * char[] ch = str.toCharArray()
	 * reverse()用法要结合StringBuilder(str)
	 * 
	 * 源码观察：
	 * substring()replace()replaceAll()返回的是new的对象，所以要值赋值给str
	 * reverse()返回的是this,是对自身进行的操作
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
	
	/**转换"www.baidu.com"->"com.baidu.www"*/
	public static void reverse2(){
		String str = "www.baidu.com";
		
		
	}

}
