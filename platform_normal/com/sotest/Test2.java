package com.sotest;

/**
 * @author mengfh
 *
 * @description ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 *
 * @date 2020-9-28����8:24:04
 */
public class Test2 {

	/**
	 * append����ƴ�Ӹ�������
	 * 
	 * ֪���ո���ô��ʾ��ch[i] != ' '���� ch[i] != ''
	 * 
	 * �����漰����ת���ַ�
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
		
		/**ת���ַ���������*/
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
		public static void reverse2(){
			String str = "www.baidu.com";
			String[] arr = str.split("\\.");
			str = new StringBuilder().append(arr[2]).append(".").append(arr[1]).append(".").append(arr[0]).toString();
			System.out.println(str);
		}

}
