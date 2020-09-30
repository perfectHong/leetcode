package com.sotest;

/**
 * @author mengfh
 *
 * @description 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @date 2020-9-28下午8:24:04
 */
public class Test2 {

	/**
	 * append可以拼接各种类型
	 * 
	 * 知道空格怎么表示吗，ch[i] != ' '还是 ch[i] != ''
	 * 
	 * 这里涉及到了转义字符
	 */
		private static boolean test() {
			String str = "We Are Happy";
			char[] ch = str.toCharArray();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < ch.length; i++) {
				if(ch[i] != ' '){
					sb.append(ch[i]);
				}else{
					sb.append("%20");
				}
			}
			System.out.println(sb.toString());
			return false;
			
		}
		
		public static void main(String[] args) {
			test();
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
		
		/**转换"www.baidu.com"->"com.baidu.www"*/
		public static void reverse2(){
			String str = "www.baidu.com";
			String[] arr = str.split("\\.");
			str = new StringBuilder().append(arr[2]).append(".").append(arr[1]).append(".").append(arr[0]).toString();
			System.out.println(str);
		}

}
