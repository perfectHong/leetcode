package algorithm.thinking.stringarray;
/**
 * @author mengfh
 *
 * @version 2020-6-23����9:19:52
 *
 * @description
 */
public class StringBase {

	public static String str = "mengfhdym";
	
	/**
	 *  charAt();      char ch = str.charAt(1);
	 */
	public static void main(String[] args) {
		System.out.println(str.compareTo("x")); //�Ƚϵ�һ���ַ���ASCII��ֵ
		System.out.println(str.charAt(1));
		System.out.println(str.toUpperCase());
		System.out.println(str.concat("111"));
	}

	private static void uplowChange(char c) {
        if(c>='A' && c<='Z'){     //���������Ǵ�д��+32���ɵõ�Сд
            c+=32;
            System.out.println(c);
        }else if(c>='a' && c<='z'){    //����������Сд��-32���ɵô�Сд
            c-=32;
            System.out.println(c);
        }
    }
}
