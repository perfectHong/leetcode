package algorithm;
/**
 * @author mengfh
 *
 * @version 2020-4-21ÉÏÎç10:02:56
 *
 * @description 
 */
public class test {

	public static void main(String[] args) {
		String str = "abcdgfe";
		String str2 = "1121";
		String str3 = "1523";
		if(str.toCharArray()[2]>'a'){
			System.out.println("dui");
		}
		if(str.toCharArray()[2]>'b'){
			System.out.println("dui");
		}
		if(str.toCharArray()[2]>'c'){
			System.out.println("cuo");
		}
		System.out.println(str3.compareTo(str2));
	}

}
