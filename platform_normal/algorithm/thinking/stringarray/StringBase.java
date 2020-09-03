package algorithm.thinking.stringarray;
/**
 * @author mengfh
 *
 * @version 2020-6-23上午9:19:52
 *
 * @description
 */
public class StringBase {

	public static String str = "mengfhdym";
	
	/**
	 *  charAt();      char ch = str.charAt(1);
	 */
	public static void main(String[] args) {
		System.out.println(str.compareTo("x")); //比较第一个字符的ASCII码值
		System.out.println(str.charAt(1));
		System.out.println(str.toUpperCase());
		System.out.println(str.concat("111"));
	}

	private static void uplowChange(char c) {
        if(c>='A' && c<='Z'){     //如果输入的是大写，+32即可得到小写
            c+=32;
            System.out.println(c);
        }else if(c>='a' && c<='z'){    //如果输入的是小写，-32即可得大小写
            c-=32;
            System.out.println(c);
        }
    }
}
